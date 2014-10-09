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
import marketplace.hal.HalLinks

import marketplace.rest.ChildObjectCollection

import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.AgencyUriBuilder

@TestMixin(GrailsUnitTestMixin)
class StewardedOrganizationsRepresentationUnitTest {
    RepresentationFactory<ChildObjectCollection<Profile, Agency>> factory

    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    Collection<Agency> orgs = [ new Agency(), new Agency() ]

    Profile profile = new Profile(
        username: 'testUser',
        stewardedOrganizations: orgs
    )

    ChildObjectCollection<Profile, Agency> stewardedOrganizations

    void setUp() {
        orgs.eachWithIndex { agency, idx -> agency.id = idx }
        profile.id = 235

        stewardedOrganizations =
            new ChildObjectCollection<Profile, Agency>(profile.stewardedOrganizations, profile)

        factory = new StewardedOrganizationsRepresentation.Factory()

        factory.profileUriBuilderFactory = new ProfileUriBuilder.Factory() {
            ProfileUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ProfileUriBuilder(null) {
                    URI getUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}")
                    }

                    URI getStewardedOrganizationsUri(Profile profile) {
                        new URI("https://localhost/asdf/profile/${profile.id}/stewarded-organizations")
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
        StewardedOrganizationsRepresentation rep =
            factory.toRepresentation(stewardedOrganizations, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/profile/235/stewarded-organizations'

        assert rep.links.toMap().get(RegisteredRelationType.VIA).href ==
            'https://localhost/asdf/profile/235'
    }

    void testEmbedded() {
        Collection<Agency> embeddedAgencies = []

        StewardedOrganizationsRepresentation rep =
            factory.toRepresentation(stewardedOrganizations, uriBuilderHolder)

        assert rep.embedded.toMap().get(RegisteredRelationType.ITEM).size() == 2

        (0..1).each {
            assert orgs[it].id == it
        }
    }
}

