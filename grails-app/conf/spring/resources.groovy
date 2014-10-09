import grails.util.GrailsUtil

import org.springframework.security.web.FilterChainProxy
import org.springframework.orm.hibernate3.support.OpenSessionInViewInterceptor

import com.fasterxml.jackson.databind.ObjectMapper;

import marketplace.*
import marketplace.search.MarketplaceElasticSearchService
import marketplace.authentication.MockAccountService
import marketplace.authentication.SpringSecurityAccountService
import ozone.utils.ApplicationContextHolder


import org.springframework.security.core.authority.SimpleGrantedAuthority

// Place your Spring DSL code here
beans = {

    def DEFAULT_AGENCY = 'DEFAULT_STORE_NAME'

	xmlns context: 'http://www.springframework.org/schema/context'
	context.'component-scan'('base-package': 'marketplace.validator,marketplace.rest')

    auditLogListener(org.ozoneplatform.auditing.AuditLogListener) {
        sessionFactory = ref('sessionFactory')
        accountService = ref('accountService')
        grailsApplication = ref('grailsApplication')
    }

    elasticSearchService(MarketplaceElasticSearchService) {
        elasticSearchHelper = ref('elasticSearchHelper')
        domainInstancesRebuilder = ref('domainInstancesRebuilder')
        elasticSearchContextHolder = ref('elasticSearchContextHolder')
        indexRequestQueue = ref('indexRequestQueue')
        grailsApplication = ref('grailsApplication')
    }

    applicationContextHolder(ApplicationContextHolder) { bean ->
        bean.factoryMethod = 'getInstance'
    }

    accountService(SpringSecurityAccountService)

    customPropertyEditorRegistrar(util.CustomPropertyEditorRegistrar)

    objectMapper(ObjectMapper)

    /**
     * OP-5818: Use the Spring class instead of the default Grails subclass of it.
     */
    openSessionInViewInterceptor(OpenSessionInViewInterceptor) {
        sessionFactory = ref('sessionFactory')
    }
}
