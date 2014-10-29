package marketplace.rest.representation.out

import com.fasterxml.jackson.annotation.JsonInclude
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.SearchUriBuilder
import marketplace.search.SearchResult

class SearchResultRepresentation<T> extends SelfRefRepresentation<SearchResult<T>> {

    /**
     * The total unpaged number of items
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final Integer total

    SearchResultRepresentation(RepresentationFactory<T> embeddedRepFactory,
            SearchUriBuilder<T> resourceUriBuilder, SearchResult<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(resourceUriBuilder.getSearchUri(entities),
                HalCollectionRepresentationSupport.createLinks(resourceUriBuilder, entities),
                HalCollectionRepresentationSupport.createEmbedded(embeddedRepFactory, entities, uriBuilderHolder))

        this.total = entities.total
    }

    /**
     *
     * @param the Class of the representation for the items in the collection
     * @param the Class of the Resource for the items in the collection
     * @return
     */
    public static <T> RepresentationFactory<SearchResult<T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            SearchUriBuilder.Factory<T> uriBuilderFactory) {

        new RepresentationFactory() {
            SearchResultRepresentation toRepresentation(entities, ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new SearchResultRepresentation<T>(embeddedRepFactory,
                        uriBuilderFactory.getBuilder(uriBuilderHolder), entities,
                        uriBuilderHolder)
            }
        }
    }
}
