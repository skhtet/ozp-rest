package marketplace.rest

import marketplace.Intent
import marketplace.Screenshot
import marketplace.ServiceItem
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory

class ApplicationRepresentation extends SelfRefRepresentation<ServiceItem> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp.application+hal'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp.applications+hal'

    final String name
    final String type
    final String description
    Map launchUrls = new HashMap()
    List screenShots
    Set tags
    Map uiHints = [
        width: 300,
        height: 300,
        singleton: true
    ]

    ApplicationRepresentation(ServiceItem serviceItem,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ServiceItemResource.class)
                .path(ServiceItemResource.class, 'read')
                .buildFromMap(id: serviceItem.id),
            null,
            embedIntents(serviceItem.intents, uriBuilderHolder)
        )

        this.name = serviceItem.title
        this.launchUrls.put('default', serviceItem.launchUrl)
        this.tags = serviceItem.tags
        this.type = serviceItem.types.title
        this.description = serviceItem.descriptionShort
        this.screenShots = serviceItem.screenshots.collect { Screenshot screenShot ->
            [href: screenShot.smallImageUrl]
        }

        this.addLink(RegisteredRelationType.DESCRIBES, new Link(new URI(serviceItem.launchUrl)))
    }

    private static HalEmbedded embedIntents(Collection intents, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(intents.collect {Intent intent ->

            URI href = uriBuilderHolder.builder
                    .path(IntentResource.class)
                    .path(IntentResource.class, 'read')
                    .buildFromMap(intent.properties)

            new AbstractMap.SimpleEntry(OzpRelationType.INTENT,
                    new IntentRepresentation(intent, uriBuilderHolder, href))
        })
    }

    public static class Factory implements RepresentationFactory<ServiceItem> {
        public ApplicationRepresentation toRepresentation(
                    ServiceItem serviceItem,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationRepresentation(serviceItem, uriBuilderHolder)
        }
    }
}