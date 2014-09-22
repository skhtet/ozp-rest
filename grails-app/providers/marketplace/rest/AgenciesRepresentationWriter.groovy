package marketplace.rest

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

@Provider
@Produces([
    AgencyRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class AgenciesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Agency>> {

    AgenciesRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(AgencyRepresentation.class,
            AgencyResource.class))
    }
}
