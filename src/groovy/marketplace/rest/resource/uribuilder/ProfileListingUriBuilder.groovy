package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.Listing

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.uribuilder.DomainResourceUriBuilder
import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

class ProfileListingUriBuilder implements SubCollectionUriBuilder<Profile, Listing> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder
    private DomainResourceUriBuilder<Listing> listingUriBuilder

    protected ProfileListingUriBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            DomainResourceUriBuilder<Listing> listingUriBuilder) {
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
        getCollectionBuilder().buildFromMap(profileId: collection.parent.id)
    }

    @Component
    public static class Factory extends SubCollectionUriBuilder.Factory<Profile, Listing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        ProfileListingUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileListingUriBuilder(uriBuilderHolder,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
