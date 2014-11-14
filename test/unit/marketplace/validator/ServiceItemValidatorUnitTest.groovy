package marketplace.validator

import grails.test.mixin.support.GrailsUnitTestMixin
import marketplace.Listing
import marketplace.ApprovalStatus
import marketplace.rest.service.ProfileRestService

@TestMixin(GrailsUnitTestMixin)
class ServiceItemValidatorUnitTest {

    ListingValidator validator

    void setUp() {
        validator = new ListingValidator()
    }

    void testValidateApprovalStatus() {
        boolean isAdmin = true, isOrgSteward = true
        ApprovalStatus inProgress = ApprovalStatus.IN_PROGRESS,
                       pending = ApprovalStatus.PENDING,
                       approvedOrg = ApprovalStatus.APPROVED_ORG,
                       approved = ApprovalStatus.APPROVED,
                       rejected = ApprovalStatus.REJECTED

        validator.profileRestService = [
            checkAdmin: { str ->
                if (!isAdmin) throw new IllegalArgumentException("checkAdmin test")
            },

            checkOrgSteward: { org, str ->
                if (!(isOrgSteward || isAdmin))
                    throw new IllegalArgumentException("checkOrgSteward test")
            }
        ] as ProfileRestService

        Map existing = [:]
        Listing dto = new Listing()

        def tryAllStatusChanges = {
            def statuses = ApprovalStatus.values()
            def allChanges = statuses.inject([]) { acc, it1 ->
                acc + statuses.collect { it2 -> [it1, it2] }
            }
            def validChanges = allChanges.collect {
                existing.approvalStatus = it[0]
                dto.approvalStatus = it[1]

                try {
                    validator.validateChanges(existing, dto)
                    return it
                }
                catch(IllegalArgumentException e) {
                    return null
                }
            } - null

            return validChanges
        }

        def adminChanges = tryAllStatusChanges()
        assert adminChanges.contains([inProgress, inProgress])
        assert adminChanges.contains([pending, pending])
        assert adminChanges.contains([approvedOrg, approvedOrg])
        assert adminChanges.contains([approved, approved])
        assert adminChanges.contains([rejected, rejected])
        assert adminChanges.contains([inProgress, pending])
        assert adminChanges.contains([pending, approvedOrg])
        assert adminChanges.contains([approvedOrg, approved])
        assert adminChanges.contains([rejected, pending])
        assert adminChanges.size() == 9

        isAdmin = false
        def orgStewardChanges = tryAllStatusChanges()
        assert orgStewardChanges.contains([inProgress, inProgress])
        assert orgStewardChanges.contains([pending, pending])
        assert orgStewardChanges.contains([approvedOrg, approvedOrg])
        assert orgStewardChanges.contains([approved, approved])
        assert orgStewardChanges.contains([rejected, rejected])
        assert orgStewardChanges.contains([inProgress, pending])
        assert orgStewardChanges.contains([pending, approvedOrg])
        assert orgStewardChanges.contains([rejected, pending])
        assert orgStewardChanges.size() == 8

        isOrgSteward = false
        def userChanges = tryAllStatusChanges()
        assert userChanges.contains([inProgress, inProgress])
        assert userChanges.contains([pending, pending])
        assert userChanges.contains([approvedOrg, approvedOrg])
        assert userChanges.contains([approved, approved])
        assert userChanges.contains([rejected, rejected])
        assert userChanges.contains([inProgress, pending])
        assert userChanges.contains([rejected, pending])
        assert userChanges.size() == 7
    }

    void testValidateNewApprovalStatus() {
        Listing dto = new Listing()

        dto.approvalStatus = ApprovalStatus.IN_PROGRESS
        validator.validateNew(dto)

        dto.approvalStatus = ApprovalStatus.PENDING
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }

        dto.approvalStatus = ApprovalStatus.REJECTED
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }

        dto.approvalStatus = ApprovalStatus.APPROVED
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }
    }
}
