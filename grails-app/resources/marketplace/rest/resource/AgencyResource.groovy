package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Agency

import marketplace.hal.PagedCollection

import marketplace.rest.service.AgencyRestService

import marketplace.rest.representation.out.AgencyRepresentation
import marketplace.rest.representation.in.AgencyInputRepresentation

@Path('api/agency')
@Produces([
    AgencyRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Consumes([
    AgencyInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class AgencyResource extends RepresentationResource<Agency, AgencyInputRepresentation> {

    @Autowired
    public AgencyResource(AgencyRestService categoryRestService) {
        super(categoryRestService)
    }

    AgencyResource() {}

    @Produces([
        AgencyRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Agency> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }
}
