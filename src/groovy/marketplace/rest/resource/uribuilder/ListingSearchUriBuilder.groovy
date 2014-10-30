package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.rest.resource.ListingResource
import marketplace.search.SearchResult

import marketplace.Listing

class ListingSearchUriBuilder implements SearchUriBuilder<Listing> {
    protected ApplicationRootUriBuilderHolder uriBuilderHolder

    ListingSearchUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getSearchUri(SearchResult<Listing> searchResult) {
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

    CollectionUriBuilder<Listing> getCollectionUriBuilder(SearchResult<Listing> searchResult) {
        { -> getSearchUri(searchResult) } as CollectionUriBuilder
    }

    @Component
    public static class Factory implements SearchUriBuilder.Factory<Listing> {
        ListingSearchUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingSearchUriBuilder(uriBuilderHolder)
        }
    }
}
