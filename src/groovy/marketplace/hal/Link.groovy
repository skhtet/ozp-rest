package marketplace.hal

import com.github.fge.uritemplate.URITemplate

class Link {
    //The following two variables both represent the href property. Only one should be non-null
    private URITemplate hrefTemplate
    private URI href

    private MediaType type
    private URI deprecation
    private String name
    private URI profile
    private String title

    //consider using the RFC 5646 library present in Java 8 or 9, if we ever upgrade that far
    private String hreflang

    Link(String href, Boolean templated, MediaType type, URI deprecation, String name,
            URI profile, String title, String hreflang) {
        if (!href) {
            throw new NullPointerException("Link must have an href")
        }

        if (templated) {
            hrefTemplate = new URITemplate(href)
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
        hrefTemplate?.toString() ?: href.toString()
    }

    public Boolean getTemplated() {
        //null instead of false to avoid including it and cut down on JSON size
        hrefTemplate ? true : null
    }

    public MediaType getType() { mediaType }
    public URI getDeprecation() { deprecation }
    public String getName() { name }
    public URI getProfile() { profile }
    public String getTitle() { title }
    public String getHreflang() { hreflang }

    boolean equals(other) {
        other instanceof Link && getTemplated() == other.templated && getHref() == other.href
    }

    int hashCode() {
        hrefTemplate?.hashCode() ?: href.hashCode()
    }
}
