
package marketplace

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.json.JSONObject
import org.junit.Test

import marketplace.testutil.FakeAuditTrailHelper

@TestFor(Agency)
class AgencyTests {

    void setUp() {
        FakeAuditTrailHelper.install()
    }

    @Test
    public void testToString(){
        def agency = new Agency(title: 'Agency Title')
        assert agency.toString() == 'Agency Title'
    }


    @Test
    public void testAsJSON(){
        Agency agency = new Agency(title: "Title", iconUrl: "iconUrl.png")
        agency.id = 1


        JSONObject json = agency.asJSON()

        assert agency.id == json.id
        assert agency.title == json.title
        assert agency.iconUrl == json.iconUrl
    }
}
