package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.Profile
import marketplace.IwcDataObject

class ProfileUriBuilder extends RepresentationResourceUriBuilder<Profile> {
    protected ProfileUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ProfileResource.class, uriBuilderHolder)
    }

    URI getApplicationLibraryUri(Profile profile) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getApplicationLibrary')
            .buildFromMap(profileId: profile.id)
    }

    URI getApplicationsUri(Profile profile) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'readApplicationsForCurrentUser')
            .buildFromMap(profileId: profile.id)
    }

    URI getIntentsUri(Profile profile) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'readIntentsForApplicationsOfCurrentUser')
            .buildFromMap(profileId: profile.id)
    }

    URI getUserDataUri(Profile profile) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'readAllData')
            .buildFromMap(profileId: profile.id)
    }

    URI getUserDataItemUri(IwcDataObject userData) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'readDataItem')
            .buildFromMap(key: userData.key, profileId: userData.profile.id)
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<Profile>,
            CollectionUriBuilder.Factory<Profile> {
        ProfileUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileUriBuilder(uriBuilderHolder)
        }
    }
}
