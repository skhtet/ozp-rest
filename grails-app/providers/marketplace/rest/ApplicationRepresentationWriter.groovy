package marketplace.rest

import marketplace.ServiceItem
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces(['application/vnd.ozp.application+json'])
class ApplicationRepresentationWriter extends AbstractRepresentationWriter<ServiceItem> {
    ApplicationRepresentationWriter() {
        super(new ApplicationRepresentation.Factory())
    }
}
