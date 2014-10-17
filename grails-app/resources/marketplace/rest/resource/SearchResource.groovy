package marketplace.rest.resource

import marketplace.SearchableService
import marketplace.search.SearchCriteria

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo

import marketplace.rest.service.SearchRestService

@Path('/api/search')
class SearchResource extends JsonResource {

    @Context UriInfo uriInfo
    SearchableService searchableService
    SearchRestService searchRestService

    @GET
    Map search() {
        Map params = parseParams(uriInfo.getQueryParameters())
        params = searchRestService.buildSearchParams(params)
        doSearch(params)
    }

    @GET
    @Path('/affiliated')
    Map affiliatedSearch() {
        Map params = parseParams(uriInfo.getQueryParameters())
        params = searchRestService.buildAffiliatedSearchParams(params)
        doSearch(params)
    }

    private Map doSearch(Map params) {
        SearchCriteria searchBean = new SearchCriteria(params)
        def result = searchableService.searchListings(searchBean)
        Collection resultsList = result?.searchResults

        [
            total: result?.total ?: resultsList.size(),
            data: resultsList
        ]
    }
}
