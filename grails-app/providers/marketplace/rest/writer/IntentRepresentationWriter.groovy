package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.rest.representation.out.IntentRepresentation

@Provider
@Produces([
    IntentRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentRepresentationWriter extends AbstractRepresentationWriter<Intent> {

    @Autowired
    IntentRepresentationWriter(GrailsApplication grailsApplication,
            IntentRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
