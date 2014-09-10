package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider

@Consumes(['application/vnd.ozp.library.entry+json', 'application/json'])
@Provider
class ApplicationLibraryEntryInputRepresentationReader
        extends AbstractRepresentationReader<ApplicationLibraryEntryInputRepresentation> {}
