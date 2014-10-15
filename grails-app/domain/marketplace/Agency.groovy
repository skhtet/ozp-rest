package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject

@gorm.AuditStamp
class Agency implements Serializable {

    static searchable = {
        root false
        title index: 'not_analyzed'
        iconUrl index: 'not_analyzed', excludeFromAll: true
        only = ['title', 'iconUrl']
    }

    String title
    String iconUrl

    static constraints = {
        title blank: false, maxSize: 255, unique: true
        iconUrl nullable: true, maxSize: Constants.MAX_URL_SIZE, matches: Constants.URL_REGEX
    }

    static transients = { 'description' }

    static mapping = {
        id natural: [properties: ['title'], mutable: true]
    }

    //see line 93 of JSONUtil.groovy
    public String getDescription() { null }

    @Override
    String toString() { title }

    @Override
    boolean equals(other) {
        other instanceof Agency && title == other.title
    }

    @Override
    int hashCode() {
        title.hashCode()
    }
}
