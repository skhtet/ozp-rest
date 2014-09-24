package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.AgencyIdRef
import marketplace.rest.representation.in.IdRefInputRepresentation

@Provider
@Consumes([IdRefInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class AgencyIdRefInputRepresentationReader extends AbstractRepresentationReader<AgencyIdRef> {}
