package marketplace

import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder

@gorm.AuditStamp
class Category implements Serializable {
    static searchable = {
        root false
        title index: 'not_analyzed'
        only = ['title']
    }

    String title
    String description

    static constraints = {
        title blank: false, nullable: false, maxSize: 50
        description nullable: true, maxSize: 255
    }
    static mapping = {
        id natural: [properties: ['title'], mutable: true]
        cache true
        batchSize 50
    }

    @Override
    String toString() { title }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(title)
            .toHashCode()
    }

    @Override
    boolean equals(Object other) {
        if (other instanceof Category) {
            return new EqualsBuilder()
                .append(title, other.title)
                .isEquals()
        }

        false
    }
}
