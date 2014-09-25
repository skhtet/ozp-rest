package marketplace.rest.representation.in

import marketplace.Scorecard

class ScorecardInputRepresentation extends AbstractInputRepresentation<Scorecard> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp.scorecard+json'

    ScorecardInputRepresentation() {
        super(Scorecard.class)
    }

    String question
    String description
    String image
    Boolean showOnListing
}
