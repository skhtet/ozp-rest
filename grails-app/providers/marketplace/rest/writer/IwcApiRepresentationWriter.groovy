package marketplace.rest.writer

import marketplace.hal.AbstractRepresentationWriter
import marketplace.Profile
import marketplace.rest.IwcApi

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import marketplace.rest.representation.out.IwcApiRepresentation

@Provider
@Produces([
    IwcApiRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcApiRepresentationWriter extends AbstractRepresentationWriter<IwcApi> {
    IwcApiRepresentationWriter() {
        super(new IwcApiRepresentation.Factory())
    }
}
