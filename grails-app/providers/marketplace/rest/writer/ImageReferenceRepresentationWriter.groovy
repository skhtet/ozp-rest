package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.ImageReference

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ImageReferenceRepresentation

@Provider
@Produces([
    ImageReferenceRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON,
    MediaType.TEXT_PLAIN
])
class ImageReferenceRepresentationWriter extends AbstractRepresentationWriter<ImageReference> {

    @Autowired
    ImageReferenceRepresentationWriter(GrailsApplication grailsApplication,
            ImageReferenceRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
