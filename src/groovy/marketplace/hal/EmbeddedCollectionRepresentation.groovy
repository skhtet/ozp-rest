package marketplace.hal

import com.fasterxml.jackson.annotation.JsonIgnore
import marketplace.rest.DomainResource

/**
 * Representation of a collection where all of the elements are embedded representations
 *
 * TODO: This representation could probably support optional paging (next/prev links) as well
 */
class EmbeddedCollectionRepresentation<T> extends SelfRefRepresentation<Collection<T>> {
    @JsonIgnore
    final Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType
    @JsonIgnore
    final Class<? extends DomainResource<T>> embeddedResourceType

    EmbeddedCollectionRepresentation(
            Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType,
            Class<? extends DomainResource<T>> embeddedResourceType,
            Collection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(
            uriBuilderHolder.builder
                .path(embeddedResourceType)
                .path(embeddedResourceType, 'readAll')
                .build(),
            null,
            null
        )

        this.embeddedRepresentationType = embeddedRepresentationType
        this.embeddedResourceType = embeddedResourceType

        this.addEmbedded(embedEntities(entities, uriBuilderHolder))
    }

    private HalEmbedded embedEntities(Collection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->
            Map props = entity.properties as HashMap
            props.id = entity.id

            URI href = uriBuilderHolder.builder
                    .path(embeddedResourceType)
                    .path(embeddedResourceType, 'read')
                    .buildFromMap(props)

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepresentationType.newInstance(entity, uriBuilderHolder, href))
        })
    }

    /**
     *
     * @param the Class of the representation for the items in the collection
     * @param the Class of the Resource for the items in the collection
     * @return
     */
    public static RepresentationFactory<Collection<?>> createFactory(
            Class<? extends AbstractHalRepresentation> embeddedRepresentationType,
            Class<? extends DomainResource> embeddedResourceType) {

        { Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder ->
            new EmbeddedCollectionRepresentation(embeddedRepresentationType,
                    embeddedResourceType, entities, uriBuilderHolder)
        } as RepresentationFactory
    }
}
