package marketplace

class Image {
    String mediaType
    byte[] data

    static constraints = {
        data maxLength: (1 << 20) //images must be no larger than 1 MiB
    }
}
