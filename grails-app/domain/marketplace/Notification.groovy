package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import gorm.AuditStamp

@AuditStamp
class Notification implements Serializable{

    static constraints = {
        message blank: false, maxSize: 150
        expiresDate blank: false
    }

    static hasMany = [
            // The users who have already dismissed this notification
            dismissedBy: Profile
    ]

    static belongsTo = Profile

    static mappedBy = [
            //keep grails from getting confused into thinking that these are opposite sides of the
            //same relationship
            createdBy: 'none',
            editedBy: 'none'
    ]

    // createdDate from @AuditStamp
    // createdBy from @AuditStamp
    Date expiresDate
    String message

    Set<Profile> dismissedBy = new HashSet()

    @Override
    String toString() {
        return "notification:${message}"
    }

    @Override
    boolean equals(other) {

        if (other instanceof Notification) {
            return new EqualsBuilder()
                    .append(message, other.message)
                    .append(expiresDate, other.expiresDate)
                    .isEquals()
        }

        false
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
                .append(expiresDate)
                .append(message)
                .append(createdBy)
                .toHashCode()
    }
}
