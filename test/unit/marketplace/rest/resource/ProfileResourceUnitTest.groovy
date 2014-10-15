package marketplace.rest.resource

import org.codehaus.groovy.grails.web.json.JSONArray

import marketplace.Profile
import marketplace.Listing
import marketplace.ItemComment
import marketplace.ListingActivity
import marketplace.Constants

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.TestMixin

import marketplace.rest.service.ProfileRestService
import marketplace.rest.service.ListingActivityRestService
import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.ListingRestService

@TestMixin(DomainClassUnitTestMixin)
class ProfileResourceUnitTest {

    ProfileResource resource

    def currentUser

    void setUp() {
        def testUser = new Profile(username: 'testUser')
        testUser.id = 1

        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()

        mockDomain(Profile.class, [testUser])

        def profileRestService = [
            getCurrentUserProfile: { currentUser },
            getById: { id ->
                Profile.get(id)
            }
        ] as ProfileRestService


        resource = new ProfileResource(profileRestService)
    }

    void testGetOwnProfile() {
        currentUser = Profile.get(1)
        assert resource.getOwnProfile() == currentUser
    }

    void testGetListingsByAuthorId() {
        def idPassedIn

        def listingRestServiceMock = mockFor(ListingRestService)
        listingRestServiceMock.demand.getAllByAuthorId(1..1) { id ->
            idPassedIn = id
            return null
        }

        resource.listingRestService = listingRestServiceMock.createMock()

        def idToPass = 1 as String

        resource.getListingsByAuthorId(idToPass)

        assert idPassedIn == idToPass as Integer
    }

    void testGetOwnListings() {
        currentUser = Profile.get(1)

        def idPassedIn

        def listingRestServiceMock = mockFor(ListingRestService)
        listingRestServiceMock.demand.getAllByAuthorId(1..1) { id ->
            idPassedIn = id
            return null
        }

        resource.listingRestService = listingRestServiceMock.createMock()

        resource.getListingsByAuthorId('self')

        assert idPassedIn == currentUser.id
    }

    void testGetItemCommentsByAuthorId() {
        def idPassedIn

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.getAllByAuthorId(1..1) { id ->
            idPassedIn = id

            return [new ItemComment(
                author: Profile.get(1),
                text: 'blah blah',
                rate: 1,
                listing: new Listing(title: 'test listing')
            )] as Set
        }

        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()

        def idToPass = 1 as String

        def dtos = resource.getItemCommentsByAuthorId(idToPass)
        def json = dtos.collect { it.asJSON() }

        assert idPassedIn == idToPass as Integer

        assert json.size() == 1
        assert json[0].text == 'blah blah'
        assert json[0].rate == 1
    }

    void testGetOwnItemComments() {
        currentUser = Profile.get(1)

        def idPassedIn

        def itemCommentRestServiceMock = mockFor(ItemCommentRestService)
        itemCommentRestServiceMock.demand.getAllByAuthorId(1..1) { id ->
            idPassedIn = id

            return [new ItemComment(
                author: Profile.get(1),
                text: 'blah blah',
                rate: 1,
                listing: new Listing(title: 'test listing')
            )] as Set
        }

        resource.itemCommentRestService = itemCommentRestServiceMock.createMock()

        def dtos = resource.getItemCommentsByAuthorId('self')
        def json = dtos.collect { it.asJSON() }

        assert idPassedIn == currentUser.id

        assert json.size() == 1
        assert json[0].text == 'blah blah'
        assert json[0].rate == 1
    }

//    void testGetTagsByProfileId() {
//        def idPassedIn
//
//        def serviceItemTagRestServiceMock = mockFor(ServiceItemTagRestService)
//        serviceItemTagRestServiceMock.demand.getAllByProfileId(1..1) { id ->
//            idPassedIn = id
//
//            def tag = new Tag(title: 'tag 1')
//            tag.id = 1
//
//            def serviceItem = new ServiceItem(title: 'listing 1')
//            serviceItem.id = 2
//
//            return [new ServiceItemTag(
//                createdBy: Profile.get(id),
//                tag: tag,
//                serviceItem: serviceItem
//            )] as Set
//        }
//
//        resource.serviceItemTagRestService = serviceItemTagRestServiceMock.createMock()
//
//        def idToPass = 1
//
//        def dtos = resource.getTagsByProfileId(idToPass)
//        def json = dtos.collect {
//            assert it instanceof ProfileServiceItemTagDto
//            it.asJSON()
//        } as JSONArray
//
//        assert idPassedIn == idToPass
//
//        assert json.size() == 1
//        assert json[0].tag.title == 'tag 1'
//        assert json[0].tag.id == 1
//        assert json[0].serviceItem.title == 'listing 1'
//        assert json[0].serviceItem.id == 2
//    }

//    void testOwnTags() {
//        currentUser = Profile.get(1)
//
//        def idPassedIn
//
//        def serviceItemTagRestServiceMock = mockFor(ServiceItemTagRestService)
//        serviceItemTagRestServiceMock.demand.getAllByProfileId(1..1) { id ->
//            idPassedIn = id
//
//            def tag = new Tag(title: 'tag 1')
//            tag.id = 1
//
//            def serviceItem = new ServiceItem(title: 'listing 1')
//            serviceItem.id = 2
//
//            return [new ServiceItemTag(
//                createdBy: Profile.get(id),
//                tag: tag,
//                serviceItem: serviceItem
//            )] as Set
//        }
//
//        resource.serviceItemTagRestService = serviceItemTagRestServiceMock.createMock()
//
//        def dtos = resource.getOwnTags()
//        def json = dtos.collect {
//            assert it instanceof ProfileServiceItemTagDto
//            it.asJSON()
//        } as JSONArray
//
//        assert idPassedIn == currentUser.id
//
//        assert json.size() == 1
//        assert json[0].tag.title == 'tag 1'
//        assert json[0].tag.id == 1
//        assert json[0].serviceItem.title == 'listing 1'
//        assert json[0].serviceItem.id == 2
//    }

    void testGetListingActivitiesByProfileId() {
        def idPassedIn, offsetPassedIn, maxPassedIn

        def listingActivityRestServiceMock = mockFor(ListingActivityRestService)
        listingActivityRestServiceMock.demand.getAllByProfileId(1..1) { id, offset, max ->
            idPassedIn = id
            offsetPassedIn = offset
            maxPassedIn = max

            def listing = new Listing(title: 'listing 1')
            listing.id = 2

            return [new ListingActivity(
                action: Constants.Action.CREATED,
                author: Profile.get(1),
                listing: listing
            )]
        }

        resource.listingActivityRestService = listingActivityRestServiceMock.createMock()

        def idToPass = 1 as String
        def offsetToPass = 10
        def maxToPass = 5

        def dtos = resource.getListingActivitiesByProfileId(idToPass, offsetToPass, maxToPass)

        assert idPassedIn == idToPass as Integer
        assert offsetPassedIn == offsetToPass
        assert maxPassedIn == maxToPass

        assert dtos.size() == 1
        assert dtos[0].action == Constants.Action.CREATED
        assert dtos[0].author.id == 1
        assert dtos[0].listing.title == 'listing 1'
        assert dtos[0].listing.id == 2
    }

    void testGetOwnListingActivities() {
        currentUser = Profile.get(1)

        def idPassedIn, offsetPassedIn, maxPassedIn

        def listingActivityRestServiceMock = mockFor(ListingActivityRestService)
        listingActivityRestServiceMock.demand.getAllByProfileId(1..1) { id, offset, max ->
            idPassedIn = id
            offsetPassedIn = offset
            maxPassedIn = max

            def listing = new Listing(title: 'listing 1')
            listing.id = 2

            return [new ListingActivity(
                action: Constants.Action.CREATED,
                author: Profile.get(1),
                listing: listing
            )]
        }

        resource.listingActivityRestService = listingActivityRestServiceMock.createMock()

        def offsetToPass = 10
        def maxToPass = 5

        def dtos = resource.getListingActivitiesByProfileId('self', offsetToPass, maxToPass)

        assert idPassedIn == currentUser.id
        assert offsetPassedIn == offsetToPass
        assert maxPassedIn == maxToPass

        assert dtos.size() == 1
        assert dtos[0].action == Constants.Action.CREATED
        assert dtos[0].author.id == 1
        assert dtos[0].listing.title == 'listing 1'
        assert dtos[0].listing.id == 2
    }

    void testGetListingActivitiesByListingOwnerId() {
        def idPassedIn, offsetPassedIn, maxPassedIn

        def listingActivityRestServiceMock = mockFor(ListingActivityRestService)
        listingActivityRestServiceMock.demand.getAllByListingOwnerId(1..1) { id, offset,
                max ->

            idPassedIn = id
            offsetPassedIn = offset
            maxPassedIn = max

            def listing = new Listing(title: 'listing 1')
            listing.id = 2

            return [new ListingActivity(
                action: Constants.Action.CREATED,
                author: Profile.get(1),
                listing: listing
            )]
        }

        resource.listingActivityRestService = listingActivityRestServiceMock.createMock()

        def idToPass = 1 as String
        def offsetToPass = 10
        def maxToPass = 5

        def dtos = resource.getListingActivitiesByListingOwnerId(idToPass, offsetToPass,
                maxToPass)

        assert idPassedIn == idToPass as Integer
        assert offsetPassedIn == offsetToPass
        assert maxPassedIn == maxToPass

        assert dtos.size() == 1
        assert dtos[0].action == Constants.Action.CREATED
        assert dtos[0].author.id == 1
        assert dtos[0].listing.title == 'listing 1'
        assert dtos[0].listing.id == 2
    }

    void testGetListingActivitiesOnOwnListings() {
        currentUser = Profile.get(1)

        def idPassedIn, offsetPassedIn, maxPassedIn

        def listingActivityRestServiceMock = mockFor(ListingActivityRestService)
        listingActivityRestServiceMock.demand.getAllByListingOwnerId(1..1) { id, offset,
                max ->

            idPassedIn = id
            offsetPassedIn = offset
            maxPassedIn = max

            def listing = new Listing(title: 'listing 1')
            listing.id = 2

            return [new ListingActivity(
                action: Constants.Action.CREATED,
                author: Profile.get(1),
                listing: listing
            )]
        }

        resource.listingActivityRestService = listingActivityRestServiceMock.createMock()

        def offsetToPass = 10
        def maxToPass = 5

        def dtos = resource.getListingActivitiesByListingOwnerId('self', offsetToPass,
                maxToPass)

        assert idPassedIn == currentUser.id
        assert offsetPassedIn == offsetToPass
        assert maxPassedIn == maxToPass

        assert dtos.size() == 1
        assert dtos[0].action == Constants.Action.CREATED
        assert dtos[0].author.id == 1
        assert dtos[0].listing.title == 'listing 1'
        assert dtos[0].listing.id == 2
    }
}
