package marketplace

@gorm.AuditStamp
class Agency implements Serializable {

    static searchable = {
        root false
        title index: 'not_analyzed'
        icon component: true, excludeFromAll: true
        shortName index: 'not_analyzed', excludeFromAll: true
        only = ['title', 'shortName', 'icon']
    }

    String title
    ImageReference icon
    String shortName

    static constraints = {
        title blank: false, maxSize: 255, unique: true
        shortName blank: false, maxSize: 8, unique: true
        icon nullable: true
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
