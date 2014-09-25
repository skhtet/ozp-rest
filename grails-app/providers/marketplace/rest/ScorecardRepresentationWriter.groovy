package marketplace.rest

import marketplace.Scorecard
import marketplace.hal.AbstractRepresentationWriter

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

@Provider
@Produces([
    ScorecardRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ScorecardRepresentationWriter extends AbstractRepresentationWriter<Scorecard> {
    ScorecardRepresentationWriter() {
        super(new ScorecardRepresentation.Factory())
    }
}
