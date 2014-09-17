package marketplace

import gorm.AuditStamp

import org.codehaus.groovy.grails.web.json.JSONObject

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

import java.security.MessageDigest

@AuditStamp
class Intent implements Serializable {

    //Source: http://tools.ietf.org/html/rfc6838#section-4.2
    static final TYPE_REGEX = /^[-\w]([-\w\+\$\!\#\&\-\_\^\.]{1,126})?\/[-\w]([-\w\+\$\!\#\&\-\_\^\.]{1,126})?$/
    static final ACTION_REGEX = /^[-\w]([-\w\+\$\!\#\&\-\_\^\.]{1,126})?$/

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
    String id

    static mapping = {
        id generator: 'assigned'
        cache true
        batchSize 50
    }

    static constraints = {
        action blank: false, maxSize: 127, matches: ACTION_REGEX
        type blank: false, maxSize: 255, matches: TYPE_REGEX
        icon nullable: true, maxSize: 2083
        label nullable: true, maxSize: 255
        id maxSize: 40, validator: { val, obj -> val == generateId(obj) }
    }

    def beforeValidate() {
        if(!id) {
            id = generateId(this)
        }
    }

    def beforeDelete() {
        //there is no "GORM Way" to remove a unidirectional one-to-many association from the many side, so
        //it must be done manually. An alternative is to set the cascade on the foreign key that references intent
        //in the join table during creation of the db schema.
        withNewSession {
            def items = ServiceItem.createCriteria().list {
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
            label: label
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

    /**
     * Calculates the id using a SHA1 digest of type and action
     *
     * @param intent
     * @return
     */
    public static String generateId(intent) {
        MessageDigest.getInstance('SHA1')
            .digest("${intent.type}/${intent.action}".bytes)
            .encodeAsHex()
    }
}
