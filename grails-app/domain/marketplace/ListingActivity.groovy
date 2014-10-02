package marketplace

import gorm.AuditStamp
import org.codehaus.groovy.grails.web.json.JSONObject
import marketplace.Constants.Action

//Domain object that holds an audit trail of a listing.
@AuditStamp
class ListingActivity implements Serializable {

    static constraints = {
        action maxSize: 128
    }

    Action action
    Date activityDate = new Date()

    static belongsTo = [listing: Listing, author: Profile]

    static hasMany = [changeDetails: ChangeDetail]

    static mapping = {
        author fetch: 'join'
        cache true
        tablePerHierarchy false
        changeDetails batchSize: 25
    }

    String toString(){
        return AdminObjectFormatter.fullDateDisplay(activityDate)
    }

    String prettyPrint() {
        toString()
    }

    JSONObject asJSON() {
        new JSONObject(
            author: author.asJSONRef(),
            action: action.asJSON(),
            activityDate: activityDate,
            listing: listing.asJSONMinimum(),
            changeDetails: changeDetails.collect { it.asJSON() }
        )
    }
}
