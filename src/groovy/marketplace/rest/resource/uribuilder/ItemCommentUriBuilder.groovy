package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder
import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

import marketplace.rest.ChildObjectCollection

import marketplace.Listing
import marketplace.Profile
import marketplace.ItemComment

class ItemCommentUriBuilder implements
        ObjectUriBuilder<ItemComment>,
        ChildCollectionUriBuilder<Listing, ItemComment> {
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
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Listing listing) {
        getCollectionBuilder().buildFromMap(listingId: listing.id)
    }

    CollectionUriBuilder<ItemComment> getCollectionUriBuilder(Listing parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder
    }

    CollectionUriBuilder<ItemComment> getCollectionUriBuilder(
            ChildObjectCollection<Profile, Listing> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getItemCommentsByListingId')
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<ItemComment>,
            ChildCollectionUriBuilder.Factory<Listing, ItemComment> {
        ItemCommentUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ItemCommentUriBuilder(uriBuilderHolder)
        }
    }
}
