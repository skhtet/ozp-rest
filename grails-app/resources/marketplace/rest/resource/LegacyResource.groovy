package marketplace.rest.resource

import javax.ws.rs.PathParam
import javax.ws.rs.FormParam
import javax.ws.rs.Path
import javax.ws.rs.PUT

import marketplace.rest.filter.LegacyHTTPMethod


/**
 * This class contains endpoints that are a carry-over (interface-wise) from OWF 7.x
 * and earlier.  These endpoints still need to exist to support OWF 7 widget compatibility.
 */
@Path('/api/prefs')
class LegacyResource {
    @Path('/preference/{namespace}/{name}')
    @PUT
    @LegacyHTTPMethod
    public /*LegacyPreference*/ Object setPreference(
            @PathParam('namespace') String namespace,
            @PathParam('name') String name,
            @FormParam('value') String value) {
        //TODO
        return null
    }
}
