package marketplace.hal

import com.damnhandy.uri.template.UriTemplate

/**
 * A "namespace" for extension link relations.  Per HAL specs, this is defined as a
 * name and a URI template.
 */
enum HalRelationCurie {
    //TODO determine the right URI
    OZP(UriTemplate.fromTemplate('/docs/relations/ozp/{rel}'), 'ozp')

    private UriTemplate href
    private String name

    /**
     * @param href A UriTemplate relative to the application root.  This template must include
     * a single template parameter named 'rel'
     * @param name The name for this curie, This is used within abbreviated link relation names
     * to reference the curie link object
     */
    private HalRelationCurie(UriTemplate href, String name) {
        if (!href || !name) {
            throw new NullPointerException("HalRelationNamespace must have a UriTemplate")
        }

        this.href = href
        this.name = name

        validateHref()
    }

    public Link toLink() {
        new Link(href, null, null, name, null, null, null)
    }

    private void validateHref() throws IllegalArgumentException {
        if (!(href.variables as List<String>).contains('rel')) {
            throw new IllegalArgumentException(
                "HAL relation URI templates must have a parameter named 'rel'")
        }
    }
}
