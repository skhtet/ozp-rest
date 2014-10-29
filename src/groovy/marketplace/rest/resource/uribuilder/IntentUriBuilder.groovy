package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.IntentResource
import marketplace.Intent

class IntentUriBuilder extends RepresentationResourceUriBuilder<Intent> {
    private IntentUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(IntentResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<Intent>, CollectionUriBuilder.Factory<Intent> {
        IntentUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IntentUriBuilder(uriBuilderHolder)
        }
    }
}
