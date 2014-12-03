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

import com.sun.jersey.multipart.FormDataParam
import com.sun.jersey.multipart.FormDataBodyPart

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing
import marketplace.Image
import marketplace.RejectionListing
import marketplace.ItemComment
import marketplace.ListingActivity

import marketplace.rest.PagingChildObjectCollection
import marketplace.rest.ChildObjectCollection
import marketplace.rest.representation.in.ListingInputRepresentation
import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.representation.in.ItemCommentInputRepresentation
import marketplace.rest.representation.in.RejectionListingInputRepresentation
import marketplace.rest.representation.in.ScreenshotInputRepresentation
import marketplace.rest.representation.out.ItemCommentRepresentation
import marketplace.rest.representation.out.RejectionListingRepresentation
import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.representation.out.ListingRepresentation
import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.service.ListingRestService
import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.RejectionListingRestService
import marketplace.rest.service.ListingActivityRestService
import marketplace.rest.service.ImageRestService
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ImageUriBuilder

import marketplace.hal.PagedCollection
import marketplace.hal.ApplicationRootUriBuilderHolder

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
    @Autowired ImageRestService imageRestService

    @Autowired ImageUriBuilder.Factory imageUriBuilderFactory

    @Autowired
    ListingResource(ListingRestService service) {
        super(service)
    }

    ListingResource() {}

    @Override
    @GET
    @Produces([
        ListingRepresentation.COLLECTION_MEDIA_TYPE,
        ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    PagedCollection<Listing> readAll(@QueryParam('offset') Integer offset,
                                     @QueryParam('max') Integer max) {
        super.readAll(offset, max)
    }

    /**
     * A multipart/form-data request is used to upload a listing along with its
     * images.  For screenshots, there should be a matching number of `screenshotSmall`
     * and `screenshotLarge` parts which will be combined index-wise to make Screenshot objects.
     * NOTE: External image URIs can still be included in the listing json, but uploaded images
     * take precedence
     *
     * Expected form parts:
     * listing (application/vnd.ozp-listing-v1+json or application/json)
     *   A typical JSON representation of a listing
     * imageSmall (image/*) A image to be the small icon for the listing
     * imageMedium (image/*) A image to be the medium icon for the listing
     * imageLarge (image/*) A image to be the banner for the listing
     * imageXlarge (image/*) A image to be the featured banner for the listing
     * screenshotSmall (image/*) One or more images to be the small images in screenshots
     * screenshotLarge (image/*) One or more images to be the large images in screenshots
     */
    @POST
    @Produces([
        ListingRepresentation.COLLECTION_MEDIA_TYPE,
        ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createFromFormData(
            @Context UriInfo uriInfo,
            @FormDataParam('listing') ListingInputRepresentation listing,
            @FormDataParam('smallIcon') FormDataBodyPart smallIcon,
            @FormDataParam('largeIcon') FormDataBodyPart largeIcon,
            @FormDataParam('bannerIcon') FormDataBodyPart bannerIcon,
            @FormDataParam('featuredBannerIcon') FormDataBodyPart featuredBannerIcon,
            @FormDataParam('screenshotSmall') List<FormDataBodyPart> screenshotsSmall,
            @FormDataParam('screenshotLarge') List<FormDataBodyPart> screenshotsLarge) {

        ObjectUriBuilder<Image> imageUriBuilder =
            imageUriBuilderFactory.getBuilder(new ApplicationRootUriBuilderHolder(uriInfo))

        //create an image from the form data and get a URL to reference it
        def createImageAndGetUrl = { FormDataBodyPart formData ->
            Image image = imageRestService.create(
                    formData.getValueAs((byte[]).class), formData.MediaType)

            return imageUriBuilder.getUri(image).toString()
        }

        if (imageSmall)  listing.smallIcon  = smallIcon
        if (imageMedium) listing.largeIcon = largeIcon
        if (imageLarge)  listing.bannerIcon  = bannerIcon
        if (imageXlarge) listing.featuredBannerIcon = featuredBannerIcon

        if (screenshotsSmall && screenshotsLarge) {
            listing.screenshots = [screenshotsSmall, screenshotsLarge].transpose().collect {
                new ScreenshotInputRepresentation(
                    smallImage: it[0],
                    largeImage: it[1]
                )
            }
        }

        return create(listing)
    }


    @Path('/activity')
    @Produces([
        ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    public PagedCollection<ListingActivity> getActivitiesForListings(
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, listingActivityRestService.getAll(offset, max))
    }

    @Path('/{listingId}/activity')
    @Produces([
        ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    public PagingChildObjectCollection<Listing, ListingActivity> getListingActivitiesForListing(
            @PathParam('listingId') long listingId,
            @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagingChildObjectCollection(
            listingActivityRestService.getByParentId(listingId, offset, max),
            read(listingId),
            offset,
            max
        );
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
    @Produces([
        ListingRepresentation.COLLECTION_MEDIA_TYPE,
        ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    public SearchResult<Listing> search(@Context UriInfo uriInfo) {
        listingSearchService.searchListings(SearchCriteria.fromQueryParams(uriInfo.getQueryParameters(true)))
    }
}
