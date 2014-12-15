package marketplace.rest.filter

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.lang.annotation.ElementType

/**
 * Header for resource methods to specify a custom Cache-Control HTTP header
 *
 * This code taken from http://stackoverflow.com/a/10970785
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheControlHeader {
    String value()
}
