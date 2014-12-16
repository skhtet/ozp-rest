package marketplace.rest.resource

import javax.servlet.http.HttpServletRequest

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
import javax.ws.rs.core.CacheControl

import com.sun.jersey.multipart.FormDataBodyPart
import com.sun.jersey.multipart.FormDataParam

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ImageReference
import marketplace.ClientAuditData

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.service.ImageRestService

import marketplace.rest.representation.out.ImageReferenceRepresentation
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

import marketplace.rest.filter.CacheControlHeader

@Path('/api/image')
class ImageResource {

    @Autowired ImageRestService service
    @Autowired ImageReferenceUriBuilder.Factory uriBuilderFactory

    @GET
    @Path('{id}.{extension}')
    @Produces('image/*')
    @Consumes()
    @CacheControlHeader('max-age: 604800')
    public Response getImage(
            @Context HttpServletRequest request,
            @PathParam('id') UUID id,
            @PathParam('extension') String fileExtension) {
        ImageReference reference = new ImageReference(id, service.getMediaType(fileExtension))

        File file = service.get(reference, ClientAuditData.fromHttpRequest(request)).toFile()
        Response.ok(file, reference.mediaType).build()
    }

    @POST
    @Produces([ImageReferenceRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes('image/*')
    public Response create(
            @Context UriInfo uriInfo,
            @Context HttpServletRequest request,
            byte[] image,
            @HeaderParam('Content-Type') MediaType requestType) {
        ImageReference reference = new ImageReference(requestType)

        service.createFromRepresentation(reference, image,
            ClientAuditData.fromHttpRequest(request))

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
            @Context HttpServletRequest request,
            @FormDataParam('image') FormDataBodyPart formData) {
        if (!formData) {
            throw new IllegalArgumentException("Request must include a part named 'image'")
        }

        create(uriInfo, request, formData.getValueAs((byte[]).class), formData.mediaType)
    }

    //PUT isn't allowed, and deletes are handled automatically by a quartz job
}
