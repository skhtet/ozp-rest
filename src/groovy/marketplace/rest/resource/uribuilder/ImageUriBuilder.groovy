package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ImageResource
import marketplace.Image
import marketplace.ImageReference

class ImageUriBuilder extends RepresentationResourceUriBuilder<Image> {
    protected ImageUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ImageResource.class, uriBuilderHolder)
    }

    URI getUri(ImageReference imageRef) {
        imageRef.image ? getUri(imageRef.image) : imageRef.uri
    }

    @Component
    public static class Factory implements ObjectUriBuilder.Factory<Image>,
            CollectionUriBuilder.Factory<Image> {
        ImageUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ImageUriBuilder(uriBuilderHolder)
        }
    }
}
