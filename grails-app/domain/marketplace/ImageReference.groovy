package marketplace

@gorm.AuditStamp
class ImageReference {
    String mediaType

    static searchable = {
        root false
        mediaType index: 'not_analyzed', excludeFromAll: true
        id index: 'not_analyzed', excludeFromAll: true
        only = ['mediaType', 'id']
    }

    //use a UUID id for easier directory name generation
    String id = UUID.randomUUID().toString()

    static constraints = {
        mediaType validator: { it.startsWith('image/') } //only allow image types
    }

    static mapping = {
        id generator: 'assigned'
    }
}
