package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Type

@Service
class TypeRestService extends AdminRestService<Type> {
    @Autowired
    public TypeRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Type.class, null, null)
    }

    TypeRestService() {}
}
