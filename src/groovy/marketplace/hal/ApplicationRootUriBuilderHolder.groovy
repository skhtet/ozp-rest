package marketplace.hal

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import org.codehaus.groovy.grails.commons.GrailsApplication

/**
 * A class that safely enforces access to UriBuilders that are initialized to the application
 * root. This mitigates the risk of forgetting to clone a shared uriBuilder before changing its
 * state.
 */
class ApplicationRootUriBuilderHolder {
    private UriBuilder uriBuilder

    ApplicationRootUriBuilderHolder(GrailsApplication grailsApplication, UriInfo uriInfo) {
        String configuredPublicUri = grailsApplication.config.marketplace.publicURI

        uriBuilder = configuredPublicUri ?
            UriBuilder.fromUri(configuredPublicUri) :
            uriInfo.getBaseUriBuilder()
    }

    /**
     * Provides a fresh UriBuilder initialized to the application root URI
     */
    UriBuilder getBuilder() {
        uriBuilder.clone()
    }
}
