package marketplace.rest.resource

import marketplace.IwcDataObject
import marketplace.Notification
import marketplace.rest.IwcUserApplications
import marketplace.rest.IwcUserData
import marketplace.rest.IwcUserIntents
import marketplace.rest.representation.in.NotificationInputRepresentation
import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.representation.out.IwcDataObjectRepresentation
import marketplace.rest.representation.out.NotificationRepresentation

import javax.ws.rs.Consumes
import javax.ws.rs.HeaderParam
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.core.UriBuilder

import static org.grails.jaxrs.response.Responses.*

import marketplace.Profile
import marketplace.Agency
import marketplace.Listing
import marketplace.ItemComment
import marketplace.ListingActivity
import marketplace.ApplicationLibraryEntry
import marketplace.Role

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.PagedCollection

import marketplace.rest.service.ListingRestService
import marketplace.rest.service.ItemCommentRestService
import marketplace.rest.service.ListingActivityRestService
import marketplace.rest.service.ApplicationLibraryEntryRestService
import marketplace.rest.service.ProfileRestService

import marketplace.rest.representation.in.IdRefInputRepresentation
import marketplace.rest.representation.in.AgencyIdRef
import marketplace.rest.representation.in.AgencyInputRepresentation
import marketplace.rest.representation.in.ApplicationLibraryEntryInputRepresentation
import marketplace.rest.representation.in.ProfileInputRepresentation
import marketplace.rest.representation.out.AgencyRepresentation
import marketplace.rest.representation.out.ApplicationLibraryEntryRepresentation
import marketplace.rest.representation.out.ApplicationLibraryRepresentation
import marketplace.rest.representation.out.ProfileRepresentation
import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.representation.out.ItemCommentListingRepresentation
import marketplace.rest.representation.out.SimpleApplicationLibraryEntryRepresentation
import marketplace.rest.representation.out.SimpleApplicationLibraryRepresentation
import marketplace.rest.ChildObjectCollection
import marketplace.rest.PagingChildObjectCollection
import marketplace.rest.ProfileOwnedListingActivities

@Path('/api/profile')
@Produces([ProfileRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
@Consumes([ProfileInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ProfileResource extends RepresentationResource<Profile, ProfileInputRepresentation> {

    @Autowired ListingRestService listingRestService
    @Autowired ItemCommentRestService ItemCommentRestService
    @Autowired ListingActivityRestService listingActivityRestService
    @Autowired ApplicationLibraryEntryRestService applicationLibraryEntryRestService

    @Autowired
    ProfileResource(ProfileRestService profileRestService) {
        super(profileRestService)
    }

    ProfileResource() {}

    private long getProfileId(String uriId) {
        uriId == 'self' ? service.currentUserProfile.id : uriId as long
    }

    //NOTE: This method does not get called as it no longer has @GET etc.
    //readAllByRole has replaced it
    @Override
    PagedCollection<Profile> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        super.readAll(offset, max)
    }

    @GET
    @Produces([ProfileRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    PagedCollection<Profile> readAllByRole(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max, @QueryParam('role') Role role) {
        new PagedCollection(offset, max, service.getAll(offset, max, role))
    }

    @Path('/self')
    @GET
    Profile getOwnProfile() {
        read(service.currentUserProfile.id)
    }

    @Path('/{profileId}/listing')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    ChildObjectCollection<Profile, Listing> getListingsByAuthorId(
            @PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)
        new ChildObjectCollection(listingRestService.getAllByAuthorId(id), read(id))
    }

    @Path('/{profileId}/itemComment')
    @GET
    @Produces([
        MediaType.APPLICATION_JSON,
        ItemCommentListingRepresentation.COLLECTION_MEDIA_TYPE
    ])
    @Consumes([MediaType.APPLICATION_JSON])
    ChildObjectCollection<Profile, ItemComment> getItemCommentsByAuthorId(
            @PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)
        new ChildObjectCollection(itemCommentRestService.getAllByAuthorId(id), read(id))
    }

    @Path('/{profileId}/activity')
    @GET
    @Produces([
        ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    PagingChildObjectCollection<Profile, ListingActivity> getListingActivitiesByProfileId(
            @PathParam('profileId') String profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        long id = getProfileId(profileId)

        new PagingChildObjectCollection(
            listingActivityRestService.getAllByProfileId(id, offset, max),
            read(id),
            offset,
            max
        )
    }

    @Path('/{profileId}/listing/activity')
    @GET
    @Produces([
        ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    ProfileOwnedListingActivities getListingActivitiesByListingOwnerId(
            @PathParam('profileId') String profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        long id = getProfileId(profileId)

        new ProfileOwnedListingActivities(
            listingActivityRestService.getAllByListingOwnerId(id, offset, max),
            read(id),
            offset,
            max
        )
    }

    @GET
    @Path('/{profileId}/application')
    @Produces([
            ApplicationRepresentation.COLLECTION_MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    IwcUserApplications readApplicationsForCurrentUser(@PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)

        new IwcUserApplications(applicationLibraryEntryRestService.getByParentId(id).collect {
            it.listing
        }, service.getById(id))
    }

    @GET
    @Path('/{profileId}/intent')
    @Produces([
        IntentRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcUserIntents readIntentsForApplicationsOfCurrentUser(@PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)

        new IwcUserIntents(applicationLibraryEntryRestService.getByParentId(id).collect {
            it.listing.intents
        }.flatten().unique(), service.getById(id))
    }

    @GET
    @Path('/{profileId}/data')
    @Produces([
        IwcDataObjectRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcUserData readAllData(@PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)

        new IwcUserData(service.getUserData(id), service.getById(id))
    }

    @Path('/{profileId}/data/{key:.+}')
    @GET
    @Produces([
        IwcDataObjectRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcDataObject readDataItem(@PathParam('profileId') String profileId,
                               @PathParam('key') String key) {
        long id = getProfileId(profileId)

        service.getDataItem(id, keyFromPath(key))
    }

    @Path('/{profileId}/data/{key:.+}')
    @PUT
    @Consumes(MediaType.WILDCARD)
    @Produces([])
    Response updateDataItem(@PathParam('profileId') String profileId,
                            @PathParam('key') String  key, String value,
                            @HeaderParam(HttpHeaders.CONTENT_TYPE) String contentType) {
        long id = getProfileId(profileId)

        service.updateDataItem(id, keyFromPath(key), value, typeFromHeader(contentType))

        Response.noContent().build()
    }

    @Path('/{profileId}/data/{key:.+}')
    @DELETE
    @Produces([])
    Response deleteDataItem(@PathParam('profileId') String profileId,
                            @PathParam('key') String key) {
        long id = getProfileId(profileId)
        service.deleteDataItem(id, keyFromPath(key))
        Response.noContent().build()
    }

    private static String keyFromPath(String key) {
        key.endsWith('/') ? key[0..-2] : key
    }

    private static String typeFromHeader(String contentType) {
        MediaType mt = MediaType.valueOf(contentType)
        mt.type + '/' + mt.subtype
    }

    @Path('/{profileId}/library')
    @GET
    @Produces([
        ApplicationLibraryRepresentation.MEDIA_TYPE,
        SimpleApplicationLibraryRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    ChildObjectCollection<Profile, ApplicationLibraryEntry> getApplicationLibrary(
            @PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)

        new ChildObjectCollection(applicationLibraryEntryRestService.getByParentId(id),
            read(id))
    }

    @Path('/{profileId}/library')
    @POST
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        SimpleApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response addToApplicationLibrary(@PathParam('profileId') String profileId,
            ApplicationLibraryEntryInputRepresentation representation) {
        created applicationLibraryEntryRestService.createFromParentIdAndRepresentation(
            getProfileId(profileId), representation)
    }

    /**
     * For the application library, PUT replaces the whole library, POST adds a single new entry.
     */
    @Path('/{profileId}/library')
    @PUT
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        SimpleApplicationLibraryRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    ChildObjectCollection<Profile, ApplicationLibraryEntry> replaceApplicationLibrary(
            @PathParam('profileId') String profileId,
            List<ApplicationLibraryEntryInputRepresentation> library) {
        long id = getProfileId(profileId)

        new ChildObjectCollection(
            applicationLibraryEntryRestService.replaceAllByParentIdAndRepresentation(id, library),
            read(id))
    }

    @Path('/{profileId}/library/{listingId}')
    @Consumes()
    @DELETE
    void removeFromApplicationLibrary(@PathParam('profileId') String profileId,
            @PathParam('listingId') long applicationLibraryEntryId) {
        applicationLibraryEntryRestService.deleteByParentIdAndServiceItemId(getProfileId(profileId),
            applicationLibraryEntryId)
    }

    /**
     * Return all unread notifications for this user
     */
    @GET
    @Path('/{profileId}/notification')
    @Produces([
            NotificationRepresentation.COLLECTION_MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    ChildObjectCollection<Profile, Notification> getNotification(
            @PathParam('profileId') String profileIdStr) {
        long profileId = getProfileId(profileIdStr)
        new ChildObjectCollection(service.getUnreadNotifications(profileId), read(profileId))
    }

    /**
     * Mark a notification as read for a given user
     */
    @Path('/{profileId}/notification/{notificationId}')
    @DELETE
    @Produces([
            NotificationRepresentation.MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    void dismissNotification(@PathParam('profileId') String profileIdStr,
                                 @PathParam('notificationId') String notificationIdStr) {
        long profileId = getProfileId(profileIdStr)
        service.dismissNotification(profileId, Long.parseLong(notificationIdStr))
    }

}
