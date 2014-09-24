package marketplace.rest.resource

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import marketplace.hal.PagedCollection

import marketplace.rest.service.RestService

import marketplace.rest.representation.in.InputRepresentation

/**
 * Parent class of jaxrs rest controllers for domain
 * objects, using Representation classes for input
 */

class RepresentationResource<T> {

    protected RestService<T> service

    /**
     * Constructor that should be called by subclasses in order
     * to initialize the subclass-specific fields of this class.
     */
    protected RepresentationResource(RestService<T> service) {
        this.service = service
    }

    protected RepresentationResource() {}

    @POST
    Response create(InputRepresentation<T> rep) {
        created service.createFromRepresentation(rep)
    }

    @GET
    @Path('/{id}')
    T read(@PathParam('id') long id) {
        service.getById(id)
    }

    /**
     * GET all of the domain objects of type T, optionally
     * with paging parameters to limit the size of the return
     */
    //TODO if we move to Jersey 2 or a different JAX-RS framework, this can be separated
    //into a separate resource class to prevent subclasses from having to override it
    //just to specify a different @Produces
    @GET
    PagedCollection<T> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }

    @PUT
    @Path('/{id}')
    T update(@PathParam('id') long id, InputRepresentation<T> rep) {
        service.updateById(id, rep)
    }

    @DELETE
    @Path('/{id}')
    void delete(@PathParam('id') long id) {
        service.deleteById(id)
    }
}
