package marketplace.hal

import com.fasterxml.jackson.annotation.JsonIgnore
import marketplace.rest.DomainResource

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

            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION,
                    embeddedRepresentationType.newInstance(entity, uriBuilderHolder, href))
        })
    }

    public static RepresentationFactory createFactory(
            Class<? extends AbstractHalRepresentation> embeddedRepresentationType,
            Class<? extends DomainResource> embeddedResourceType) {

        { Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri ->
            new EmbeddedCollectionRepresentation(embeddedRepresentationType,
                    embeddedResourceType, entities, uriBuilderHolder, requestUri)
        } as RepresentationFactory
    }
}
