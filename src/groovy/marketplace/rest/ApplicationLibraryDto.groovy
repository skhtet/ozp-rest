package marketplace.rest

import org.codehaus.groovy.grails.web.json.JSONObject
import javax.ws.rs.core.UriBuilder

import marketplace.ServiceItem
import marketplace.ApplicationLibraryEntry

class ApplicationLibraryDto {
    //map from folder name to list of Listings
    Map<String, Collection<ServiceItem>> library
    UriBuilder uriBuilder

    /**
     * A UriBuilder that should be initialized to the application root
     * (e.g. https://localhost:8443/marketplace)
     */
    ApplicationLibraryDto(Collection<ApplicationLibraryEntry> entries, UriBuilder uriBuilder) {
        setLibrary(entries)
        this.uriBuilder = uriBuilder.clone()
    }

    public void setLibrary(Collection<ApplicationLibraryEntry> entries) {
        library = entries.inject([:]) { map, ent ->
            Collection<ServiceItem> list = map[ent.folder]
            map[ent.folder] = list ? (list + ent.serviceItem) : [ent.serviceItem]

            return map
        }
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
}
