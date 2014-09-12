package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider

@Provider
@Consumes(['application/vnd.ozp.listing+json'])
class ListingInputRepresentationReader extends AbstractRepresentationReader<ListingInputRepresentation> {}
