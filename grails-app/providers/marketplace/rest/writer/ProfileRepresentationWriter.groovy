package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ProfileRepresentation

@Provider
@Produces([ProfileRepresentation.MEDIA_TYPE])
class ProfileRepresentationWriter extends AbstractRepresentationWriter<Profile> {

    @Autowired
    ProfileRepresentationWriter(ProfileRepresentation.Factory factory) {
        super(factory)
    }
}
