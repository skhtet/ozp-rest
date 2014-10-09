package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApplicationLibraryEntry
import marketplace.Listing
import marketplace.Profile

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.HalEmbedded
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.uribuilder.ChildObjectUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder

class ApplicationLibraryEntryRepresentation
        extends AbstractHalRepresentation<ApplicationLibraryEntry> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-entry-v1+json'

    private ApplicationLibraryEntry entry

    private ApplicationLibraryEntryRepresentation(ApplicationLibraryEntry entry,
            ChildObjectUriBuilder<Profile, ApplicationLibraryEntry> entryUriBuilder,
            ResourceUriBuilder<Listing> listingUriBuilder) {
        super(createLinks(entry, entryUriBuilder),
            createEmbeddedListing(entry, entryUriBuilder, listingUriBuilder))

        assert entry != null
        assert entry.listing != null

        this.entry = entry
    }

    private static HalLinks createLinks(ApplicationLibraryEntry entry,
            ChildObjectUriBuilder<Profile, ApplicationLibraryEntry> entryUriBuilder) {
        URI collectionHref = entryUriBuilder.getCollectionUri(entry),
            entryHref = entryUriBuilder.getUri(entry)

        new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.COLLECTION,
                new Link(collectionHref)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.SELF, new Link(entryHref))
        ])
    }

    private static HalEmbedded createEmbeddedListing(ApplicationLibraryEntry entry,
            ResourceUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ResourceUriBuilder<Listing> listingUriBuilder) {
        new HalEmbedded(OzpRelationType.APPLICATION,
            new LibraryApplicationRepresentation(entry, entryUriBuilder,
                listingUriBuilder))
    }

    public String getFolder() { entry.folder }
    public IdRefRepresentation<Listing> getListing() {
        new IdRefRepresentation<Listing>(entry.listing)
    }

    @Component
    public static class Factory
            implements RepresentationFactory<ApplicationLibraryEntry> {
        @Autowired ApplicationLibraryEntryUriBuilder.Factory entryUriBuilderFactory
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        @Override
        ApplicationLibraryEntryRepresentation toRepresentation(ApplicationLibraryEntry entry,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryEntryRepresentation(entry,
                entryUriBuilderFactory.getBuilder(uriBuilderHolder),
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
