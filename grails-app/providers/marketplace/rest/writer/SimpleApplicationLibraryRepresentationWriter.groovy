package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.SimpleApplicationLibraryRepresentation
import marketplace.rest.ChildObjectCollection

@Provider
@Produces([SimpleApplicationLibraryRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class SimpleApplicationLibraryRepresentationWriter extends
        AbstractRepresentationWriter<Collection<ApplicationLibraryEntry>> {
    @Autowired
    SimpleApplicationLibraryRepresentationWriter(GrailsApplication grailsApplication,

            SimpleApplicationLibraryRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}
