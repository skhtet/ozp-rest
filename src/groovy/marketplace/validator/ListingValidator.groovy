package marketplace.validator

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApprovalStatus
import marketplace.Listing
import marketplace.ContactType
import org.springframework.stereotype.Component

import marketplace.rest.service.ProfileRestService

@Component
class ListingValidator implements DomainValidator<Listing> {
    @Autowired ProfileRestService profileRestService

    /**
     * Ensures that any change in approval status is valid and allowed for this user.
     * Also ensures that approval preprequisites are met
     */
    private void validateApprovalStatus(Map existing, Listing updated) {
        def newApprovalStatus = updated.approvalStatus
        def oldApprovalStatus = existing.approvalStatus

        def inProgress = ApprovalStatus.IN_PROGRESS
        def pending = ApprovalStatus.PENDING
        def approvedOrg = ApprovalStatus.APPROVED_ORG
        def approved = ApprovalStatus.APPROVED
        def rejected = ApprovalStatus.REJECTED

        def validUserTransitions = [[inProgress, pending], [rejected, pending]]

        def validOrgStewardTransitions = validUserTransitions + [[pending, approvedOrg]]

        //NOTE although [pending, rejected] is valid generally, it is not valid for it to
        //be explicitly changed.  Instead, rejections are performed by POSTing
        //a RejectionListing
        def validAdminTransitions = validOrgStewardTransitions + [[approvedOrg, approved]]

        def transition = [oldApprovalStatus, newApprovalStatus]

        //if approvalStatus has changed
        if (newApprovalStatus != oldApprovalStatus) {
            if (!validUserTransitions.contains(transition)) {
                if (validOrgStewardTransitions.contains(transition)) {
                    profileRestService.checkOrgSteward(updated.agency,
                        "Illegal attempt to change approvalStatus of Listing " +
                        "with id ${existing.id}")
                }
                else {
                    if (validAdminTransitions.contains(transition)) {
                        profileRestService.checkAdmin("Illegal attempt to change " +
                            "approvalStatus of Listing with id ${existing.id}")
                    }
                    else {
                        throw new IllegalArgumentException("Invalid approval status transition " +
                            "from ${oldApprovalStatus} to ${newApprovalStatus}")
                    }
                }
            }
        }
    }

    /**
     * Ensures that a new ServiceItem does not have an approval status other that In Progress
     */
    private void validateNewApprovalStatus(Listing newObj) {
       if (newObj.approvalStatus != ApprovalStatus.IN_PROGRESS) {
            throw new IllegalArgumentException("New Listings cannot have an " +
                "approvalStatus other than ${ApprovalStatus.IN_PROGRESS}")
        }
    }

    /**
     * Check that no required contact types have been removed
     */
    private void validateExistingRequiredContactTypes(Map existing, Listing updated) {
        Collection<ContactType> required = ContactType.findAllByRequired(true),
            oldContactTypes = existing.contacts*.type,
            newContactTypes = updated.contacts*.type,
            missingRequired = required.intersect(oldContactTypes) - newContactTypes

        if (missingRequired) {
            throw new IllegalArgumentException(
                "Missing contacts for required types: ${missingRequired}")
        }
    }

    /**
     * Check that all required contact types are present
     */
    private void validateAllRequiredContactTypes(Listing updated) {
        Collection<ContactType> required = ContactType.findAllByRequired(true),
            newContactTypes = updated.contacts*.type,
            missingRequired = required - newContactTypes

        if (missingRequired) {
            throw new IllegalArgumentException(
                "Missing contacts for required types: ${missingRequired}")
        }
    }

    @Override
    public void validateNew(Listing newObj) {
        validateNewApprovalStatus(newObj)
    }


    @Override
    public void validateChanges(Map existing, Listing updated) {
        validateApprovalStatus(existing, updated)

        /**
         * In order to allow new required contact types to be added without
         * messing up required listings, some complicated rules needed to be added.
         * First of all, required contact types are not checked at all for Draft listings.
         * Then, whenever a listing is submitted, it is checked to ensure that all
         * currently-existing contact types are present.  Then, further updates check that
         * no required contact types are removed from the listing, but do not check that
         * new required contact types are added
         */
        if (updated.approvalStatus == ApprovalStatus.PENDING &&
                existing.approvalStatus != ApprovalStatus.PENDING) {
            validateAllRequiredContactTypes(updated)
        }
        else if (updated.approvalStatus != ApprovalStatus.IN_PROGRESS) {
            validateExistingRequiredContactTypes(existing, updated)
        }
    }
}
