package marketplace.rest.service

import marketplace.Intent

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IntentRestService extends AdminRestService<Intent> {
    @Autowired
    IntentRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Intent.class, null, null)
    }

    IntentRestService() {}
}
