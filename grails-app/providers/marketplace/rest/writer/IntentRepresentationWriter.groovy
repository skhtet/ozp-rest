package marketplace.rest.writer

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.IntentRepresentation

@Provider
@Produces([
    IntentRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentRepresentationWriter extends AbstractRepresentationWriter<Intent> {
    IntentRepresentationWriter() {
        super(new IntentRepresentation.Factory())
    }
}
