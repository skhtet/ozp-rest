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

    /**
     * {
     *     "title": "folder 1",
     *     "_links": {
     *         "item": [
     *             {"href": "https://localhost:8443/marketplace/api/serviceItem/1", name: "1"},
     *             {"href": "https://localhost:8443/marketplace/api/serviceItem/2", name: "2"}
     *         ]
     *     }
     * }
     */
    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String title

        FolderRepresentation(String title, Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            super(createLinks(entries, uriBuilderHolder, title), null)
            this.title = title
        }

        private static HalLinks createLinks(Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder, String title) {
            new HalLinks(entries.collect { entry ->
                assert entry.folder == title

                URI href = uriBuilderHolder.builder.path(ServiceItemResource.class, 'read')
                    .buildFromMap(id: entry.serviceItem.id)

                new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    new Link(href, entry.serviceItem.id.toString()))
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
        super(requestUri, null, createFolders(entries, uriBuilderHolder))
    }

    private static HalEmbedded createFolders(Collection<ApplicationLibraryEntry> entries,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entries.groupBy([{ it.folder }]).collect { folderName, folderEntries ->
           new AbstractMap.SimpleEntry(OzpRelationType.FOLDER,
                new FolderRepresentation(folderName, folderEntries, uriBuilderHolder))
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
