package marketplace.rest

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry

import marketplace.hal.AbstractRepresentationWriter

@Provider
@Produces(['application/vnd.ozp.library+hal', 'application/hal+json'])
class ApplicationLibraryRepresentationWriter
        extends AbstractRepresentationWriter<ApplicationLibrary> {
    ApplicationLibraryRepresentationWriter() {
        super(new ApplicationLibraryRepresentation.Factory())
    }
}
