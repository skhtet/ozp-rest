package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.Profile
import marketplace.Agency

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType

import marketplace.rest.ApplicationLibrary

@TestMixin(GrailsUnitTestMixin)
class ProfileRepresentationUnitTest {
    RepresentationFactory<Profile> factory =
        new ProfileRepresentation.Factory()

    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    Collection<Agency> organizations = [ new Agency(), new Agency() ]

    Profile profile = new Profile(
        username: 'testUser',
        organizations: organizations
    )

    void setUp() {
        organizations.eachWithIndex { agency, idx -> agency.id = idx }
        profile.id = 235
    }

    void testLinks() {
        ProfileRepresentation rep = factory.toRepresentation(profile, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/profile/235'

        assert rep.links.toMap().get(OzpRelationType.APPLICATION_LIBRARY).href ==
            'https://localhost/asdf/api/profile/235/library'

        assert rep.links.toMap().get(OzpRelationType.STEWARDSHIP).href ==
            'https://localhost/asdf/api/profile/235/stewarded-organizations'
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
