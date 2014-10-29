package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.Listing

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

class ProfileListingUriBuilder implements
        ChildCollectionUriBuilder<Profile, Listing>,
        ObjectUriBuilder<Listing> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder
    private ObjectUriBuilder<Listing> listingUriBuilder

    protected ProfileListingUriBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ObjectUriBuilder<Listing> listingUriBuilder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    /**
     * delegates to ListingUriBuilder.getUri
     */
    URI getUri(Listing listing) {
        listingUriBuilder.getUri(listing)
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getListingsByAuthorId')
    }

    URI getCollectionUri(ChildObjectCollection<Profile, Listing> collection) {
        getCollectionUri(parent)
    }

    URI getCollectionUri(Profile parent) {
        getCollectionBuilder().buildFromMap(profileId: parent.id)
    }

    CollectionUriBuilder<Listing> getCollectionUriBuilder(
            ChildObjectCollection<Profile, Listing> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<Listing>
    }

    CollectionUriBuilder<Listing> getCollectionUriBuilder(Profile parent) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<Listing>
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Profile, Listing>,
            ObjectUriBuilder.Factory<Listing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        ProfileListingUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileListingUriBuilder(uriBuilderHolder,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
