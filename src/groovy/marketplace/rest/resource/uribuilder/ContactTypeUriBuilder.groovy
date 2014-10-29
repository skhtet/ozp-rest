package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.ContactTypeResource
import marketplace.ContactType

class ContactTypeUriBuilder extends RepresentationResourceUriBuilder<ContactType> {
    protected ContactTypeUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(ContactTypeResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<ContactType>, CollectionUriBuilder.Factory<ContactType> {
        ContactTypeUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ContactTypeUriBuilder(uriBuilderHolder)
        }
    }
}
