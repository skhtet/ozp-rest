package marketplace.rest.writer

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.resource.IntentResource

@Provider
@Produces([
    IntentRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentsRepresentationWriter extends AbstractRepresentationWriter<Collection<Intent>> {

    IntentsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(IntentRepresentation.class, IntentResource.class))
    }
}
