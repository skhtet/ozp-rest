package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.resource.ListingResource
import marketplace.rest.resource.RepresentationResource
import marketplace.search.SearchResult

abstract class SearchableRepresentationResourceUriBuilder<T>
        extends RepresentationResourceUriBuilder<T> implements SearchUriBuilder<T> {

    protected SearchableRepresentationResourceUriBuilder(
            Class<? extends RepresentationResource<T, ? extends InputRepresentation<T>>>
                resourceCls,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(resourceCls, uriBuilderHolder)
    }

    URI getSearchUri(SearchResult<T> searchResult) {
        def uriBuilder = uriBuilderHolder.builder
                .path(ListingResource.class)
                .path(ListingResource.class, 'search')

        searchResult.filters.each { String field, List values ->
            String fieldPath = field.contains(".") ? field.split("\\.")[0] : field
            values.each { value ->
                uriBuilder.queryParam(fieldPath, value)
            }
        }

        uriBuilder.queryParam('queryString', searchResult.queryString)
        uriBuilder.queryParam('sort', searchResult.sort)
        uriBuilder.queryParam('order', searchResult.order)
        uriBuilder.queryParam('max', searchResult.max)
        uriBuilder.queryParam('offset', searchResult.offset)

        uriBuilder.build()
    }

    CollectionUriBuilder<T> getCollectionUriBuilder(SearchResult<T> searchResult) {
        { -> getSearchUri(searchResult) } as CollectionUriBuilder
    }
}
