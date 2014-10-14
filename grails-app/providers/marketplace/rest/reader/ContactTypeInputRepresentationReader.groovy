package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.ContactTypeInputRepresentation

@Consumes([
    ContactTypeInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Provider
class ContactTypeInputRepresentationReader
        extends AbstractRepresentationReader<ContactTypeInputRepresentation> {}
