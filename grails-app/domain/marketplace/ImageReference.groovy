package marketplace

class ImageReference {
    String mediaType

    //use a UUID id for easier directory name generation
    String id = UUID.randomUUID().toString()

    static constraints = {
        mediaType validator: { it.startsWith('image/') } //only allow image types
    }

    static mapping = {
        id generator: 'assigned'
    }

    public String getPath() {
        String fileName = id, folderName = fileName[0..1]
        return "$folderName/$fileName"
    }
}
