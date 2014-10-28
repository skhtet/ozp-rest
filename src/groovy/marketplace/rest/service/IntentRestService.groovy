package marketplace.rest.service

import marketplace.Intent
import marketplace.rest.representation.in.InputRepresentation
import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.security.RolesAllowed

@Service
class IntentRestService extends AdminRestService<Intent> {
    @Autowired
    IntentRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Intent.class, null, null)
    }

    IntentRestService() {}

    @Override
    @RolesAllowed('ROLE_ADMIN')
    Intent updateById(Object id, InputRepresentation rep) {
        Intent intent = getById(id)

        if(intent.action != rep.action || intent.type != rep.type) {
            throw new IllegalArgumentException('Cannot modify an intent action or type')
        } else {
            super.updateById(id, rep)
        }
    }
}
