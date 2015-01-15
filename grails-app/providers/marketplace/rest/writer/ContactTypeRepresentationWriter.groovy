package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ContactType

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ContactTypeRepresentation

@Provider
@Produces([
    ContactTypeRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ContactTypeRepresentationWriter extends AbstractRepresentationWriter<ContactType> {

    @Autowired
    ContactTypeRepresentationWriter(GrailsApplication grailsApplication,
            ContactTypeRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
