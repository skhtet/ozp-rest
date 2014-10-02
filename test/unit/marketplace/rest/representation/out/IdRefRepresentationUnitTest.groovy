package marketplace.rest.representation.out

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class IdRefRepresentationUnitTest {
    void testGetId() {
        long id = 5

        IdRefRepresentation rep = new IdRefRepresentation([id: id])
        assert rep.id == id
    }
}
