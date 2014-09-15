package marketplace.rest

import marketplace.ServiceItem
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces([ApplicationRepresentation.COLLECTION_MEDIA_TYPE])
class ApplicationsRepresentationWriter extends AbstractRepresentationWriter<Collection<ServiceItem>> {
    ApplicationsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(ApplicationRepresentation.class, ServiceItemResource.class))
    }
}