package marketplace.rest.representation.in

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class AbstractInputRepresentationUnitTest {
    private static class InputRep extends AbstractInputRepresentation {
        String prop1 = 'p1'
        int prop2 = 4
        List<Integer> three = [5,6,7,8,90]

        InputRep() { super(AbstractInputRepresentationUnitTest.class) }
    }

    void testRepresentedClass() {
        assert new InputRep().representedClass() == this.class
    }

    void testGetInputProperties() {
        Map<String, Object> props = new InputRep().getInputProperties()

        assert props['prop1'] == 'p1'
        assert props['prop2'] == 4
        assert props['three'] == [5,6,7,8,90]
    }
}
