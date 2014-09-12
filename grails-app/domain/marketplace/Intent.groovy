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

    public String getDataType() { "$mainType/$subType" }

    static constraints = {
        action blank: false, maxSize: 75
        subType blank: false, maxSize: 105
        mainType blank: false, maxSize: 75
        icon nullable: true, maxSize: 2083
        label nullable: true, maxSize: 255
        id maxSize: 255
    }

    static transients = ['dataType']

    static mapping = {
        id generator: 'assigned'
        cache true
        batchSize 50
    }

    String toString() {
        "$dataType/$action"
    }

    def beforeValidate() {
        id = toString()
    }

    JSONObject asJSON() {
        return new JSONObject(
            action: action,
            dataType: dataType,
            icon: icon,
            label: label
        )
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(action)
            .append(dataType)
            .toHashCode()
    }

    @Override
    boolean equals(obj) {

        // Since intents are typically in a lazy loaded collection, the instances could be
        // hibernate proxies, so use the GORM 'instanceOf' method
        Boolean sameType
        try {
            sameType = obj.instanceOf(Intent)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if (sameType) {
            return new EqualsBuilder()
                .append(action, obj.action)
                .append(dataType, obj.dataType)
                .isEquals()
        }

        false
    }

}
