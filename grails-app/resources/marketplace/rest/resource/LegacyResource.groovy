package marketplace.rest.resource

import javax.ws.rs.PathParam
import javax.ws.rs.FormParam
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.MediaType

import marketplace.rest.filter.LegacyHTTPMethod

import marketplace.rest.LegacyPreference

/**
 * This class contains endpoints that are a carry-over (interface-wise) from OWF 7.x
 * and earlier.  These endpoints still need to exist to support OWF 7 widget compatibility.
 */
@Path('/api/prefs')
@Produces([
    MediaType.APPLICATION_JSON,
    MediaType.TEXT_HTML
])
class LegacyResource {
    @Path('/preference/{namespace}/{name}')
    @PUT
    public LegacyPreference setPreference(
            @PathParam('namespace') String namespace,
            @PathParam('name') String name,
            @FormParam('value') String value) {
        //TODO real impl
        new LegacyPreference(namespace: namespace, name: name, value: value)
    }
}
