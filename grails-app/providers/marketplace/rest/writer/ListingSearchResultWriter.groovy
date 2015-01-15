package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Listing
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.ListingRepresentation
import marketplace.rest.representation.out.SearchResultRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ListingSearchUriBuilder
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
    ListingSearchResultWriter(GrailsApplication grailsApplication,

            ListingRepresentation.Factory factory,
            ListingSearchUriBuilder.Factory searchUriBuilderFactory,
            ListingUriBuilder.Factory uriBuilderFactory) {
        super(grailsApplication, SearchResultRepresentation.createFactory(factory, searchUriBuilderFactory,
            uriBuilderFactory))
    }
}
