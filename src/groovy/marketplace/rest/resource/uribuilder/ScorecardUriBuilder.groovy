package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ScorecardResource
import marketplace.Scorecard

class ScorecardUriBuilder extends RepresentationResourceUriBuilder<Scorecard> {
    private ScorecardUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ScorecardResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<Scorecard> {
        ScorecardUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ScorecardUriBuilder(uriBuilderHolder)
        }
    }
}
