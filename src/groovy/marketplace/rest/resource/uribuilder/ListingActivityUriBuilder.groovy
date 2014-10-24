package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder
import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

import marketplace.rest.ChildObjectCollection

import marketplace.Listing
import marketplace.ListingActivity

class ListingActivityUriBuilder implements
        SubCollectionUriBuilder<Listing, ListingActivity>, RootResourceUriBuilder {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private ListingActivityUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getCollectionUri(ChildObjectCollection<Listing, ListingActivity> collection) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getListingActivitiesForListing')
            .buildFromMap(listingId: collection.parent.id)
    }

    URI getRootUri() {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getActivitiesForListings')
            .build()
    }

    @Component
    public static class Factory implements
            SubCollectionUriBuilder.Factory<Listing, ListingActivity>,
            RootResourceUriBuilder.Factory {
        ListingActivityUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingActivityUriBuilder(uriBuilderHolder)
        }
    }
}
