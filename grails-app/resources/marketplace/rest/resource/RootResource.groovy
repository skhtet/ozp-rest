package marketplace.rest.resource

import java.util.concurrent.Future
import java.util.concurrent.Callable

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import marketplace.Listing

import marketplace.rest.service.ProfileRestService
import marketplace.rest.service.CategoryRestService
import marketplace.rest.service.TypeRestService
import marketplace.rest.service.IntentRestService
import marketplace.rest.service.ContactTypeRestService
import marketplace.rest.service.AgencyRestService
import marketplace.rest.service.ListingSearchService

import marketplace.rest.StoreMetadata
import marketplace.rest.Storefront
import marketplace.rest.IwcApi

import marketplace.rest.representation.out.IwcApiRepresentation
import marketplace.rest.representation.out.StoreMetadataRepresentation
import marketplace.rest.representation.out.StorefrontRepresentation

import marketplace.search.SearchCriteria
import marketplace.search.SearchResult

@Path('api')
class RootResource {

    @Autowired ProfileRestService profileRestService
    @Autowired CategoryRestService categoryRestService
    @Autowired TypeRestService typeRestService
    @Autowired IntentRestService intentRestService
    @Autowired ContactTypeRestService contactTypeRestService
    @Autowired AgencyRestService agencyRestService
    @Autowired ListingSearchService listingSearchService

    //use a thread pool to perform the three searches of getStorefrontInfo in parallel
    //for minimum latency
    @Autowired ThreadPoolTaskExecutor storefrontSearchThreadPool

    @GET
    @Produces([
        IwcApiRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcApi readIwcApi() {
        new IwcApi(profileRestService.currentUserProfile)
    }

    @Path('metadata')
    @GET
    @Produces([
        StoreMetadataRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    StoreMetadata getAllMetadata() {
        new StoreMetadata(
            categoryRestService.getAll(null, null),
            typeRestService.getAll(null, null),
            intentRestService.getAll(null, null),
            contactTypeRestService.getAll(null, null),
            agencyRestService.getAll(null, null)
        )
    }

    /**
     * A method to return the various listing information required for the
     * front page of the center-ui.  This includes featured listings, most
     * recent listings, and highest-rated listings
     */
    @Path('storefront')
    @GET
    @Produces([
        StorefrontRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Storefront getStorefrontInfo() {
        Callable<SearchResult<Listing>> getFeaturedListings = { ->
            listingSearchService.searchListings(SearchCriteria.fromQueryParams(
                isFeatured: ['true'],
                sort: ['avgRate'],
                order: ['desc'],
                max: ['24']
            ))
        } as Callable

        Callable<SearchResult<Listing>> getRecentListings = { ->
            listingSearchService.searchListings(SearchCriteria.fromQueryParams(
                sort: ['approvedDate'],
                order: ['desc'],
                max: ['24']
            ))
        } as Callable

        Callable<SearchResult<Listing>> getBestListings = { ->
            listingSearchService.searchListings(SearchCriteria.fromQueryParams(
                sort: ['avgRate'],
                order: ['desc'],
                max: ['36']
            ))
        } as Callable

        Future<SearchResult<Listing>> featuredFuture =
            storefrontSearchThreadPool.submit((Callable)getFeaturedListings)
        Future<SearchResult<Listing>> recentFuture =
            storefrontSearchThreadPool.submit((Callable)getRecentListings)
        Future<SearchResult<Listing>> bestFuture =
            storefrontSearchThreadPool.submit((Callable)getBestListings)

        new Storefront(featuredFuture.get(), recentFuture.get(), bestFuture.get())
    }
}
