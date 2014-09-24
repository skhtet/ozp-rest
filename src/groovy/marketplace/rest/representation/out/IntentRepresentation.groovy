package marketplace.rest.representation.out

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.IntentResource

class IntentRepresentation extends SelfRefRepresentation<Intent> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-intent-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-intents-v1+json'

    final String type
    final String action
    final String label
    final String icon

    IntentRepresentation(Intent intent,
                         ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(IntentResource.class)
                .path(IntentResource.class, 'read')
                .buildFromMap([id: intent.id]),
            null,
            null
        )

        this.type = intent.type
        this.action = intent.action
        this.label = intent.label
        this.icon = intent.icon
    }

    public static class Factory implements RepresentationFactory<Intent> {
        public IntentRepresentation toRepresentation(Intent intent,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IntentRepresentation(intent, uriBuilderHolder)
        }
    }
}
