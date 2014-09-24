package marketplace.rest.representation.out

import marketplace.hal.AbstractHalRepresentation

/**
 * WARNING: Only use this class with objects that have an 'id' field, like
 * grails domain objects.  Since grails domain objects do not have a common
 * superclass, this constraint cannot be enforced by the type system
 */
class IdRefRepresentation<T> extends AbstractHalRepresentation<T> {
    private T object

    IdRefRepresentation(T object) {
        this.object = object
    }

    public long getId() { object.id }
}
