package marketplace.rest.representation.out

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.search.SearchResult

import marketplace.rest.resource.uribuilder.SearchUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder

class SearchResultRepresentation<T> extends EmbeddedCollectionRepresentation<T> {
    protected SearchResultRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            SearchUriBuilder<T> searchUriBuilder,
            ObjectUriBuilder<T> objectUriBuilder,
            SearchResult<T> searchResult,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            embeddedRepFactory,
            searchUriBuilder.getCollectionUriBuilder(searchResult),
            objectUriBuilder,
            searchResult,
            uriBuilderHolder
        )
    }

    public static <T> RepresentationFactory<SearchResult<T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            SearchUriBuilder.Factory<T> searchUriBuilderFactory,
            ObjectUriBuilder.Factory<T> uriBuilderFactory) {

        new RepresentationFactory() {
            SearchResultRepresentation toRepresentation(searchResult,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new SearchResultRepresentation<T>(
                        embeddedRepFactory,
                        searchUriBuilderFactory.getBuilder(uriBuilderHolder),
                        uriBuilderFactory?.getBuilder(uriBuilderHolder),
                        searchResult,
                        uriBuilderHolder)
            }
        }
    }
}
