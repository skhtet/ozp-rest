package marketplace.rest

import marketplace.hal.AbstractRepresentationWriter
import marketplace.Profile

import javax.ws.rs.Produces
import javax.ws.rs.ext.Provider

@Provider
@Produces([IwcApiRepresentation.MEDIA_TYPE])
class IwcApiRepresentationWriter extends AbstractRepresentationWriter<Profile> {
    IwcApiRepresentationWriter() {
        super(new IwcApiRepresentation.Factory())
    }
}
