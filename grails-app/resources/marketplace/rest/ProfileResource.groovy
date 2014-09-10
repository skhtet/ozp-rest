package marketplace.rest

import grails.converters.JSON
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.Response.Status

import org.springframework.beans.factory.annotation.Autowired

import static org.grails.jaxrs.response.Responses.*

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

    @Path('/self/userData/{key:.+}')
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    Response getCurrentUserDataItem(@PathParam('key') String key) {
        String value = service.getCurrentUserDataItem(key)

        value != null ? userDataFound(value) : userDataNotFound()
    }

    @Path('/self/userData/{key:.+}')
    @PUT
    @Consumes(MediaType.WILDCARD)
    Response putCurrentUserDataItem(@PathParam('key') String  key, String value) {
        String putValue = service.updateCurrentUserDataByKey(key, value)

        putValue != null ? userDataFound() : userDataCreated(key)
    }

    @Path('/self/userData/{key:.+}')
    @DELETE
    @Consumes(MediaType.WILDCARD)
    Response deleteCurrentUserDataItem(@PathParam('key') String key) {
        String value = service.deleteCurrentUserDataByKey(key)

        value != null ? userDataFound() : userDataNotFound()
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
    Response addToApplicationLibrary(@PathParam('profileId') long profileId,
            ApplicationLibraryEntryInputRepresentation representation) {
        created applicationLibraryEntryRestService.createFromParentIdAndRepresentation(profileId,
            representation)
    }

    @Path('/self/library')
    @POST
    Response addToOwnApplicationLibrary(
            ApplicationLibraryEntryInputRepresentation representation) {
        addToApplicationLibrary(service.currentUserProfile.id,
            representation)
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

    /**
     *  The following helper methods exist because at the moment we don't have
     *  generic handling for text/plain
     */

    //By default returns 204, indicating success without an entity. If value is
    //provided, returns 200 with the value as the entity
    private Response userDataFound(String value = null) {
        value ? Response.ok().entity(value).build() : Response.noContent().build()
    }

    private Response userDataNotFound() {
        Response.status(Status.NOT_FOUND).entity('Resource Does Not Exist').build()
    }

    private Response userDataCreated(String key) {
        URI uri = UriBuilder.fromPath(key).build()
        Response.created(uri).build()
    }
}
