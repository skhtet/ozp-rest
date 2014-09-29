package marketplace.rest.representation.out

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

import marketplace.rest.resource.ServiceItemResource

class ApplicationRepresentation extends SelfRefRepresentation<ServiceItem> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-application-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-applications-v1+json'

    final String name
    final String type
    final String description
    final String uuid

    Map<String, String> launchUrls = new HashMap()
    List<Map<String, String>> screenShots
    Set<String> tags
    Set<Map<String, String>> intents

    //TODO: Not sure yet how we're gathering this information, where it's needed, how it's used etc. So for now, it's hard coded.
    final String state = 'Active'
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
            null
        )

        this.name = serviceItem.title
        this.launchUrls.put('default', serviceItem.launchUrl)
        this.tags = serviceItem.tags
        this.type = serviceItem.type.title
        this.uuid = serviceItem.uuid
        this.description = serviceItem.descriptionShort
        this.screenShots = serviceItem.screenshots.collect { Screenshot screenShot ->
            [href: screenShot.smallImageUrl]
        }
        this.intents = serviceItem.intents.collect { Intent intent ->
            [type: intent.type, action: intent.action, icon: intent.icon, label: intent.label]
        }

        this.addLink(RegisteredRelationType.DESCRIBES, new Link(new URI(serviceItem.launchUrl)))
    }

    public static class Factory implements RepresentationFactory<ServiceItem> {
        public ApplicationRepresentation toRepresentation(
                    ServiceItem serviceItem,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationRepresentation(serviceItem, uriBuilderHolder)
        }
    }
}
