package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import com.google.common.reflect.TypeToken

import marketplace.ApplicationLibraryEntry

import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.AbstractHalRepresentation

import marketplace.rest.representation.out.ApplicationLibraryEntryRepresentation

@Provider
@Produces([
    ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
    AbstractHalRepresentation.HAL_MEDIA_TYPE
])
class ApplicationLibraryEntryRepresentationWriter
        extends AbstractRepresentationWriter<ApplicationLibraryEntry> {

    @Autowired
    ApplicationLibraryEntryRepresentationWriter(ApplicationLibraryEntryRepresentation.Factory factory) {
        super(factory)
    }
}
