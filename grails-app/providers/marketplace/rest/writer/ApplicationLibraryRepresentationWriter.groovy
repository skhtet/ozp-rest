package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ApplicationLibraryRepresentation
import marketplace.rest.ChildObjectCollection

@Provider
@Produces([ApplicationLibraryRepresentation.MEDIA_TYPE])
class ApplicationLibraryRepresentationWriter extends
        AbstractRepresentationWriter<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {
    @Autowired
    ApplicationLibraryRepresentationWriter(ApplicationLibraryRepresentation.Factory factory) {
        super(factory)
    }
}
