package marketplace

import gorm.AuditStamp

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
    UUID iconId

    static mapping = {
        id natural: [properties: ['type', 'action']]
        cache true
        batchSize 50
    }

    static constraints = {
        action blank: false, maxSize: 64, matches: Constants.INTENT_ACTION_REGEX, unique: 'type'
        type blank: false, maxSize: 129, matches: Constants.MEDIA_TYPE_REGEX
        iconId nullable: true
        label nullable: true, maxSize: 255
    }

    def beforeDelete() {
        withNewSession {
            def items = Listing.createCriteria().list {
                intents {
                    and {
                        eq("action", this.action)
                        eq("type", this.type)
                    }
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
