package marketplace.rest.writer

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.ListingRepresentation
import marketplace.rest.representation.out.SearchResultRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.search.SearchResult
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Produces([
    ListingRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ListingSearchResultWriter extends AbstractRepresentationWriter<SearchResult<Listing>> {

    @Autowired
    ListingSearchResultWriter(ListingRepresentation.Factory factory, ListingUriBuilder.Factory uriBuilderFactory) {
        super(SearchResultRepresentation.createFactory(factory, uriBuilderFactory))
    }
}
