package marketplace.rest

import marketplace.Intent

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IntentRestService extends RestService<Intent> {
    @Autowired
    IntentRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Intent.class, null, null)
    }

    IntentRestService() {}

    @Transactional(readOnly=true)
    public static Collection<Intent> getAllByMainType(String mainType, Integer offset, Integer max) {
        Intent.createCriteria().list(offset: offset, max: max) {
            eq('mainType', mainType)
        }
    }

    @Transactional(readOnly=true)
    public static Collection<Intent> getAllByMediaType(String mainType, String subType, Integer max, Integer offset) {
        Intent.createCriteria().list(offset: offset, max: max) {
            eq('mainType', mainType)
            eq('subType', subType)
        }
    }

    public Intent updateById(Object id, InputRepresentation<Intent> rep) {
        throw new UnsupportedOperationException('Updating an existing Intent is not allowed, they can only be created/deleted')
    }

    public Intent updateById(Object id, Intent dto) {
        throw new UnsupportedOperationException('Updating an existing Intent is not allowed, they can only be created/deleted')
    }
}
