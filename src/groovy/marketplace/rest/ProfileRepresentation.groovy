package marketplace.rest

import marketplace.Profile
import marketplace.Agency

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.AbstractHalRepresentation

class ProfileRepresentation extends SelfRefRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-profile-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-profiles-v1+json'

    private Profile profile

    ProfileRepresentation(Profile profile, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'read')
                .buildFromMap(id: profile.id),
            createLinks(profile, uriBuilderHolder),
            createEmbedded(profile, uriBuilderHolder)
        )

        this.profile = profile
    }

    private static HalLinks createLinks(Profile profile,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        URI applicationLibraryUri = uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'getApplicationLibrary')
                .buildFromMap(profileId: profile.id)
        //TODO add link to userdata once a resource for it exists

        new HalLinks(OzpRelationType.APPLICATION_LIBRARY, new Link(applicationLibraryUri))
    }

    private static HalEmbedded createEmbedded(Profile profile,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        RepresentationFactory<Agency> agencyFactory = new AgencyRepresentation.Factory()

        Collection<Map.Entry> organizationEmbedded = profile.organizations.collect {
            AbstractHalRepresentation<Agency> rep =
                agencyFactory.toRepresentation(it, uriBuilderHolder)

            new AbstractMap.SimpleEntry(OzpRelationType.ORGANIZATION, rep)
        }

        new HalEmbedded(organizationEmbedded)
    }

    String getUsername() { profile.username }
    String getDisplayName() { profile.displayName }
    String getEmail() { profile.email }
    String getBio() { profile.bio }
    String getCreatedDate() { profile.createdDate }
    String getLastLogin() { profile.lastLogin }
    Collection<IdRefRepresentation<Agency>> getOrganizations() {
        profile.organizations.collect { new IdRefRepresentation(it) }
    }

    public static class Factory extends RepresentationFactory<Profile> {
        @Override
        public ProfileRepresentation toRepresentation(Profile profile,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileRepresentation(profile, uriBuilderHolder)
        }
    }
}
