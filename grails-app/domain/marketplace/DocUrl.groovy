package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.web.json.JSONObject

class DocUrl implements Serializable {

    static searchable = {
        root false
        only = ['name', 'url']
    }

    String name
    String url

    static belongsTo = [listing: Listing]

    static constraints = {
        name maxSize: 255, nullable: false
        url maxSize: Constants.MAX_URL_SIZE, nullable: false, matches: Constants.URL_REGEX
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(name)
            .append(url)
            .toHashCode()
    }

    @Override
    boolean equals(other) {
        // Since docUrls is a lazy loaded collection, the instances could be
        // hibernate proxies, so use the GORM 'instanceOf' method
        Boolean sameType
        try {
            sameType = other.instanceOf(DocUrl)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if(sameType) {

            return new EqualsBuilder()
                        .append(name, other.name)
                        .append(url, other.url)
                        .isEquals()
        }
        return false
    }

    @Override
    String toString() {
        "$name: $url"
    }
}
