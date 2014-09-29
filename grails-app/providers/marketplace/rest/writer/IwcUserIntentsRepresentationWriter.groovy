package marketplace.rest.writer

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.IwcUserIntents
import marketplace.rest.representation.out.IwcUserIntentsRepresentation

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.IntentRepresentation

@Provider
@Produces([
    IntentRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcUserIntentsRepresentationWriter extends AbstractRepresentationWriter<IwcUserIntents> {

    IwcUserIntentsRepresentationWriter() {
        super(new IwcUserIntentsRepresentation.Factory())
    }
}
