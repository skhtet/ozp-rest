package marketplace.rest.service

import marketplace.Intent

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import marketplace.rest.representation.in.InputRepresentation

@Service
class IntentRestService extends RestService<Intent> {
    @Autowired
    IntentRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Intent.class, null, null)
    }

    IntentRestService() {}


    @Transactional(readOnly=true)
    public static Collection<Intent> getAllByMediaType(String type, Integer max, Integer offset) {
        Intent.createCriteria().list(offset: offset, max: max) {
            eq('type', type)
        }
    }

    @Transactional
    public Intent updateById(Object id, InputRepresentation<Intent> rep) {
        super.updateById(id, rep)
    }
}
