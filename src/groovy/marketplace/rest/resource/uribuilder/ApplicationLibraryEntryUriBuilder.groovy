package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource

import marketplace.rest.ChildObjectCollection

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

class ApplicationLibraryEntryUriBuilder implements
        ObjectUriBuilder<ApplicationLibraryEntry>,
        ChildCollectionUriBuilder<Profile, ApplicationLibraryEntry> {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    protected ApplicationLibraryEntryUriBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(ApplicationLibraryEntry entry) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'removeFromApplicationLibrary')
            .buildFromMap(listingId: entry.listing.id, profileId: entry.owner.id)
    }

    URI getCollectionUri(ChildObjectCollection<Profile, ApplicationLibraryEntry> collection) {
        getCollectionUri(collection.parent)
    }

    URI getCollectionUri(Profile parent) {
        getCollectionBuilder().buildFromMap(profileId: parent.id)
    }

    CollectionUriBuilder<ApplicationLibraryEntry> getCollectionUriBuilder(Profile parent) {
        { -> getCollectionUri(parent) } as CollectionUriBuilder<ApplicationLibraryEntry>
    }

    CollectionUriBuilder<ApplicationLibraryEntry> getCollectionUriBuilder(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder<ApplicationLibraryEntry>
    }

    private UriBuilder getCollectionBuilder() {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getApplicationLibrary')
    }

    @Component
    public static class Factory implements
            ChildCollectionUriBuilder.Factory<Profile, ApplicationLibraryEntry>,
            ObjectUriBuilder.Factory<ApplicationLibraryEntry> {

        ApplicationLibraryEntryUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryEntryUriBuilder(uriBuilderHolder)
        }
    }
}
