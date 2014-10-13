package marketplace.rest.service

import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import marketplace.Contact
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import org.springframework.security.access.AccessDeniedException

import marketplace.Listing
import marketplace.Type
import marketplace.DocUrl
import marketplace.Screenshot
import marketplace.Profile
import marketplace.ListingActivity
import marketplace.RejectionActivity
import marketplace.RejectionListing
import marketplace.Intent
import marketplace.Relationship
import marketplace.Constants
import marketplace.ApprovalStatus
import marketplace.ChangeDetail
import marketplace.validator.ListingValidator
import ozone.marketplace.enums.RelationshipType

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

@TestMixin(DomainClassUnitTestMixin)
class ListingRestServiceUnitTest {

    GrailsApplication grailsApplication

    ListingRestService service

    Profile currentUser, owner, nonOwner, admin
    Type type1

    private static final exampleServiceItemProps = [
        id: 1,
        title: "test service item",
        type: [ id: 1 ],
        state: [ id: 1 ],
        description: "a test service item",
        launchUrl: "https://localhost/asf",
        owners: [ id: 1 ],
        versionName: '1',
        isEnabled: true,
        isOutside: true,
        approvalStatus: ApprovalStatus.IN_PROGRESS
    ]

    private createGrailsApplication() {
        grailsApplication = new DefaultGrailsApplication()
        grailsApplication.refresh()

        //necessary to get reflection-based marshalling to work
        grailsApplication.addArtefact(DocUrl.class)
        grailsApplication.addArtefact(Screenshot.class)
        grailsApplication.addArtefact(Relationship.class)
        grailsApplication.addArtefact(Intent.class)
        grailsApplication.addArtefact(Listing.class)
        grailsApplication.addArtefact(Contact.class)
        grailsApplication.addArtefact(Profile.class)

        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()
    }

    private makeServiceItem() {
        def exampleServiceItem = new Listing(exampleServiceItemProps + [
            owners: [owner],
            type: type1
        ])
        exampleServiceItem.id = exampleServiceItemProps.id

        return exampleServiceItem
    }

    void setUp() {
        def owner = new Profile(username: 'owner')
        owner.id = 1
        def nonOwner = new Profile(username: 'nonOwner')
        nonOwner.id = 2
        def admin = new Profile(username: 'admin')
        admin.id = 3


        def type = new Type(title: 'Test Type', ozoneAware: true)
        type.id = 1

        type1 = type

        def intent = new Intent(
            action: 'run',
            dataType: 'text/plain'
        )
        intent.id = 1

        createGrailsApplication()

        mockDomain(ChangeDetail.class)
        mockDomain(ListingActivity.class)
        mockDomain(Relationship.class)
        mockDomain(RejectionListing.class)

        mockDomain(Type.class, [type])
        mockDomain(Intent.class, [intent])
        mockDomain(Profile.class, [owner, nonOwner, admin])

        currentUser = admin
        this.admin = admin
        this.owner = owner
        this.nonOwner = nonOwner

        mockDomain(Listing.class)
        makeServiceItem().save(failOnError: true)

        def serviceItemValidator = [
            validateNew: {},
            validateChanges: { a, b -> }
        ] as ListingValidator

        service = new ListingRestService(grailsApplication, serviceItemValidator)

        service.profileRestService = [
            getCurrentUserProfile: { currentUser },
            getById: { id -> Profile.get(id) },
            isAdmin: { currentUser.username.toLowerCase().contains('admin') },
            checkAdmin: {
                if (!currentUser.username.toLowerCase().contains('admin')) {
                    throw new AccessDeniedException('access denied')
                }
            }
        ] as ProfileRestService

        service.listingActivityInternalService = [
            addListingActivity: {si, action -> }
        ] as ListingActivityInternalService

        //dirty checking isn't mocked in unit tests, so we need to mock
        //the method that relies on it
        Listing.metaClass.modifiedForChangeLog = { false }
    }

    void testAuthorizeUpdate() {
        Listing si

        //this should work because the listing is in progress
        currentUser = Profile.findByUsername('owner')
        service.updateById(exampleServiceItemProps.id, makeServiceItem())

        //populate initial ServiceItem
        Listing original = makeServiceItem()
        service.populateDefaults(original)
        original.approvalStatus = ApprovalStatus.APPROVED
        original.save(failOnError: true)

        //this should succeed because owners can always edit their listings
        Listing updates = makeServiceItem()
        service.populateDefaults(updates)
        updates.approvalStatus = ApprovalStatus.APPROVED
        service.updateById(exampleServiceItemProps.id, updates)

        //this should fail because an non-admin, non-owner user is trying to update
        shouldFail(AccessDeniedException) {
            si = Listing.get(1)
            si.approvalStatus = ApprovalStatus.IN_PROGRESS
            si.save(failOnError: true)
            currentUser = nonOwner
            service.updateById(exampleServiceItemProps.id, makeServiceItem())
        }

        //this should succeed because admins can always edit
        currentUser = admin
        service.updateById(exampleServiceItemProps.id, makeServiceItem())
    }

    void testAuthorizeCreate() {

        //dirty checking isn't mocked in unit tests, so we need to mock
        //the method that relies on it
        Listing.metaClass.modifiedForChangeLog = { false }

        //ensure that normal users can create
        currentUser = Profile.findByUsername('nonOwner')
        service.createFromDto(makeServiceItem())

        //ensure that admins can create
        currentUser = Profile.findByUsername('admin')
        Listing dto = service.createFromDto(makeServiceItem())

        assertNotNull dto
    }

    void testApprove() {
        ListingActivity activity
        Listing dto
        def id

        service.listingActivityInternalService = [
            addListingActivity: { si, action ->
                //creation of the changelog uses the other signature
                if(action instanceof ListingActivity)
                    return
                activity = new ListingActivity(action: action, listing: si)
            }
        ] as ListingActivityInternalService

        def approve = {
            dto = makeServiceItem()
            dto.id = id
            dto.approvalStatus = ApprovalStatus.APPROVED
            dto = service.updateById(dto.id, dto)
        }

        dto = makeServiceItem()

        id = service.createFromDto(dto).id
        dto = makeServiceItem()
        dto.id = id
        dto.approvalStatus = ApprovalStatus.PENDING
        dto = service.updateById(dto.id, dto)

        //users cannot approve
        shouldFail(AccessDeniedException) {
            currentUser = this.owner
            approve()
        }

        currentUser = admin

        //need to reset the approval status because the unit tests aren't transactional and
        //the preceding failed change did not get rolled back
        Listing.get(dto.id).approvalStatus = ApprovalStatus.PENDING
        approve()

        assert activity.action == Constants.Action.APPROVED
        assert activity.listing == dto

        //make sure it was approved within the last second
        assert dto.approvedDate.time > (new Date()).time - 1000
    }

    void testReject() {
        Listing created
        ListingActivity activity

        service.listingActivityInternalService = [
            addRejectionActivity: { si, rejectionListing ->
                activity = new RejectionActivity(
                    serviceItem: si,
                    rejectionListing: rejectionListing
                )
            },
            addListingActivity: { si, action -> }
        ] as ListingActivityInternalService

        def reject = {
            service.reject(created, new RejectionListing(
                description: 'bad listing'
            ))
        }

        def id = service.createFromDto(makeServiceItem()).id

        //make a fresh dto
        created = makeServiceItem()
        service.populateDefaults(created)
        created.id = id
        created.approvalStatus = ApprovalStatus.PENDING
        created = service.updateById(created.id, created)

        //in grails 2, shouldFail with a specific exception
        //type doesn't seem to work
        shouldFail(AccessDeniedException) {
            currentUser = this.owner
            reject()
        }

        currentUser = admin
        reject()

        assert created.approvalStatus == ApprovalStatus.REJECTED
        assert activity.rejectionListing.description == 'bad listing'
        assert activity instanceof RejectionActivity
        assert created.rejectionListings == [activity.rejectionListing] as SortedSet
    }

    void testPopulateDefaults() {
        service.profileRestService = [
            isAdmin: { currentUser.username.toLowerCase().contains('admin') },
            checkAdmin: {
                if (!currentUser.username.toLowerCase().contains('admin')) {
                    throw new AccessDeniedException('access denied')
                }
            },
            getCurrentUserProfile: {
                currentUser
            }
        ] as ProfileRestService

        //create a dto with no defaults filled in
        Listing dto = makeServiceItem()
        dto.owners = null


        Listing created = service.createFromDto(dto)

        assert created.owners == [currentUser] as Set

        //create a dto with defaults filled in and ensure that ey are preserved
        dto = makeServiceItem()
        dto.owners = [Profile.findByUsername('nonOwner')]

        created = service.createFromDto(dto)

        assert created.owners == [Profile.findByUsername('nonOwner')] as Set
    }

    void testUpdateHiddenServiceItemActivity() {
        //isEnabled = true is the default
        def id = service.createFromDto(makeServiceItem()).id
        def activity

        service.listingActivityInternalService = [
            addListingActivity: { si, action ->
                activity = new ListingActivity(action: action, listing: si)
            }
        ] as ListingActivityInternalService

        Listing dto = makeServiceItem()
        service.populateDefaults(dto)
        dto.id = id
        dto.isEnabled = false

        dto = service.updateById(id, dto)
        assertNotNull activity
        assert activity.action == Constants.Action.DISABLED
        assert activity.listing == dto


        dto = makeServiceItem()
        service.populateDefaults(dto)
        dto.id = id
        dto.isEnabled = true

        dto = service.updateById(id, dto)
        assertNotNull activity
        assert activity.action == Constants.Action.ENABLED
        assert activity.listing == dto
    }

    void testUpdateRelationshipServiceItemActivity() {
        def makeRelationship = { related=null ->
            new Relationship(
                relationshipType: RelationshipType.REQUIRE,
                relatedItems: related ?: []
            )
        }

        currentUser = Profile.findByUsername('admin')

        def id = service.createFromDto(makeServiceItem()).id
        def parent, added, removed
        def relationship = makeRelationship()
        def relatedItem1 = service.createFromDto(makeServiceItem())
        def relatedItem2 = service.createFromDto(makeServiceItem())

        service.listingActivityInternalService = [
            addListingActivity: { si, action -> },
            addRelationshipActivities: { p, a, r ->
                parent = p
                added = a
                removed = r
            }
        ] as ListingActivityInternalService

        Listing dto = makeServiceItem()
        dto.id = id
        dto.relationships = [makeRelationship([relatedItem1, relatedItem2])]
        service.updateById(id, dto)

        assert parent.id == dto.id
        assert added.collect { it.id } as Set == [relatedItem1.id, relatedItem2.id] as Set
        assert removed as Set == [] as Set

        dto.relationships = [makeRelationship([relatedItem1])]
        service.updateById(id, dto)

        assert added as Set == [] as Set
        assert removed.collect {it.id} as Set == [relatedItem2.id] as Set

        dto.relationships = [makeRelationship([relatedItem2])]
        service.updateById(id, dto)

        assert added.collect {it.id} as Set == [relatedItem2.id] as Set
        assert removed.collect {it.id} as Set == [relatedItem1.id] as Set

        dto.relationships = [makeRelationship([relatedItem2])]
        service.updateById(id, dto)

        assert added as Set == [] as Set
        assert removed as Set == [] as Set
    }

    void testGetAllRequiredServiceItemsByParentId() {
        def makeRelationship = { related=null ->
            new Relationship(
                relationshipType: RelationshipType.REQUIRE,
                relatedItems: related ?: []
            )
        }

        def id = service.createFromDto(makeServiceItem()).id

        def getRequired = {
            service.getAllRequiredListingsByParentId(id)
                .collect {it.id} as Set
        }

        def relationship = makeRelationship()
        def relatedItem1 = service.createFromDto(makeServiceItem())
        def relatedItem2 = makeServiceItem()
        relatedItem2 = service.createFromDto(relatedItem2)

        service.listingActivityInternalService = [
            addListingActivity: { si, action -> },
            addRelationshipActivities: { p, a, r -> }
        ] as ListingActivityInternalService

        Listing dto = makeServiceItem()
        dto.id = id
        dto.relationships = [makeRelationship([relatedItem1, relatedItem2])]
        service.updateById(id, dto)

        assert getRequired() == [relatedItem1.id, relatedItem2.id] as Set

        dto.relationships = [makeRelationship([relatedItem1])]
        service.updateById(id, dto)

        assert getRequired() == [relatedItem1.id] as Set

        dto.relationships = [makeRelationship([relatedItem2])]
        service.updateById(id, dto)

        assert getRequired() == [relatedItem2.id] as Set

        dto.relationships = [makeRelationship()]
        service.updateById(id, dto)

        assert getRequired() == [] as Set
    }

    void testGetAllRequiredServiceItemsByParentIdCyclicDependency() {
        def makeRelationship = { ids=null ->
            new Relationship(
                relationshipType: RelationshipType.REQUIRE,
                relatedItems: ids.collect {
                    def si = new Listing()
                    si.id = it
                    si
                } ?: []
            )
        }

        def id

        def getRequired = {
            service.getAllRequiredListingsByParentId(id)
                .collect {it.id} as Set
        }

        service.listingActivityInternalService = [
            addListingActivity: { si, action -> },
            addRelationshipActivities: { p, a, r -> }
        ] as ListingActivityInternalService

        def relatedItem1Id = service.createFromDto(makeServiceItem()).id
        def relatedItem2Id = service.createFromDto(makeServiceItem()).id

        def relatedItem1Dto = makeServiceItem()
        relatedItem1Dto.id = relatedItem1Id
        relatedItem1Dto.relationships = [makeRelationship([relatedItem2Id])]

        def relatedItem2Dto = makeServiceItem()
        relatedItem2Dto.id = relatedItem2Id
        relatedItem2Dto.relationships = [makeRelationship([relatedItem1Id])]

        def relatedItem1 = service.updateById(relatedItem1Id, relatedItem1Dto)
        def relatedItem2 = service.updateById(relatedItem2Id, relatedItem2Dto)

        def dto = makeServiceItem()
        dto.relationships = [makeRelationship([relatedItem1Id])]
        id = service.createFromDto(dto).id

        assert getRequired() == [relatedItem1.id, relatedItem2.id] as Set
    }

    void testGetAllByAuthorId() {
        Listing.metaClass.static.findAllByAuthor = { Profile a ->
            Listing.list().grep { it.owners.contains(a) }
        }

        Listing existing = Listing.get(1)
        //create a serviceitem that is approved. The default one is not
        Listing approved = makeServiceItem()
        approved.approvalStatus = ApprovalStatus.APPROVED
        approved.id = 2
        approved.save(failOnError: true)

        def author = Profile.findByUsername('owner')
        def authorId = author.id

        currentUser = Profile.findByUsername('nonOwner')

        def serviceItems = service.getAllByAuthorId(authorId)

        assert serviceItems.size() == 1
        assert serviceItems == [approved] as Set
    }
}
