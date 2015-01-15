package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Type

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.TypeRepresentation
import marketplace.rest.resource.uribuilder.TypeUriBuilder

@Provider
@Produces([
    TypeRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class TypesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Type>> {

    @Autowired
    TypesRepresentationWriter(GrailsApplication grailsApplication,
            TypeRepresentation.Factory factory,
            TypeUriBuilder.Factory typeUriBuilderFactory) {
        super(grailsApplication, EmbeddedCollectionRepresentation.createFactory(factory, typeUriBuilderFactory))
    }
}


