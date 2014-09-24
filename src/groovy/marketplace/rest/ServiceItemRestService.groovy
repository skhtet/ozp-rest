package marketplace.rest

import grails.plugin.executor.PersistenceContextExecutorWrapper
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.codehaus.groovy.grails.commons.GrailsApplication
import marketplace.ServiceItem
import marketplace.Profile
import marketplace.ServiceItemActivity
import marketplace.Constants
import marketplace.RejectionListing
import marketplace.Relationship
import marketplace.ServiceItemSnapshot
import ozone.marketplace.enums.RelationshipType
import marketplace.AccountService
import marketplace.validator.ServiceItemValidator
import org.springframework.security.access.AccessDeniedException
import org.springframework.transaction.annotation.Transactional

@Service
class ServiceItemRestService extends RestService<ServiceItem> {
    @Autowired AccountService accountService
    @Autowired ProfileRestService profileRestService
    @Autowired ServiceItemActivityInternalService serviceItemActivityInternalService
    @Autowired PersistenceContextExecutorWrapper executorService
    @Autowired SessionFactory sessionFactory

    @Autowired
    public ServiceItemRestService(GrailsApplication grailsApplication,
            ServiceItemValidator serviceItemValidator) {
        super(grailsApplication, ServiceItem.class, null, null)
    }

    //needed for CGLIB
    ServiceItemRestService() {}

    @Transactional(readOnly=true)
    public Set<ServiceItem> getAllByAuthorId(Long profileId) {
        Profile profile = profileRestService.getById(profileId)
        ServiceItem.findAllByAuthor(profile).grep { canView(it) } as Set
    }

    /**
     * Recursively find all ServiceItems that are required by this one
     */
    @Transactional(readOnly=true)
    public Set<ServiceItem> getAllRequiredServiceItemsByParentId(Long id) {
        ServiceItem parent = getById(id)

        getAllRequiredServiceItems(parent, [parent] as Set).grep { canView(it) }
    }

    /**
     * Find all ServiceItems that require this one. This is not recursive
     */
    @Transactional(readOnly=true)
    public Set<ServiceItem> getRequiringServiceItemsByChildId(Long id) {
        //ensure that they are allowed to view the child
        ServiceItem child = getById(id)

        ServiceItem.createCriteria().list() {
            relationships {
                eq('relationshipType', RelationshipType.REQUIRE)

                relatedItems {
                    eq('id', id)
                }
            }
        }.grep{ canView(it) }
    }

    /**
     * @param ignore ServiceItems not to recurse into. Necessary to prevent infinite recursion
     */
    private Set<ServiceItem> getAllRequiredServiceItems(ServiceItem parent,
            Set<ServiceItem> ignore) {

        Set<ServiceItem> immediateRequired =
            parent.relationships.collect { it.relatedItems }.flatten() - ignore

        Set<ServiceItem> recursiveRequired = immediateRequired.collect {
            getAllRequiredServiceItems(it, (immediateRequired + ignore + parent))
        }.flatten()

        //get all immediate required items, items that those items require, and ignore the
        //current item
        immediateRequired + recursiveRequired - parent
    }

    @Override
    public void deleteById(Long id) {
        ServiceItem item = getById(id)

        updateRelationshipsForDelete(item)

        super.deleteById(id)
    }

    @Override
    protected boolean canView(ServiceItem si) {
        Profile profile = profileRestService.currentUserProfile

        //owners and admins can always view.  For others, there are more rules
        if (!accountService.isAdmin() && !si.isOwner(profile)) {

            //if it is enabled and approved it is visible to everyone
            if (!(si.isEnabled && si.approvalStatus == Constants.APPROVAL_STATUSES['APPROVED'])) {

                //if the user is an extern admin and the original creator it is visible
                //to them, even if they aren't the original owner
                if (!(accountService.isExternAdmin() && profile == si.createdBy)) {
                    return false
                }
            }
        }

        return true
    }

    @Override
    protected void authorizeUpdate(ServiceItem existing) {
        Profile profile = profileRestService.currentUserProfile

        //check enabled, approvalStatus, etc
        authorizeView(existing)

        def unauthorized = {
            throw new AccessDeniedException("Unauthorized attempt to modify ServiceItem with " +
                "id ${existing.id} by user ${profile.username}")
        }

        //admins can always edit
        if (!(accountService.isAdmin())) {
            //non-admin, non-owners can never edit
            if (!existing.isOwner(profile)) {
                unauthorized()
            }
        }
    }

    @Override
    protected void authorizeCreate(ServiceItem newItem) {
        //anyone can create service items
    }

    @Override
    protected void postprocess(ServiceItem updated, Map original = null) {

        if (original) {
            updateEnabledServiceItemActivity(updated, original)
            updateApprovalStatus(updated, original)
            serviceItemActivityInternalService.createChangeLog(updated, original)
        }
        else {
            //create
            serviceItemActivityInternalService.addServiceItemActivity(updated,
                Constants.Action.CREATED)
        }

        updateRelationshipsServiceItemActivity(updated, original)

    }

    /**
     * Checks for changes to the approvalStatus flag and reacts accordingly.  This method
     * assumes that the ServiceItemValidator has already bee run against this ServiceItem
     */
    private void updateApprovalStatus(ServiceItem updated, Map original) {
        def newApprovalStatus = updated.approvalStatus
        def oldApprovalStatus = original.approvalStatus

        if (newApprovalStatus != oldApprovalStatus) {
            switch (newApprovalStatus) {
                case Constants.APPROVAL_STATUSES['PENDING']:
                    serviceItemActivityInternalService.addServiceItemActivity(updated,
                        Constants.Action.SUBMITTED)
                    break
                case Constants.APPROVAL_STATUSES['APPROVED']:
                    doApprove(updated)
                    break
                default:
                    //should never happen assuming validateApprovalStatus has been run
                    throw new IllegalStateException("Unexpected approvalStatus transition in " +
                        "updateApprovalStatus: $oldApprovalStatus -> $newApprovalStatus")
            }
        }
    }

    /**
     * Business Logic that must happen when a listing is approved.  This method does not actually
     * do the approval, since that occurs during the update
     */
    private void doApprove(ServiceItem si) {
        ServiceItemActivity activity =
            serviceItemActivityInternalService.addServiceItemActivity(si,
                Constants.Action.APPROVED)

        accountService.checkAdmin()

        si.approvedDate = activity.activityDate
    }

    /**
     * Update the listing to be rejected.  This includes setting the approvalStatus, adding the
     * RejectionListing to the ServiceItem, and creating the RejectionActivity
     */
    public void reject(ServiceItem si, RejectionListing rejectionListing) {
        if (si.approvalStatus != Constants.APPROVAL_STATUSES['PENDING']) {
            throw new IllegalArgumentException("Cannot reject ServiceItem ${si.id} that has " +
                "approval status of ${si.approvalStatus}")
        }

        accountService.checkAdmin()

        si.approvalStatus = Constants.APPROVAL_STATUSES["REJECTED"]
        serviceItemActivityInternalService.addRejectionActivity(si, rejectionListing)

        if (!si.rejectionListings?.contains(rejectionListing)) {
            si.addToRejectionListings(rejectionListing)
        }
    }

    @Override
    protected void populateDefaults(ServiceItem dto) {
        Profile profile = profileRestService.currentUserProfile
        if(!dto.owners) {
            dto.addToOwners(profile)
        }
    }

    /**
     * Add a ServiceItemActivity for the changing of the hidden flag (known externally as
     * enabled
     */
    private void updateEnabledServiceItemActivity(ServiceItem updated, Map old) {
        boolean oldIsEnabled = old.isEnabled, updatedIsEnabled = updated.isEnabled

        if (oldIsEnabled != updatedIsEnabled) {
            serviceItemActivityInternalService.addServiceItemActivity(updated,
                Constants.Action[updatedIsEnabled ? 'ENABLED' : 'DISABLED'])
        }
    }

    /**
     * Create the appropriate ServiceItemActivities for any relationship changes
     */
    private void updateRelationshipsServiceItemActivity(ServiceItem updated, Map old) {
        Set<ServiceItem> oldRelated =
            old?.relationships?.collect { it.relatedItems }?.flatten() ?: new HashSet()
        Set<ServiceItem> newRelated = updated.relationships.collect { it.relatedItems }.flatten()

        Set<ServiceItem> added = newRelated - oldRelated
        Set<ServiceItem> removed = oldRelated - newRelated

        serviceItemActivityInternalService.addRelationshipActivities(updated, added, removed)
    }

    /**
     * Create the necessary changelog entries, and unhook the necessary objects, to allow
     * this service item to be deleted
     */
    private void updateRelationshipsForDelete(ServiceItem item) {
        Set<Relationship> relatedBy = Relationship.findRelationshipsByRelatedItem(item) as Set
        Set<Relationship> relatedTo = item.relationships as Set

        //use a set to ensure no duplicates
        Set<ServiceItem> relatedByServiceItems = relatedBy.collect { it.owningEntity }
        Set<ServiceItem> relatedToServiceItems = relatedTo.collect {
            it.relatedItems
        }.flatten()

        relatedBy.each { it.removeFromRelatedItems(item) }
        relatedTo.each { item.removeFromRelationships(it) }

        //update ServiceItemActivities
        relatedByServiceItems.each {
            serviceItemActivityInternalService.addRelationshipActivities(it, [], [item])
        }
        serviceItemActivityInternalService.addRelationshipActivities(item, [],
            relatedToServiceItems)

        //OP-5334: this save prevents the "collection not processed by flush" exception with Oracle and Postgresql
        item.save(flush: true)

        //unhook all ServiceItemSnapshots
        (ServiceItemSnapshot.findAllByServiceItem(item) as Set).each { it.serviceItem = null }
    }
}
