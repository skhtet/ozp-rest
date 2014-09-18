package marketplace.rest

import static org.grails.jaxrs.response.Responses.*

import javax.annotation.PostConstruct

import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import marketplace.rest.RestService

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
