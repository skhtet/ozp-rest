package marketplace.rest

import marketplace.Agency

class AgencyInputRepresentation extends AbstractInputRepresentation<Agency> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-organization-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-organizations-v1+json'

    AgencyInputRepresentation() {
        super(Agency.class)
    }

    String title
    URI icon
}
