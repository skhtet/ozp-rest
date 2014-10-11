package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject

@gorm.AuditStamp
class Agency implements Serializable {
    final static bindableProperties = ['title', 'iconUrl']
    final static modifiableReferenceProperties = []

    static searchable = {
        root false
        title index: 'not_analyzed'
        iconUrl index: 'not_analyzed', excludeFromAll: true
        only = ['title', 'iconUrl']
    }

    String title
    String iconUrl

    static constraints = {
        title blank: false, maxSize: 255
        iconUrl blank: true, nullable: true, maxSize: Constants.MAX_URL_SIZE
    }

    static mapping = {
        id natural: [properties: ['title'], mutable: true]
    }

    JSONObject asJSON() {
        new JSONObject([
            id: id,
            title: title,
            iconUrl: iconUrl
        ])
    }

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
