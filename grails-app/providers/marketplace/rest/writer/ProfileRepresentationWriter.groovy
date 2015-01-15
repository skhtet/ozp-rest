package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ProfileRepresentation

@Provider
@Produces([
    ProfileRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfileRepresentationWriter extends AbstractRepresentationWriter<Profile> {

    @Autowired
    ProfileRepresentationWriter(GrailsApplication grailsApplication,
            ProfileRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
