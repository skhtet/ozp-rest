package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil
import org.codehaus.groovy.grails.web.json.JSONObject

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Types)
class TypesTests {
    def types

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Types)
        types = new Types()
    }

    void testBlankConstraints(){
        TestUtil.assertPropertyBlank('title',types)
    }

    void testNullConstraints(){
        TestUtil.assertPropertyRequired('title',types)
    }

    void testSizeContraints(){
        TestUtil.checkSizeConstraintProperty('title',types, 50)
    }
}
