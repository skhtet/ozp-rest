package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import marketplace.rest.representation.in.ListingInputRepresentation

@Provider
@Consumes([
    ListingInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ListingInputRepresentationReader extends AbstractRepresentationReader<ListingInputRepresentation> {}
