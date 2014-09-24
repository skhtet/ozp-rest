package marketplace.rest.resource

import marketplace.Intent
import marketplace.Profile
import marketplace.ServiceItem

import javax.ws.rs.GET
import javax.ws.rs.Path
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.service.ApplicationLibraryEntryRestService
import marketplace.rest.service.ProfileRestService
import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.representation.out.ApplicationRepresentation

@Path('/api/iwc')
class IwcResource {

    @Autowired ApplicationLibraryEntryRestService libraryRestService
    @Autowired ProfileRestService profileRestService

    @GET
    @Path('/application')
    @Produces([
        ApplicationRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Collection<ServiceItem> readApplicationsForCurrentUser() {
        libraryRestService.getByParentId(profileRestService.currentUserProfile.id).collect {
            it.serviceItem
        }
    }

    @GET
    @Path('/intent')
    @Produces([
        IntentRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Collection<Intent> readIntentsForApplicationsOfCurrentUser() {
        libraryRestService.getByParentId(profileRestService.currentUserProfile.id).collect {
            it.serviceItem.intents
        }.flatten().unique()
    }

    @GET
    Profile readIwcApi() {
        profileRestService.currentUserProfile
    }

}
