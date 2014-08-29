package marketplace.validator

import javax.annotation.PostConstruct

import marketplace.AccountService
import marketplace.Constants
import marketplace.ServiceItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ServiceItemValidator implements DomainValidator<ServiceItem> {

    @Autowired
    AccountService accountService


    /**
     * Ensures that any change in approval status is valid and allowed for this user.
     * Also ensures that approval preprequisites are met
     */
    private void validateApprovalStatus(ServiceItem existing, ServiceItem dto) {
        def newApprovalStatus = dto.approvalStatus
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
                    accountService.checkAdmin("Illegal attempt to change approvalStatus of " +
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
    private void validateNewApprovalStatus(dto) {
       if (dto.approvalStatus != Constants.APPROVAL_STATUSES['IN_PROGRESS']) {
            throw new IllegalArgumentException("New ServiceItems cannot have an " +
                "approvalStatus other than ${Constants.APPROVAL_STATUSES['IN_PROGRESS']}")
        }
    }

    @Override
    public void validateNew(ServiceItem dto) {
        validateNewApprovalStatus(dto)
    }


    @Override
    public void validateChanges(ServiceItem existing, ServiceItem dto) {
        validateApprovalStatus(existing, dto)
    }
}
