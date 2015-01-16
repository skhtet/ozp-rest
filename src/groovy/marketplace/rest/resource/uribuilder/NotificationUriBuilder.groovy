package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.NotificationResource
import marketplace.Notification

class NotificationUriBuilder extends RepresentationResourceUriBuilder<Notification> {
    protected NotificationUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(NotificationResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements
            ObjectUriBuilder.Factory<Notification>, CollectionUriBuilder.Factory<Notification> {
        NotificationUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new NotificationUriBuilder(uriBuilderHolder)
        }
    }
}
