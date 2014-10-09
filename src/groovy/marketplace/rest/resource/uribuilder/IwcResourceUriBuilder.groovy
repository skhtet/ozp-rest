package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.IwcResource

class IwcResourceUriBuilder implements RootResourceUriBuilder {
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private IwcResourceUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getRootUri() {
        uriBuilderHolder.builder
            .path(IwcResource.class)
            .build()
    }

    @Component
    public static class Factory implements RootResourceUriBuilder.Factory {
        IwcResourceUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcResourceUriBuilder(uriBuilderHolder)
        }
    }
}
