package marketplace.rest.resource

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ContactType

import marketplace.rest.service.ContactTypeRestService

@Path('api/contactType')
class ContactTypeResource extends DomainResource<ContactType> {

    @Autowired
    public ContactTypeResource(ContactTypeRestService contactTypeRestService) {
        super(ContactType.class, contactTypeRestService)
    }

    ContactTypeResource() {}
}
