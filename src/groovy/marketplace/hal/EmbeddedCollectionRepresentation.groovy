package marketplace.hal

import com.fasterxml.jackson.annotation.JsonIgnore
import marketplace.rest.DomainResource

/**
 * Representation of a collection where all of the elements are embedded representations
 *
 * TODO: This representation could probably support optional paging (next/prev links) as well
 */
class EmbeddedCollectionRepresentation extends SelfRefRepresentation {
    @JsonIgnore
    final Class<? extends AbstractHalRepresentation> embeddedRepresentationType
    @JsonIgnore
    final Class<? extends DomainResource> embeddedResourceType

    EmbeddedCollectionRepresentation(Class<? extends AbstractHalRepresentation> embeddedRepresentationType,
            Class<? extends DomainResource> embeddedResourceType,
            Collection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            URI requestUri) {

        super(requestUri, null, null)

        this.embeddedRepresentationType = embeddedRepresentationType
        this.embeddedResourceType = embeddedResourceType

        this.addEmbedded(embedEntities(entities, uriBuilderHolder))
    }

    private HalEmbedded embedEntities(Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->
            URI href = uriBuilderHolder.builder
                    .path(embeddedResourceType)
                    .path(embeddedResourceType, 'read')
                    .buildFromMap(id: entity.id)

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
    public static RepresentationFactory createFactory(
            Class<? extends AbstractHalRepresentation> embeddedRepresentationType,
            Class<? extends DomainResource> embeddedResourceType) {

        { Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri ->
            new EmbeddedCollectionRepresentation(embeddedRepresentationType,
                    embeddedResourceType, entities, uriBuilderHolder, requestUri)
        } as RepresentationFactory
    }
}
