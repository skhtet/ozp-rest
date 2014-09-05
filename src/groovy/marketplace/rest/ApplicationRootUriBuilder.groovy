package marketplace.rest

/**
 * A class that safely enforces access to UriBuilders that are initialized to the application
 * root. This mitigates the risk of forgetting to clone a shared uriBuilder before changing its
 * state.
 */
class ApplicationRootUriBuilderHolder {
    private UriBuilder uriBuilder

    ApplicationRootUriBuilder(UriInfo uriInfo) {
        uriBuilder = uriInfo.getBaseUriBuilder()
    }

    /**
     * Provides a fresh UriBuilder initialized to the application root URI
     */
    UriBuilder getBuilder() {
        urlBuilder.clone()
    }
}
