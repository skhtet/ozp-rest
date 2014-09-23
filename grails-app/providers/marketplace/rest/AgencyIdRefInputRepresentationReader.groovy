package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

@Provider
@Consumes([IdRefInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class AgencyIdRefInputRepresentationReader extends AbstractRepresentationReader<AgencyIdRef> {}
