package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ListingResource
import marketplace.Listing

class ListingUriBuilder extends SearchableRepresentationResourceUriBuilder<Listing> {
    protected ListingUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ListingResource.class, uriBuilderHolder)
    }

    URI getListingActivitiesUri(Listing listing) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getListingActivitiesForListing')
            .buildFromMap(listingId: listing.id)
    }

    URI getListingCommentsUri(Listing listing) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getItemCommentsByListingId')
            .buildFromMap(listingId: listing.id)
    }

    URI getRequiredListingsUri(Listing listing) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getRequiredListings')
            .buildFromMap(listingId: listing.id)
    }

    URI getRequiringListingsUri(Listing listing) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getRequiringListings')
            .buildFromMap(listingId: listing.id)
    }

    @Component
    public static class Factory implements SearchableResourceUriBuilder.Factory<Listing> {
        ListingUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingUriBuilder(uriBuilderHolder)
        }
    }
}
