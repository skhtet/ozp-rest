package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.LegacyPreference

import marketplace.hal.AbstractWindownameWriter

import marketplace.rest.representation.out.LegacyPreferenceRepresentation

@Provider
@Produces([MediaType.TEXT_HTML, MediaType.APPLICATION_XHTML_XML])
class LegacyPreferenceWindownameWriter extends
        AbstractWindownameWriter<LegacyPreference> {
    @Autowired
    LegacyPreferenceWindownameWriter(GrailsApplication grailsApplication,
            LegacyPreferenceRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
