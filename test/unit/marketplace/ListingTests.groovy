package marketplace

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Ignore
import ozone.utils.TestUtil

import static org.junit.Assert.*

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Listing)
@Mock([ContactType])
class ListingTests {
    def listing

    void setUp() {
        FakeAuditTrailHelper.install()
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
}
