package marketplace.rest

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter

@Provider
@Produces([AgencyRepresentation.MEDIA_TYPE])
class AgencyRepresentationWriter extends AbstractRepresentationWriter<Agency> {
    AgencyRepresentationWriter() {
        super(new AgencyRepresentation.Factory())
    }
}
