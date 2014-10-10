package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.RejectionListing

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.RejectionListingRepresentation

@Provider
@Produces([
    RejectionListingRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class RejectionListingRepresentationWriter extends AbstractRepresentationWriter<RejectionListing> {

    @Autowired
    RejectionListingRepresentationWriter(RejectionListingRepresentation.Factory factory) {
        super(factory)
    }
}

