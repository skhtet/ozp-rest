package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

class ApplicationLibraryEntryUriBuilder implements
        ChildObjectUriBuilder<Profile, ApplicationLibraryEntry> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private ApplicationLibraryEntryUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(ApplicationLibraryEntry entry) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'removeFromApplicationLibrary')
            .buildFromMap(listingId: entry.listing.id, profileId: entry.owner.id)
    }

    URI getCollectionUri(ChildObjectCollection<Profile, ApplicationLibraryEntry> collection) {
        getCollectionBuilder().buildFromMap(profileId: collection.parent.id)
    }

    URI getCollectionUri(ApplicationLibraryEntry entry) {
        getCollectionBuilder().buildFromMap(profileId: entry.owner.id)
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getApplicationLibrary')
    }

    @Component
    public static class Factory implements
            ChildObjectUriBuilder.Factory<Profile, ApplicationLibraryEntry> {
        ApplicationLibraryEntryUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryEntryUriBuilder(uriBuilderHolder)
        }
    }
}
