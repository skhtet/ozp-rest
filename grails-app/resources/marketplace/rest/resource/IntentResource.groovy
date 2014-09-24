package marketplace.rest.resource

import marketplace.Intent

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created

import marketplace.rest.service.IntentRestService
import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.representation.in.IntentInputRepresentation

@Path('api/intent')
class IntentResource {
    @Autowired IntentRestService intentRestService

    IntentResource() {}

    @GET
    @Path('/{id}')
    @Produces([
        IntentRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Intent read(@PathParam('id') String id) {

        intentRestService.getById(id)
    }

    @DELETE
    @Path('/{id}')
    void delete(@PathParam('id') String id) {

        intentRestService.deleteById(id)
    }

    @POST
    @Consumes([
        IntentInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        IntentRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response create(IntentInputRepresentation rep) {
        created intentRestService.createFromRepresentation(rep)
    }

    @GET
    @Produces([
        IntentRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Collection<Intent> readAll(@QueryParam('offset') Integer offset,
                               @QueryParam('max') Integer max) {

        intentRestService.getAll(offset, max)
    }

    @PUT
    @Consumes([
        IntentInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        IntentRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Path('/{id}')
    Intent update(@PathParam('id') String id,
                  IntentInputRepresentation rep) {
        intentRestService.updateById(id, rep)
    }
}
