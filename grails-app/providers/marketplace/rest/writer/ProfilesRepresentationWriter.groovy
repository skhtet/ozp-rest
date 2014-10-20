package marketplace.rest.writer

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.ProfileRepresentation
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

@Provider
@Produces([
    ProfileRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfilesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Profile>> {

    @Autowired
    ProfilesRepresentationWriter(ProfileRepresentation.Factory factory,
            ProfileUriBuilder.Factory profileUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(factory,
            profileUriBuilderFactory))
    }
}
