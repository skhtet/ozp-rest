package marketplace.rest

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

@Path('/api/profile')
class ProfileResource extends DomainResource<Profile> {
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

    @Path('/{profileId}/tag')
    @GET
    Collection<ProfileServiceItemTagDto> getTagsByProfileId(
            @PathParam('profileId') long profileId){
        serviceItemTagRestService.getAllByProfileId(profileId).collect {
            new ProfileServiceItemTagDto(it)
        }
    }

    @Path('/self/tag')
    @GET
    Collection<ProfileServiceItemTagDto> getOwnTags() {
        getTagsByProfileId(service.currentUserProfile.id)
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

    @Path('/{profileId}/applicationLibrary')
    @GET
    List<ApplicationLibraryEntry> getApplicationLibrary(@PathParam('profileId') long profileId) {
        applicationLibraryEntryRestService.getByParentId(profileId)
    }

    @Path('/self/applicationLibrary')
    @GET
    List<ApplicationLibraryEntry> getOwnApplicationLibrary() {
        getApplicationLibrary(service.currentUserProfile.id)
    }

    @Path('/{profileId}/applicationLibrary')
    @POST
    ApplicationLibraryEntry addToApplicationLibrary(@PathParam('profileId') long profileId,
            ApplicationLibraryEntry applicationLibraryEntry) {
        applicationLibraryEntryRestService.createFromParentIdAndDto(profileId,
            applicationLibraryEntry)
    }

    @Path('/self/applicationLibrary')
    @POST
    ApplicationLibraryEntry addToOwnApplicationLibrary(
            ApplicationLibraryEntry applicationLibraryEntry) {
        addToApplicationLibrary(service.currentUserProfile.id,
            applicationLibraryEntry)
    }

    @Path('/{profileId}/applicationLibrary/{applicationLibraryEntryId}')
    @DELETE
    void removeFromApplicationLibrary(@PathParam('profileId') long profileId,
            @PathParam('applicationLibraryEntryId') long applicationLibraryEntryId) {
        applicationLibraryEntryRestService.deleteById(applicationLibraryEntryId)
    }

    @Path('/self/applicationLibrary/{applicationLibraryEntryId}')
    @DELETE
    void removeFromOwnApplicationLibrary(
            ApplicationLibraryEntry applicationLibraryEntry) {
        removeFromOwnApplicationLibrary(service.currentUserProfile.id,
            applicationLibraryEntry)
    }
}
