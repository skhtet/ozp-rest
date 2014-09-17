package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Consumes([
    IntentInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentRepresentationReader extends AbstractRepresentationReader<IntentInputRepresentation> {}
