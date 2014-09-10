package marketplace.rest

import marketplace.ApplicationLibraryEntry
import marketplace.ServiceItem

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.HalEmbedded
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.RepresentationFactory

class ApplicationLibraryEntryRepresentation
        extends AbstractHalRepresentation<ApplicationLibraryEntry> {

    private ApplicationLibraryEntry entry

    private ApplicationLibraryEntryRepresentation(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            URI requestUri) {
        super(createCollectionLink(entry, uriBuilderHolder),
            createEmbeddedServiceItem(entry, uriBuilderHolder, requestUri))

        assert entry != null
        assert entry.serviceItem != null

        this.entry = entry
    }

    private static HalLinks createCollectionLink(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        URI href = uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getApplicationLibrary')
            .buildFromMap(profileId: entry.owner.id)

        new HalLinks(RegisteredRelationType.COLLECTION, new Link(href))
    }

    private static HalEmbedded createEmbeddedServiceItem(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            URI requestUri) {
        RepresentationFactory<ServiceItem> factory =
            new LibraryApplicationRepresentation.Factory()

        new HalEmbedded(OzpRelationType.APPLICATION, factory.toRepresentation(entry.serviceItem,
            uriBuilderHolder, requestUri))
    }

    public String getFolder() { entry.folder }

    public static class Factory
            implements RepresentationFactory<ApplicationLibraryEntry> {

        @Override
        ApplicationLibraryEntryRepresentation toRepresentation(ApplicationLibraryEntry entry,
                ApplicationRootUriBuilderHolder uriBuilderHolder,
                URI requestUri) {
            new ApplicationLibraryEntryRepresentation(entry, uriBuilderHolder, requestUri)
        }
    }
}
