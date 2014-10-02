package marketplace.validator

import marketplace.Constants
import marketplace.Listing
import org.springframework.stereotype.Component

import marketplace.rest.service.ProfileRestService

@Component
class ListingValidator implements DomainValidator<Listing> {
    ProfileRestService profileRestService

    /**
     * Ensures that any change in approval status is valid and allowed for this user.
     * Also ensures that approval preprequisites are met
     */
    private void validateApprovalStatus(Map existing, Listing updated) {
        def newApprovalStatus = updated.approvalStatus
        def oldApprovalStatus = existing.approvalStatus

        def inProgress = Constants.APPROVAL_STATUSES['IN_PROGRESS']
        def pending = Constants.APPROVAL_STATUSES['PENDING']
        def approved = Constants.APPROVAL_STATUSES['APPROVED']
        def rejected = Constants.APPROVAL_STATUSES['REJECTED']

        def validUserTransitions = [[inProgress, pending], [rejected, pending]]

        //NOTE although [pending, rejected] is valid generally, it is not valid for it to
        //be explicitly changed.  Instead, rejections are performed by POSTing
        //a RejectionListing
        def validAdminTransitions = validUserTransitions + [[pending, approved]]

        def transition = [oldApprovalStatus, newApprovalStatus]

        //if approvalStatus has changed
        if (newApprovalStatus != oldApprovalStatus) {
            if (!validUserTransitions.contains(transition)) {
                if (validAdminTransitions.contains(transition)) {
                    profileRestService.checkAdmin("Illegal attempt to change approvalStatus of " +
                        "ServiceItem with id ${existing.id}")
                }
                else {
                    throw new IllegalArgumentException("Invalid approval status transition from" +
                        " ${oldApprovalStatus} to ${newApprovalStatus}")
                }
            }
        }
    }

    /**
     * Ensures that a new ServiceItem does not have an approval status other that In Progress
     */
    private void validateNewApprovalStatus(Listing newObj) {
       if (newObj.approvalStatus != Constants.APPROVAL_STATUSES['IN_PROGRESS']) {
            throw new IllegalArgumentException("New ServiceItems cannot have an " +
                "approvalStatus other than ${Constants.APPROVAL_STATUSES['IN_PROGRESS']}")
        }
    }

    @Override
    public void validateNew(Listing newObj) {
        validateNewApprovalStatus(newObj)
    }


    @Override
    public void validateChanges(Map existing, Listing updated) {
        validateApprovalStatus(existing, updated)
    }
}
