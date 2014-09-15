package marketplace.rest

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation


class IntentRepresentation extends SelfRefRepresentation<Intent> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp.intent+hal'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp.intents+hal'

    final String mediaType
    final String action
    final String label
    final String icon

    IntentRepresentation(Intent intent,
                         ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(IntentResource.class)
                .path(IntentResource.class, 'read')
                .buildFromMap(intent.properties),
            null,
            null
        )

        this.mediaType = intent.mediaType
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
