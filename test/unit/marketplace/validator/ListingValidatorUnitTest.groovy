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
