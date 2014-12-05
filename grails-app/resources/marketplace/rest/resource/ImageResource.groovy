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
import javax.ws.rs.core.UriInfo
import javax.ws.rs.core.Context

import com.sun.jersey.multipart.FormDataBodyPart
import com.sun.jersey.multipart.FormDataParam

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ImageReference

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.service.ImageRestService

import marketplace.rest.representation.out.ImageReferenceRepresentation
import marketplace.rest.representation.in.ImageReferenceInputRepresentation
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

@Path('/api/image')
class ImageResource {
    @Autowired ImageRestService service
    @Autowired ImageReferenceUriBuilder.Factory uriBuilderFactory

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
    public Response create(
            @Context UriInfo uriInfo,
            byte[] image,
            @HeaderParam('Content-Type') MediaType requestType) {
        ImageReference imageRef = service.createFromRepresentation(
            new ImageReferenceInputRepresentation(
                mediaType: requestType,
                image: image
            )
        )

        ImageReferenceUriBuilder imageUriBuilder =
            uriBuilderFactory.getBuilder(new ApplicationRootUriBuilderHolder(uriInfo))
        Response.created(imageUriBuilder.getUri(imageRef)).entity(imageRef).build()
    }

    /**
     * Allow images to be submitted via multipart/form-data requests for compatibility
     * with browsers which have no way to do a raw image as the request body.  The image
     * should be in a response part named 'image'
     */
    @POST
    @Produces([ImageReferenceRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createFromForm(
            @Context UriInfo uriInfo,
            @FormDataParam('image') FormDataBodyPart formData) {
        create(uriInfo, formData.getValueAs((byte[]).class), formData.mediaType)
    }

    //PUT isn't allowed, and deletes are handled automatically by a quartz job
}
