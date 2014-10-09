package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.AgencyResource
import marketplace.Agency

class AgencyUriBuilder extends RepresentationResourceUriBuilder<Agency> {
    protected AgencyUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(AgencyResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<Agency> {
        AgencyUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new AgencyUriBuilder(uriBuilderHolder)
        }
    }
}
