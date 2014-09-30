package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.Agency

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

@TestMixin(GrailsUnitTestMixin)
class AgencyRepresentationUnitTest {
    RepresentationFactory<Agency> factory = new AgencyRepresentation.Factory()
    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    void testSelfUri() {
        Agency agency = new Agency()
        agency.id = 14

        AgencyRepresentation rep = factory.toRepresentation(agency, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/agency/14'
    }

    void testGetIcon() {
        String iconPath = 'https://localhost/icon'

        Agency agency = new Agency()
        agency.id = 14

        AgencyRepresentation rep = factory.toRepresentation(agency, uriBuilderHolder)

        assert rep.icon == null

        agency.iconUrl = iconPath
        assert rep.icon == new URI(iconPath)
    }
}
