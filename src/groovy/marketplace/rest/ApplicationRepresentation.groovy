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
            ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri) {
        super(requestUri, null, embedIntents(serviceItem.intents, uriBuilderHolder))

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
                    .buildFromMap(id: intent.id)

            new AbstractMap.SimpleEntry(OzpRelationType.INTENT,
                    new IntentRepresentation(intent, uriBuilderHolder, href))
        })
    }

    public static class Factory implements RepresentationFactory<ServiceItem> {
        public ApplicationRepresentation toRepresentation(
                    ServiceItem serviceItem,
                    ApplicationRootUriBuilderHolder uriBuilderHolder,
                    URI requestUri) {
            new ApplicationRepresentation(serviceItem, uriBuilderHolder, requestUri)
        }
    }
}
