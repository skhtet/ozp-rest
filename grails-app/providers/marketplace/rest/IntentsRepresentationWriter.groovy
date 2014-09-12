package marketplace.rest

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces(['application/vnd.ozp.intents+hal'])
class IntentsRepresentationWriter extends AbstractRepresentationWriter<Collection<Intent>> {

    IntentsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(IntentRepresentation.class, IntentResource.class))
    }
}
