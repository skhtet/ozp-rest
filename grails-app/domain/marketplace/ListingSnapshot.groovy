package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject

//TODO Is ther a reason to have this class? title is generally just the title of the serviceItem,
//it seems redundant
class ListingSnapshot implements Serializable {

    Listing listing
    String title

    static belongsTo = ModifyRelationshipActivity

    static constraints = {
        listing nullable: true
    }

    boolean equals(other) {
        other instanceof ListingSnapshot && this.title == other.title &&
            this.listing == other.listing
    }
}
