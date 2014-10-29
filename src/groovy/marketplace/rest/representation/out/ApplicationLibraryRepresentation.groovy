package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.Listing

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ChildCollectionUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder

import marketplace.rest.ChildObjectCollection


class ApplicationLibraryRepresentation
        extends SelfRefRepresentation<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-v1+json'

    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String folder

        FolderRepresentation(String folder, Collection<ApplicationLibraryEntry> entries,
                ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
                ObjectUriBuilder<Listing> listingUriBuilder) {
            super(null, createItems(entries, entryUriBuilder, listingUriBuilder, folder))
            this.folder = folder
        }

        private static HalEmbedded createItems(Collection<ApplicationLibraryEntry> entries,
                ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
                ObjectUriBuilder<Listing> listingUriBuilder, String folder) {
            new HalEmbedded(entries.collect { entry ->
                assert entry.folder == folder

                new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION,
                    new LibraryApplicationRepresentation(entry, entryUriBuilder,
                        listingUriBuilder))
            })
        }
    }

    private ApplicationLibraryRepresentation(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ChildCollectionUriBuilder<Profile, ApplicationLibraryEntry> entryCollectionUriBuilder,
            ObjectUriBuilder<Profile, ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Profile> profileUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder) {
        super(
            entryUriBuilder.getCollectionUri(library),
            createLinks(library, profileUriBuilder),
            createFolders(library, entryUriBuilder, listingUriBuilder)
        )
    }

    private static HalLinks createLinks(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ObjectUriBuilder<Profile> profileUriBuilder) {
        URI viaUri = profileUriBuilder.getUri(library.parent)
        new HalLinks(RegisteredRelationType.VIA, new Link(viaUri))
    }

    private static HalEmbedded createFolders(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder) {
        List<ApplicationLibraryEntry> entries = library.collection

        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                new FolderRepresentation(folderName, folderEntries, entryUriBuilder,
                    listingUriBuilder))
        })
    }

    @Component
    public static class Factory implements
            RepresentationFactory<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {
        @Autowired ApplicationLibraryEntryUriBuilder.Factory entryUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        @Override
        ApplicationLibraryRepresentation toRepresentation(
                ChildObjectCollection<Profile, ApplicationLibraryEntry>  entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            ApplicationLibraryEntryUriBuilder entryUriBuilder =
                entryUriBuilderFactory.getBuilder(uriBuilderHolder)

            new ApplicationLibraryRepresentation(entries,
                entryUriBuilder,
                entryUriBuilder,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
