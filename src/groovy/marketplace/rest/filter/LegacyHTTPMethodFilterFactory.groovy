package marketplace.rest.filter

import com.sun.jersey.spi.container.ResourceFilter
import com.sun.jersey.spi.container.ResourceFilterFactory
import com.sun.jersey.spi.container.ContainerRequestFilter
import com.sun.jersey.spi.container.ContainerResponseFilter
import com.sun.jersey.spi.container.ContainerRequest
import com.sun.jersey.api.representation.Form

import com.sun.jersey.api.model.AbstractMethod

/**
 * Add Cache-Control: no-cache to all responses unless
 * they have a CacheControlHeader annotation defined.
 *
 * This code taken from http://stackoverflow.com/a/10970785
 */
public class LegacyHTTPMethodFilterFactory implements ResourceFilterFactory {
    private static final List<ResourceFilter> NO_CACHE_FILTER = [new LegacyHTTPMethodFilter()]

    @Override
    public List<ResourceFilter> create(AbstractMethod am) {
        LegacyHTTPMethod annotation = am.getAnnotation(LegacyHTTPMethod.class)
        annotation ? [new LegacyHTTPMethodFilter()] : []
    }

    private static class LegacyHTTPMethodFilter implements
            ResourceFilter, ContainerRequestFilter {
        @Override
        public ContainerRequestFilter getRequestFilter() {
            this
        }

        @Override
        public ContainerResponseFilter getResponseFilter() {
            null
        }

        @Override
        public ContainerRequest filter(ContainerRequest request) {
            Form form = request.formParameters
            String formMethod = form.getFirst('_method')
            if (formMethod) {
                request.method = formMethod
            }

            return request
        }
    }
}

