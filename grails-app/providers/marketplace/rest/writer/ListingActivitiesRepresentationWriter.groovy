package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder
import marketplace.hal.AbstractRepresentationWriter

import marketplace.ListingActivity

@Provider
@Produces([
    ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ListingActivitiesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<ListingActivity>> {

    @Autowired
    ListingActivitiesRepresentationWriter(ListingActivityRepresentation.Factory factory,
            ListingActivityUriBuilder.Factory listingActivityUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(factory,
            listingActivityUriBuilderFactory))
    }
}
