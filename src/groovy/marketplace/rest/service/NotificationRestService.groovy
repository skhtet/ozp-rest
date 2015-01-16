package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Notification

@Service
class NotificationRestService extends AdminRestService<Notification> {
    @Autowired
    public NotificationRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Notification.class, null, null)
    }

    NotificationRestService() {}
}
