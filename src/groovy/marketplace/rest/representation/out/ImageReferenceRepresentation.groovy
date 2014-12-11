package marketplace.rest.representation.out

import javax.ws.rs.core.MediaType

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import marketplace.ImageReference

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

class ImageReferenceRepresentation extends SelfRefRepresentation<ImageReference> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-image-ref-v1+json'

    private ImageReference imageReference

    ImageReferenceRepresentation(
            ImageReference imageReference,
            ImageReferenceUriBuilder imageReferenceUriBuilder) {
        super(imageReferenceUriBuilder.getImageUri(imageReference), null, null)
        this.imageReference = imageReference
    }

    UUID getId() { imageReference.id }

    @JsonSerialize(using=ToStringSerializer.class)
    MediaType getContentType() { imageReference.mediaType }

    @Component
    public static class Factory implements RepresentationFactory<ImageReference> {
        @Autowired ImageReferenceUriBuilder.Factory uriBuilderFactory

        @Override
        public ImageReferenceRepresentation toRepresentation(ImageReference imageReference,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ImageReferenceRepresentation(imageReference,
                uriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}

