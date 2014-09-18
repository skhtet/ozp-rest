package marketplace.rest

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation
import marketplace.hal.PagedCollection

@Provider
@Produces([
    ProfileRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfilesRepresentationWriter extends
        AbstractRepresentationWriter<PagedCollection<Profile>> {

    ProfilesRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(ProfileRepresentation.class,
            ProfileCollectionResource.class))
    }
}
