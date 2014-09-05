package marketplace.rest

import java.lang.reflect.Type

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.MediaType

import org.springframework.stereotype.Component

import org.codehaus.groovy.grails.web.json.JSONObject

import marketplace.ServiceItem
import marketplace.ApplicationLibraryEntry

class ApplicationLibraryRepresentation
        extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {

    /**
     * {
     *     "title": "folder 1",
     *     "_links": {
     *         "item": [
     *             {"href": "https://localhost:8443/marketplace/api/serviceItem/1"},
     *             {"href": "https://localhost:8443/marketplace/api/serviceItem/2"}
     *         ]
     *     }
     * }
     */
    private static class FolderRepresentation
            extends AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {
        final String title

        FolderRepresentation(String title, Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            this.title = title

            addLinks(entries, uriBuilderHolder)
        }

        private HalLinks addLinks(Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilder uriBuilderHolder) {
            entries.inject([:]) { linkMap, entry ->
                assert entry.folder == title

                URI href = uriBuilderHolder.builder.path(ServiceItemResource.class, 'read')
                    .buildFromMap(id: entry.serviceItem.id)

                _links.put(RegisteredRelationType.ITEM,
                    new Link(href, entry.serviceItem.id.toString()))
            }
        }
    }

    /**
     * A UriBuilder that should be initialized to the application root
     * (e.g. https://localhost:8443/marketplace)
     */
    private ApplicationLibraryRepresentation(Collection<ApplicationLibraryEntry> entries,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(null, createFolders(entries, uriBuilderHolder))
    }

    private HalEmbedded createFolders(Collection<ApplicationLibraryEntry> entries
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        entries.groupBy([{ it.folder }]).collect {folderName, entries ->
           _embedded.put(OzpRelationType.FOLDER, new FolderRepresentation(folderName, entries))
        }
    }

    private void setLibrary(Collection<ApplicationLibraryEntry> entries) {
        library = entries.inject([:]) { map, ent ->
            Collection<ServiceItem> list = map[ent.folder]
            map[ent.folder] = list ? (list + ent.serviceItem) : [ent.serviceItem]

            return map
        }
    }

    Map<String, Collection<ServiceItem>> getLibrary() {
        Collections.unmodifiedMap(library)
    }

    /**
     * Resulting JSON structure:
     * {
     *      "_embedded": {
     *          "ozp:folder": {
     *              "title": "folder 1",
     *              "_links": {
     *                  "item": [
     *                      {"href": "https://localhost:8443/marketplace/api/serviceItem/1"},
     *                      {"href": "https://localhost:8443/marketplace/api/serviceItem/2"}
     *                  ]
     *              }
     *          }
     *      }
     * }
     */
    JSONObject asJSON() {
        def makeLink = { si ->
            [
                href: uriBuilder.clone().path(ServiceItemResource.class, 'read')
                    .buildFromMap(id: si.id).toString()
            ]
        }

        def makeFolder = { folderName, items ->
            if (items.size()) {
                [
                    "title": folderName,
                    "_links": items.collect(makeLink)
                ]
            }
            else {
                null
            }
        }

        if (library.size()) {
            new JSONObject(
                "_embedded": [
                    "ozp:folder": library.collect(makeFolder) - null
                ]
            )
        }
        else {
            new JSONObject()
        }
    }

    @Component
    public static class Factory
            implements RepresentationFactory<Collection<ApplicationLibraryEntry>> {

        private static final Set<MediaType> MEDIA_TYPES =
            [
                new MediaType('application', 'vnd.ozp.library+json'),
                MediaType.APPLICATION_JSON_TYPE
            ] as Set


        Set<MediaType> getMediaTypes() { MEDIA_TYPES }
        Type getSupportedType() { null }

        ApplicationLibraryRepresentation toRepresentation(
                Collection<ApplicationLibraryEntry> entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationLibraryRepresentation(entries, uriBuilder)
        }
    }
}
