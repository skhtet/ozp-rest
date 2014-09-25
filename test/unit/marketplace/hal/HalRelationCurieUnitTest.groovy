package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class HalRelationCurieUnitTest {
    void testOZPToLink() {
        Link link = HalRelationCurie.OZP.toLink()

        assert link.name == 'ozp'
        assert link.templated == true
        assert link.href == 'http://ozoneplatform.org/docs/rels/{rel}'
    }
}
