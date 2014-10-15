package marketplace

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

import ozone.marketplace.enums.RelationshipType

class Relationship implements Serializable {

    List<Listing> relatedItems
    RelationshipType relationshipType

    static hasMany = [relatedItems: Listing]
    static belongsTo = [owningEntity: Listing]

    static constraints = {
        owningEntity(nullable: false)
    }

    /**
     * Find all Relationships whose relatedItems include the specificed ServiceItem
     */
    static Collection<Relationship> findRelationshipsByRelatedItem(Listing related) {
        Relationship.createCriteria().list {
            relatedItems {
                eq('id', related.id)
            }
        }
    }
}
