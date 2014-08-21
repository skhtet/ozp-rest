package marketplace.rest

import grails.converters.JSON
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

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

import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo

@Path('/api/profile')
class ProfileResource extends DomainResource<Profile> {
    @Context
    UriInfo uriInfo

    @Autowired ServiceItemRestService serviceItemRestService
    @Autowired ItemCommentRestService ItemCommentRestService
    @Autowired ServiceItemTagRestService serviceItemTagRestService
    @Autowired ServiceItemActivityRestService serviceItemActivityRestService

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
    String getCurrentUserDataItem(@PathParam('key') String  key) {
        String userData = serviceItemTagRestService.getCurrentUserDataItem(key)
        if (uriInfo != null) {
            println("absolute url: " + uriInfo.absolutePath)
        }

        return userData
    }

    @Path('/self/userData')
    @POST
    void postCurrentUserDataItem(String keyValueJson) {
        def keyValue = new KeyValue(JSON.parse(keyValueJson))
        serviceItemTagRestService.updateCurrentUserDataByKey(keyValue.key, keyValue.value)
    }

    @Path('/self/userData')
    @PUT
    void putCurrentUserDataItem(String keyValueJson) {
        def keyValue = new KeyValue(JSON.parse(keyValueJson))
        serviceItemTagRestService.updateCurrentUserDataByKey(keyValue.key, keyValue.value)
    }

    @Path('/self/userData/{keyValue}')
    @DELETE
    void deleteCurrentUserDataItem(@PathParam('key') String  key) {
        serviceItemTagRestService.deleteCurrentUserDataByKey(key)
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
}