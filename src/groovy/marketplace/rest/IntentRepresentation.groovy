package marketplace.rest

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation


class IntentRepresentation extends SelfRefRepresentation<Intent> {
    final String dataType
    final String action

    IntentRepresentation(Intent intent,
                         ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri) {
        super(requestUri, null, null)

        this.dataType = intent.dataType.title
        this.action = intent.action.title
    }

    public static class Factory implements RepresentationFactory<Intent> {
        public IntentRepresentation toRepresentation(Intent intent,
                                                     ApplicationRootUriBuilderHolder uriBuilderHolder,
                                                     URI requestUri) {
            new IntentRepresentation(intent, uriBuilderHolder, requestUri)
        }
    }
}
