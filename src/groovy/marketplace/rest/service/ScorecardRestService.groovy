package marketplace.rest.service

import marketplace.Scorecard

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ScorecardRestService extends AdminRestService<Scorecard> {
    @Autowired
    ScorecardRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Scorecard.class, null, null)
    }

    ScorecardRestService() {}
}
