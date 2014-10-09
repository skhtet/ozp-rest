package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Scorecard
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ScorecardUriBuilder

import marketplace.Scorecard

class ScorecardRepresentation extends SelfRefRepresentation<Scorecard> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-scorecard-v1+json'

    final String question
    final String description
    final String image
    final Boolean showOnListing

    ScorecardRepresentation(Scorecard scorecard,
                         ResourceUriBuilder<Scorecard> scorecardUriBuilder) {
        super(scorecardUriBuilder.getUri(scorecard), null, null)

        this.question = scorecard.question
        this.description = scorecard.description
        this.image = scorecard.image
        this.showOnListing = scorecard.showOnListing
    }

    @Component
    public static class Factory implements RepresentationFactory<Scorecard> {
        @Autowired ScorecardUriBuilder.Factory scorecardUriBuilderFactory

        public ScorecardRepresentation toRepresentation(Scorecard scorecard,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ScorecardRepresentation(scorecard,
                scorecardUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
