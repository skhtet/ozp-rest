package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder

import marketplace.Listing
import marketplace.ListingActivity

@Provider
@Produces([
    ListingActivityRepresentation.CHILD_COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ListingActivitiesChildRepresentationWriter extends
        ChildObjectCollectionWriter<Listing, ListingActivity> {

    @Autowired
    ListingActivitiesChildRepresentationWriter(ListingActivityRepresentation.Factory factory,
            ListingActivityUriBuilder.Factory collectionUriBuilderFactory,
            ListingUriBuilder.Factory parentUriBuilderFactory) {
        super(factory, collectionUriBuilderFactory, parentUriBuilderFactory)
    }
}
