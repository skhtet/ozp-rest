package marketplace.rest.representation.out

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.PagedCollection
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.search.SearchResult

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

import marketplace.rest.resource.uribuilder.ResourceUriBuilder

/**
 * Representation of a collection where all of the elements are embedded representations
 */
class EmbeddedCollectionRepresentation<T> extends SelfRefRepresentation<Collection<T>> {
    /**
     * The total unpaged number of items
     */
    @JsonInclude(Include.NON_NULL)
    final Integer total

    EmbeddedCollectionRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            ResourceUriBuilder<T> resourceUriBuilder,
            Collection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(
            resourceUriBuilder.getRootUri(),
            HalCollectionRepresentationSupport.createLinks(resourceUriBuilder, entities),
            HalCollectionRepresentationSupport.createEmbedded(embeddedRepFactory, entities, uriBuilderHolder)
        )

        if (entities instanceof PagedCollection || entities instanceof SearchResult) {
            this.total = entities.total
        }
    }

    /**
     *
     * @param the Class of the representation for the items in the collection
     * @param the Class of the Resource for the items in the collection
     * @return
     */
    public static <T> RepresentationFactory<Collection<T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            ResourceUriBuilder.Factory<T> uriBuilderFactory) {

        new RepresentationFactory() {
            EmbeddedCollectionRepresentation toRepresentation(entities,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new EmbeddedCollectionRepresentation<T>(embeddedRepFactory,
                        uriBuilderFactory.getBuilder(uriBuilderHolder), entities,
                        uriBuilderHolder)
            }
        }
    }
}
