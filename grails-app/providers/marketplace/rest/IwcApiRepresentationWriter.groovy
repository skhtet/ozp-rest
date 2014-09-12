package marketplace.rest

import marketplace.hal.AbstractRepresentationWriter
import marketplace.Profile

import javax.ws.rs.Produces
import javax.ws.rs.ext.Provider

@Provider
@Produces(['application/vnd.ozp.iwc+hal'])
class IwcApiRepresentationWriter extends AbstractRepresentationWriter<Profile> {
    IwcApiRepresentationWriter() {
        super(new IwcApiRepresentation.Factory())
    }
}
