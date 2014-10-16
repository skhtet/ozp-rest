package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.web.json.JSONObject


@gorm.AuditStamp
class Scorecard implements Serializable {
    String question
    String description
    String image
    Boolean showOnListing = false

    private static final int SMALL_FIELD_SIZE = 250

    static constraints = {
        question(blank: false, nullable: false, maxSize: SMALL_FIELD_SIZE, unique: false)
        description(blank: false, nullable: false, maxSize: 500, unique: false)
        showOnListing(blank: true, nullable: true)
        image(nullable:true, maxSize:Constants.MAX_URL_SIZE, matches: Constants.URL_REGEX)
    }

    static mapping = {
        cache true
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(question)
            .append(description)
            .toHashCode()
    }

    @Override
    boolean equals(other) {
        if (other instanceof Scorecard) {
            return new EqualsBuilder()
                .append(question, other.question)
                .append(description, other.description)
                .isEquals()
        }
        return false
    }

    @Override
    String toString() {
        return question + ": True"

    }
}
