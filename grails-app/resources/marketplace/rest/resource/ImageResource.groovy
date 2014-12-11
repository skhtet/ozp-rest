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
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

@Path('/api/image')
class ImageResource {
    @Autowired ImageRestService service
    @Autowired ImageReferenceUriBuilder.Factory uriBuilderFactory

    @GET
    @Path('{id}.{extension}')
    @Produces('image/*')
    @Consumes()
    public Response getImage(@PathParam('id') UUID id,
            @PathParam('extension') String fileExtension) {
        ImageReference reference = new ImageReference(id, service.getMediaType(fileExtension))

        service.get(reference)

        Response.ok(path, reference.mediaType).build()
    }

    @POST
    @Produces([ImageReferenceRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes('image/*')
    public Response create(
            @Context UriInfo uriInfo,
            byte[] image,
            @HeaderParam('Content-Type') MediaType requestType) {
        ImageReference reference = new ImageReference(requestType)

        service.createFromRepresentation(reference, image)

        ImageReferenceUriBuilder imageUriBuilder =
            uriBuilderFactory.getBuilder(new ApplicationRootUriBuilderHolder(uriInfo))
        Response.created(imageUriBuilder.getImageUri(reference)).entity(reference).build()
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
        if (!formData) {
            throw new IllegalArgumentException("Request must include a part named 'image'")
        }

        create(uriInfo, formData.getValueAs((byte[]).class), formData.mediaType)
    }

    //PUT isn't allowed, and deletes are handled automatically by a quartz job
}
