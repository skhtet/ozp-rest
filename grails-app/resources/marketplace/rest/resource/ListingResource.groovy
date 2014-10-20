package marketplace.rest.resource

import marketplace.rest.service.ListingSearchService
import marketplace.search.SearchCriteria
import marketplace.search.SearchResult

import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.Produces
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing
import marketplace.RejectionListing
import marketplace.ItemComment
import marketplace.ListingActivity

import marketplace.rest.ChildObjectCollection
import marketplace.rest.representation.in.ListingInputRepresentation
import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.representation.in.ItemCommentInputRepresentation
import marketplace.rest.representation.in.RejectionListingInputRepresentation
import marketplace.rest.representation.out.ItemCommentRepresentation
import marketplace.rest.representation.out.RejectionListingRepresentation
import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.representation.out.ListingRepresentation
import marketplace.rest.service.ListingRestService
import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.RejectionListingRestService
import marketplace.rest.service.ListingActivityRestService

import javax.ws.rs.core.UriInfo

import static org.grails.jaxrs.response.Responses.*

@Path('/api/listing')
@Produces([
    ListingRepresentation.MEDIA_TYPE,
    ApplicationRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Consumes([ListingInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ListingResource extends RepresentationResource<Listing, ListingInputRepresentation> {

    @Autowired ListingActivityRestService listingActivityRestService
    @Autowired RejectionListingRestService rejectionListingRestService
    @Autowired ItemCommentRestService itemCommentRestService
    @Autowired ListingSearchService listingSearchService

    @Autowired
    ListingResource(ListingRestService service) {
        super(service)
    }

    ListingResource() {}

    @Path('/activity')
    @GET
    public Collection<ListingActivity> getActivitiesForListings(
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        listingActivityRestService.getAll(offset, max)
    }

    @Path('/{listingId}/activity')
    @GET
    public Collection<ListingActivity> getListingActivitiesForListing(
            @PathParam('listingId') long listingId,
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        listingActivityRestService.getByParentId(listingId, offset, max)
    }

    @Path('/{listingId}/rejectionListing')
    @Produces([
        RejectionListingRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes([
        RejectionListingInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @POST
    public RejectionListing createRejectionListing(@PathParam('listingId') long listingId,
            InputRepresentation<RejectionListing> rep) {
        rejectionListingRestService.createFromParentIdAndRepresentation(listingId, rep)
    }

    @Path('/{listingId}/rejectionListing')
    @Produces([
        RejectionListingRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    public RejectionListing getMostRecentRejectionListing(
            @PathParam('listingId') long listingId) {
        rejectionListingRestService.getMostRecentRejectionListing(listingId)
    }

    @Path('/{listingId}/requiredListings')
    @GET
    public Collection<Listing> getRequiredListings(
            @PathParam('listingId') long listingId) {

        service.getAllRequiredListingsByParentId(listingId)
    }

    @Path('/{listingId}/requiringListings')
    @GET
    public Collection<Listing> getRequiringListings(
            @PathParam('listingId') long listingId) {

        service.getRequiringListingsByChildId(listingId)
    }

    @Path('/{listingId}/itemComment')
    @GET
    @Produces([ItemCommentRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    public ChildObjectCollection<Listing, ItemComment> getItemCommentsByListingId(
            @PathParam('listingId') long listingId) {
        new ChildObjectCollection(itemCommentRestService.getByParentId(listingId), read(listingId))
    }

    @Path('/{listingId}/itemComment')
    @POST
    @Consumes([ItemCommentInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Produces([ItemCommentRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    public Response createItemComment(@PathParam('listingId') long listingId,
            InputRepresentation<ItemComment> rep) {
        created itemCommentRestService.createFromParentIdAndRepresentation(listingId, rep)
    }

    @Path('/{listingId}/itemComment/{itemCommentId}')
    @PUT
    @Consumes([ItemCommentInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Produces([ItemCommentRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    public ItemComment updateItemComment(@PathParam('listingId') long listingId,
            @PathParam('itemCommentId') long id, InputRepresentation<ItemComment> rep) {
        itemCommentRestService.updateById(id, rep)
    }

    @Path('/{listingId}/itemComment/{itemCommentId}')
    @DELETE
    @Produces([])
    public void deleteItemComment(@PathParam('itemCommentId') long itemCommentId) {
        itemCommentRestService.deleteById(itemCommentId)
    }

    @Path('/search')
    @GET
    public SearchResult<Listing> search(@Context UriInfo uriInfo) {
        listingSearchService.searchListings(SearchCriteria.fromQueryParams(uriInfo.getQueryParameters(true)))
    }
}
