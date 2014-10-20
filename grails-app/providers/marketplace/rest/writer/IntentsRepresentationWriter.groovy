package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.resource.uribuilder.IntentUriBuilder

@Provider
@Produces([
    IntentRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentsRepresentationWriter extends AbstractRepresentationWriter<Collection<Intent>> {

    @Autowired
    IntentsRepresentationWriter(IntentRepresentation.Factory intentFactory,
            IntentUriBuilder.Factory intentUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(
                intentFactory, intentUriBuilderFactory))
    }
}
