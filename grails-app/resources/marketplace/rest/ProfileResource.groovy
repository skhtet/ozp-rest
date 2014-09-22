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
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

import org.springframework.beans.factory.annotation.Autowired

import static org.grails.jaxrs.response.Responses.*

import marketplace.Profile
import marketplace.ServiceItem
import marketplace.Tag
import marketplace.ServiceItemActivity
import marketplace.ApplicationLibraryEntry

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.PagedCollection

@Path('/api/profile')
@Produces([ProfileRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
@Consumes([ProfileInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ProfileResource extends RepresentationResource<Profile> {

    @Autowired ServiceItemRestService serviceItemRestService
    @Autowired ItemCommentRestService ItemCommentRestService
    @Autowired ServiceItemTagRestService serviceItemTagRestService
    @Autowired ServiceItemActivityRestService serviceItemActivityRestService
    @Autowired ApplicationLibraryEntryRestService applicationLibraryEntryRestService

    @Autowired
    ProfileResource(ProfileRestService profileRestService) {
        super(profileRestService)
    }

    ProfileResource() {}

    @Override
    @GET
    @Produces([ProfileRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    PagedCollection<Profile> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        super.readAll(offset, max)
    }

    @Path('/self')
    @GET
    Profile getOwnProfile() {
        read(service.currentUserProfile.id)
    }

    @Path('/{profileId}/serviceItem')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    Set<ServiceItem> getServiceItemsByAuthorId(@PathParam('profileId') long profileId) {
        serviceItemRestService.getAllByAuthorId(profileId)
    }

    @Path('/self/serviceItem')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    Set<ServiceItem> getOwnServiceItems() {
        getServiceItemsByAuthorId(service.currentUserProfile.id)
    }

    @Path('/{profileId}/itemComment')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ItemCommentServiceItemDto> getItemCommentsByAuthorId(
            @PathParam('profileId') long profileId) {
        itemCommentRestService.getAllByAuthorId(profileId).collect {
            new ItemCommentServiceItemDto(it)
        }
    }

    @Path('/self/itemComment')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ItemCommentServiceItemDto> getOwnItemComments() {
        getItemCommentsByAuthorId(service.currentUserProfile.id)
    }

    @Path('/self/tag')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    Collection<ProfileServiceItemTagDto> getOwnTags() {
        getTagsByProfileId(service.currentUserProfile.id)
    }

    @Path('/{profileId}/activity')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ServiceItemActivity> getServiceItemActivitiesByProfileId(
            @PathParam('profileId') long profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getAllByProfileId(profileId, offset, max)
    }

    @Path('/self/activity')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ServiceItemActivity> getOwnServiceItemActivities(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        getServiceItemActivitiesByProfileId(service.currentUserProfile.id, offset, max)
    }

    @Path('/{profileId}/serviceItem/activity')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ServiceItemActivity> getServiceItemActivitiesByServiceItemOwnerId(
            @PathParam('profileId') long profileId, @QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        serviceItemActivityRestService.getAllByServiceItemOwnerId(profileId, offset, max)
    }

    @Path('/self/serviceItem/activity')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ServiceItemActivity> getServiceItemActivitiesOnOwnServiceItems(
            @QueryParam('offset') Integer offset, @QueryParam('max') Integer max) {
         getServiceItemActivitiesByServiceItemOwnerId(service.currentUserProfile.id, offset, max)
    }

    @Path('/{profileId}/library')
    @GET
    @Produces([
        ApplicationLibraryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE
    ])
    ApplicationLibrary getApplicationLibrary(@PathParam('profileId') long profileId) {
        new ApplicationLibrary(profileId,
            applicationLibraryEntryRestService.getByParentId(profileId))
    }

    /**
     * Remove after the demo and add application/json to the Produces annotation of
     * getApplicationLibrary
     */
    @Path('/{profileId}/library')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Deprecated
    List<ApplicationLibraryEntry> getNonHalApplicationLibrary(
            @PathParam('profileId') long profileId) {
        applicationLibraryEntryRestService.getByParentId(profileId)
    }

    @Path('/self/library')
    @GET
    @Produces([
        ApplicationLibraryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE
    ])
    ApplicationLibrary getOwnApplicationLibrary() {
        getApplicationLibrary(service.currentUserProfile.id)
    }

    /** Remove after demo */
    @Path('/self/library')
    @GET
    @Produces([MediaType.APPLICATION_JSON])
    @Deprecated
    List<ApplicationLibraryEntry> getOwnNonHalApplicationLibrary() {
        getNonHalApplicationLibrary(service.currentUserProfile.id)
    }

    @Path('/{profileId}/library')
    @POST
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response addToApplicationLibrary(@PathParam('profileId') long profileId,
            ApplicationLibraryEntryInputRepresentation representation) {
        created applicationLibraryEntryRestService.createFromParentIdAndRepresentation(profileId,
            representation)
    }

    @Path('/self/library')
    @POST
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
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
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    ApplicationLibrary replaceApplicationLibrary(
            @PathParam('profileId') long profileId,
            List<ApplicationLibraryEntryInputRepresentation> library) {
        new ApplicationLibrary(profileId,
            applicationLibraryEntryRestService.replaceAllByParentIdAndRepresentation(profileId,
                library))
    }

    /** remove after the demo */
    @Path('/{profileId}/library')
    @PUT
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Deprecated
    List<ApplicationLibraryEntry> replaceNonHalApplicationLibrary(
            @PathParam('profileId') long profileId,
            List<ApplicationLibraryEntryInputRepresentation> library) {
        applicationLibraryEntryRestService.replaceAllByParentIdAndRepresentation(profileId,
            library)
    }

    @Path('/self/library')
    @PUT
    @Produces([
        ApplicationLibraryEntryRepresentation.MEDIA_TYPE,
        AbstractHalRepresentation.HAL_MEDIA_TYPE
    ])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    ApplicationLibrary replaceOwnApplicationLibrary(
            List<ApplicationLibraryEntryInputRepresentation> library) {
        replaceApplicationLibrary(service.currentUserProfile.id, library)
    }

    /** remove after demo */
    @Path('/self/library')
    @PUT
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([
        ApplicationLibraryEntryInputRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Deprecated
    List<ApplicationLibraryEntry> replaceNonHalOwnApplicationLibrary(
            List<ApplicationLibraryEntryInputRepresentation> library) {
        replaceNonHalApplicationLibrary(service.currentUserProfile.id, library)
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
