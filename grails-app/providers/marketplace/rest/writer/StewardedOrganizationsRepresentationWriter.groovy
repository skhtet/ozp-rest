package marketplace.rest.writer

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

    StewardedOrganizationsRepresentationWriter() {
        super(new StewardedOrganizationsRepresentation.Factory())
    }
}
