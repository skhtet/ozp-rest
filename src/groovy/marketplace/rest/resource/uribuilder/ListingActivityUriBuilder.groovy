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
        ChildCollectionUriBuilder<Listing, ListingActivity>,
        CollectionUriBuilder<ListingActivity> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private ListingActivityUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getCollectionUri(ChildObjectCollection<Listing, ListingActivity> collection) {
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Listing parent) {
        getUriBuilder().buildFromMap(listingId: parent.id)
    }

    /**
     * @return the URI for the collection of Listing Activities on the parent Listing
     */
    CollectionUriBuilder<ListingActivity> getCollectionUriBuilder(
            ChildObjectCollection<Listing, ListingActivity> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<ListingActivity>
    }

    CollectionUriBuilder<ListingActivity> getCollectionUriBuilder(Listing parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder<ListingActivity>
    }

    private UriBuilder getUriBuilder() {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getListingActivitiesForListing')
    }

    /**
     * @return the URI for the global collection of listing activities
     */
    URI getCollectionUri() {
        uriBuilderHolder.builder
            .path(ListingResource.class)
            .path(ListingResource.class, 'getActivitiesForListings')
            .build()
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Listing, ListingActivity>,
            CollectionUriBuilder.Factory<ListingActivity> {
        ListingActivityUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingActivityUriBuilder(uriBuilderHolder)
        }
    }
}
