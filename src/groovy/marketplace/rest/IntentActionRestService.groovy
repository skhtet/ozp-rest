package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.IntentAction

@Service
class IntentActionRestService extends AdminRestService<IntentAction> {
    @Autowired
    public IntentActionRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, IntentAction.class, null, null)
    }

    IntentActionRestService() {}
}
