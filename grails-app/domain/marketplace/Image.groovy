package marketplace

class Image {
    String mediaType
    byte[] data

    static constraints = {
        data nullable: false, minSize: 1, maxSize: (1 << 20) //images must be no larger than 1 MiB
        mediaType validator: { it.startsWith('image/') } //only allow image types
    }
}
