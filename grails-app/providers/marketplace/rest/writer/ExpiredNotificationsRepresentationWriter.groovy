package marketplace.rest.writer

import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.ExpiredNotificationCollection
import marketplace.rest.resource.uribuilder.ExpiredNotificationUriBuilder
import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import marketplace.rest.representation.out.NotificationRepresentation

@Provider
@Produces([
        NotificationRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
])
class ExpiredNotificationsRepresentationWriter extends AbstractRepresentationWriter<ExpiredNotificationCollection> {

    @Autowired
    ExpiredNotificationsRepresentationWriter(GrailsApplication grailsApplication,
                                   NotificationRepresentation.Factory factory,
                                   ExpiredNotificationUriBuilder.Factory expiredNotificationUriBuilderFactory) {
        super(grailsApplication, EmbeddedCollectionRepresentation.createFactory(factory, expiredNotificationUriBuilderFactory))
    }
}

