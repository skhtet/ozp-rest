package marketplace.rest.service

import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.GrailsDomainClass

import marketplace.Sorter
import marketplace.validator.DomainValidator
import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.representation.in.IdRefInputRepresentation
import marketplace.rest.DomainObjectNotFoundException
import marketplace.rest.representation.in.PropertyRefInputRepresentation
import marketplace.rest.representation.in.AbstractInputRepresentation

/**
 * Parent class of services designed to support the
 * jaxrs-based Rest layer
 */
@Transactional
abstract class RestService<T> {

    protected final GrailsApplication grailsApplication

    //the domain class that this class deals with.
    //should be set by the subclass
    protected final Class<T> DomainClass
    protected final GrailsDomainClass grailsDomainClass

    protected final DomainValidator<T> validator

    protected final Sorter sorter

    protected RestService(GrailsApplication grailsApplication, Class<T> DomainClass,
            DomainValidator<T> validator, Sorter<T> sorter) {
        this.grailsApplication = grailsApplication

        this.DomainClass = DomainClass
        this.grailsDomainClass = grailsApplication.getDomainClass(DomainClass.name)
        this.validator = validator
        this.sorter = sorter
    }

    //Keep CGLIB happy
    protected RestService() {}

    public void deleteById(Object id) {
        T obj = getById(id)

        authorizeUpdate(obj)

        //judging from GRAILS-7699, delete without flush
        //isn't particularly reliable, at least in unit tests
        //if not also certain production databases
        obj.delete(flush: true)
    }

    public T updateById(Object id, InputRepresentation<T> rep) {
        T toUpdate = getById(id)

        //we need an extra copy that doesn't get changed by the update
        //so we can pass it to postprocess.  This creates a shallow copy
        Map old = new HashMap()
        old.putAll(toUpdate.properties)
        old.id = toUpdate.id   //the above does not copy the id
        copyCollections(old)

        authorizeUpdate(toUpdate)

        merge(toUpdate, rep)

        validator?.validateChanges(old, toUpdate)
        postprocess(toUpdate, old)

        return save(toUpdate)
    }

    private Map makeOldCopy(T toUpdate) {
        Map old = new HashMap()
        old.putAll(toUpdate.properties)
        old.id = toUpdate.id   //the above does not copy the id
        copyCollections(old)

        return old
    }

    /**
     * Go through all properties of the object and make shallow copies of all collections.
     * This insulates this object from changes to those collections.  This is used to
     * keep the "old" copy of the domain object from getting changed
     */
    private void copyCollections(obj) {
        grailsDomainClass.persistentProperties.grep {
            obj[it.name] instanceof Collection
        }.each { property ->
            def oldCollection = obj[property.name]

            //TODO add support for more than just sets and lists
            if (oldCollection instanceof List) {
                obj[property.name] = new ArrayList(oldCollection)
            }
            else if (oldCollection instanceof SortedSet) {
                obj[property.name] = new TreeSet(oldCollection)
            }
            else {
                obj[property.name] = new HashSet(oldCollection)
            }
        }
    }

    /**
     * @return the object in the database represented by rep
     */
    protected static <S> S getFromDb(IdRefInputRepresentation rep) {
        S retval = rep.representedClass().get(rep.id)

        if (retval == null) {
            throw new IllegalArgumentException("Attempted to find non-existant object " +
                "of type ${rep.representedClass()}")
        }

        return retval
    }

    /**
     * @return the object in the database represented by rep
     */
    protected static <S> S getFromDb(PropertyRefInputRepresentation rep) {
        S retval = rep.representedClass().findWhere(rep.identifyingProperties)

        if (retval == null) {
            throw new IllegalArgumentException("Attempted to find non-existant object " +
                "of type ${rep.representedClass()}")
        }

        return retval
    }

    private static <S> S merge(S object, InputRepresentation<S> representation) {
        /**
         * get the new value from the representation
         * @param repValue The value taken from the InputRepresentation
         * @param existingValue The value on the existing object
         */
        def getNestedValue

        getNestedValue = { repValue, existingValue ->
            if (repValue instanceof IdRefInputRepresentation ||
                    repValue instanceof PropertyRefInputRepresentation) {
                getFromDb(repValue)
            }
            else if (repValue instanceof InputRepresentation) {
                merge(existingValue, repValue)
            }
            else if (repValue instanceof Collection) {
                repValue.collect {
                    getNestedValue it, null
                }
            }
            else {
                repValue
            }
        }

        Map<String, Object> props = representation.inputProperties.collectEntries { name, val ->
            [name, getNestedValue(val, object ? object[name] : null)]
        }

        if (object) {
            props.each { propName, propValue ->
                if(object[propName] instanceof Collection || propValue instanceof Collection) {
                    object[propName]?.clear()
                    propValue.each {
                        object."addTo${propName.capitalize()}"(it)
                    }
                }
                else {
                    object[propName] = propValue
                }

            }

            return object
        }
        else {
            representation.representedClass().metaClass.invokeConstructor(props)
        }
    }

    /**
     * Save the domain object
     */
    protected T save(T obj) {
        obj.save(failOnError: true)
    }


    @Transactional(readOnly=true)
    public T getById(Object id) {
        T obj = DomainClass.get(id)

        if (!obj) {
            throw new DomainObjectNotFoundException(DomainClass, id)
        }

        authorizeView(obj)

        obj
    }

    @Transactional(readOnly=true)
    public Collection<T> getAll(Integer offset, Integer max) {
        DomainClass.createCriteria().list(offset: offset, max: max) {
            if (this.sorter) {
                order(sorter.sortField, sorter.direction.name().toLowerCase())
            }
        }
    }

    public T createFromRepresentation(InputRepresentation<T> rep) {
        T object = DomainClass.metaClass.invokeConstructor()

        merge(object, rep)
        populateDefaults(object)

        authorizeCreate(object)

        validator?.validateNew(object)
        postprocess(object)

        return save(object)
    }

    public Collection<T> createFromDtoCollection(Collection<T> dtos) {
        dtos.collect {
            createFromDto(it)
        }
    }

    /**
     * @return whether or not the current user is allowed to view this object
     */
    protected boolean canView(T obj) {
        true
    }

    /**
     * Authorize changes on the given existing object.
     *
     * This method should be overridden by subclasses in order to
     * enforce complex authorization checks (such as admin + owner
     * for ServiceItem
     *
     * The default implementation delegates to authorizeView since, at a minimum,
     * people generally cannot update objects that they cannot view
     *
     * @param existing The existing service item being updated or
     * deleted.  This method should be called before the object
     * is updated.
     *
     * @throws AccessDeniedException if this user is not authorized
     */
    protected void authorizeUpdate(T existing) throws AccessDeniedException {
        authorizeView(existing)
    }

    /**
     * Authorize the creation of a new object of type T.
     * The default implementation just defers to the same logic as authorizeUpdate
     *
     * @param newObject The currently unsaved new object being created
     *
     * @throws AccessDeniedException if this user is not authorized
     */
    protected void authorizeCreate(T newObject) throws AccessDeniedException {
        authorizeUpdate(newObject)
    }

    /**
     * Authorize the viewing of a single object.  Note that this method is used by getById, but
     * is NOT used by getAll.  It is recommended that subclasses add filtering rules into the
     * getAll database criteria in order to avoid breaking paging by filtering the query results.
     *
     * @param obj The object being viewed
     *
     * @throws AccessDeniedException if this user is not authorized
     */
    protected final void authorizeView(T obj) throws AccessDeniedException {
        if (!canView(obj)) {
            throw new AccessDeniedException("Unauthorized attempt to view ${obj.class} $obj")
        }
    }

    /**
     * Perform tasks that should occur after a domain object is updated, but before save is
     * called on it.  This is called after both create and update.  If other domain objects
     * need to be explicitly persisted, this is a good place to do it.  This method may choose
     * to itself save the updated object
     * @param updated The object that was updated
     * @param original The original copy of the object, if there was one (would be null for
     * a create)
     */
    protected void postprocess(T updated, Map original = null) {}

    /**
     * populate default field values in this ServiceItem
     */
    protected void populateDefaults(T dto) {}
}
