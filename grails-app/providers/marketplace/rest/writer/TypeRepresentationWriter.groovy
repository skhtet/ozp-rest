package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Type

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.TypeRepresentation

@Provider
@Produces([
    TypeRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class TypeRepresentationWriter extends AbstractRepresentationWriter<Type> {

    @Autowired
    TypeRepresentationWriter(GrailsApplication grailsApplication,
            TypeRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}


