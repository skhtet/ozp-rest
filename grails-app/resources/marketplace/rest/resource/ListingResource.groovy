package marketplace.rest.resource

import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.Produces
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import org.springframework.beans.factory.annotation.Autowired

import org.grails.plugins.elasticsearch.ElasticSearchAdminService

import marketplace.Listing
import marketplace.RejectionListing
import marketplace.ItemComment
import marketplace.ListingActivity

import marketplace.rest.representation.in.ListingInputRepresentation
import marketplace.rest.service.ListingRestService
import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.RejectionListingRestService
import marketplace.rest.service.ListingActivityRestService

import static org.grails.jaxrs.response.Responses.created

@Path('/api/listing')
class ListingResource extends DomainResource<Listing> {
    ListingRestService serviceItemRestService
    ListingActivityRestService serviceItemActivityRestService
    RejectionListingRestService rejectionListingRestService
    ItemCommentRestService itemCommentRestService
    ElasticSearchAdminService elasticSearchAdminService

    @Autowired
    ListingResource(ListingRestService service) {
        super(Listing.class, service)
    }

    ListingResource() {}

    @POST
    @Consumes([
        ListingInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response create(ListingInputRepresentation rep) {
        created service.createFromRepresentation(rep)
    }

    @PUT
    @Path('/{id}')
    @Consumes([
        ListingInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Listing update(@PathParam('id') long id, ListingInputRepresentation rep) {
        service.updateById(id, rep)
    }

    @Path('/activity')
    @GET
    public Collection<ListingActivity> getActivitiesForServiceItems(
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getAll(offset, max)
    }

    @Path('/{listingId}/activity')
    @GET
    public Collection<ListingActivity> getServiceItemActivitiesForServiceItem(
            @PathParam('listingId') long listingId,
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getByParentId(listingId, offset, max)
    }

    @Path('/{listingId}/rejectionListing')
    @POST
    public RejectionListing createRejectionListing(@PathParam('listingId') long listingId,
            RejectionListing dto) {
        rejectionListingRestService.createFromParentIdAndDto(listingId, dto)
    }

    @Path('/{listingId}/rejectionListing')
    @GET
    public RejectionListing getMostRecentRejectionListing(
            @PathParam('listingId') long listingId) {
        rejectionListingRestService.getMostRecentRejectionListing(listingId)
    }

    @Path('/{listingId}/requiredListings')
    //add JSONP support.  javascript has to be first in the list because browsers
    //send */* Accept headers for script tags, which is quite unhelpful
    @Produces(['application/javascript', 'text/javascript', 'application/json'])
    @GET
    public Collection<Listing> getRequiredListings(
            @PathParam('listingId') long serviceItemId) {

        serviceItemRestService.getAllRequiredListingsByParentId(serviceItemId)
    }

    @Path('/{listingId}/requiringListings')
    @Produces(['application/javascript', 'text/javascript', 'application/json'])
    @GET
    public Collection<Listing> getRequiringListings(
            @PathParam('listingId') long listingId) {

        serviceItemRestService.getRequiringListingsByChildId(listingId)
    }

    @Path('/{listingId}/itemComment')
    @GET
    public Collection<ItemComment> getItemCommentsByListingId(
            @PathParam('listingId') long listingId) {
        itemCommentRestService.getByParentId(listingId)
    }

    @Path('/{listingId}/itemComment')
    @POST
    public ItemComment createItemComment(@PathParam('listingId') long listingId,
            ItemComment dto) {
        itemCommentRestService.createFromParentIdAndDto(listingId, dto)
    }

    @Path('/{listingId}/itemComment/{itemCommentId}')
    @PUT
    public ItemComment updateItemComment(@PathParam('listingId') long listingId,
            @PathParam('itemCommentId') long id, ItemComment dto) {
        itemCommentRestService.updateByParentId(listingId, id, dto)
    }

    @Path('/{listingId}/itemComment/{itemCommentId}')
    @DELETE
    public void deleteItemComment(@PathParam('itemCommentId') long itemCommentId) {
        itemCommentRestService.deleteById(itemCommentId)
    }

    @Override
    public void delete(long id) {
        super.delete(id)
        refreshElasticSearch()
    }

    @Override
    public Response create(Listing dto) {
        Response retval = super.create(dto)
        refreshElasticSearch()
        return retval
    }

    @Override
    public Listing update(long id, Listing dto) {
        Listing retval = super.update(id, dto)
        refreshElasticSearch()
        return retval
    }

    private void refreshElasticSearch() {
        //ensure elastic search is finished updating before returning response
        elasticSearchAdminService.refresh(Listing)
    }
}
