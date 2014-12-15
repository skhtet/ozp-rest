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

import marketplace.rest.resource.uribuilder.ChildCollectionUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

class ApplicationLibraryEntryRepresentation
        extends AbstractHalRepresentation<ApplicationLibraryEntry> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-entry-v1+json'

    private ApplicationLibraryEntry entry

    private ApplicationLibraryEntryRepresentation(
            ApplicationLibraryEntry entry,
            ChildCollectionUriBuilder<Profile, ApplicationLibraryEntry> entryCollectionUriBuilder,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
        super(createLinks(entry, entryCollectionUriBuilder, entryUriBuilder),
            createEmbeddedListing(entry, entryUriBuilder, listingUriBuilder, imageUriBuilder))

        assert entry != null
        assert entry.listing != null

        this.entry = entry
    }

    private static HalLinks createLinks(
            ApplicationLibraryEntry entry,
            ChildCollectionUriBuilder<Profile, ApplicationLibraryEntry> entryCollectionUriBuilder,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder) {
        URI collectionHref = entryCollectionUriBuilder.getCollectionUri(entry.owner),
            entryHref = entryUriBuilder.getUri(entry)

        new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.COLLECTION,
                new Link(collectionHref)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.SELF, new Link(entryHref))
        ])
    }

    private static HalEmbedded createEmbeddedListing(ApplicationLibraryEntry entry,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
        new HalEmbedded(OzpRelationType.APPLICATION,
            new LibraryApplicationRepresentation(entry, entryUriBuilder,
                listingUriBuilder, imageUriBuilder))
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
        @Autowired ImageReferenceUriBuilder.Factory imageReferenceUriBuilderFactory

        @Override
        ApplicationLibraryEntryRepresentation toRepresentation(ApplicationLibraryEntry entry,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            ApplicationLibraryEntryUriBuilder entryUriBuilder =
                entryUriBuilderFactory.getBuilder(uriBuilderHolder)

            new ApplicationLibraryEntryRepresentation(entry,
                entryUriBuilder,
                entryUriBuilder,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                imageReferenceUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
