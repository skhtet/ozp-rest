package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ContactType

import marketplace.hal.PagedCollection

import marketplace.rest.service.ContactTypeRestService

import marketplace.rest.representation.out.ContactTypeRepresentation
import marketplace.rest.representation.in.ContactTypeInputRepresentation

@Path('api/contactType')
@Produces([
    ContactTypeRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Consumes([
    ContactTypeInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ContactTypeResource extends RepresentationResource<ContactType, ContactTypeInputRepresentation> {

    @Autowired
    public ContactTypeResource(ContactTypeRestService categoryRestService) {
        super(categoryRestService)
    }

    ContactTypeResource() {}

    @Produces([
        ContactTypeRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<ContactType> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }
}
