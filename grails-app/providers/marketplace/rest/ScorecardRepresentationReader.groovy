package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Consumes([
    ScorecardInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ScorecardRepresentationReader extends AbstractRepresentationReader<ScorecardInputRepresentation> {}
