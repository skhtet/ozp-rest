package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.RepresentationResource

/**
 * Logic for getting resource URIs from a RepresentationResource class. Objects of type
 * T must have an id field
 */
abstract class RepresentationResourceUriBuilder<T> implements ResourceUriBuilder<T> {
    private Class<? extends RepresentationResource<T, ?>> resourceCls
    protected ApplicationRootUriBuilderHolder uriBuilderHolder

    protected RepresentationResourceUriBuilder(
            Class<? extends RepresentationResource<T, ?>> resourceCls,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.resourceCls = resourceCls
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(T obj) {
        uriBuilderHolder.builder
            .path(resourceCls)
            .path(resourceCls, 'read')
            .buildFromMap(id: obj.id)
    }

    URI getRootUri() {
        uriBuilderHolder.builder
            .path(resourceCls)
            .build()
    }
}
