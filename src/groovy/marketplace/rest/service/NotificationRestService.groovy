package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Notification

@Service
class NotificationRestService extends AdminRestService<Notification> {
    @Autowired
    public NotificationRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Notification.class, null, null)
    }

    //Keep CGLIB happy
    NotificationRestService() {}

    @Transactional(readOnly=true)
    public Set<Notification> getAllByExpired(Boolean expired, Integer offset, Integer max) {
        def now = new Date()
        if (expired) {
            Notification.findAll("from Notification as notification where notification.expiresDate < :now", [now: now],
                    [offset: offset, max: max])
        } else {
            Notification.findAll("from Notification as notification where notification.expiresDate > :now",
                    [now: now], [offset: offset, max: max])
        }

    }
}
