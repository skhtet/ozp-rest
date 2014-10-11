package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Category)
class CategoryTests {
    def category

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Category)
        category = new Category()
    }

    void testBlankConstraints(){
        TestUtil.assertPropertyBlank('title',category)
    }

    void testDescriptionRequired(){
        TestUtil.assertPropertyRequired('title',category)
    }

    void testSizeContraints(){
        TestUtil.checkSizeConstraintProperty('title',category, 50)
        TestUtil.checkSizeConstraintProperty('description',category, 255)
    }
}
