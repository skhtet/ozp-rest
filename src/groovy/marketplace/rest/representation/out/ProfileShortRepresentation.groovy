package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

class ProfileShortRepresentation extends SelfRefRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-profile-short-v1+json'
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-profiles-short-v1+json'

    private Profile profile

    ProfileShortRepresentation(
            Profile profile,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ObjectUriBuilder<Profile> profileUriBuilder) {
        super(profileUriBuilder.getUri(profile), null, null)

        this.profile = profile
    }

    String getUsername() { profile.username }
    String getDisplayName() { profile.displayName }
    Long getId() { profile.id }

    @Component
    public static class Factory implements RepresentationFactory<Profile> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        public ProfileShortRepresentation toRepresentation(Profile profile,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileShortRepresentation(profile, uriBuilderHolder,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
