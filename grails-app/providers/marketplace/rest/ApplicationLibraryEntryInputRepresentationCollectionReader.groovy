package marketplace.rest

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider

@Consumes(['application/vnd.ozp.library+json', 'application/json'])
@Provider
class ApplicationLibraryEntryInputRepresentationCollectionReader extends
AbstractRepresentationCollectionReader<ApplicationLibraryEntryInputRepresentation> {}
