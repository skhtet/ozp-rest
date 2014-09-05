package marketplace.rest

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import org.springframework.beans.factory.annotation.Autowired
import marketplace.ApplicationLibraryEntry

@Path('/api/iwc')
@Produces(['application/json'])
class IwcResource {

    @Autowired ApplicationLibraryEntryRestService libraryRestService
    @Autowired ProfileRestService profileRestService

    @GET
    @Path('/application')
    Collection<ApplicationDto> readApplicationsForCurrentUser() {
        libraryRestService.getByParentId(profileRestService.currentUserProfile.id).collect {
            new ApplicationDto(it.serviceItem)
        }
    }

    @GET
    @Path('/intent')
    Collection<IntentDto> readIntentsForApplicationsOfCurrentUser() {
        libraryRestService.getByParentId(profileRestService.currentUserProfile.id).collect {
            it.serviceItem.intents.collect { intent -> new IntentDto(intent) }
        }.flatten().unique()
    }

    @GET
    Map readCurrentUserProfile() {
        def profile = profileRestService.currentUserProfile
        [user: [userName: profile.username, name: profile.displayName]]
    }

}
