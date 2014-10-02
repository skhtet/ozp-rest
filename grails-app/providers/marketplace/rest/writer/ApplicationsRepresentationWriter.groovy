package marketplace.rest.writer

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.resource.ListingResource

@Provider
@Produces([ApplicationRepresentation.COLLECTION_MEDIA_TYPE])
class ApplicationsRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Listing>> {
    ApplicationsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(
            new ApplicationRepresentation.Factory(), ListingResource.class))
    }
}
