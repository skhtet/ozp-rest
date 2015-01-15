package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.CategoryRepresentation
import marketplace.rest.resource.uribuilder.CategoryUriBuilder

@Provider
@Produces([
    CategoryRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class CategoriesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Category>> {

    @Autowired
    CategoriesRepresentationWriter(GrailsApplication grailsApplication,
            CategoryRepresentation.Factory factory,
            CategoryUriBuilder.Factory categoryUriBuilderFactory) {
        super(grailsApplication, EmbeddedCollectionRepresentation.createFactory(factory, categoryUriBuilderFactory))
    }
}

