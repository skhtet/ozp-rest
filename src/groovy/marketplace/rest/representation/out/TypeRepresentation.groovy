package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Type

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.AbstractHalRepresentation

import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.TypeUriBuilder

class TypeRepresentation extends SelfRefRepresentation<Type> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-type-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-types-v1+json'

    private Type type

    private TypeRepresentation(Type type,
            ResourceUriBuilder<Type> typeUriBuilder) {
        super(typeUriBuilder.getUri(type), null, null)

        this.type = type
    }

    public String getTitle() { type.title }
    public String getDescription() { type.description }
    public String getUuid() { type.uuid }
    public Long getId() { type.id }

    @Component
    public static class Factory implements RepresentationFactory<Type> {
        @Autowired TypeUriBuilder.Factory uriBuilderFactory

        TypeRepresentation toRepresentation(Type type,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new TypeRepresentation(type,
                uriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}

