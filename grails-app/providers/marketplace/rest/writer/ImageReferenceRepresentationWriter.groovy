package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.ImageReference

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ImageReferenceRepresentation

@Provider
@Produces([
    ImageReferenceRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ImageReferenceRepresentationWriter extends AbstractRepresentationWriter<ImageReference> {

    @Autowired
    ImageReferenceRepresentationWriter(ImageReferenceRepresentation.Factory factory) {
        super(factory)
    }
}
