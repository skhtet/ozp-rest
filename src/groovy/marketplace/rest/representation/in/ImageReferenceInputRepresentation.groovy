package marketplace.rest.representation.in

import com.sun.jersey.multipart.FormDataBodyPart

import marketplace.ImageReference

class UriImageReferenceInputRepresentation extends AbstractInputRepresentation<ImageReference> {
    URI uri

    UriImageReferenceInputRepresentation() {
        super(ImageReference)
    }
}

class EmbeddedImageReferenceInputRepresentation extends
        AbstractInputRepresentation<ImageReference> {
    EmbeddedImageReferenceInputRepresentation() {
        super(ImageReference)
    }

    ImageInputRepresentation image

    public void setImage(FormDataBodyPart formData) {
        this.image = new ImageInputRepresentation(formData)
    }
}
