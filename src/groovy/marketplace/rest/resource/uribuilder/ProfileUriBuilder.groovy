package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ProfileResource
import marketplace.Profile

class ProfileUriBuilder extends RepresentationResourceUriBuilder<Profile> {
    private ProfileUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ProfileResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<Profile> {
        ProfileUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileUriBuilder(uriBuilderHolder)
        }
    }
}
