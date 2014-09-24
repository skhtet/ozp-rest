package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.ApplicationLibraryEntryInputRepresentation

@Consumes([
    ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Provider
class ApplicationLibraryEntryInputRepresentationCollectionReader extends
AbstractRepresentationCollectionReader<ApplicationLibraryEntryInputRepresentation> {}
