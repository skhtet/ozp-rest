package marketplace.rest.writer

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Agency

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.AgencyRepresentation
import marketplace.rest.resource.uribuilder.AgencyUriBuilder

@Provider
@Produces([
    AgencyRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class AgenciesRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Agency>> {

    @Autowired
    AgenciesRepresentationWriter(AgencyRepresentation.Factory factory,
            AgencyUriBuilder.Factory agencyUriBuilderFactory) {
        super(EmbeddedCollectionRepresentation.createFactory(factory,
            agencyUriBuilderFactory))
    }
}
