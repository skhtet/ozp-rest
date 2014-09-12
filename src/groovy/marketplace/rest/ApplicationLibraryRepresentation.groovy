package marketplace.rest

import java.lang.reflect.Type

import javax.ws.rs.core.MediaType

import org.springframework.stereotype.Component

import org.codehaus.groovy.grails.web.json.JSONObject

import marketplace.ServiceItem
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

class ApplicationLibraryRepresentation
        extends SelfRefRepresentation<ApplicationLibrary> {

    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String title

        FolderRepresentation(String title, Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            super(null, createItems(entries, uriBuilderHolder, title))
            this.title = title
        }

        private static HalEmbedded createItems(Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder, String title) {
            RepresentationFactory<ApplicationLibraryEntry> factory =
                new LibraryApplicationRepresentation.Factory()

            new HalEmbedded(entries.collect { entry ->
                assert entry.folder == title

                new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    factory.toRepresentation(entry.serviceItem, uriBuilderHolder))
            })
        }
    }

    /**
     * A UriBuilder that should be initialized to the application root
     * (e.g. https://localhost:8443/marketplace)
     */
    private ApplicationLibraryRepresentation(ApplicationLibrary library,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'getApplicationLibrary')
                .buildFromMap(profileId: library.profileId),
            createLinks(library, uriBuilderHolder),
            createFolders(library, uriBuilderHolder)
        )
    }

    private static HalLinks createLinks(ApplicationLibrary library,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        URI viaUri = uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'read')
            .buildFromMap(id: library.profileId)

        new HalLinks(RegisteredRelationType.VIA, new Link(viaUri))
    }

    private static HalEmbedded createFolders(ApplicationLibrary library,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        List<ApplicationLibraryEntry> entries = library.entries
        URI collectionUri = uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'read')
            .buildFromMap(id: library.profileId)

        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                new FolderRepresentation(folderName, folderEntries, uriBuilderHolder))
        })
    }

    public static class Factory
            implements RepresentationFactory<ApplicationLibrary> {
        @Override
        ApplicationLibraryRepresentation toRepresentation(
                ApplicationLibrary entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryRepresentation(entries, uriBuilderHolder)
        }
    }
}
