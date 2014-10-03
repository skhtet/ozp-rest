package marketplace.rest.service

import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import marketplace.Contact
import marketplace.Screenshot
import marketplace.ItemComment
import marketplace.Listing
import marketplace.DocUrl
import marketplace.ListingSnapshot
import marketplace.ListingActivity
import marketplace.ChangeDetail
import marketplace.Profile
import marketplace.RejectionActivity
import marketplace.ModifyRelationshipActivity
import marketplace.RejectionListing
import marketplace.Constants
import marketplace.ApprovalStatus
import marketplace.Types

import marketplace.testutil.FakeAuditTrailHelper

@TestMixin(DomainClassUnitTestMixin)
class ListingActivityInternalServiceUnitTest {
    ListingActivityInternalService service

    Profile currentUser
    Listing serviceItem1
    Listing serviceItem2
    List serviceItemActivities
    List changeDetails

    private Listing makeServiceItem() {
        Listing serviceItem = new Listing(
            title: "test service item",
            description: "a test service item",
            launchUrl: "https://localhost/asf",
            versionName: '1',
            approvalStatus: ApprovalStatus.IN_PROGRESS,
            version: 1
        )

        return serviceItem
    }

    void setUp() {
        serviceItem1 = makeServiceItem()
        serviceItem2 = makeServiceItem()
        currentUser = new Profile(username: 'admin')

        def serviceItemActivity1 = new ListingActivity(
            action: Constants.Action.MODIFIED,
            listing: serviceItem1
        )
        def serviceItemActivity2 = new ListingActivity(
            action: Constants.Action.ENABLED,
            listing: serviceItem1
        )
        def serviceItemActivity3 = new ListingActivity(
                action: Constants.Action.CREATED,
                listing: serviceItem2
        )
        def serviceItemActivity4 = new ListingActivity(
                action: Constants.Action.MODIFIED,
                listing: serviceItem2
        )

        def changeDetail1 = new ChangeDetail(
            fieldName: 'Made Up field',
            oldValue: 'null',
            newValue: 'New Value'
        )
        def changeDetail2 = new ChangeDetail(
            fieldName: 'Made Up field 2',
            oldValue: 'old value',
            newValue: 'New Value 2'
        )

        serviceItemActivities = [serviceItemActivity1, serviceItemActivity2,
            serviceItemActivity3, serviceItemActivity4]
        changeDetails = [changeDetail1, changeDetail2]

        FakeAuditTrailHelper.install()

        mockDomain(ItemComment)
        mockDomain(RejectionActivity)
        mockDomain(Contact)
        mockDomain(Screenshot)
        mockDomain(DocUrl)
        mockDomain(ListingActivity, serviceItemActivities)
        mockDomain(ChangeDetail, changeDetails)
        mockDomain(Listing.class, [serviceItem1, serviceItem2])

        currentUser = new Profile(username: 'admin')

        def serviceItemRestService = [
            getById: { Listing.get(it) },
        ] as ListingRestService


        service = new ListingActivityInternalService()

        service.profileRestService = [
            getCurrentUserProfile: { currentUser }
        ] as ProfileRestService
    }

    public void testAddServiceItemActivityByAction() {
        Listing si = makeServiceItem()

        service.addListingActivity(si, Constants.Action.DISABLED)

        assert si.listingActivities.size() == 1
        assert si.listingActivities[0].action == Constants.Action.DISABLED
        assert si.listingActivities[0].author == currentUser

        assert si.lastActivity == si.listingActivities[0]
    }

    public void testAdminServiceItemActivity() {
        Listing si = makeServiceItem()
        ListingActivity activity = new ListingActivity(
            description: 'desc',
            action: Constants.Action.APPROVED
        )

        service.addListingActivity(si, activity)

        assert si.listingActivities.size() == 1
        assert si.listingActivities[0] == activity

        assert si.lastActivity == activity
    }

    public void testAddRejectionActivity() {
        Listing si = makeServiceItem()
        RejectionListing rejectionListing = new RejectionListing(
            description: 'rejected'
        )

        mockDomain(RejectionListing, [rejectionListing])

        service.addRejectionActivity(si, rejectionListing)

        assert si.listingActivities.size() == 1
        assert si.listingActivities[0].author == currentUser
        assert si.listingActivities[0] instanceof RejectionActivity
        assert si.listingActivities[0].rejectionListing == rejectionListing

        assert si.lastActivity == si.listingActivities[0]
    }

    public void testAddRelationshipActivities() {
        Listing parent = makeServiceItem()
        Listing child1 = makeServiceItem()
        Listing child2 = makeServiceItem()
        Listing child3 = makeServiceItem()
        Listing child4 = makeServiceItem()

        def snapshotsOf = { siList ->
            siList.collect { new ListingSnapshot(title: it.title, serviceItem: it) }
        }

        service.addRelationshipActivities(parent, [child1, child2], [])

        ModifyRelationshipActivity parentActivity = parent.listingActivities[0]

        assert parent.listingActivities.size() == 1
        assert parent.listingActivities[0].author == currentUser
        assert parent.listingActivities[0] instanceof ModifyRelationshipActivity
        assert parent.listingActivities[0].action == Constants.Action.ADDRELATEDITEMS
        assert parent.listingActivities[0].items == snapshotsOf([child1, child2])
        assert parent.lastActivity == parent.listingActivities[0]

        assert child1.listingActivities.size() == 1
        assert child1.listingActivities[0].author == currentUser
        assert child1.listingActivities[0] instanceof ModifyRelationshipActivity
        assert child1.listingActivities[0].items == snapshotsOf([parent])
        assert child1.listingActivities[0].action == Constants.Action.ADDRELATEDTOITEM
        assert child1.lastActivity == child1.listingActivities[0]

        assert child2.listingActivities.size() == 1
        assert child2.listingActivities[0].author == currentUser
        assert child2.listingActivities[0] instanceof ModifyRelationshipActivity
        assert child2.listingActivities[0].items == snapshotsOf([parent])
        assert child2.listingActivities[0].action == Constants.Action.ADDRELATEDTOITEM
        assert child2.lastActivity == child2.listingActivities[0]

        service.addRelationshipActivities(parent, [], [child1])

        assert parent.listingActivities.size() == 2
        assert parent.listingActivities[1].author == currentUser
        assert parent.listingActivities[1] instanceof ModifyRelationshipActivity
        assert parent.listingActivities[1].action == Constants.Action.REMOVERELATEDITEMS
        assert parent.listingActivities[1].items == snapshotsOf([child1])
        assert parent.lastActivity == parent.listingActivities[1]

        assert child1.listingActivities.size() == 2
        assert child1.listingActivities[1].author == currentUser
        assert child1.listingActivities[1] instanceof ModifyRelationshipActivity
        assert child1.listingActivities[1].items == snapshotsOf([parent])
        assert child1.listingActivities[1].action == Constants.Action.REMOVERELATEDTOITEM
        assert child1.lastActivity == child1.listingActivities[1]

        service.addRelationshipActivities(parent, [child1], [child2])

        assert parent.listingActivities.size() == 4
        def addActivity = parent.listingActivities[2]
        def removeActivity = parent.listingActivities[3]

        //since the activities were done at pretty much the same time, they could be in
        //either order
        if (addActivity.action == Constants.Action.REMOVERELATEDITEMS) {
            def tmp = removeActivity
            addActivity = removeActivity
            removeActivity = tmp
        }

        assert addActivity.author == currentUser
        assert addActivity instanceof ModifyRelationshipActivity
        assert addActivity.action == Constants.Action.ADDRELATEDITEMS
        assert addActivity.items == snapshotsOf([child1])

        assert removeActivity.author == currentUser
        assert removeActivity instanceof ModifyRelationshipActivity
        assert removeActivity.action == Constants.Action.REMOVERELATEDITEMS
        assert removeActivity.items == snapshotsOf([child2])

        assert child1.listingActivities.size() == 3
        assert child1.listingActivities[2].author == currentUser
        assert child1.listingActivities[2] instanceof ModifyRelationshipActivity
        assert child1.listingActivities[2].items == snapshotsOf([parent])
        assert child1.listingActivities[2].action == Constants.Action.ADDRELATEDTOITEM
        assert child1.lastActivity == child1.listingActivities[2]

        assert child2.listingActivities.size() == 2
        assert child2.listingActivities[1].author == currentUser
        assert child2.listingActivities[1] instanceof ModifyRelationshipActivity
        assert child2.listingActivities[1].items == snapshotsOf([parent])
        assert child2.listingActivities[1].action == Constants.Action.REMOVERELATEDTOITEM
        assert child2.lastActivity == child2.listingActivities[1]
    }

    public void testChangeLogNotCreatedIfThereAreNoChanges() {
        def (updated, old) = [makeServiceItem(), makeServiceItem()]
        def (activityCountBefore, activityCountAfter) = doChangeLog(updated, old.properties)
        assertEquals activityCountBefore, activityCountAfter
    }

    public void testChangelogNotCreatedIfChangesAreNotAuditable() {
        // This test assumes these are some of the properties in the auditable.ignore list.
        assert Listing.auditable.ignore.containsAll(['avgRate', 'itemComments', 'totalVotes', 'approvalStatus'])

        def (updated, old) = [makeServiceItem(), makeServiceItem()]

        updated.with {
            avgRate = old.avgRate + 1.0
            totalVotes = old.totalVotes + 1
            approvalStatus = old.approvalStatus == ApprovalStatus.IN_PROGRESS ? ApprovalStatus.APPROVED : ApprovalStatus.IN_PROGRESS
            addToItemComments(new ItemComment(rate: 1.0, text: 'review'))
        }

        def (activityCountBefore, activityCountAfter) = doChangeLog(updated, old.properties)
        assert activityCountBefore == activityCountAfter
    }

    public void testChangelogIsCreatedWhenAuditableFieldsAreModified() {
        // This test assumes these are some of some of the auditable properties of a ServiceItem.
        Set fieldsToTest = ['description', 'type', 'title']
        assert Listing.auditable.ignore.disjoint(fieldsToTest)

        def (updated, old) = [makeServiceItem(), makeServiceItem()]

        updated.with {
            title = old.title + ' new!'
            description = old.description + 'new!'
            type = new Types(title: 'new type!!')
        }

        def (activityCountBefore, activityCountAfter, activity) = doChangeLog(updated, old.properties)
        assert activityCountBefore + 1 == activityCountAfter
        assert activity.changeDetails.size() == 3
        assert activity.changeDetails*.fieldName as Set == fieldsToTest

    }

    public void testChangelogIsCreateWhenAuditableCollectionsAreModified() {
        // This test assumes these are some of some of the auditable collection properties of a ServiceItem.
        Set fieldsToTest = ['docUrls', 'contacts', 'screenshots']
        assert Listing.auditable.ignore.disjoint(fieldsToTest)

        def (updated, old) = [makeServiceItem(), makeServiceItem()]

        old.with {
            addToContacts(new Contact(name: "name1"))
            addToDocUrls(new DocUrl(url: "https://url1"))
            if(screenshots) screenshots.clear()
        }

        updated.with {
            if(contacts) contacts.clear()
            addToContacts(new Contact(name: "name2"))
            addToDocUrls(new DocUrl(url: "https://url2"))
            addToScreenshots(new Screenshot(largeImageUrl: 'https://urlurlurlurl'))
        }

        def (activityCountBefore, activityCountAfter, activity) = doChangeLog(updated, old.properties)
        assert activityCountBefore + 1 == activityCountAfter
        assert activity.changeDetails.size() == 3
        assert activity.changeDetails*.fieldName as Set == fieldsToTest
    }

    private doChangeLog(updated, old) {
        def countActivities = { updated.listingActivities?.size() ?: 0 }
        def initialCount = countActivities()
        def activity = service.createChangeLog(updated, old)

        [initialCount, countActivities(), activity]
    }
}
