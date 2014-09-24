package marketplace.rest.writer

import marketplace.ServiceItem
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation

@Provider
@Produces([ApplicationRepresentation.MEDIA_TYPE])
class ApplicationRepresentationWriter extends AbstractRepresentationWriter<ServiceItem> {
    ApplicationRepresentationWriter() {
        super(new ApplicationRepresentation.Factory())
    }
}
