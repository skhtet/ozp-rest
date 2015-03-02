package marketplace.rest.resource

import marketplace.rest.IwcApi
import marketplace.rest.representation.out.IwcApiRepresentation

import javax.ws.rs.GET
import javax.ws.rs.Path
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.service.ProfileRestService
import marketplace.rest.service.CategoryRestService
import marketplace.rest.service.TypeRestService
import marketplace.rest.service.IntentRestService
import marketplace.rest.service.ContactTypeRestService
import marketplace.rest.service.AgencyRestService

import marketplace.rest.StoreMetadata
import marketplace.rest.representation.out.StoreMetadataRepresentation

@Path('api')
class RootResource {

    @Autowired ProfileRestService profileRestService
    @Autowired CategoryRestService categoryRestService
    @Autowired TypeRestService typeRestService
    @Autowired IntentRestService intentRestService
    @Autowired ContactTypeRestService contactTypeRestService
    @Autowired AgencyRestService agencyRestService

    @GET
    @Produces([
        IwcApiRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcApi readIwcApi() {
        new IwcApi(profileRestService.currentUserProfile)
    }

    @Path('metadata')
    @GET
    @Produces([
        StoreMetadataRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    StoreMetadata getAllMetadata() {
        new StoreMetadata(
            categoryRestService.getAll(null, null),
            typeRestService.getAll(null, null),
            intentRestService.getAll(null, null),
            contactTypeRestService.getAll(null, null),
            agencyRestService.getAll(null, null)
        )
    }
}
