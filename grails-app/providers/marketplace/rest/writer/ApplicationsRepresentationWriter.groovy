package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder

@Provider
@Produces([ApplicationRepresentation.COLLECTION_MEDIA_TYPE])
class ApplicationsRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Listing>> {

    @Autowired
    ApplicationsRepresentationWriter(ApplicationRepresentation.Factory appRepFactory,
            ListingUriBuilder.Factory listingUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(
            appRepFactory, listingUriBuilderFactory))
    }
}
