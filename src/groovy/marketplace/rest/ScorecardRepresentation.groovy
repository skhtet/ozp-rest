package marketplace.rest

import marketplace.Scorecard
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation


class ScorecardRepresentation extends SelfRefRepresentation<Scorecard> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-scorecard-v1+json'

    final String question
    final String description
    final String image
    final Boolean showOnListing

    ScorecardRepresentation(Scorecard scorecard,
                         ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ScorecardResource.class)
                .path(ScorecardResource.class, 'read')
                .buildFromMap([id: scorecard.id]),
            null,
            null
        )

        this.question = scorecard.question
        this.description = scorecard.description
        this.image = scorecard.image
        this.showOnListing = scorecard.showOnListing
    }

    public static class Factory implements RepresentationFactory<Scorecard> {
        public ScorecardRepresentation toRepresentation(Scorecard scorecard,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ScorecardRepresentation(scorecard, uriBuilderHolder)
        }
    }
}
