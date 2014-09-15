package marketplace.rest

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces([IntentRepresentation.MEDIA_TYPE])
class IntentRepresentationWriter extends AbstractRepresentationWriter<Intent> {
    IntentRepresentationWriter() {
        super(new IntentRepresentation.Factory())
    }
}
