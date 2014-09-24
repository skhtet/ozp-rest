package marketplace.rest.representation.in

import marketplace.Intent

class IntentInputRepresentation extends AbstractInputRepresentation<Intent> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp.intent+json'

    IntentInputRepresentation() {
        super(Intent.class)
    }

    String type
    String action
    String label
    String icon
}
