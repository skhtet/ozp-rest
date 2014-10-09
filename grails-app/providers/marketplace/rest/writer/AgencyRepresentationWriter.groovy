package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.AgencyRepresentation

@Provider
@Produces([AgencyRepresentation.MEDIA_TYPE])
class AgencyRepresentationWriter extends AbstractRepresentationWriter<Agency> {

    @Autowired
    AgencyRepresentationWriter(AgencyRepresentation.Factory factory) {
        super(factory)
    }
}
