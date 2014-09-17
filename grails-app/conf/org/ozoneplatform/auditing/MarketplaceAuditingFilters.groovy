package org.ozoneplatform.auditing

import java.util.Map;
import javax.servlet.http.HttpServletRequest
import marketplace.AccountService
import marketplace.rest.ProfileRestService
import marketplace.Profile
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.ozoneplatform.auditing.filter.AbstractAuditingFilters
import org.ozoneplatform.auditing.format.cef.Extension
import org.springframework.beans.BeansException
import org.springframework.web.context.request.RequestContextHolder as RCH

class MarketplaceAuditingFilters extends AbstractAuditingFilters{

    GrailsApplication grailsApplication
    AccountService accountService
    ProfileRestService profileRestService

    public String getApplicationVersion(){
        return grailsApplication.metadata['app.version']
    }

    @Override
    public boolean doCefLogging() {
        grailsApplication.config.cef.enabled
    }

    @Override
    public String getUserName() {
        return accountService.getLoggedInUsername()
    }

    @Override
    public String getHostClassification() {
        grailsApplication.config.cef.securityLevel ?: Extension.UNKOWN_VALUE
    }

    @Override
    public String getDeviceProduct() {
        grailsApplication.config.cef.device.product
    }

    @Override
    public String getDeviceVendor() {
        grailsApplication.config.cef.device.vendor
    }

    @Override
    public String getDeviceVersion() {
        	grailsApplication.config.cef.device.version
    }

    @Override
    public int getCEFVersion() {
        grailsApplication.config.cef.version
    }


    public HttpServletRequest getRequest()  {
        return RCH?.getRequestAttributes()?.getRequest()
    }

    @Override
    public Map<String, String> getUserInfo(){
        Profile currentUser = profileRestService.currentUserProfile
        def map = [:]
        map['USERNAME'] = currentUser.username
        map['NAME']     = currentUser.displayName
        map['ORG']      = currentUser.organization.title
        map['EMAIL']    = currentUser.email
        map['ROLES']    = accountService.getLoggedInUserRoles().collect{it instanceof String ? it : it.authority}
        map
    }

}
