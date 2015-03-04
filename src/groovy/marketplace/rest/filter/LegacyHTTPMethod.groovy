package marketplace.rest.filter

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.lang.annotation.ElementType

/**
 * Header for resource methods that support specifying the "real" HTTP method for the request
 * as a form parameter in a POST request
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LegacyHTTPMethod {}
