package marketplace.rest.service

import marketplace.Intent
import marketplace.rest.representation.in.InputRepresentation
import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.security.RolesAllowed

import marketplace.rest.DomainObjectNotFoundException

@Service
class IntentRestService extends AdminRestService<Intent> {
    @Autowired
    ImageRestService imageRestService

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

    @Override
    protected void postprocess(Intent updated, Map original = null) {
        super.postprocess(updated, original)

        checkIconReference(updated)
    }

    private void checkIconReference(updated) {
        UUID iconId = updated.iconId

        if (iconId) {
            try {
                imageRestService.getImageReference(iconId)
            }
            catch(DomainObjectNotFoundException e) {
                throw new IllegalArgumentException("Invalid icon id: $updated.iconId", e)
            }
        }
    }
}
