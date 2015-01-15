package marketplace.rest.filter

import javax.ws.rs.core.HttpHeaders

import com.sun.jersey.spi.container.ResourceFilter
import com.sun.jersey.spi.container.ResourceFilterFactory
import com.sun.jersey.spi.container.ContainerResponseFilter
import com.sun.jersey.spi.container.ContainerRequestFilter
import com.sun.jersey.spi.container.ContainerResponse
import com.sun.jersey.spi.container.ContainerRequest

import com.sun.jersey.api.model.AbstractMethod

/**
 * Add Cache-Control: no-cache to all responses unless
 * they have a CacheControlHeader annotation defined.
 *
 * This code taken from http://stackoverflow.com/a/10970785
 */
public class CacheFilterFactory implements ResourceFilterFactory {
    private static final List<ResourceFilter> NO_CACHE_FILTER =
        [new CacheResponseFilter("no-cache")]

    @Override
    public List<ResourceFilter> create(AbstractMethod am) {
        CacheControlHeader cch = am.getAnnotation(CacheControlHeader.class)
        cch ? [new CacheResponseFilter(cch.value())] : NO_CACHE_FILTER
    }

    private static class CacheResponseFilter implements ResourceFilter, ContainerResponseFilter {
        private final String headerValue

        CacheResponseFilter(String headerValue) {
            this.headerValue = headerValue
        }

        @Override
        public ContainerRequestFilter getRequestFilter() {
            null
        }

        @Override
        public ContainerResponseFilter getResponseFilter() {
            this
        }

        @Override
        public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
            // attache Cache Control header to each response based on the annotation value
            response.getHttpHeaders().putSingle(HttpHeaders.CACHE_CONTROL, headerValue)
            return response
        }
    }
}
