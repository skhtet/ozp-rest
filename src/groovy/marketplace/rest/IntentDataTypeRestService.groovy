package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.IntentDataType

@Service
class IntentDataTypeRestService extends AdminRestService<IntentDataType> {
    @Autowired
    public IntentDataTypeRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, IntentDataType.class, null, null)
    }

    IntentDataTypeRestService() {}
}
