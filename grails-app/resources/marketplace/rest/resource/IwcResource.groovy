package marketplace.rest.resource

import marketplace.rest.IwcApi
import marketplace.rest.representation.out.IwcApiRepresentation

import javax.ws.rs.GET
import javax.ws.rs.Path
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.service.ProfileRestService

@Path('api')
class IwcResource {

    @Autowired ProfileRestService profileRestService

    @GET
    @Produces([
        IwcApiRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcApi readIwcApi() {
        new IwcApi(profileRestService.currentUserProfile)
    }
}
