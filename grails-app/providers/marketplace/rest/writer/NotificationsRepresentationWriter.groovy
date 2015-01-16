package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Notification

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.NotificationRepresentation
import marketplace.rest.resource.uribuilder.NotificationUriBuilder

@Provider
@Produces([
        NotificationRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
])
class NotificationsRepresentationWriter extends
        AbstractRepresentationWriter<Collection<Notification>> {

    @Autowired
    NotificationsRepresentationWriter(GrailsApplication grailsApplication,
                                   NotificationRepresentation.Factory factory,
                                   NotificationUriBuilder.Factory notificationUriBuilderFactory) {
        super(grailsApplication, EmbeddedCollectionRepresentation.createFactory(factory, notificationUriBuilderFactory))
    }
}

