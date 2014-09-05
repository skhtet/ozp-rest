package marketplace.rest

import marketplace.Intent
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.json.JSONArray
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder

class IntentDto {
    private Intent intent

    public IntentDto(Intent intent) {
        this.intent = intent
    }

    public JSONObject asJSON() {
        new JSONObject([
            type: intent.dataType.title,
            action: intent.action.title
        ])
    }

    boolean equals(other) {
        return (other instanceof IntentDto) &&
        new EqualsBuilder()
            .append(intent?.action?.title, other.intent?.action?.title)
            .append(intent?.dataType?.title, other.intent?.dataType?.title)
            .isEquals()
    }

    int hashCode() {
        new HashCodeBuilder()
            .append(intent?.dataType?.title)
            .append(intent?.action?.action)
            .toHashCode()
    }
}
