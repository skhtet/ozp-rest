package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class SelfRefRepresentationUnitTest {
    void testSelfLink() {
        URI selfLink = new URI('https://localhost/self')
        Link intentLink = new Link(new URI('https://localhost/intent'))

        SelfRefRepresentation representation = new SelfRefRepresentation(selfLink, null, null) {}

        assert representation.links.toMap().get(RegisteredRelationType.SELF).href ==
            selfLink.toString()

        representation = new SelfRefRepresentation(selfLink,
            new HalLinks(OzpRelationType.INTENT, intentLink), null) {}

        assert representation.links.toMap().get(RegisteredRelationType.SELF).href ==
            selfLink.toString()
        assert representation.links.toMap().get(OzpRelationType.INTENT) == intentLink

        shouldFail(NullPointerException) {
            representation = new SelfRefRepresentation(null,
                new HalLinks(OzpRelationType.INTENT, intentLink), null) {}
        }
    }
}
