package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.Profile
import marketplace.Agency
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.AgencyUriBuilder

@TestMixin(GrailsUnitTestMixin)
class ProfileRepresentationUnitTest {
    ProfileRepresentation.Factory factory
    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    Collection<Agency> organizations = [ new Agency(title: 'org1'), new Agency(title: 'org2') ]

    Profile profile = new Profile(
        username: 'testUser',
        organizations: organizations
    )

    void setUp() {
        organizations.eachWithIndex { agency, idx -> agency.id = idx }
        profile.id = 235

        factory = new ProfileRepresentation.Factory()

        factory.profileUriBuilderFactory = new ProfileUriBuilder.Factory() {
            ProfileUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ProfileUriBuilder(null) {
                    URI getUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}")
                    }

                    URI getApplicationLibraryUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}/library")
                    }

                    URI getStewardedOrganizationsUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}/stewarded-organizations")
                    }

                    URI getUserDataUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}/user-data")
                    }
                }
            }
        }

        factory.agencyRepresentationFactory = new AgencyRepresentation.Factory()
        factory.agencyRepresentationFactory.uriBuilderFactory = new AgencyUriBuilder.Factory() {
            AgencyUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new AgencyUriBuilder(null) {
                    URI getUri(Agency agency) {
                        new URI("https://localhost/asdf/agency/${agency.id}")
                    }
                }
            }
        }
    }

    void testLinks() {
        ProfileRepresentation rep = factory.toRepresentation(profile, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/profile/235'

        assert rep.links.toMap().get(OzpRelationType.APPLICATION_LIBRARY).href ==
            'https://localhost/asdf/profile/235/library'

        assert rep.links.toMap().get(OzpRelationType.STEWARDSHIP).href ==
            'https://localhost/asdf/profile/235/stewarded-organizations'

        assert rep.links.toMap().get(OzpRelationType.USER_DATA).href ==
            'https://localhost/asdf/profile/235/user-data'
    }

    void testEmbedded() {
        Collection<Agency> embeddedAgencies = []

        ProfileRepresentation rep = factory.toRepresentation(profile, uriBuilderHolder)

        assert rep.embedded.toMap().get(OzpRelationType.ORGANIZATION).size() == 2

        (0..1).each {
            assert organizations[it].id == it
        }
    }
}
