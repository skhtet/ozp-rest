package marketplace.rest.resource

import marketplace.Intent
import marketplace.rest.representation.out.IntentRepresentation
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created

import marketplace.rest.service.IntentRestService
import marketplace.rest.representation.in.IntentInputRepresentation
import marketplace.hal.PagedCollection

@Path('api/intent')
@Consumes([
    IntentInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Produces([
    IntentRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentResource extends RepresentationResource<Intent, IntentInputRepresentation> {
    @Autowired
    public IntentResource(IntentRestService intentRestService) {
        super(intentRestService)
    }

    IntentResource() {}

    @Produces([
        IntentRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Intent> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }
}
