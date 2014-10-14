package marketplace

import gorm.AuditStamp

import org.codehaus.groovy.grails.web.json.JSONObject

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

@AuditStamp
class Intent implements Serializable {

    static searchable = {
        root false
        type index: 'not_analyzed'
        action index: 'not_analyzed'
        only = ['type', 'action']
    }

    String action
    String type
    String label
    String icon

    static mapping = {
        id natural: [properties: ['type', 'action']]
        cache true
        batchSize 50
    }

    static constraints = {
        action blank: false, maxSize: 64, matches: Constants.INTENT_ACTION_REGEX
        type blank: false, maxSize: 129, matches: Constants.MEDIA_TYPE_REGEX
        icon nullable: true, maxSize: Constants.MAX_URL_SIZE, matches: Constants.URL_REGEX
        label nullable: true, maxSize: 255
    }

    def beforeDelete() {
        withNewSession {
            def items = Listing.createCriteria().list {
                intents {
                    equals(this)
                }
            }

            items.each {
                it.removeFromIntents(this)
                //For some reason, the flush is needed to prevent the association from being silently recreated.
                it.save(flush: true)
            }
        }
    }

    String toString() { "$type/$action" }

    JSONObject asJSON() {
        return new JSONObject(
            action: action,
            type: type,
            icon: icon,
            label: label,
            id: id
        )
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(action)
            .append(type)
            .toHashCode()
    }

    @Override
    boolean equals(other) {

        // Since intents are typically in a lazy loaded collection, the instances could be
        // hibernate proxies, so use the GORM 'instanceOf' method
        Boolean sameType
        try {
            sameType = other.instanceOf(Intent)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if (sameType) {
            return new EqualsBuilder()
                .append(action, other.action)
                .append(type, other.type)
                .isEquals()
        }

        false
    }
}
