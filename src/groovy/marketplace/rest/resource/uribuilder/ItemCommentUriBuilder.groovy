package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

import marketplace.rest.ChildObjectCollection

import marketplace.Listing
import marketplace.ItemComment

class ItemCommentUriBuilder implements ChildObjectUriBuilder<Listing, ItemComment> {
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
        getCollectionBuilder().buildFromMap(listingId: collection.parent.id)
    }

    URI getCollectionUri(ItemComment comment) {
        getCollectionBuilder().buildFromMap(listingId: comment.listing.id)
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getItemCommentsByListingId')
    }

    @Component
    public static class Factory implements
            ChildObjectUriBuilder.Factory<Listing, ItemComment> {
        ItemCommentUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ItemCommentUriBuilder(uriBuilderHolder)
        }
    }
}
