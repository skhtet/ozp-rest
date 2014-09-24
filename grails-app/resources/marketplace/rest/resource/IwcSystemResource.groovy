package marketplace.rest.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.UriInfo

//TODO: This is obviously a placeholder for what should really go here...  remove after demo
@Path('api/system')
class IwcSystemResource {
    @GET
    @Produces([
        MediaType.APPLICATION_JSON
    ])
    Map<String, String> read(@Context UriInfo uriInfo) {
        [
            version: '1.0',
            name: 'IWC Demo Site',
            "_links": [
                self: [href: uriInfo.absolutePath.toString()]
            ]
        ]
    }
}
