package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.IntentResource
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.IntentUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

class IntentRepresentation extends SelfRefRepresentation<Intent> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-intent-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-intents-v1+json'

    final long id
    final String type
    final String action
    final String label
    final UUID iconId

    private ImageReferenceUriBuilder imageUriBuilder

    IntentRepresentation(
            Intent intent,
            ObjectUriBuilder<Intent> intentUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
        super(intentUriBuilder.getUri(intent), null, null)

        this.id = intent.id
        this.action = intent.action
        this.type = intent.type
        this.label = intent.label
        this.iconId = intent.iconId

        this.imageUriBuilder = imageUriBuilder
    }

    public URI getIcon() {
        iconId ? imageUriBuilder.getImageUri(iconId) : null
    }

    @Component
    public static class Factory implements RepresentationFactory<Intent> {
        @Autowired IntentUriBuilder.Factory intentUriBuilderFactory
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

        public IntentRepresentation toRepresentation(Intent intent,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IntentRepresentation(intent,
                intentUriBuilderFactory.getBuilder(uriBuilderHolder),
                imageUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
