package marketplace.rest.representation.in

import javax.ws.rs.core.MediaType

import com.sun.jersey.multipart.FormDataBodyPart

import marketplace.ImageReference

class ImageReferenceInputRepresentation extends
        AbstractInputRepresentation<ImageReference> {
    MediaType mediaType
    byte[] image

    ImageReferenceInputRepresentation() {
        super(ImageReference)
    }

    @Override
    Map<String, Object> getInputProperties() {
        [mediaType: mediaType]
    }
}
