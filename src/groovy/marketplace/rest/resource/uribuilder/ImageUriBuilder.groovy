package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ImageResource
import marketplace.Image

class ImageUriBuilder extends RepresentationResourceUriBuilder<Image> {
    protected ImageUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ImageResource.class, uriBuilderHolder)
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

