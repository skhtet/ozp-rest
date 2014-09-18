package marketplace.rest

import grails.orm.PagedResultList

import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.GET
import javax.ws.rs.Produces

import marketplace.hal.PagedCollection

/**
 * Parent class of jaxrs rest controllers for collections of domain
 * objects, using Representation classes for input.  Generally, for a given
 * domain class, a subclass of both this and RepresentationResource would
 * be created.  They are separate to make it easier to deal with
 * @Produces and @Consumes
 */

class RepresentationCollectionResource<T> {

    protected RestService<T> service

    /**
     * Constructor that should be called by subclasses in order
     * to initialize the subclass-specific fields of this class.
     */
    protected DomainResource(RestService<T> service) {
        this.service = service
    }

    protected DomainResource() {}

    /**
     * GET all of the domain objects of type T, optionally
     * with paging parameters to limit the size of the return
     */
    @GET
    PagedCollection<T> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        Collection<T> items = service.getAll(offset, max)
        int total = items instanceof PagedResultList ? items.totalCount : items.size()

        return new PagedCollection(offset, max, total, items)
    }
}
