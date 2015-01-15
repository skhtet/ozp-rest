package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.CategoryRepresentation

@Provider
@Produces([
    CategoryRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class CategoryRepresentationWriter extends AbstractRepresentationWriter<Category> {

    @Autowired
    CategoryRepresentationWriter(GrailsApplication grailsApplication,
            CategoryRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}

