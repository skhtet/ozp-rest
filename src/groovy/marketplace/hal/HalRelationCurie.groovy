package marketplace.hal

/**
 * A "namespace" for extension link relations.  Per HAL specs, this is defined as a
 * name and a URI template.
 */
enum HalRelationCurie {
    //TODO determine the right URI
    OZP('/docs/relations/ozp/{rel}', 'ozp')

    private URITemplate href
    private String name


    private HalRelationCurie(String href, String name) {
        this(new URITemplate(uriTemplate), name)
    }

    /**
     * @param href A URITemplate relative to the application root.  This template must include
     * a single template parameter named 'rel'
     * @param name The name for this curie, This is used within abbreviated link relation names
     * to reference the curie link object
     */
    private HalRelationCurie(URITemplate href, String name) {
        if (!uriTemplate || !name) {
            throw new NullPointerException("HalRelationNamespace must have a URITemplate")
        }

        this.href = href
        this.name = name

        validateHref()
    }

    public Link toLink() {
        new Link(href.toString(), true, null, null, name, null, null, null)
    }

    private void validateHref() throws IllegalArgumentException {
        //it would be nice if URITemplate had methods to list its variables, but it doesn't
        //so just do a quick and dirty string match
        if (!href.contains("{rel}")) {
            throw new IllegalArgumentException(
                "HAL relation URI templates must have a parameter named 'rel'")
        }
    }

    boolean equals(other) {
        other instanceof HalRelationCurie && href == other.href
    }

    int hashCode() {
        href.hashCode()
    }
}
