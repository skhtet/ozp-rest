package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import marketplace.IwcDataObject
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import marketplace.rest.representation.out.IwcDataObjectRepresentation

@Provider
@Produces([
    IwcDataObjectRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcDataObjectRepresentationWriter extends AbstractRepresentationWriter<IwcDataObject> {

    @Autowired
    IwcDataObjectRepresentationWriter(IwcDataObjectRepresentation.Factory factory) {
        super(factory)
    }
}
