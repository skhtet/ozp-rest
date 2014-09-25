package marketplace.rest.service

import marketplace.Scorecard

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import marketplace.rest.representation.in.InputRepresentation

@Service
class ScorecardRestService extends RestService<Scorecard> {
    @Autowired
    ScorecardRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Scorecard.class, null, null)
    }

    ScorecardRestService() {}


    // @Transactional(readOnly=true)
    // public static Collection<Intent> getAllByMediaType(String type, Integer max, Integer offset) {
    //     Intent.createCriteria().list(offset: offset, max: max) {
    //         eq('type', type)
    //     }
    // }

    @Transactional
    public Scorecard updateById(Object id, InputRepresentation<Scorecard> rep) {
        super.updateById(id, rep)
    }
}
