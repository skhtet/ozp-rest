package marketplace.testutil

import grails.util.Holders

/**
 * This class is used in the unit tests as a mocked version
 * of the AuditTrailHelper from the audit-trail plugin
 */
class FakeAuditTrailHelper {
    void initializeFields(obj) {
        obj.createdDate = new Date()
        obj.editedDate = new Date()
    }

    static void install() {
        Holders.grailsApplication.mainContext.registerSingleton('auditTrailHelper', FakeAuditTrailHelper)
    }
}
