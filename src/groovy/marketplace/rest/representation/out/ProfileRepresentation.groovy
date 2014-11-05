package marketplace.rest.representation.out

import marketplace.Role
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

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
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

class ProfileRepresentation extends SelfRefRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-profile-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-profiles-v1+json'

    private Profile profile

    ProfileRepresentation(Profile profile, ApplicationRootUriBuilderHolder uriBuilderHolder,
            ProfileUriBuilder profileUriBuilder,
            RepresentationFactory<Agency> agencyRepresentationFactory) {
        super(
            profileUriBuilder.getUri(profile),
            createLinks(profile, profileUriBuilder),
            createEmbedded(profile, uriBuilderHolder, agencyRepresentationFactory)
        )

        this.profile = profile
    }

    private static HalLinks createLinks(Profile profile,
            ProfileUriBuilder profileUriBuilder) {
        URI applicationLibraryUri = profileUriBuilder.getApplicationLibraryUri(profile),
            stewardshipUri = profileUriBuilder.getStewardedOrganizationsUri(profile),
            userDataUri = profileUriBuilder.getUserDataUri(profile)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION_LIBRARY,
                    new Link(applicationLibraryUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.STEWARDSHIP, new Link(stewardshipUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.USER_DATA, new Link(userDataUri))
        ])
    }

    private static HalEmbedded createEmbedded(Profile profile,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            RepresentationFactory<Agency> agencyRepresentationFactory) {

        Collection<Map.Entry> organizationEmbedded = profile.organizations.collect {
            AbstractHalRepresentation<Agency> rep =
                agencyRepresentationFactory.toRepresentation(it, uriBuilderHolder)

            new AbstractMap.SimpleEntry(OzpRelationType.ORGANIZATION, rep)
        }

        new HalEmbedded(organizationEmbedded)
    }

    String getUsername() { profile.username }
    Long getId() { profile.id }
    String getDisplayName() { profile.displayName }
    String getEmail() { profile.email }
    String getBio() { profile.bio }
    Date getCreatedDate() { profile.createdDate }
    Date getLastLogin() { profile.lastLogin }
    Collection<IdRefRepresentation<Agency>> getOrganizations() {
        profile.organizations.collect { new IdRefRepresentation(it) }
    }
    Role getHighestRole() { profile.highestRole }

    @Component
    public static class Factory implements RepresentationFactory<Profile> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired AgencyRepresentation.Factory agencyRepresentationFactory

        @Override
        public ProfileRepresentation toRepresentation(Profile profile,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ProfileRepresentation(profile, uriBuilderHolder,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                agencyRepresentationFactory)
        }
    }
}
