package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil
import org.codehaus.groovy.grails.web.json.JSONObject

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Type)
class TypeTests {
    def types

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Type)
        types = new Type()
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
