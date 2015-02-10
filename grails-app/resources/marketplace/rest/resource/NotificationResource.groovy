package marketplace.rest.resource

import marketplace.rest.service.ProfileRestService

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.DELETE
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.DefaultValue
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Notification

import marketplace.hal.PagedCollection

import marketplace.rest.service.NotificationRestService

import marketplace.rest.representation.out.NotificationRepresentation
import marketplace.rest.representation.in.NotificationInputRepresentation

@Path('api/notification')
@Produces([
        NotificationRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
])
@Consumes([
        NotificationInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
])
class NotificationResource extends RepresentationResource<Notification, NotificationInputRepresentation> {
    @Autowired ProfileRestService profileRestService
    @Autowired
    public NotificationResource(NotificationRestService notificationRestService) {
        super(notificationRestService)
    }

    NotificationResource() {}

    @Produces([
            NotificationRepresentation.COLLECTION_MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Notification> readAll(@QueryParam('offset') Integer offset,
                                      @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }

    @Path('/expired')
    @Produces([
            NotificationRepresentation.COLLECTION_MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Notification> readAllExpired(@DefaultValue("0") @QueryParam('offset') Integer offset,
                                                 @DefaultValue("10000") @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAllByExpired(true, offset, max))
    }

    @Path('/pending')
    @Produces([
            NotificationRepresentation.COLLECTION_MEDIA_TYPE,
            MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Notification> readAllPending(@DefaultValue("0") @QueryParam('offset') Integer offset,
                                                 @DefaultValue("10000") @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAllByExpired(false, offset, max))
    }


    @Path('/{id}')
    @DELETE
    @Consumes()
    @Produces()
    void delete(@PathParam('id') long id) {
        profileRestService.clearNotificationFromDismissed(id)
        service.deleteById(id)
    }
}
