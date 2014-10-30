package marketplace.rest.resource

import marketplace.IwcDataObject
import marketplace.rest.IwcUserApplications
import marketplace.rest.IwcUserData
import marketplace.rest.IwcUserIntents
import marketplace.rest.representation.out.ApplicationRepresentation
import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.representation.out.IwcDataObjectRepresentation

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
import marketplace.ListingActivity
import marketplace.ApplicationLibraryEntry

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
import marketplace.rest.ChildObjectCollection
import marketplace.rest.PagingChildObjectCollection
import marketplace.rest.ProfileOwnedListingActivities
import marketplace.rest.ItemCommentServiceItemDto

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
    @Produces([MediaType.APPLICATION_JSON])
    @Consumes([MediaType.APPLICATION_JSON])
    List<ItemCommentServiceItemDto> getItemCommentsByAuthorId(
            @PathParam('profileId') String profileId) {
        itemCommentRestService.getAllByAuthorId(getProfileId(profileId)).collect {
            ItemCommentServiceItemDto itemComment = new ItemCommentServiceItemDto(it)
            itemComment.asJSON()
        }
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
        AbstractHalRepresentation.HAL_MEDIA_TYPE
    ])
    ChildObjectCollection<Profile, ApplicationLibraryEntry> getApplicationLibrary(
            @PathParam('profileId') String profileId) {
        long id = getProfileId(profileId)

        new ChildObjectCollection(applicationLibraryEntryRestService.getByParentId(id),
            read(id))
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
            @PathParam('profileId') String profileId) {
        applicationLibraryEntryRestService.getByParentId(getProfileId(profileId))
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
        AbstractHalRepresentation.HAL_MEDIA_TYPE
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
            @PathParam('profileId') String profileId,
            List<ApplicationLibraryEntryInputRepresentation> library) {
        applicationLibraryEntryRestService.replaceAllByParentIdAndRepresentation(getProfileId(profileId),
            library)
    }

    @Path('/{profileId}/library/{listingId}')
    @DELETE
    void removeFromApplicationLibrary(@PathParam('profileId') String profileId,
            @PathParam('listingId') long applicationLibraryEntryId) {
        applicationLibraryEntryRestService.deleteByParentIdAndServiceItemId(getProfileId(profileId),
            applicationLibraryEntryId)
    }

    @Path('/{profileId}/stewarded-organizations')
    @GET
    @Produces([AgencyRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    ChildObjectCollection<Profile, Agency> getStewardedOrganizations(
            @PathParam('profileId') String profileId) {
        Profile profile = service.getById(getProfileId(profileId))
        new ChildObjectCollection(profile.stewardedOrganizations, profile)
    }

    @Path('/{profileId}/stewarded-organizations')
    @PUT
    @Produces([AgencyRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes([AgencyInputRepresentation.COLLECTION_MEDIA_TYPE, MediaType.APPLICATION_JSON])
    ChildObjectCollection<Profile, Agency> setStewardedOrganizations(
            @PathParam('profileId') String profileId, Collection<AgencyIdRef> organizations) {
        long id = getProfileId(profileId)

        service.setStewardedOrganizations(id, organizations)
        Profile profile = service.getById(id)
        new ChildObjectCollection(profile.stewardedOrganizations, profile)
    }

    @Path('/{profileId}/stewarded-organizations')
    @POST
    @Produces([AgencyRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes([IdRefInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    Response addSteward(@PathParam('profileId') String profileId,
            IdRefInputRepresentation<Agency, Long> organization) {
        created service.addProfileAsSteward(getProfileId(profileId), organization.id)
    }

    @Path('/{profileId}/stewarded-organizations/{organizationId}')
    @DELETE
    @Produces([AgencyRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    @Consumes([IdRefInputRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
    void removeSteward(@PathParam('profileId') String profileId,
            @PathParam('organizationId') long organizationId) {
        service.removeProfileAsSteward(getProfileId(profileId), organizationId)
    }
}
