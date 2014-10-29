package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ContactType

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory
import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ContactTypeUriBuilder

class ContactTypeRepresentation extends SelfRefRepresentation<ContactType> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-contact-type-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-contact-types-v1+json'

    private ContactType contactType

    private ContactTypeRepresentation(ContactType contactType,
            ObjectUriBuilder<ContactType> contactTypeUriBuilder) {
        super(contactTypeUriBuilder.getUri(contactType), null, null)

        this.contactType = contactType
    }

    public String getTitle() { contactType.title }
    public boolean getRequired() { contactType.required }
    public Long getId() { contactType.id }

    @Component
    public static class Factory implements RepresentationFactory<ContactType> {
        @Autowired ContactTypeUriBuilder.Factory uriBuilderFactory

        ContactTypeRepresentation toRepresentation(ContactType contactType,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ContactTypeRepresentation(contactType,
                uriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
