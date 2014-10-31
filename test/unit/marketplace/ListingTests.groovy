package marketplace

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Ignore
import ozone.utils.TestUtil

import static org.junit.Assert.*

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

@TestFor(Listing)
class ListingTests {
    def listing

    void setUp() {
        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()

        mockDomain(Profile)
        mockDomain(ContactType)
        mockDomain(Type)
        mockDomain(Agency)
        mockDomain(Category)
        mockDomain(Contact)
        mockDomain(Listing)

        listing = new Listing()
    }

    @Ignore //disabled until approval workflow is re-enabled
    void testApprovedNotNull() {
        assert listing.approvalStatus != null, "approval status should be initialized set"
        assertEquals "approval status should be initialized to Pending", ApprovalStatus.IN_PROGRESS, listing.approvalStatus
    }

    void testIsEnabledNotNull() {
        assert listing.isEnabled != null, "isEnabled should be initialized set"
        assertEquals "isEnabled should be initialized to true", listing.isEnabled, true
    }

    void testAvgRateNotNull() {
        assert listing.avgRate != null, "avgRate should be initialized set"
        assertEquals "avgRate should be initialized to 0", listing.avgRate as Integer, new Integer(0)
    }

    void testTitleNotBlank(){
        listing.title = ''
        listing.validate()

        assert (listing.errors['title']*.code).find { it == 'blank' }
    }

    void testDescriptionSizeContraints(){
        TestUtil.checkSizeConstraintProperty('description',listing, 4000)
    }

    void testRequirementsSizeContraints(){
        TestUtil.checkSizeConstraintProperty('requirements',listing, 1000)
    }

    void testNullable(){
        listing = new Listing(launchUrl: null,
            installUrl: null,
            requirements: null,
            dependencies: null,
            organization: null)

        assertFalse listing.validate()

        assertNotSame "launchUrl should be allowed to be nullable.", 'nullable', listing.errors['launchUrl']
        assertNotSame "installUrl should be allowed to be nullable.", 'nullable', listing.errors['installUrl']
        assertNotSame "requirements should be allowed to be nullable.", 'nullable', listing.errors['requirements']
        assertNotSame "dependencies should be allowed to be nullable.", 'nullable', listing.errors['dependencies']
        assertNotSame "organization should be allowed to be nullable.", 'nullable', listing.errors['organization']
    }

    void testLaunchURLValid() {
        listing = new Listing(launchUrl: "https://www.foo.com")
        listing.validate()
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "https://192.168.20.28:8443")
        assertFalse listing.validate()
        listing.errors.allErrors.each {
                println it
        }
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://localhost/widgetA")
        assertFalse listing.validate()
        listing.errors.allErrors.each {
            println it
        }
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://localhost:8080/widgetA")
        assertFalse listing.validate()
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://my-machine/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse listing.validate()
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://pctina/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse listing.validate()
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://pctina:8080/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse listing.validate()
        assertNull listing.errors['launchUrl']

        listing = new Listing(launchUrl: "http://pctina:80805/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse listing.validate()
        assertNull listing.errors['launchUrl']
    }

    void testRequiredContactTypes() {
        new ContactType(title: 'requiredType', required: true ).save(flush: true)
        listing.validate()

        assert (listing.errors['contacts']*.code).find { it == 'requiredContactType' }
    }

    void testMinDraftProperties() {
        Type type = new Type(title: "type").save(failOnError: true)
        Profile owner = new Profile(username: 'testAdmin').save(failOnError:true)
        Agency ag = new Agency(title: "agency", shortName: "a").save(failOnError:true)
        Category category = new Category(title: 'cat').save(failOnError:true)
        ContactType contactType = new ContactType(title: "contact type").save(failOnError:true)
        Contact contact = new Contact(
            name: "bob",
            email: "bob@example.com",
            securePhone: '555-5555',
            unsecurePhone: '555-555-5555',
            type: contactType
        )

        listing = new Listing(title: "test", type: type, owners: [owner], approvalStatus: ApprovalStatus.IN_PROGRESS)

        assert listing.save(failOnError: true)

        listing.approvalStatus = ApprovalStatus.PENDING
        assert !listing.validate()

        listing.approvalStatus = ApprovalStatus.APPROVED
        assert !listing.validate()

        listing.approvalStatus = ApprovalStatus.REJECTED
        assert !listing.validate()

        listing.with {
            approvalStatus = ApprovalStatus.PENDING
            width = 10
            height = 10
            whatIsNew = "nothing"
            descriptionShort = "test"
            isFeatured = true
            description = "tes tes test"
            versionName = '1.2.3'
            requirements = "Netscape Navigator"
            agency = ag
            launchUrl = 'https://localhost/asdf'
            categories = [category]
            imageSmallUrl = 'https://localhost/asdf'
            imageMediumUrl = 'https://localhost/asdf'
            imageLargeUrl = 'https://localhost/asdf'
            imageXlargeUrl = 'https://localhost/asdf'
            contacts = [contact]
            screenshots = [new Screenshot(
                smallImageUrl: 'https://localhost/asdf',
                largeImageUrl: 'https://localhost/asdf'
            )]
            docUrls = [new DocUrl(
                name: 'documents',
                url: 'https://localhost/asdf'
            )]
        }

        assert listing.validate()

        def checkAndTest = { valToCheck, prop ->
            def oldVal = listing[prop]
            listing[prop] = valToCheck

            assert !listing.validate()

            listing[prop] = oldVal
        }

        //check that validation fails when these properties are null
        [
            'width',
            'height',
            'whatIsNew',
            'descriptionShort',
            'isFeatured',
            'description',
            'versionName',
            'requirements',
            'agency',
            'launchUrl',
            'categories',
            'imageSmallUrl',
            'imageMediumUrl',
            'imageLargeUrl',
            'imageXlargeUrl',
            'contacts',
            'screenshots'
        ].each(checkAndTest.curry(null))

        //check that empty lists fail validation
        ['categories', 'contacts', 'screenshots'].each(checkAndTest.curry([]))

        //check that empty strings fail validation
        [
            'whatIsNew',
            'descriptionShort',
            'description',
            'versionName',
            'requirements',
            'launchUrl',
            'imageSmallUrl',
            'imageMediumUrl',
            'imageLargeUrl',
            'imageXlargeUrl'
        ].each(checkAndTest.curry(""))
    }
}
