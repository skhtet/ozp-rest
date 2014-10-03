package marketplace

import grails.test.mixin.TestFor
import ozone.utils.TestUtil

import static org.junit.Assert.*

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Listing)
class ListingTests {
    def serviceItem

    void setUp() {
        FakeAuditTrailHelper.install()

        mockForConstraintsTests(Listing)
        serviceItem = new Listing()
    }

    @Ignore //disabled until approval workflow is re-enabled
    void testApprovedNotNull() {
        assert serviceItem.approvalStatus != null, "approval status should be initialized set"
        assertEquals "approval status should be initialized to Pending", ApprovalStatus.IN_PROGRESS, serviceItem.approvalStatus
    }

    void testIsEnabledNotNull() {
        assert serviceItem.isEnabled != null, "isEnabled should be initialized set"
        assertEquals "isEnabled should be initialized to true", serviceItem.isEnabled, true
    }

    void testAvgRateNotNull() {
        assert serviceItem.avgRate != null, "avgRate should be initialized set"
        assertEquals "avgRate should be initialized to 0", serviceItem.avgRate as Integer, new Integer(0)
    }

    /**
     * class ServiceItem {
     *      ...
     *      title blank: false
     *      ...
     * }
     */
    void testTitleNotBlank(){
        serviceItem = new Listing()
        serviceItem.title = ''
        assertFalse serviceItem.validate()
        assertEquals 'title is blank.', 'blank', serviceItem.errors['title']

        serviceItem.title = "Not Blank Title For Test"
        assertFalse serviceItem.validate() //Other items haven't been set yet
        assertNotSame "title is not allowed to be blank.", 'blank', serviceItem.errors['title']
    }

    /**
     * class ServiceItem {
     *      ...
     *      description maxSize: 500
     *      ...
     * }
     */
    void testDescriptionSizeContraints(){
        TestUtil.checkSizeConstraintProperty('description',serviceItem, 4000)
    }

    /**
     * class ServiceItem {
     *      ...
     *      requirements maxSize: 250
     *      ...
     * }
     */
    void testRequirementsSizeContraints(){
        TestUtil.checkSizeConstraintProperty('requirements',serviceItem, 1000)
    }

    /**
     * class ServiceItem {
     *      ...
     *      description validator: {
     *          if (it.size() > 500)
     *          {
     *              return ["serviceItem.description.maxsize",500]
     *          }
     *          else
     *              return true
     *      }
     *      ...
     * }
     */
    void testDescriptionCustomValidator(){
        serviceItem = new Listing(description: TestUtil.getStringOfLength(4001))
        assertFalse serviceItem.validate()
        assertEquals 'description fails validation of size 4001.', 'maxSize', serviceItem.errors['description']

        serviceItem = new Listing(description: TestUtil.getStringOfLength(4000))
        assertFalse serviceItem.validate() //Other items haven't been set yet
        assertNotSame "description should pass validation of size 4000", 'maxSize', serviceItem.errors['description']
    }

    /**
     * class ServiceItem {
     *      ...
     *      launchUrl nullable: true
     *      docUrl nullable: true
     *      ...
     *      installUrl nullable: true
     *      ...
     *      requirements nullable: true
     *      dependencies nullable: true
     *      organization nullable: true
     *      ...
     *      emailAddress nullable: true
     *      ...
     * }
     */
    void testNullable(){
        serviceItem = new Listing(launchUrl: null,
            installUrl: null,
            requirements: null,
            dependencies: null,
            organization: null)

        assertFalse serviceItem.validate()

        assertNotSame "launchUrl should be allowed to be nullable.", 'nullable', serviceItem.errors['launchUrl']
        assertNotSame "installUrl should be allowed to be nullable.", 'nullable', serviceItem.errors['installUrl']
        assertNotSame "requirements should be allowed to be nullable.", 'nullable', serviceItem.errors['requirements']
        assertNotSame "dependencies should be allowed to be nullable.", 'nullable', serviceItem.errors['dependencies']
        assertNotSame "organization should be allowed to be nullable.", 'nullable', serviceItem.errors['organization']
    }

    void testLaunchURLValid() {
        serviceItem = new Listing(launchUrl: "https://www.foo.com")
        serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "https://192.168.20.28:8443")
        assertFalse serviceItem.validate()
        serviceItem.errors.allErrors.each {
                println it
        }
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://localhost/widgetA")
        assertFalse serviceItem.validate()
        serviceItem.errors.allErrors.each {
            println it
        }
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://localhost:8080/widgetA")
        assertFalse serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://my-machine/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://pctina/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://pctina:8080/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        serviceItem = new Listing(launchUrl: "http://pctina:80805/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNull serviceItem.errors['launchUrl']

        // too many digits in port
        /*
        serviceItem = new ServiceItem(launchUrl: "http://pctina:808056/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNotNull serviceItem.errors['launchUrl']

        // No port #, though indicates port
        serviceItem = new ServiceItem(launchUrl: "http://pctina:/owf/examples/fake-widgets/img/fakeWidgets/fakeWidget8.png")
        assertFalse serviceItem.validate()
        assertNotNull serviceItem.errors['launchUrl']
         */

    }

    //TODO see if there is a way to get getPersistentValue
    //working in grails 2 unit tests
    //void testModifiedForChangelog() {
        //def dirtyProperty
        //def oldValue = 'old'
        //def newValue = 'new'
        //def serviceItemDirty
        //def owfPropertiesDirty
        //def categoryDirty

        //ServiceItem.metaClass.isDirty = {
            //serviceItemDirty
        //}

        //ServiceItem.metaClass.getDirtyPropertyNames = {
            //[dirtyProperty]
        //}

        //ServiceItem.metaClass.getPersistentValue = { prop ->
            //if (prop == dirtyProperty) {
                //oldValue
            //}
            //else if (prop == 'owfProperties') {
                //new OwfProperties(
                    //universalName: dirtyProperty == 'universalName' ? oldValue : newValue
                //)
            //}
        //}

        //OwfProperties.metaClass.isDirty = {
            //owfPropertiesDirty
        //}

        //OwfProperties.metaClass.getDirtyPropertyNames = {
            //[dirtyProperty]
        //}

        //OwfProperties.metaClass.getPersistentValue = {
            //oldValue
        //}

        //Category.metaClass.isDirty = {
            //categoryDirty
        //}

        //Category.metaClass.getDirtyPropertyNames = {
            //[dirtyProperty]
        //}

        //Category.metaClass.getPersistentValue = {
            //oldValue
        //}

        //def testServiceItem = new ServiceItem(
            //title: newValue,
            //owfProperties: new OwfProperties(
                //universalName: newValue
            //),
            //categories: [new Category(title: newValue)]
        //)

        ////test detection of dirty properties directly on the service item
        //serviceItemDirty = false
        //owfPropertiesDirty = false
        //categoryDirty = false
        //assertFalse testServiceItem.modifiedForChangeLog()

        //serviceItemDirty = true
        //dirtyProperty = 'version'   //a property that should be ignored
        //assertFalse testServiceItem.modifiedForChangeLog()

        //dirtyProperty = 'title'
        //assertTrue testServiceItem.modifiedForChangeLog()

        //oldValue = 'new' //supposedly dirty, but the value hasn't actually changed
        //assertFalse testServiceItem.modifiedForChangeLog()
        //oldValue = 'old'

        ////test detection of dirty properties on the owfProperties
        //serviceItemDirty = false
        //owfPropertiesDirty = true
        //dirtyProperty = 'version'
        //assertFalse testServiceItem.modifiedForChangeLog()

        //dirtyProperty = 'universalName'
        //assertTrue testServiceItem.modifiedForChangeLog()

        //oldValue = 'new' //supposedly dirty, but the value hasn't actually changed
        //assertFalse testServiceItem.modifiedForChangeLog()
        //oldValue = 'old'

        ////test that subobjects are checked.  Using category as an example but recommendedLayouts
        ////and customFields should also work
        //owfPropertiesDirty = false
        //categoryDirty = true
        //dirtyProperty = 'title'
        //assertTrue testServiceItem.modifiedForChangeLog()

        //oldValue = 'new' //supposedly dirty, but the value hasn't actually changed
        //assertFalse testServiceItem.modifiedForChangeLog()
        //oldValue = 'old'
    //}
}
