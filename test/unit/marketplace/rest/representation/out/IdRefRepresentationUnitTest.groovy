package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.ServiceItem

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType

@TestMixin(GrailsUnitTestMixin)
class IdRefRepresentationUnitTest {
    void testGetId() {
        long id = 5

        IdRefRepresentation rep = new IdRefRepresentation([id: id])
        assert rep.id == id
    }
}
