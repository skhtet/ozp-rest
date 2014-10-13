package marketplace.rest.writer

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Type

import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.TypeRepresentation
import marketplace.rest.resource.TypeResource
import marketplace.rest.resource.uribuilder.TypeUriBuilder

@Provider
@Produces([
    TypeRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class TypesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Type>> {

    @Autowired
    TypesRepresentationWriter(TypeRepresentation.Factory factory,
            TypeUriBuilder.Factory typeUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(factory,
            typeUriBuilderFactory))
    }
}


