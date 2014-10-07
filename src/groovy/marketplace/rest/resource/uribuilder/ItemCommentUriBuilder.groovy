package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

import marketplace.rest.ChildObjectCollection

import marketplace.Listing
import marketplace.ItemComment

class ItemCommentUriBuilder implements ResourceUriBuilder<ItemComment>, ChildObjectCollectionUriBuilder<Listing, ItemComment> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private ItemCommentUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(ItemComment comment) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'updateItemComment')
            .buildFromMap(listingId: comment.listing.id, itemCommentId: comment.id)
    }

    URI getCollectionUri(ChildObjectCollection<Listing, ItemComment> collection) {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getItemCommentsByListingId')
            .buildFromMap(listingId: collection.parent.id)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<ItemComment>,
            ChildObjectCollectionUriBuilder.Factory<Listing, ItemComment> {
        ItemCommentUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ItemCommentUriBuilder(uriBuilderHolder)
        }
    }
}
