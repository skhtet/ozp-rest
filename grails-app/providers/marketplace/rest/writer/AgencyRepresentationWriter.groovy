package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.AgencyRepresentation

@Provider
@Produces([
    AgencyRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class AgencyRepresentationWriter extends AbstractRepresentationWriter<Agency> {

    @Autowired
    AgencyRepresentationWriter(GrailsApplication grailsApplication,
            AgencyRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
