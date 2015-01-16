package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Notification

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.NotificationRepresentation

@Provider
@Produces([
        NotificationRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
])
class NotificationRepresentationWriter extends AbstractRepresentationWriter<Notification> {

    @Autowired
    NotificationRepresentationWriter(GrailsApplication grailsApplication,
                                 NotificationRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}

