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
        extends SelfRefRepresentation<Collection<ApplicationLibraryEntry>> {

    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String title

        FolderRepresentation(String title, Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri) {
            super(null, createItems(entries, uriBuilderHolder, title, requestUri))
            this.title = title
        }

        private static HalEmbedded createItems(Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder, String title, URI requestUri) {
            RepresentationFactory<ApplicationLibraryEntry> factory =
                new LibraryApplicationRepresentation.Factory()

            new HalEmbedded(entries.collect { entry ->
                assert entry.folder == title

                new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    factory.toRepresentation(entry.serviceItem, uriBuilderHolder, requestUri))
            })
        }
    }

    /**
     * A UriBuilder that should be initialized to the application root
     * (e.g. https://localhost:8443/marketplace)
     */
    private ApplicationLibraryRepresentation(Collection<ApplicationLibraryEntry> entries,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            URI requestUri) {
        super(requestUri, null, createFolders(entries, uriBuilderHolder, requestUri))
    }

    private static HalEmbedded createFolders(Collection<ApplicationLibraryEntry> entries,
            ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri) {
        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                new FolderRepresentation(folderName, folderEntries, uriBuilderHolder, requestUri))
        })
    }

    public static class Factory
            implements RepresentationFactory<Collection<ApplicationLibraryEntry>> {
        ApplicationLibraryRepresentation toRepresentation(
                Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder,
                URI requestUri) {
            new ApplicationLibraryRepresentation(entries, uriBuilderHolder, requestUri)
        }
    }
}
