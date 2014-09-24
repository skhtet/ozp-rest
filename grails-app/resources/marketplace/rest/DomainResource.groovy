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
 * objects using the older style of passing
 * domain objects as DTOs
 */

class DomainResource<T> {

    private Class<T> DomainClass

    protected RestService<T> service

    /**
     * Constructor that should be called by subclasses in order
     * to initialize the subclass-specific fields of this class.
     * @param DomainClass The class of the domain object that this
     * resource is for
     */
    protected DomainResource(Class<T> DomainClass,
            RestService<T> service) {
        this.DomainClass = DomainClass
        this.service = service
    }

    protected DomainResource() {}

    @POST
    Response create(T dto) {
        created service.createFromDto(dto)
    }

    @PUT
    @Path('/{id}')
    T update(@PathParam('id') long id, T dto) {
        service.updateById(id, dto)
    }

    /**
     * GET all of the domain objects of type T, optionally
     * with paging parameters to limit the size of the return
     */
    @GET
    Collection<T> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        service.getAll(offset, max)
    }

    @GET
    @Path('/{id}')
    T read(@PathParam('id') long id) {
        service.getById(id)
    }

    @DELETE
    @Path('/{id}')
    void delete(@PathParam('id') long id) {
        service.deleteById(id)
    }
}
