package marketplace.rest

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces(['application/vnd.ozp.intent+json'])
class IntentRepresentationWriter extends AbstractRepresentationWriter<Intent> {
    IntentRepresentationWriter() {
        super(new IntentRepresentation.Factory())
    }
}
