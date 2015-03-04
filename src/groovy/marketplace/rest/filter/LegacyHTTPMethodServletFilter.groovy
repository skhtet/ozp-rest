package marketplace.rest.filter

import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

class LegacyHTTPMethodServletFilter implements Filter {
    private static final String METHOD_PARAM_KEY = '_method'

    /**
     * A ServletRequest that gets its HTTP method from either the HTTP headers, or if present,
     * a _method form parameter
     */
    private static class LegacyHTTPMethodServletRequest extends HttpServletRequestWrapper {
        final String method

        LegacyHTTPMethodServletRequest(HttpServletRequest request) {
            super(request)

            this.method = getLegacyHTTPMethod(request)
        }
    }

    private static final String getLegacyHTTPMethod(request) {
        String requestMethod = request.method
        if (requestMethod == 'POST') {
            return request.getParameter(METHOD_PARAM_KEY) ?: requestMethod
        }
        else {
            return requestMethod
        }
    }

    void destroy() {}

    void init(FilterConfig config) {}

    void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) {
        filterChain.doFilter(new LegacyHTTPMethodServletRequest(request), response)
    }
}
