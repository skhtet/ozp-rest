package marketplace.rest.writer

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.ListingRepresentation
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Produces([
    MediaType.APPLICATION_JSON,
    ListingRepresentation.MEDIA_TYPE
])
class ListingRepresentationWriter extends AbstractRepresentationWriter<Listing> {
    @Autowired
    ListingRepresentationWriter(ListingRepresentation.Factory factory) {
        super(factory)
    }
}
