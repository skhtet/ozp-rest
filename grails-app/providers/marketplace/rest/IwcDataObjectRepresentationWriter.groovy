package marketplace.rest

import marketplace.IwcDataObject
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Produces([
    IwcDataObjectRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcDataObjectRepresentationWriter extends AbstractRepresentationWriter<IwcDataObject> {
    IwcDataObjectRepresentationWriter() {
        super(new IwcDataObjectRepresentation.Factory())
    }
}
