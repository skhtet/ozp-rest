package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject

class RejectionActivity extends ListingActivity {

    public RejectionActivity(){
        action = Constants.Action.REJECTED
    }

    RejectionListing rejectionListing

    static mapping = {
        //TODO: this doesn't seem right - rejectionListings do not belong to rejectionActivities
        rejectionListing cascade:"delete"
    }
}
