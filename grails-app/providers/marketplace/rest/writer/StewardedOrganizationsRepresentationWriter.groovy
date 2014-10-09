package marketplace.rest.writer

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import marketplace.rest.StewardedOrganizations
import marketplace.rest.representation.out.StewardedOrganizationsRepresentation
import marketplace.rest.representation.out.AgencyRepresentation

@Provider
@Produces([
    AgencyRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class StewardedOrganizationsRepresentationWriter extends
        AbstractRepresentationWriter<StewardedOrganizations> {

    @Autowired
    StewardedOrganizationsRepresentationWriter(StewardedOrganizationsRepresentation.Factory factory) {
        super(factory)
    }
}
