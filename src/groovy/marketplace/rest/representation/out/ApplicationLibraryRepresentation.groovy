package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ChildObjectUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.rest.ChildObjectCollection


class ApplicationLibraryRepresentation
        extends SelfRefRepresentation<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-v1+json'

    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String folder

        FolderRepresentation(String folder, Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            super(null, createItems(entries, uriBuilderHolder, folder))
            this.folder = folder
        }

        private static HalEmbedded createItems(Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder, String folder) {
            new HalEmbedded(entries.collect { entry ->
                assert entry.folder == folder

                new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION,
                    new LibraryApplicationRepresentation(entry, uriBuilderHolder))
            })
        }
    }

    private ApplicationLibraryRepresentation(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ChildObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ResourceUriBuilder<Profile> profileUriBuilder) {
        super(
            entryUriBuilder.getCollectionUri(library),
            createLinks(library, profileUriBuilder),
            createFolders(library, uriBuilderHolder)
        )
    }

    private static HalLinks createLinks(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ResourceUriBuilder<Profile> profileUriBuilder) {
        URI viaUri = profileUriBuilder.getUri(library.parent)
        new HalLinks(RegisteredRelationType.VIA, new Link(viaUri))
    }

    private static HalEmbedded createFolders(
            ChildObjectCollection<Profile, ApplicationLibraryEntry> library,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        List<ApplicationLibraryEntry> entries = library.collection

        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                new FolderRepresentation(folderName, folderEntries, uriBuilderHolder))
        })
    }

    @Component
    public static class Factory implements
            RepresentationFactory<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {
        @Autowired ApplicationLibraryEntryUriBuilder.Factory entryUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        ApplicationLibraryRepresentation toRepresentation(
                ChildObjectCollection<Profile, ApplicationLibraryEntry>  entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryRepresentation(entries, uriBuilderHolder,
                entryUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
