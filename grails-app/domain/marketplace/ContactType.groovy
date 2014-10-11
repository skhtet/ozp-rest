package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.web.json.JSONObject
import gorm.AuditStamp

@AuditStamp
class ContactType implements Serializable {

    static searchable = {
        root false
        title index: 'not_analyzed', excludeFromAll: true
        only = ['title']
    }

    String title
    Boolean required = false

    static constraints = {
        title blank: false, maxSize: 50
    }

    static mapping = {
        cache true
        id natural: [properties: ['title'], mutable: true]
    }

    final static bindableProperties = ['title', 'required']
    final static modifiableReferenceProperties = []

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(title)
            .toHashCode()
    }

    @Override
    boolean equals(other) {
        if (other instanceof ContactType) {
            return new EqualsBuilder()
                .append(title, other.title)
                .isEquals()
        }
        return false
    }

    JSONObject asJSON() {
        new JSONObject([
            id: id,
            title: title,
            required: required
        ])
    }

    @Override
    String toString() { title }

    def beforeDelete() {
        ContactType.withNewSession {
            Contact.findAllByType(this)*.delete()
        }
    }
}
