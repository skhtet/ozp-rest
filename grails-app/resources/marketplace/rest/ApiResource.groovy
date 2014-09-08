package marketplace.rest

import grails.util.GrailsUtil
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path('/api')
class ApiResource {

    @GET
    Map api() {
        [
            version: 'nextgen-demo',
            buildNumber: '-1',
            buildDate: new Date()
        ]
    }
}
