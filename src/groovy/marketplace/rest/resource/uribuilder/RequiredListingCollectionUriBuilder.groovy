package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

// import marketplace.Profile
import marketplace.Listing

import marketplace.hal.ApplicationRootUriBuilderHolder

// import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

import marketplace.rest.ChildObjectCollection

class RequiredListingCollectionUriBuilder implements ChildCollectionUriBuilder<Listing, Listing>, ObjectUriBuilder<Listing> {

    private ApplicationRootUriBuilderHolder uriBuilderHolder
    private ObjectUriBuilder<Listing> listingUriBuilder

    protected RequiredListingCollectionUriBuilder(
        ApplicationRootUriBuilderHolder uriBuilderHolder,
        ObjectUriBuilder<Listing> listingUriBuilder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
        .path(ListingResource.class)
        .path(ListingResource.class, 'getRequiredListings')
    }

    /**
    * delegates to ListingUriBuilder.getUri
    */
    URI getUri(Listing listing) {
        listingUriBuilder.getUri(listing)
    }

    URI getCollectionUri(ChildObjectCollection<Listing, Listing> collection) {
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Listing parent) {
        getCollectionBuilder().buildFromMap(listingId: parent.id)
    }

    CollectionUriBuilder<Listing> getCollectionUriBuilder(ChildObjectCollection<Listing, Listing> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<Listing>
    }

    CollectionUriBuilder<Listing> getCollectionUriBuilder(Listing parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder<Listing>
    }

    @Component
    public static class Factory implements ChildCollectionUriBuilder.Factory<Listing, Listing>, ObjectUriBuilder.Factory<Listing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        RequiredListingCollectionUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new RequiredListingCollectionUriBuilder(uriBuilderHolder, listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
