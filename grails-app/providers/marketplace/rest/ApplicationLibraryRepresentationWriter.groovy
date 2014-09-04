package marketplace.rest

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry

@Provider
@Produces(['application/vnd.ozp.library+json', 'application/json'])
class ApplicationLibraryRepresentationWriter
        extends AbstractRepresentationWriter<Collection<ApplicationLibraryEntry>> {
    ApplicationLibraryRepresentationWriter() {
        super(new ApplicationLibraryRepresentation.Factory())
    }
}
