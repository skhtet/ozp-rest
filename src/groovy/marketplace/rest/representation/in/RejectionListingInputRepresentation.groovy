package marketplace.rest.representation.in

import marketplace.RejectionListing

class RejectionListingInputRepresentation extends AbstractInputRepresentation<RejectionListing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-rejection-v1+json'

    RejectionListingInputRepresentation() {
        super(RejectionListing.class)
    }

    String description
}
