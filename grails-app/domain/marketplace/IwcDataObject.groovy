package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class IwcDataObject {
    String entity
    String key
    String contentType

    static belongsTo = [profile: Profile]

    static mapping = {
        id natural: [properties: ['key', 'profile']]
        key column: "`key`"
    }

    static constraints = {
        key blank: false, maxSize: 255
        contentType blank: false, maxSize: 129, matches: Constants.MEDIA_TYPE_REGEX
        entity nullable: true
    }

    @Override
    public int hashCode() {
        new HashCodeBuilder()
            .append(key)
            .append(profile)
            .toHashCode()
    }

    @Override
    boolean equals(other) {
        Boolean sameType
        try {
            sameType = other.instanceOf(IwcDataObject)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if (sameType) {
            return new EqualsBuilder()
                .append(key, other.key)
                .append(profile, other.profile)
                .isEquals()
        }

        false
    }
}
