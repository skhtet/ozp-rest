package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation

@Provider
@Produces([ApplicationRepresentation.MEDIA_TYPE])
class ApplicationRepresentationWriter extends AbstractRepresentationWriter<Listing> {

    @Autowired
    ApplicationRepresentationWriter(GrailsApplication grailsApplication,
            ApplicationRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
