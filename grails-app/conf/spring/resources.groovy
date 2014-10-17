import org.springframework.orm.hibernate3.support.OpenSessionInViewInterceptor
import com.fasterxml.jackson.databind.ObjectMapper;
import marketplace.authentication.SpringSecurityAccountService
import ozone.utils.ApplicationContextHolder
import marketplace.search.MarketplaceSearchAuditEventListener
import org.ozoneplatform.auditing.AuditLogListener
import util.CustomPropertyEditorRegistrar

// Place your Spring DSL code here
beans = {
    xmlns context: 'http://www.springframework.org/schema/context'
    context.'component-scan'('base-package': 'marketplace.validator,marketplace.rest')

    auditLogListener(AuditLogListener) {
        sessionFactory = ref('sessionFactory')
        accountService = ref('accountService')
        grailsApplication = ref('grailsApplication')
    }

    auditListener(MarketplaceSearchAuditEventListener, ref('hibernateDatastore')) {
        elasticSearchContextHolder = ref('elasticSearchContextHolder')
        indexRequestQueue = ref('indexRequestQueue')
    }

    applicationContextHolder(ApplicationContextHolder) { bean ->
        bean.factoryMethod = 'getInstance'
    }

    accountService(SpringSecurityAccountService)

    customPropertyEditorRegistrar(CustomPropertyEditorRegistrar)

    objectMapper(ObjectMapper)

    /**
     * OP-5818: Use the Spring class instead of the default Grails subclass of it.
     */
    openSessionInViewInterceptor(OpenSessionInViewInterceptor) {
        sessionFactory = ref('sessionFactory')
    }
}
