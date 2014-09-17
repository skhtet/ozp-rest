package marketplace.rest

import marketplace.ServiceItem
import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory

/**
 * A representation of a Service Item within the Application Library, with all information needed
 * by the library UI to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<ServiceItem> {

    private ServiceItem serviceItem

    private LibraryApplicationRepresentation(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ServiceItemResource.class)
                .path(ServiceItemResource.class, 'read')
                .buildFromMap(id: entry.serviceItem.id),
            createLinks(entry, uriBuilderHolder),
            null
        )

        this.serviceItem = entry.serviceItem
    }

    private static HalLinks createLinks(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        ServiceItem serviceItem = entry.serviceItem
        URI launchUri = serviceItem.launchUrl ? new URI(serviceItem.launchUrl) : null,
            libraryEntryUri = uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'removeFromApplicationLibrary')
                .buildFromMap(profileId: entry.owner.id, serviceItemId: serviceItem.id)

        new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.DESCRIBES, new Link(launchUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, new Link(libraryEntryUri))
        ])
    }

    public String getTitle() { serviceItem.title }
    public Map<String, URI> getLaunchUrls() { [default: new URI(serviceItem.launchUrl)] }
    public Map<String, URI> getIcons() {
        [
            small: serviceItem.imageSmallUrl,
            large: serviceItem.imageMediumUrl,
            banner: serviceItem.imageLargeUrl,
            featuredBanner: serviceItem.imageXlargeUrl
        ]
    }
    public long getId() { serviceItem.id }
}
