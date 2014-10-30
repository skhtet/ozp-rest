package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder
import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

import marketplace.Profile
import marketplace.ListingActivity

/**
 * A builder for URIs to the /api/profile/{id}/listing/activity call
 */
class ProfileOwnedListingActivityUriBuilder extends
        ProfileListingActivityUriBuilder {

    private ProfileOwnedListingActivityUriBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder)
    }

    @Override
    URI getCollectionUri(Profile parent) {
        this.uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getListingActivitiesByListingOwnerId')
            .buildFromMap(profileId: parent.id)
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Profile, ListingActivity> {
        ProfileOwnedListingActivityUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileOwnedListingActivityUriBuilder(uriBuilderHolder)
        }
    }
}
