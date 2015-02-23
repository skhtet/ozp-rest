package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.Notification

import marketplace.rest.resource.NotificationResource

class ExpiredNotificationUriBuilder<Notification> implements ObjectUriBuilder<Notification>, CollectionUriBuilder<Notification> {

    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private ExpiredNotificationUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getUri(Notification obj) {
        uriBuilderHolder.builder
            .path(NotificationResource.class)
            .path(NotificationResource.class, 'read')
            .buildFromMap(id: obj.id)
    }

    URI getCollectionUri () {
        uriBuilderHolder.builder
            .path(NotificationResource.class)
            .path(NotificationResource.class, 'readAllExpired')
            .build()
    }

    @Component
    public static class Factory implements ObjectUriBuilder.Factory<marketplace.Notification>, CollectionUriBuilder.Factory<Notification> {
        ExpiredNotificationUriBuilder<Notification> getBuilder (ApplicationRootUriBuilderHolder uriBuilderHolder) {
            return new ExpiredNotificationUriBuilder(uriBuilderHolder)
        }
    }
}
