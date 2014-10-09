package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.IwcUserData
import marketplace.rest.representation.out.IwcUserDataRepresentation

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import marketplace.rest.representation.out.IwcDataObjectRepresentation

@Provider
@Produces([
    IwcDataObjectRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcUserDataRepresentationWriter extends AbstractRepresentationWriter<IwcUserData> {

    @Autowired
    IwcUserDataRepresentationWriter(IwcUserDataRepresentation.Factory factory) {
        super(factory)
    }
}
