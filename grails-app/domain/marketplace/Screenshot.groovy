package marketplace

import gorm.AuditStamp
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * A Domain class representing a pair of screenshots.  This pair should consist of
 * a large version and a small version of the same image.  The large version is optional.
 * If it is not present, the small version should be used for both
 */
@AuditStamp
class Screenshot implements Serializable {

    static searchable = {
        root false
        largeImage index: 'not_analyzed', excludeFromAll: true
        smallImage index: 'not_analyzed', excludeFromAll: true
    }

    static belongsTo = [serviceItem: Listing]
    static embedded = ['largeImage', 'smallImage']

    ImageReference largeImage
    ImageReference smallImage

    static constraints = {
        smallImage nullable: false
        largeImage nullable: true
    }

    public ImageReference getLargeImage() {
        this.largeImage ? this.largeImage : this.smallImage
    }

    @Override
    boolean equals(other) {
        // Since screenshots is a lazy loaded collection, the instances could be
        // hibernate proxies, so use the GORM 'instanceOf' method
        Boolean sameType
        try {
            sameType = other.instanceOf(Screenshot)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if(sameType) {
            return new EqualsBuilder()
                        .append(smallImage, other.smallImage)
                        .append(largeImage, other.largeImage)
                        .isEquals()
        }
        return false
    }

    @Override
    int hashCode() {
        return new HashCodeBuilder()
                    .append(smallImage)
                    .append(largeImage)
                    .toHashCode()
    }
}
