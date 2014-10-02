package marketplace.rest.writer

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation

@Provider
@Produces([
    ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ApplicationRepresentationWriter extends AbstractRepresentationWriter<Listing> {
    ApplicationRepresentationWriter() {
        super(new ApplicationRepresentation.Factory())
    }
}
