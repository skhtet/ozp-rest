package marketplace.rest.writer

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.ContactType

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.ContactTypeRepresentation
import marketplace.rest.resource.uribuilder.ContactTypeUriBuilder

@Provider
@Produces([
    ContactTypeRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ContactTypesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<ContactType>> {

    @Autowired
    ContactTypesRepresentationWriter(ContactTypeRepresentation.Factory factory,
            ContactTypeUriBuilder.Factory typeUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(factory, typeUriBuilderFactory))
    }
}
