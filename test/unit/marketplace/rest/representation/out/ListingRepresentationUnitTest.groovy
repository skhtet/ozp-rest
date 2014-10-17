package marketplace.rest.representation.out

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import marketplace.Agency
import marketplace.ApprovalStatus
import marketplace.Contact
import marketplace.ContactType
import marketplace.DocUrl
import marketplace.Intent
import marketplace.Listing
import marketplace.Profile
import marketplace.Category
import marketplace.Screenshot
import marketplace.Type
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType
import marketplace.rest.resource.uribuilder.ListingUriBuilder

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

@TestMixin(GrailsUnitTestMixin)
class ListingRepresentationUnitTest {

    static final String BASE_URL = 'https://localhost/asdf'
    static final Long LISTING_ID = 123

    ListingRepresentation.Factory factory
    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
            getBaseUriBuilder: {
                UriBuilder.fromPath(BASE_URL)
            }
    ] as UriInfo)

    ContactType contactType = new ContactType(title: 'contact type')
    Set<Profile> owners = [new Profile(username: 'testUser1'), new Profile(username: 'testUser2')] as Set
    Set<Category> categories = [new Category(title: 'Category 1'), new Category(title: 'Category 2')] as Set
    ApprovalStatus approvalStatus = ApprovalStatus.IN_PROGRESS
    Set<Contact> contacts = [
        new Contact(
            type: contactType,
            email: '123@123.com',
            securePhone: '1111111',
            unsecurePhone: '123',
            organization: 'contact organization',
            name: 'contact name'
        )
    ]
    Set<DocUrl> docUrls = [new DocUrl(url: 'http://hjkl'),
                           new DocUrl(url: 'http://asdf')] as Set
    Set<Screenshot> screenshots = [new Screenshot(largeImageUrl: 'https://qwerty'),
                                   new Screenshot(largeImageUrl: 'https://asqwe')] as Set
    Set<Intent> intents = [new Intent(type: 'application/json', action: 'edit'),
                           new Intent(type: 'application/json', action: 'view')] as Set
    Type type = new Type(title: 'Web Application')
    Agency organization = new Agency(title: 'org1')

    Listing listing = new Listing(
        type: type,
        owners: owners,
        approvalStatus: approvalStatus,
        categories: categories,
        agency: organization,
        contacts: contacts,
        docUrls: docUrls,
        screenshots: screenshots,
        intents: intents
    )

    def testCollectionSizeAndElementType = { Collection reps, Collection original, Class type ->
        assert reps.size() == original.size()
        reps.each {
            assert (it.class.isAssignableFrom(type))
        }
    }

    void setUp() {

        //Check that original sets are of the expected size
        assert owners.size() == 2
        assert categories.size() == 2
        assert docUrls.size() == 2
        assert screenshots.size() == 2
        assert intents.size() == 2
        assert contacts.size() == 1

        listing.id = LISTING_ID

        factory = new ListingRepresentation.Factory()

        factory.listingUriBuilderFactory = new ListingUriBuilder.Factory() {
            ListingUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ListingUriBuilder(null) {
                    def _url = ListingRepresentationUnitTest.BASE_URL
                    URI getUri(Listing listing) {
                        new URI("$_url/listing/${listing.id}")
                    }

                    URI getListingActivitiesUri(Listing listing) {
                        new URI("$_url/listing/${listing.id}/activity")
                    }

                    URI getListingCommentsUri(Listing listing) {
                        new URI("$_url/listing/${listing.id}/itemComment")
                    }

                    URI getRequiredListingsUri(Listing listing) {
                        new URI("$_url/listing/${listing.id}/requiredListings")
                    }

                    URI getRequiringListingsUri(Listing listing) {
                        new URI("$_url/listing/${listing.id}/requiringListings")
                    }
                }
            }
        }
    }

    void testPropertiesAreConvertedToCorrectRepresentations() {
        ListingRepresentation rep = factory.toRepresentation(listing, uriBuilderHolder)

        testCollectionSizeAndElementType(rep.categories, categories, String.class)
        testCollectionSizeAndElementType(rep.intents, intents, String.class)
        testCollectionSizeAndElementType(rep.owners, owners, OwnerRepresentation.class)
        testCollectionSizeAndElementType(rep.docUrls, docUrls, DocUrlRepresentation.class)
        testCollectionSizeAndElementType(rep.contacts, contacts, ContactRepresentation.class)
        testCollectionSizeAndElementType(rep.screenshots, screenshots, ScreenshotRepresentation.class)

        assert rep.type == type.title
        assert rep.agency == organization.title
    }

    void testListingRepresentationLinks() {
        Map links = factory.toRepresentation(listing, uriBuilderHolder).links.toMap()

        assert links.get(RegisteredRelationType.SELF).href == "$BASE_URL/listing/$LISTING_ID"
        assert links.get(OzpRelationType.ACTIVITY).href == "$BASE_URL/listing/$LISTING_ID/activity"
        assert links.get(OzpRelationType.REQUIRED).href == "$BASE_URL/listing/$LISTING_ID/requiredListings"
        assert links.get(OzpRelationType.REQUIRED_BY).href == "$BASE_URL/listing/$LISTING_ID/requiringListings"
        assert links.get(OzpRelationType.REVIEW).href == "$BASE_URL/listing/$LISTING_ID/itemComment"
    }

    void testContactRepresentation() {
        Contact contact = contacts[0]

        def rep = new ContactRepresentation(contact)

        assert rep.type == contact.type.title
    }
}
