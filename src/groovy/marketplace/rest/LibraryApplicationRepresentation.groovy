package marketplace.rest

import marketplace.ServiceItem

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
 * by the library to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<ServiceItem> {

    private ServiceItem serviceItem

    private LibraryApplicationRepresentation(ServiceItem serviceItem,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ServiceItemResource.class)
                .path(ServiceItemResource.class, 'read')
                .buildFromMap(id: serviceItem.id),
            createLinks(serviceItem, uriBuilderHolder),
            null
        )

        this.serviceItem = serviceItem
    }

    private static HalLinks createLinks(ServiceItem serviceItem,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        URI bannerUri = serviceItem.imageLargeUrl ? new URI(serviceItem.imageLargeUrl) : null,
            iconUri = serviceItem.imageMediumUrl ? new URI(serviceItem.imageMediumUrl) : null,
            launchUri = serviceItem.launchUrl ? new URI(serviceItem.launchUrl) : null

        new HalLinks(RegisteredRelationType.DESCRIBES, new Link(launchUri))
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

    public static class Factory implements RepresentationFactory<ServiceItem> {
        @Override
        public LibraryApplicationRepresentation toRepresentation(
                    ServiceItem serviceItem,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new LibraryApplicationRepresentation(serviceItem, uriBuilderHolder)
        }
    }
}

