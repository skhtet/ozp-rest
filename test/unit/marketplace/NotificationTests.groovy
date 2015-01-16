package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Notification)
class NotificationTests {
    def notificationItem

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Notification)
        notificationItem = new Notification()
    }

    def cleanup() {
    }

    void testMessageNotNull() {

        // message can't be blank or null
        notificationItem = new Notification()
        // TODO: set other fields (expiresDate, createdBy)
        assertFalse notificationItem.validate()
    }
}
