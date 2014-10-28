package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import marketplace.Profile
import marketplace.ItemComment
import marketplace.Listing
import marketplace.ListingActivity
import marketplace.RejectionActivity
import marketplace.RejectionListing
import marketplace.ListingSnapshot
import marketplace.ModifyRelationshipActivity
import marketplace.ChangeDetail

import marketplace.Constants

/**
 * This class was split off from ServiceItemActivityRestService to resolve a circular dependency.
 * This class handles the implicit creation of ServiceItemActivities when other
 * things happen, and is therefore referenced by numerous other services.
 * ServiceItemActivityRestService
 * handles basic retrieval operations that need to be available to the resource layer
 */
@Service
@Transactional
class ListingActivityInternalService {
    @Autowired ProfileRestService profileRestService

    /**
     * Create a changelog entry as needed that consists of a MODIFIED activity and one or more
     * change details by comparing two ServiceItems. If there are changes, this activity is added
     * to the updated ServiceItem's set of ServiceItemActivities. If no ChangeDetails are created,
     * the activity is not added, but it is still returned.
     *
     * @param updated the new ServiceItem which will have the changelog entry if it is needed
     * @param original the original ServiceItem to use for comparison
     * @return The activity that is created, regardless of whether or not it is added to the
     * ServiceItem.
     */
    public ListingActivity createChangeLog(Listing updated, Map original) {
        def activity = new ListingActivity(action: Constants.Action.MODIFIED)
        def propsChangeLogger = (ListingActivityInternalService.&logIfDifferent).curry(
                activity, updated, original)

        Listing.CHANGE_LOG_PROPERTIES.each(propsChangeLogger)

        activity.changeDetails ? addListingActivity(updated, activity) : activity
    }

    /**
     * Add a new ServiceItemActivity to the service item with the specified action
     */
    public ListingActivity addListingActivity(Listing listing,
            Constants.Action action) {
        addListingActivity(listing, new ListingActivity(action: action))
    }

    @Transactional
    public ListingActivity addListingActivity(Listing listing,
            ListingActivity activity) {
        activity.author = profileRestService.currentUserProfile

        listing.save()

        listing.addToListingActivities(activity)
        listing.lastActivity = activity

        return activity
    }

    @Transactional
    public RejectionActivity addRejectionActivity(Listing listing,
            RejectionListing rejectionListing) {

        rejectionListing.save()

        def activity = new RejectionActivity(
            rejectionListing: rejectionListing
        )

        addListingActivity(listing, activity)
        return activity
    }

    @Transactional
    public void addReviewEditedActivity(Listing listing,
            Profile commentOwner, String newCommentText, String oldCommentText) {
        if (newCommentText != oldCommentText) {
            ListingActivity activity = addListingActivity(listing, new ListingActivity(
                action: Constants.Action.REVIEW_EDITED
            ))
            activity.addToChangeDetails(new ChangeDetail(
                fieldName: "${commentOwner.displayName}'s Review",
                newValue: newCommentText,
                oldValue: oldCommentText
            ))
        }
    }

    @Transactional
    public void addReviewDeletedActivity(ItemComment review) {
        ListingActivity activity = addListingActivity(review.listing, new ListingActivity(
            action: Constants.Action.REVIEW_DELETED
        ))
        activity.addToChangeDetails(new ChangeDetail(
            fieldName: "reviewOwner",
            newValue: review.author.displayName
        ))
    }

    /**
     * Create all necessary ModifyRelationshipActivities for the ServiceItems that were
     * added and removed from this one
     * @param parent The ServiceItem being added and removed from.
     * @param added ServiceItems that were added to the parent
     * @param removed ServiceItems that were removed from the parent
     */
    @Transactional
    public void addRelationshipActivities(Listing parent, Collection<Listing> added,
            Collection<Listing> removed) {

        def addActivity = { Listing root, Collection<Listing> items, action ->
            def activity = new ModifyRelationshipActivity(
                action: action,
                author: profileRestService.currentUserProfile,
                items: items.collect { new ListingSnapshot(serviceItem: it, title: it.title)}
            )
            root.addToListingActivities(activity)

            root.lastActivity = activity
        }

        //a list consisting of just the parent, used below
        def parentList = [parent]

        //if items were added created an activity on the parent for it, and activities on each
        //of the children
        if (!added.isEmpty()) {
            addActivity(parent, added, Constants.Action.ADDRELATEDITEMS)
            added.each { addActivity(it, parentList, Constants.Action.ADDRELATEDTOITEM) }
        }

        //same as above, but for remove
        if (!removed.isEmpty()) {
            addActivity(parent, removed, Constants.Action.REMOVERELATEDITEMS)
            removed.each { addActivity(it, parentList, Constants.Action.REMOVERELATEDTOITEM) }
        }
    }

    /**
     * Compares the property with name as provided by propertyName for the updated and the old
     * object and if different, adds a changeDetail to the passed in activity.
     */
    private static void logIfDifferent(ListingActivity activity, updated,
            old, String propertyName, String displayName=null) {

        def convertToComparableLogValue = { item ->
            def itemProperty = item?."$propertyName"

            // Convert collections to Sets. For some reason PersistentSet won't do object
            //comparison with another Set on the  instances in the intents collection
            //(Intent.equals() never gets called).  Converting PersistentSet to a Set via
            // an intermediate array conversion is a workaround.
            def logValue = ([Set, Map, List].grep { itemProperty in it }) ?
                    itemProperty.toArray() as Set : itemProperty

            // if logValue satisfies groovy truth or is actually false, return it,
            //otherwise return the string 'None'
            logValue || (logValue == false) ? logValue : 'None'
        }

        def (newVal, oldVal) = [updated, old].collect { convertToComparableLogValue it }
        if(newVal != oldVal)
            activity.addToChangeDetails(new ChangeDetail(fieldName: displayName ?:
                propertyName, newValue: newVal.toString(), oldValue: oldVal.toString()))
    }
}
