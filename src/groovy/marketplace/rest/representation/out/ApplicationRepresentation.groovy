package marketplace.rest.representation.out

import marketplace.Intent
import marketplace.Screenshot
import marketplace.Listing
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.ListingResource

class ApplicationRepresentation extends SelfRefRepresentation<Listing> {
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

    ApplicationRepresentation(Listing listing,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ListingResource.class)
                .path(ListingResource.class, 'read')
                .buildFromMap(id: listing.id),
            null,
            null
        )

        this.name = listing.title
        this.launchUrls.put('default', listing.launchUrl)
        this.tags = listing.tags
        this.type = listing.type.title
        this.uuid = listing.uuid
        this.description = listing.descriptionShort
        this.screenShots = listing.screenshots.collect { Screenshot screenShot ->
            [href: screenShot.smallImageUrl]
        }
        this.intents = listing.intents.collect { Intent intent ->
            [type: intent.type, action: intent.action, icon: intent.icon, label: intent.label]
        }

        this.addLink(RegisteredRelationType.DESCRIBES, new Link(new URI(listing.launchUrl)))
    }

    public static class Factory implements RepresentationFactory<Listing> {
        public ApplicationRepresentation toRepresentation(
                    Listing listing,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationRepresentation(listing, uriBuilderHolder)
        }
    }
}
