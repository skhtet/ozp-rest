package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.IwcUserApplications
import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.representation.out.IwcUserApplicationsRepresentation

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Produces([
    ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcUserApplicationsRepresentationWriter extends AbstractRepresentationWriter<IwcUserApplications> {

    @Autowired
    IwcUserApplicationsRepresentationWriter(IwcUserApplicationsRepresentation.Factory factory) {
        super(factory)
    }
}
