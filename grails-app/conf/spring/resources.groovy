import grails.util.GrailsUtil

import org.springframework.security.web.FilterChainProxy
import org.springframework.orm.hibernate3.support.OpenSessionInViewInterceptor

import com.fasterxml.jackson.databind.ObjectMapper;

import marketplace.*
import marketplace.rest.*
import marketplace.search.MarketplaceElasticSearchService
import ozone.utils.ApplicationContextHolder

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

    // wire up a different account service if -Duser=something and environment is development
    if (GrailsUtil.environment != "production") {
        //empty sprint security bean
        springSecurityFilterChain(FilterChainProxy, [])

        switch (System.properties.user) {
            case "testUser1":
                println("Using AutoLoginAccountService - you will be logged in as testUser1")
                accountService(AutoLoginAccountService) {
                    autoAccountUsername = "testUser1"
                    autoAccountName = "Test User 1"
                    autoAccountEmail = "testuser1@nowhere.com"
                    autoOrganization = DEFAULT_AGENCY
                    autoRoles = [Constants.USER]
                }
                break
            default:
                if (GrailsUtil.environment == "test" || GrailsUtil.environment.startsWith('with_')) {
                    println("Using AutoLoginAccountService - you will be logged in as testUser1")
                    accountService(AutoLoginAccountService) {
                        autoAccountUsername = "testUser1"
                        autoAccountName = "Test User 1"
                        autoAccountEmail = "testuser1@nowhere.com"
                        autoRoles = [Constants.USER]
                    }
                } else {
                    println("Using AutoLoginAccountService - you will be logged in as testAdmin1")
                    accountService(AutoLoginAccountService) {
                        autoAccountUsername = "testAdmin1"
                        autoAccountName = "Test Administrator 1"
                        autoAccountEmail = "testadmin1@nowhere.com"
                        autoOrganization = DEFAULT_AGENCY
                        autoRoles = [Constants.USER, Constants.ADMIN, Constants.EXTERNADMIN]
                    }
                }
                break
        }

    } else {
        accountService(AccountService)
    }

    customPropertyEditorRegistrar(util.CustomPropertyEditorRegistrar)

    objectMapper(ObjectMapper)

    /**
     * OP-5818: Use the Spring class instead of the default Grails subclass of it.
     */
    openSessionInViewInterceptor(OpenSessionInViewInterceptor) {
        sessionFactory = ref('sessionFactory')
    }

}
