package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider

@Consumes(['application/vnd.ozp.library.entries+json', 'application/json'])
@Provider
class ApplicationLibraryEntryInputRepresentationCollectionReader extends
AbstractRepresentationCollectionReader<ApplicationLibraryEntryInputRepresentation> {}
