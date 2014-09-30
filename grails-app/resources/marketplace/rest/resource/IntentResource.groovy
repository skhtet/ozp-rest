package marketplace.rest.resource

import marketplace.Intent
import marketplace.rest.representation.out.IntentRepresentation
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created

import marketplace.rest.service.IntentRestService
import marketplace.rest.representation.in.IntentInputRepresentation

@Path('api/intent')
class IntentResource extends DomainResource<Intent> {
    @Autowired
    public IntentResource(IntentRestService intentRestService) {
        super(Intent.class, intentRestService)
    }

    IntentResource() {}

    @POST
    @Consumes([
        IntentInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        IntentRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response create(IntentInputRepresentation rep) {
        created service.createFromRepresentation(rep)
    }

    @PUT
    @Consumes([
        IntentInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        IntentRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Path('/{id}')
    Intent update(@PathParam('id') String id,
                  IntentInputRepresentation rep) {
        service.updateById(id, rep)
    }
}
