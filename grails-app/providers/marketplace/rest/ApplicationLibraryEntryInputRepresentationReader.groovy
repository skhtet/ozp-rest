package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

@Consumes([
    ApplicationLibraryEntryInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Provider
class ApplicationLibraryEntryInputRepresentationReader
        extends AbstractRepresentationReader<ApplicationLibraryEntryInputRepresentation> {}
