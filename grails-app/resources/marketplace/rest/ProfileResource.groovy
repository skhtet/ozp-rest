package marketplace.rest

import grails.converters.JSON
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.ServiceItem
import marketplace.Tag
import marketplace.ServiceItemActivity
import marketplace.ApplicationLibraryEntry

import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

@Path('/api/profile')
class ProfileResource extends DomainResource<Profile> {
    @Context
    UriInfo uriInfo

    @Autowired ServiceItemRestService serviceItemRestService
    @Autowired ItemCommentRestService ItemCommentRestService
    @Autowired ServiceItemTagRestService serviceItemTagRestService
    @Autowired ServiceItemActivityRestService serviceItemActivityRestService
    @Autowired ApplicationLibraryEntryRestService applicationLibraryEntryRestService

    @Autowired
    ProfileResource(ProfileRestService profileRestService) {
        super(Profile.class, profileRestService)
    }

    ProfileResource() {}

    @Path('/self')
    @GET
    Profile getOwnProfile() {
        read(service.currentUserProfile.id)
    }

    @Path('/{profileId}/serviceItem')
    @GET
    Set<ServiceItem> getServiceItemsByAuthorId(@PathParam('profileId') long profileId) {
        serviceItemRestService.getAllByAuthorId(profileId)
    }

    @Path('/self/serviceItem')
    @GET
    Set<ServiceItem> getOwnServiceItems() {
        getServiceItemsByAuthorId(service.currentUserProfile.id)
    }

    @Path('/{profileId}/itemComment')
    @GET
    List<ItemCommentServiceItemDto> getItemCommentsByAuthorId(
            @PathParam('profileId') long profileId) {
        itemCommentRestService.getAllByAuthorId(profileId).collect {
            new ItemCommentServiceItemDto(it)
        }
    }

    @Path('/self/itemComment')
    @GET
    List<ItemCommentServiceItemDto> getOwnItemComments() {
        getItemCommentsByAuthorId(service.currentUserProfile.id)
    }

    @Path('/self/tag')
    @GET
    Collection<ProfileServiceItemTagDto> getOwnTags() {
        getTagsByProfileId(service.currentUserProfile.id)
    }

    @Path('/self/userData/{key}')
    @GET
    Response getCurrentUserDataItem(@PathParam('key') String  key) {
        String userData = serviceItemTagRestService.getCurrentUserDataItem(key)
        String content
        Response response

        if (userData != null) {

            if (uriInfo != null) {
                String hal

                hal = "{";
                hal = hal + "'_links'':";
                hal = hal + "{'self':{'href':'${uriInfo.absolutePath}'}";
                hal = hal + ",'content':'${userData}'}"
                hal = hal + "}";

                content = hal
            } else {
                content = userData
            }

            response = Response.ok(content, MediaType.APPLICATION_JSON).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).entity(
                ("Value not found for key='${key}'").toString()).build();
        }

        return response
    }

    @Path('/self/userData')
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response postCurrentUserDataItem(String keyValueJson) {
        def keyValue = new KeyValue(JSON.parse(keyValueJson))

        serviceItemTagRestService.updateCurrentUserDataByKey(keyValue.key, keyValue.value)

        return Response.status(Response.Status.OK).build()
    }

    @Path('/self/userData')
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response putCurrentUserDataItem(String keyValueJson) {
        def keyValue = new KeyValue(JSON.parse(keyValueJson))

        serviceItemTagRestService.updateCurrentUserDataByKey(keyValue.key, keyValue.value)

        return Response.status(Response.Status.OK).build()
    }

    @Path('/self/userData/{key}')
    @DELETE
    Response deleteCurrentUserDataItem(@PathParam('key') String key) {
        serviceItemTagRestService.deleteCurrentUserDataByKey(key)

        return Response.status(Response.Status.OK).build()
    }

    @Path('/{profileId}/activity')
    @GET
    List<ServiceItemActivity> getServiceItemActivitiesByProfileId(
            @PathParam('profileId') long profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getAllByProfileId(profileId, offset, max)
    }

    @Path('/self/activity')
    @GET
    List<ServiceItemActivity> getOwnServiceItemActivities(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        getServiceItemActivitiesByProfileId(service.currentUserProfile.id, offset, max)
    }

    @Path('/{profileId}/serviceItem/activity')
    @GET
    List<ServiceItemActivity> getServiceItemActivitiesByServiceItemOwnerId(
            @PathParam('profileId') long profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getAllByServiceItemOwnerId(profileId, offset, max)
    }

    @Path('/self/serviceItem/activity')
    @GET
    List<ServiceItemActivity> getServiceItemActivitiesOnOwnServiceItems(
            @QueryParam('offset') Integer offset, @QueryParam('max') Integer max) {
         getServiceItemActivitiesByServiceItemOwnerId(service.currentUserProfile.id, offset, max)
    }

    @Path('/{profileId}/library')
    @GET
    List<ApplicationLibraryEntry> getApplicationLibrary(@PathParam('profileId') long profileId) {
        applicationLibraryEntryRestService.getByParentId(profileId)
    }

    @Path('/self/library')
    @GET
    List<ApplicationLibraryEntry> getOwnApplicationLibrary() {
        getApplicationLibrary(service.currentUserProfile.id)
    }

    @Path('/{profileId}/library')
    @POST
    ApplicationLibraryEntry addToApplicationLibrary(@PathParam('profileId') long profileId,
            ApplicationLibraryEntry applicationLibraryEntry) {
        applicationLibraryEntryRestService.createFromParentIdAndDto(profileId,
            applicationLibraryEntry)
    }

    @Path('/self/library')
    @POST
    ApplicationLibraryEntry addToOwnApplicationLibrary(
            ApplicationLibraryEntry applicationLibraryEntry) {
        addToApplicationLibrary(service.currentUserProfile.id,
            applicationLibraryEntry)
    }

    /**
     * For the application library, PUT replaces the whole library, POST adds a single new entry.
     */
    @Path('/{profileId}/library')
    @PUT
    List<ApplicationLibraryEntry> replaceApplicationLibrary(
            @PathParam('profileId') long profileId,
            List<ApplicationLibraryEntry> library) {
        applicationLibraryEntryRestService.replaceAllByParentIdAndDto(profileId, library)
    }

    @Path('/self/library')
    @PUT
    List<ApplicationLibraryEntry> replaceOwnApplicationLibrary(
            List<ApplicationLibraryEntry> library) {
        replaceApplicationLibrary(service.currentUserProfile.id, library)
    }

    @Path('/{profileId}/library/{serviceItemId}')
    @DELETE
    void removeFromApplicationLibrary(@PathParam('profileId') long profileId,
            @PathParam('serviceItemId') long applicationLibraryEntryId) {
        applicationLibraryEntryRestService.deleteByParentIdAndServiceItemId(profileId,
            applicationLibraryEntryId)
    }

    @Path('/self/library/{serviceItemId}')
    @DELETE
    void removeFromOwnApplicationLibrary(
            @PathParam('serviceItemId') long applicationLibraryEntryId) {
        removeFromApplicationLibrary(service.currentUserProfile.id,
            applicationLibraryEntryId)
    }
}
