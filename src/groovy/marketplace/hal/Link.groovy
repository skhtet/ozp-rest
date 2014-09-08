package marketplace.hal

import javax.ws.rs.core.MediaType;

import com.damnhandy.uri.template.UriTemplate

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

@JsonInclude(Include.NON_NULL)
class Link {
    //The following two variables both represent the href property. Only one should be non-null
    private UriTemplate hrefTemplate
    private URI href

    final MediaType type
    final URI deprecation
    final String name
    final URI profile
    final String title

    //consider using the RFC 5646 library present in Java 8 or 9, if we ever upgrade that far
    final String hreflang

    Link(UriTemplate href) {
        this(href, null)
    }

    Link(UriTemplate href, String name) {
        this(href, null, null, name, null, null, null)
    }

    Link(UriTemplate hrefTemplate, MediaType type, URI deprecation, String name,
            URI profile, String title, String hreflang) {
        if (!hrefTemplate) {
            throw new NullPointerException("Link must have an href")
        }

        this.hrefTemplate = hrefTemplate
        this.type = type
        this.deprecation = deprecation
        this.name = name
        this.profile = profile
        this.title = title
        this.hreflang = hreflang
    }

    Link(URI href) {
        this(href, null)
    }

    Link(URI href, String name) {
        this(href, null, null, name, null, null, null)
    }

    Link(URI href, MediaType type, URI deprecation, String name,
            URI profile, String title, String hreflang) {
        if (!href) {
            throw new NullPointerException("Link must have an href")
        }

        this.href = href
        this.type = type
        this.deprecation = deprecation
        this.name = name
        this.profile = profile
        this.title = title
        this.hreflang = hreflang
    }

    Link(String href, Boolean templated, MediaType type, URI deprecation, String name,
            URI profile, String title, String hreflang) {
        if (!href) {
            throw new NullPointerException("Link must have an href")
        }

        if (templated) {
            hrefTemplate = new UriTemplate(href)
        }
        else {
            this.href = new URI(href)
        }

        this.type = type
        this.deprecation = deprecation
        this.name = name
        this.profile = profile
        this.title = title
        this.hreflang = hreflang
    }

    public String getHref() {
        hrefTemplate?.template ?: href.toString()
    }

    public Boolean getTemplated() {
        //null instead of false to avoid including it and cut down on JSON size
        hrefTemplate ? true : null
    }

    boolean equals(other) {
        other instanceof Link && getTemplated() == other.templated && getHref() == other.href
    }

    int hashCode() {
        hrefTemplate?.hashCode() ?: href.hashCode()
    }
}
