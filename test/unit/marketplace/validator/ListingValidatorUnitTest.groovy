package marketplace.validator

import grails.test.mixin.support.GrailsUnitTestMixin
import marketplace.Listing
import marketplace.ApprovalStatus
import marketplace.ContactType
import marketplace.Contact
import marketplace.rest.service.ProfileRestService

import marketplace.testutil.FakeAuditTrailHelper

@TestMixin(GrailsUnitTestMixin)
@Mock(ContactType)
class ListingValidatorUnitTest {

    ListingValidator validator

    void setUp() {
        FakeAuditTrailHelper.install()
        validator = new ListingValidator()
    }

    void testValidateApprovalStatus() {
        boolean isAdmin = true

        def profileServiceMock = mockFor(ProfileRestService)
        profileServiceMock.demand.checkAdmin(1..1000) {
            if (!isAdmin) throw new IllegalArgumentException("checkAdmin test")
        }

        validator.profileRestService = profileServiceMock.createMock()

        Map existing = [contacts: []]
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

    void testValidateExistingRequiredContactTypes() {
        ContactType notRequiredType1 = new ContactType(title: 'not required type 1')
        ContactType notRequiredType2 = new ContactType(title: 'not required type 2')
        ContactType requiredType1 = new ContactType(title: 'required type 1', required: true)
        ContactType requiredType2 = new ContactType(title: 'required type 2', required: true)

        Contact notRequired1 = new Contact(type: notRequiredType1)
        Contact notRequired2 = new Contact(type: notRequiredType2)
        Contact required1 = new Contact(type: requiredType1)
        Contact required2 = new Contact(type: requiredType2)

        notRequiredType1.save(failOnError:true)
        notRequiredType2.save(failOnError:true)
        requiredType1.save(failOnError:true)
        requiredType2.save(failOnError:true)

        Listing updated = new Listing(approvalStatus: ApprovalStatus.APPROVED)
        Map existing = [contacts: [], approvalStatus: ApprovalStatus.APPROVED]

        //simplest case - no existing or new contacts
        validator.validateChanges(existing, updated)

        //only existing contacts are not required
        existing.contacts = [notRequired1, notRequired2]
        validator.validateChanges(existing, updated)

        //have an existing required contact that isn't in the update - should fail
        existing.contacts = [required1, notRequired1]
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //have an existing required contact that is in the update
        updated.contacts = [required1]
        validator.validateChanges(existing, updated)

        //have a required contact in the update that is not in the existing
        existing.contacts = [notRequired1]
        validator.validateChanges(existing, updated)

        //existing has a different required contact than updated
        existing.contacts = [required1]
        updated.contacts = [required2]
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //updated is missing a required contact
        existing.contacts = [required1, required2]
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //updated adds a required contact
        existing.contacts = [required1]
        updated.contacts = [required1, required2]
        validator.validateChanges(existing, updated)
    }

    void testValidatAllRequiredContactTypes() {
        ContactType notRequiredType1 = new ContactType(title: 'not required type 1')
        ContactType notRequiredType2 = new ContactType(title: 'not required type 2')
        ContactType requiredType1 = new ContactType(title: 'required type 1', required: true)
        ContactType requiredType2 = new ContactType(title: 'required type 2', required: true)

        Contact notRequired1 = new Contact(type: notRequiredType1)
        Contact notRequired2 = new Contact(type: notRequiredType2)
        Contact required1 = new Contact(type: requiredType1)
        Contact required2 = new Contact(type: requiredType2)

        notRequiredType1.save(failOnError:true)
        notRequiredType2.save(failOnError:true)
        requiredType1.save(failOnError:true)
        requiredType2.save(failOnError:true)

        Listing updated = new Listing(approvalStatus: ApprovalStatus.PENDING)
        Map existing = [contacts: [], approvalStatus: ApprovalStatus.IN_PROGRESS]

        //missing both required types
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //still missing required types
        updated.contacts = [notRequired1, notRequired2]
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //have required types
        updated.contacts = [required1, required2]
        validator.validateChanges(existing, updated)

        //missing one required type
        updated.contacts = [required1]
        shouldFail(IllegalArgumentException) {
            validator.validateChanges(existing, updated)
        }

        //have all the types
        updated.contacts = [required1, notRequired1, required2, notRequired2]
        validator.validateChanges(existing, updated)
    }
}
