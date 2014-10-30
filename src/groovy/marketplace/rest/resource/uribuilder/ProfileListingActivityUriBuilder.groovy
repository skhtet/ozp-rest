package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder
import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

import marketplace.Profile
import marketplace.ListingActivity

class ProfileListingActivityUriBuilder implements
        ChildCollectionUriBuilder<Profile, ListingActivity> {
    protected ApplicationRootUriBuilderHolder uriBuilderHolder

    protected ProfileListingActivityUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getCollectionUri(ChildObjectCollection<Profile, ListingActivity> collection) {
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Profile parent) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getListingActivitiesByProfileId')
            .buildFromMap(profileId: parent.id)
    }

    CollectionUriBuilder<ListingActivity> getCollectionUriBuilder(
            ChildObjectCollection<Profile, ListingActivity> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<ListingActivity>
    }

    CollectionUriBuilder<ListingActivity> getCollectionUriBuilder(Profile parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder<ListingActivity>
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Profile, ListingActivity> {
        ProfileListingActivityUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileListingActivityUriBuilder(uriBuilderHolder)
        }
    }
}
