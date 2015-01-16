package marketplace.rest.representation.out

import java.text.DateFormat
import java.text.SimpleDateFormat

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Notification

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory
import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.NotificationUriBuilder

class NotificationRepresentation extends SelfRefRepresentation<Notification> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-notification-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-notifications-v1+json'

    private Notification notification

    private NotificationRepresentation(Notification notification,
                                   ObjectUriBuilder<Notification> notificationUriBuilder) {
        super(notificationUriBuilder.getUri(notification), null, null)

        this.notification = notification
    }

    public String getMessage() { notification.message }
    public Long getId() { notification.id }
    public Date getExpiresDate() {
        notification.expiresDate
    }
    public Date getCreatedDate() {
        notification.createdDate
    }

    @Component
    public static class Factory implements RepresentationFactory<Notification> {
        @Autowired NotificationUriBuilder.Factory uriBuilderFactory

        NotificationRepresentation toRepresentation(Notification notification,
                                                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new NotificationRepresentation(notification,
                    uriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
