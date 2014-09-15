package marketplace

import gorm.AuditStamp

import org.codehaus.groovy.grails.web.json.JSONObject

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

@AuditStamp
class Intent implements Serializable {
    static searchable = {
        root false
        id index: 'not_analyzed'
        only = ['id']
    }

    static bindableProperties = ['action', 'mainType', 'subType', 'label', 'icon']
    static modifiableReferenceProperties = []

    String action
    String mainType
    String subType
    String label
    String icon
    String id

    public String getMediaType() { "$mainType/$subType" }

    static transients = ['mediaType']

    static constraints = {
        action blank: false, maxSize: 60
        subType blank: false, maxSize: 120
        mainType blank: false, maxSize: 75
        icon nullable: true, maxSize: 2083
        label nullable: true, maxSize: 255
        id maxSize: 255, validator: { val, obj -> val == obj.toString() }
    }

    def beforeValidate() {
        if(!id) {
            id = toString()
        }
    }

    def beforeUpdate() { throw new RuntimeException('Update is not allowed for an existing Intent') }

    static mapping = {
        id generator: 'assigned'
        cache true
        batchSize 50
        version: false
    }

    String toString() { "$mediaType/$action" }

    JSONObject asJSON() {
        return new JSONObject(
            action: action,
            mediaType: mediaType,
            icon: icon,
            label: label
        )
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(action)
            .append(mainType)
            .append(subType)
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
                .append(mainType, other.mainType)
                .append(subType, other.subType)
                .isEquals()
        }

        false
    }
}