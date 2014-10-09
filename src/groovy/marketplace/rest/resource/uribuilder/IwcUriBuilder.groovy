package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.IwcResource
import marketplace.rest.resource.IwcSystemResource

class IwcUriBuilder implements RootResourceUriBuilder {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private IwcUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getRootUri() {
        uriBuilderHolder.builder
            .path(IwcResource.class)
            .build()
    }

    URI getSystemUri() {
        uriBuilderHolder.builder
            .path(IwcSystemResource.class)
            .build()
    }

    @Component
    public static class Factory implements RootResourceUriBuilder.Factory {
        IwcUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUriBuilder(uriBuilderHolder)
        }
    }
}
