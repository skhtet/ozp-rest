package marketplace.rest.representation.out

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.PagedCollection
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.Paging

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

import marketplace.rest.resource.uribuilder.CollectionUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder

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
            CollectionUriBuilder<T> collectionUriBuilder,
            Paging<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ObjectUriBuilder<T> objectUriBuilder = null) {
        this(embeddedRepFactory, collectionUriBuilder, (Collection<T>)entities, uriBuilderHolder)
        this.total = entities.total
    }

    EmbeddedCollectionRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            CollectionUriBuilder<T> collectionUriBuilder,
            Collection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ObjectUriBuilder<T> objectUriBuilder = null) {

        super(
            collectionUriBuilder.getCollectionUri(),
            HalCollectionRepresentationSupport.createLinks(collectionUriBuilder,
                objectUriBuilder, entities),
            HalCollectionRepresentationSupport.createEmbedded(
                embeddedRepFactory, entities, uriBuilderHolder)
        )
    }

    /**
     *
     * @param the Class of the representation for the items in the collection
     * @param the Class of the Resource for the items in the collection
     * @return
     */
    public static <T> RepresentationFactory<Collection<T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            CollectionUriBuilder.Factory uriBuilderFactory) {

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
