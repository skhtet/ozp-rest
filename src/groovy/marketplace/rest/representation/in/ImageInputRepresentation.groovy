package marketplace.rest.representation.in

import javax.ws.rs.core.MediaType

import com.sun.jersey.multipart.FormDataBodyPart

import marketplace.Image

class ImageInputRepresentation extends AbstractInputRepresentation<Image> {
    final MediaType mediaType
    final byte[] data

    ImageInputRepresentation(FormDataBodyPart formData) {
        super(Image.class)

        this.mediaType = formdata.getValueAs((byte[]).class)
        this.mediaType = formData.mediaType
    }
}
