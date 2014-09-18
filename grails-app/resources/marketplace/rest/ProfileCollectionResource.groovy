package marketplace.rest

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile

@Path('/api/profile')
@Produces([ProfileRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ProfileCollectionResource extends RepresentationCollectionResource<Profile> {
    @Autowired
    ProfileCollectionResource(ProfileRestService profileRestService) {
        super(profileRestService)
    }
}
