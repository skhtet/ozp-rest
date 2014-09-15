package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider

@Provider
@Consumes([ListingInputRepresentation.MEDIA_TYPE])
class ListingInputRepresentationReader extends AbstractRepresentationReader<ListingInputRepresentation> {}
