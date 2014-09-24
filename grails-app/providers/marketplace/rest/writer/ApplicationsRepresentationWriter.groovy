package marketplace.rest.writer

import marketplace.ServiceItem
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.resource.ServiceItemResource

@Provider
@Produces([ApplicationRepresentation.COLLECTION_MEDIA_TYPE])
class ApplicationsRepresentationWriter extends
        AbstractRepresentationWriter<Collection<ServiceItem>> {
    ApplicationsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(
            new ApplicationRepresentation.Factory(), ServiceItemResource.class))
    }
}
