package marketplace.rest.representation.in

import marketplace.Notification

class NotificationInputRepresentation extends AbstractInputRepresentation<Notification> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-notification-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-notifications-v1+json'

    NotificationInputRepresentation() {
        super(Notification.class)
    }

    Date expiresDate
    String message
}
