package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.GET
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response

import marketplace.rest.service.ImageRestService

import marketplace.Image

@Path('/api/image')
@Produces('image/*')
class ImageResource {
    ImageRestService imageRestService

    @GET
    @Path('{id}')
    public Response getImage(@PathParam('id') long id) {
        Image image = imageRestService.getById(id)

        Response.ok(image.data, image.mediaType).build()
    }
}
