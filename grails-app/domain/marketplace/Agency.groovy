package marketplace

@gorm.AuditStamp
class Agency implements Serializable {

    static searchable = {
        root false
        title index: 'not_analyzed'
        iconUrl index: 'not_analyzed', excludeFromAll: true
        shortName index: 'not_analyzed', excludeFromAll: true
        only = ['title', 'shortName', 'iconUrl']
    }

    String title
    String iconUrl
    String shortName

    static constraints = {
        title blank: false, maxSize: 255
        shortName blank: false, maxSize: 8, unique: true
        iconUrl nullable: true, maxSize: Constants.MAX_URL_SIZE, matches: Constants.URL_REGEX
    }

    static transients = { 'description' }

    static mapping = {
        id natural: [properties: ['title'], mutable: true]
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
