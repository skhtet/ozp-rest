package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.ApplicationLibraryEntryInputRepresentation

@Consumes([
    ApplicationLibraryEntryInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Provider
class ApplicationLibraryEntryInputRepresentationReader
        extends AbstractRepresentationReader<ApplicationLibraryEntryInputRepresentation> {}
