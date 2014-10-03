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
        boolean isAdmin = true

        def profileServiceMock = mockFor(ProfileRestService)
        profileServiceMock.demand.checkAdmin(1..1000) {
            if (!isAdmin) throw new IllegalArgumentException("checkAdmin test")
        }

        validator.profileRestService = profileServiceMock.createMock()

        Map existing = [:]
        Listing dto = new Listing()

        /**
         * Test different transitions
         */

        existing.approvalStatus = ApprovalStatus.IN_PROGRESS
        dto.approvalStatus = ApprovalStatus.IN_PROGRESS
        validator.validateChanges(existing, dto)

        dto.approvalStatus = ApprovalStatus.PENDING
        validator.validateChanges(existing, dto)

        dto.approvalStatus = ApprovalStatus.REJECTED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.APPROVED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = ApprovalStatus.PENDING
        dto.approvalStatus = ApprovalStatus.IN_PROGRESS
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.PENDING
        validator.validateChanges(existing, dto)

        //Rejection must be done by creating a RejectionListing. Simply setting approvalStatus
        //to Rejected should not work
        dto.approvalStatus = ApprovalStatus.REJECTED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.APPROVED
        validator.validateChanges(existing, dto)

        isAdmin = false
        dto.approvalStatus = ApprovalStatus.APPROVED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = ApprovalStatus.REJECTED
        dto.approvalStatus = ApprovalStatus.IN_PROGRESS
        isAdmin = true
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.REJECTED
        validator.validateChanges(existing, dto)

        dto.approvalStatus = ApprovalStatus.PENDING
        validator.validateChanges(existing, dto)

        dto.approvalStatus = ApprovalStatus.APPROVED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        isAdmin = false
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = ApprovalStatus.APPROVED
        dto.approvalStatus = ApprovalStatus.IN_PROGRESS
        isAdmin = true
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.REJECTED
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.PENDING
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = ApprovalStatus.APPROVED
        validator.validateChanges(existing, dto)

        isAdmin = false
        validator.validateChanges(existing, dto)

        /* approval status being a valid value at all is comstrained at the domain object level */
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
