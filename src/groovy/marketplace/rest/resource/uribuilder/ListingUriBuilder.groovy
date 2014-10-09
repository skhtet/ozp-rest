package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ListingResource
import marketplace.Listing

class ListingUriBuilder extends RepresentationResourceUriBuilder<Listing> {
    protected ListingUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ListingResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<Listing> {
        ListingUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingUriBuilder(uriBuilderHolder)
        }
    }
}
