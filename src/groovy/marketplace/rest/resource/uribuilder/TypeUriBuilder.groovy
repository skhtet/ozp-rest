package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.TypeResource
import marketplace.Type

class TypeUriBuilder extends RepresentationResourceUriBuilder<Type> {
    protected TypeUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(TypeResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<Type>,
            CollectionUriBuilder.Factory<Type> {
        TypeUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new TypeUriBuilder(uriBuilderHolder)
        }
    }
}
