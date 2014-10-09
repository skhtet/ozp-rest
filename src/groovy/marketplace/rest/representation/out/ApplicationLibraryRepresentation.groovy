package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.ApplicationLibrary
import marketplace.rest.resource.uribuilder.ChildObjectUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.Profile

class ApplicationLibraryRepresentation
        extends SelfRefRepresentation<ApplicationLibrary> {

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

    /**
     * A UriBuilder that should be initialized to the application root
     * (e.g. https://localhost:8443/marketplace)
     */
    private ApplicationLibraryRepresentation(ApplicationLibrary library,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ChildObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ResourceUriBuilder<Profile> profileUriBuilder) {
        super(
            entryUriBuilder.getCollectionUri(library),
            createLinks(library, profileUriBuilder),
            createFolders(library, uriBuilderHolder)
        )
    }

    private static HalLinks createLinks(ApplicationLibrary library,
            profileUriBuilder) {
        URI viaUri = profileUriBuilder.getUri(library.profile)
        new HalLinks(RegisteredRelationType.VIA, new Link(viaUri))
    }

    private static HalEmbedded createFolders(ApplicationLibrary library,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        List<ApplicationLibraryEntry> entries = library.entries

        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                new FolderRepresentation(folderName, folderEntries, uriBuilderHolder))
        })
    }

    @Component
    public static class Factory
            implements RepresentationFactory<ApplicationLibrary> {
        @Autowired ApplicationLibraryEntryUriBuilder.Factory entryUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        ApplicationLibraryRepresentation toRepresentation(
                ApplicationLibrary entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryRepresentation(entries, uriBuilderHolder,
                entryUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
