package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ApplicationLibraryRepresentation
import marketplace.rest.ApplicationLibrary

@Provider
@Produces([ApplicationLibraryRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ApplicationLibraryRepresentationWriter
        extends AbstractRepresentationWriter<ApplicationLibrary> {
    ApplicationLibraryRepresentationWriter() {
        super(new ApplicationLibraryRepresentation.Factory())
    }
}
