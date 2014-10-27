package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.representation.out.EmbeddedChildCollectionRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder

import marketplace.rest.ChildObjectCollection

import marketplace.hal.AbstractRepresentationWriter

import marketplace.Listing
import marketplace.ListingActivity

@Provider
@Produces([
    ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ListingActivitiesChildRepresentationWriter extends
        AbstractRepresentationWriter<ChildObjectCollection<Listing, ListingActivity>> {

    @Autowired
    ListingActivitiesChildRepresentationWriter(ListingActivityRepresentation.Factory factory,
            ListingActivityUriBuilder.Factory collectionUriBuilderFactory,
            ListingUriBuilder.Factory parentUriBuilderFactory) {
        super(EmbeddedChildCollectionRepresentation.createFactory(factory,
                collectionUriBuilderFactory, parentUriBuilderFactory))
    }
}
