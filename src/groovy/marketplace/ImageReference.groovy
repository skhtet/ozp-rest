package marketplace

/**
 * A reference to an image from a listing, agency, etc.  This class encapsulates
 * the fact that the image is referenced by URL, but may or may not be stored on our
 * server.  If it is stored on our server, a direct relational reference is maintained
 * instead of a URI
 */
class ImageReference {
    URI uri

    //relationships from embedded domain classes don't work.  Therefore make the actual image
    //a transient and just persist an id column
    long imageId
    Image image

    static transients = ['image']

    static constraints = {
        uri validator: { u, obj ->
            //must have exactly one of uri or image
            if (!((obj.uri == null) ^ (obj.image == null))) {
                //this is managed internally and isn't the user's fault,
                //so throw an IllegalStateException instead of causing a
                //validation exception
                throw new IllegalStateException("ImageReference must have either URI or Image")
            }
        }
    }

    public Image getImage() {
        if (!this.image) {
            this.image = Image.get(imageId)
        }

        return this.image
    }

    public void setImage(Image image) {
        this.image = image
    }

    private void saveImage() {
        this.image = this.image.save(failOnError:true)
        this.imageId = this.image.id
    }

    def beforeInsert() {
        saveImage()
    }

    def beforeUpdate() {
        saveImage()
    }
}
