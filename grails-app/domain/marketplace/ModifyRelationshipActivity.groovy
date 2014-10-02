package marketplace

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

class ModifyRelationshipActivity extends ListingActivity {

    List items = []

    static hasMany = [items: ListingSnapshot]

    static mapping = {
        items joinTable: [name: "relationship_activity_log", key: 'mod_rel_activity_id']
        items batchSize: 50
    }

    JSONObject asJSON() {
        def retval = super.asJSON()

        retval.put('relatedItems', new JSONArray(items.collect { ListingSnapshot snapshot ->
            snapshot.asJSON()
        }))
    }
}
