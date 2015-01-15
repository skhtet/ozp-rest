package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.ApplicationLibraryEntry

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.SimpleApplicationLibraryEntryRepresentation
import marketplace.rest.ChildObjectCollection

@Provider
@Produces([SimpleApplicationLibraryEntryRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class SimpleApplicationLibraryEntryRepresentationWriter extends
        AbstractRepresentationWriter<ApplicationLibraryEntry> {
    @Autowired
    SimpleApplicationLibraryEntryRepresentationWriter(GrailsApplication grailsApplication,

            SimpleApplicationLibraryEntryRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
