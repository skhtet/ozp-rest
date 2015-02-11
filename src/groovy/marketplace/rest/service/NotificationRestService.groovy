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
    public List<Notification> getAllByExpired(Boolean expired, Integer offset, Integer max) {
        def now = new Date()

        Notification.createCriteria().list(offset: offset, max: max, sort: "expiresDate", order: "desc") {
            if (expired) {
                lt("expiresDate", now)
            }
            else {
                gt("expiresDate", now)
            }
        }
    }
}
