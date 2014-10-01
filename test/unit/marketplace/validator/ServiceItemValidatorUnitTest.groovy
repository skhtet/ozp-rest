package marketplace.validator

import grails.test.mixin.TestFor
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.ServiceItem
import marketplace.rest.service.ProfileRestService

@TestMixin(GrailsUnitTestMixin)
class ServiceItemValidatorUnitTest {

    ServiceItemValidator validator

    void setUp() {
        validator = new ServiceItemValidator()
    }

    void testValidateApprovalStatus() {
        boolean isAdmin = true

        def profileServiceMock = mockFor(ProfileRestService)
        profileServiceMock.demand.checkAdmin(1..1000) {
            if (!isAdmin) throw new IllegalArgumentException("checkAdmin test")
        }

        validator.profileRestService = profileServiceMock.createMock()

        Map existing = [:]
        ServiceItem dto = new ServiceItem()

        /**
         * Test different transitions
         */

        existing.approvalStatus = 'In Progress'
        dto.approvalStatus = 'In Progress'
        validator.validateChanges(existing, dto)

        dto.approvalStatus = 'Pending'
        validator.validateChanges(existing, dto)

        dto.approvalStatus = 'Rejected'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Approved'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = 'Pending'
        dto.approvalStatus = 'In Progress'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Pending'
        validator.validateChanges(existing, dto)

        //Rejection must be done by creating a RejectionListing. Simply setting approvalStatus
        //to Rejected should not work
        dto.approvalStatus = 'Rejected'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Approved'
        validator.validateChanges(existing, dto)

        isAdmin = false
        dto.approvalStatus = 'Approved'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = 'Rejected'
        dto.approvalStatus = 'In Progress'
        isAdmin = true
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Rejected'
        validator.validateChanges(existing, dto)

        dto.approvalStatus = 'Pending'
        validator.validateChanges(existing, dto)

        dto.approvalStatus = 'Approved'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        isAdmin = false
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        existing.approvalStatus = 'Approved'
        dto.approvalStatus = 'In Progress'
        isAdmin = true
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Rejected'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Pending'
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, dto)
        }

        dto.approvalStatus = 'Approved'
        validator.validateChanges(existing, dto)

        isAdmin = false
        validator.validateChanges(existing, dto)

        /* approval status being a valid value at all is comstrained at the domain object level */
    }

    void testValidateNewApprovalStatus() {
        ServiceItem dto = new ServiceItem()

        dto.approvalStatus = 'In Progress'
        validator.validateNew(dto)

        dto.approvalStatus = 'Pending'
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }

        dto.approvalStatus = 'Rejected'
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }

        dto.approvalStatus = 'Approved'
        shouldFail(IllegalArgumentException) {
            validator.validateNew(dto)
        }
    }
}
