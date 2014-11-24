package marketplace.rest.resource

import marketplace.Listing
import marketplace.RejectionListing
import marketplace.ItemComment
import marketplace.ListingActivity
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import grails.orm.PagedResultList

import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.RejectionListingRestService
import marketplace.rest.service.ListingRestService
import marketplace.rest.service.ListingActivityRestService

import marketplace.rest.ChildObjectCollection

import marketplace.hal.PagedCollection

import static javax.servlet.http.HttpServletResponse.*

import marketplace.rest.representation.in.ItemCommentInputRepresentation
import marketplace.rest.representation.in.RejectionListingInputRepresentation
import marketplace.rest.representation.in.AgencyTitleInputRepresentation

import marketplace.testutil.MockPagedResultList

@TestMixin(DomainClassUnitTestMixin)
class ListingResourceUnitTest {
    ListingResource resource

    void setUp() {
        resource = new ListingResource()
    }

    void testGetActivitiesForServiceItems() {
        ListingActivity activity = new ListingActivity()
        def passedOffset, passedMax

        def serviceItemActivityRestServiceMock = mockFor(ListingActivityRestService)
        serviceItemActivityRestServiceMock.demand.getAll(1..1) { offset, max ->
            passedOffset = offset
            passedMax = max
            [activity]
        }
        resource.listingActivityRestService = serviceItemActivityRestServiceMock.createMock()

        assert resource.getActivitiesForListings(1,2) == new PagedCollection(1, 2, [activity])
        assert passedOffset == 1
        assert passedMax == 2
    }

    void testGetServiceItemActivitiesForServiceItem() {

        ListingActivity activity = new ListingActivity()
        def passedParentId, passedParentServiceId, passedOffset, passedMax
        def parent = new Listing()

        def pagedList = new MockPagedResultList().createPagedResultList([activity])

        def serviceItemActivityRestServiceMock = mockFor(ListingActivityRestService)
        serviceItemActivityRestServiceMock.demand.getByParentId(1..1) { parentId, offset, max ->
            passedParentId = parentId
            passedOffset = offset
            passedMax = max
            pagedList
        }

        def listingRestServiceMock = mockFor(ListingRestService)
        listingRestServiceMock.demand.getById(1..1) { id ->
            passedParentServiceId = id
            parent
        }

        resource.listingActivityRestService = serviceItemActivityRestServiceMock.createMock()
        resource.service = listingRestServiceMock.createMock()

        def result = resource.getListingActivitiesForListing(20, 1,2)
        assert result.collection.is(pagedList)
        assert result.parent == parent
        assert passedParentId == 20
        assert passedParentServiceId == 20
        assert passedOffset == 1
        assert passedMax == 2
    }

    void testCreateRejectionListing() {
        RejectionListingInputRepresentation rejectionListing = new RejectionListingInputRepresentation()
        def passedParentId, passedDto, returnedObj

        def rejectionListingRestServiceMock = mockFor(RejectionListingRestService)
        rejectionListingRestServiceMock.demand.createFromParentIdAndRepresentation(1..1) { parentId, dto ->
            passedParentId = parentId
            passedDto = dto
            return (returnedObj = new RejectionListing())
        }
        resource.rejectionListingRestService = rejectionListingRestServiceMock.createMock()

        assert resource.createRejectionListing(1, rejectionListing) == returnedObj
        assert passedParentId == 1
        assert passedDto == rejectionListing
    }

    void testGetMostRecentRejectionListing() {
        RejectionListing rejectionListing = new RejectionListing()
        def passedParentId

        def rejectionListingRestServiceMock = mockFor(RejectionListingRestService)
        rejectionListingRestServiceMock.demand.getMostRecentRejectionListing(1..1) {
                parentId ->
            passedParentId = parentId
            rejectionListing
        }
        resource.rejectionListingRestService = rejectionListingRestServiceMock.createMock()

        assert resource.getMostRecentRejectionListing(1) == rejectionListing
        assert passedParentId == 1
    }

    void testGetRequiredServiceItems() {
        Listing serviceItem = new Listing()
        def passedParentId

        def serviceItemRestServiceMock = mockFor(ListingRestService)
        serviceItemRestServiceMock.demand.getAllRequiredListingsByParentId(1..2) {
                parentId ->
            passedParentId = parentId
            [serviceItem]
        }
        resource.service = serviceItemRestServiceMock.createMock()

        assert resource.getRequiredListings(1) == [serviceItem]
        assert passedParentId == 1

        resource.getRequiredListings(25)
        assert passedParentId == 25
    }

    void testGetRequiringServiceItems() {
        Listing serviceItem = new Listing()
        def passedParentId

        def serviceItemRestServiceMock = mockFor(ListingRestService)
        serviceItemRestServiceMock.demand.getRequiringListingsByChildId(1..2) {
                parentId ->
            passedParentId = parentId
            [serviceItem]
        }
        resource.service = serviceItemRestServiceMock.createMock()

        assert resource.getRequiringListings(1) == [serviceItem]
        assert passedParentId == 1

        resource.getRequiringListings(25)
        assert passedParentId == 25
    }

    void testGetItemCommentsByServiceItem() {
        ItemComment comment = new ItemComment()
        Listing listing = new Listing()
        def passedParentId
        def passedListingId

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.getByParentId(1..1) { parentId ->
            passedParentId = parentId
            [comment]
        }
        def listingRestServiceMock = mockFor(ListingRestService)
        listingRestServiceMock.demand.getById(1..1) { id ->
            passedListingId = id
            return listing
        }

        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()
        resource.service = listingRestServiceMock.createMock()

        ChildObjectCollection result = resource.getItemCommentsByListingId(20)

        assert result.collection == [comment]
        assert result.parent == listing
        assert passedParentId == 20
        assert passedListingId == 20
    }

    void testCreateItemComment() {
        def passedParentId, passedRep, createdComment

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.createFromParentIdAndRepresentation(1..1) {
                parentId, rep ->
            passedParentId = parentId
            passedRep = rep
            createdComment = new ItemComment()
            createdComment.id = 1
            createdComment
        }
        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()
        def commentRep = new ItemCommentInputRepresentation([rate: 1, text: "blah"])
        def response = resource.createItemComment(1, commentRep)

        assert response.status == SC_CREATED
        assert response.entity == createdComment
        assert passedParentId == 1
        assert passedRep == commentRep
    }

    void testUpdateItemComment() {
        def comment = new ItemCommentInputRepresentation()
        def passedId, passedDto, createdComment

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.updateById(1..1) { id, dto ->
            passedId = id
            passedDto = dto
            createdComment = new ItemComment()
        }
        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()

        assert resource.updateItemComment(1, 50, comment) == createdComment
        assert passedId == 50
        assert passedDto == comment
    }

    void testDeletedItemComment() {
        def passedId

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.deleteById(1..1) { id ->
            passedId = id
        }
        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()

        resource.deleteItemComment(1)
        assert passedId == 1
    }
}
