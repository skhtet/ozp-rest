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

    void testFindDuplicates(){
        def testTypes = new Type(title: "type1", uuid: "1234")
        mockDomain(Type, [testTypes])

        def duplicateUuidTypes = new JSONObject(title: "type2", uuid: "1234")
        assertEquals testTypes.uuid, duplicateUuidTypes.uuid
        assertTrue Type.findDuplicates(duplicateUuidTypes)

        def duplicateTitleTypes = new JSONObject(title: "type1", uuid: "4321")
        assertTrue(testTypes.title == duplicateTitleTypes.title)
        assertTrue Type.findDuplicates(duplicateTitleTypes)

        def uniqueTypes = new JSONObject(title: "type3", uuid: "4321")
        assertFalse(testTypes.uuid == uniqueTypes.uuid)
        assertFalse(testTypes.title == uniqueTypes.title)
        assertFalse Type.findDuplicates(uniqueTypes)
    }
}
