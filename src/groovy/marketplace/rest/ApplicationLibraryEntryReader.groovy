package marketplace.rest

import javax.ws.rs.Consumes

@Consumes(['application/vnd.ozp.library.entry+json', 'application/json'])
class ApplicationLibraryEntryReader
        extends AbstractRepresentationReader<ApplicationLibraryEntryInputRepresentation> {}
