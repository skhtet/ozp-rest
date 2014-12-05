package marketplace.rest.resource.uribuilder

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ImageResource
import marketplace.ImageReference

class ImageReferenceUriBuilder implements ObjectUriBuilder<ImageReference> {
    GrailsApplication grailsApplication
    ApplicationRootUriBuilderHolder uriBuilderHolder

    ImageReferenceUriBuilder(
            GrailsApplication grailsApplication,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.grailsApplication = grailsApplication
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(ImageReference imageRef) {
        buildUri(uriBuilderHolder.builder, imageRef)
    }

    URI getImageUri(ImageReference imageRef) {
        String imageUriBase = grailsApplication.config.marketplace.imageUriBaseOverride

        imageUriBase ? buildUri(UriBuilder.fromUri(imageUriBase), imageRef) : getUri(imageRef)
    }

    private URI buildUri(UriBuilder base, ImageReference imageRef) {
        base.path(ImageResource)
            .path(ImageResource, 'getImageReference')
            .buildFromMap(id: imageRef.id)
    }

    @Component
    public static class Factory implements ObjectUriBuilder.Factory<ImageReference> {
        @Autowired GrailsApplication grailsApplication

        ImageReferenceUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ImageReferenceUriBuilder(grailsApplication, uriBuilderHolder)
        }
    }
}

