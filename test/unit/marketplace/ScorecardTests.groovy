package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Scorecard)
class ScorecardTests {
    def scoreCardItem

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Scorecard)
        scoreCardItem = new Scorecard()
    }

    void testQuestionNotNull() {

		//Test that 'question' fails validation if its blank
		scoreCardItem = new Scorecard()
		assertFalse scoreCardItem.validate()
		assertEquals  'nullable', scoreCardItem.errors['question']
    }

	void testQuestionNotBlank() {
		scoreCardItem = new Scorecard()
        scoreCardItem.question =  "  "
		assertFalse scoreCardItem.validate()
		assertEquals  'blank', scoreCardItem.errors['question']
	}

	void testQuestionSizeContraints(){
		scoreCardItem = new Scorecard()
		TestUtil.checkSizeConstraintProperty('question',scoreCardItem, 250)
	}


	void testDescriptionNotNull() {

		//Test that 'description' fails validation if its blank
		scoreCardItem = new Scorecard()
		assertFalse scoreCardItem.validate()
		assertEquals  'nullable', scoreCardItem.errors['description']

	}

	void testDescriptionNotBlank() {
		scoreCardItem = new Scorecard()
        scoreCardItem.description = "  "
		assertFalse scoreCardItem.validate()
		assertEquals  'blank', scoreCardItem.errors['description']
	}


	void testDescriptionSizeContraints(){
		scoreCardItem = new Scorecard()
		TestUtil.checkSizeConstraintProperty('description',scoreCardItem, 500)
	}
}
