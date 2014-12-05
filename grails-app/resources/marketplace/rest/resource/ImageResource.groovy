package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PathParam
import javax.ws.rs.HeaderParam
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.service.ImageRestService

import marketplace.ImageReference

import marketplace.rest.representation.out.ImageReferenceRepresentation
import marketplace.rest.representation.in.ImageReferenceInputRepresentation

@Path('/api/image')
class ImageResource {
    @Autowired ImageRestService service

    @GET
    @Path('{id}')
    @Produces('image/*')
    @Consumes()
    public Response getImage(@PathParam('id') UUID id) {
        ImageReference image = service.getById(id.toString())

        Response.ok(service.getFile(image), image.mediaType).build()
    }

    @GET
    @Path('{id}')
    @Produces([ImageReferenceRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes()
    public ImageReference getImageReference(@PathParam('id') UUID id) {
        service.getById(id.toString())
    }

    @POST
    @Produces([ImageReferenceRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes('image/*')
    public ImageReference create(
            byte[] image,
            @HeaderParam('Content-Type') MediaType requestType) {
        service.createFromRepresentation(new ImageReferenceInputRepresentation(
            mediaType: requestType,
            image: image
        ))
    }

    //PUT isn't allowed, and deletes and handled automatically by a quartz job
}
