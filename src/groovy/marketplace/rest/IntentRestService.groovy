package marketplace.rest

import marketplace.Intent
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IntentRestService extends RestService<Intent> {
    @Autowired
    IntentRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Intent.class, null, null)
    }

    IntentRestService() {}

    public Collection<Intent> getByMainType(String mainType) {
        Intent.findAllByMainType(mainType)
    }

    public Collection<Intent> getByDataType(String mainType, String subType) {
        Intent.findAllByMainTypeAndSubType(mainType, subType)
    }
}
