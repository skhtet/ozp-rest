package marketplace.hal

abstract class AbstractHalRepresentation<T> {
    private HalLinks _links = new HalLinks()
    private HalEmbedded _embedded = new HalEmbedded()

    private UriBuilder uriBuilder

    AbstractHalRepresentation() {}

    AbstractHalRepresentation(HalLinks links, HalEmbedded embedded) {
        addLinks(links)
        addEmbedded(embedded)
    }

    HalLinks get_links() { _links.isEmpty() ? null : _links }
    HalEmbedded get_embedded() { _embedded.isEmpty() ? null : _embedded }

    protected void addLinks(HalLinks links) {
        _links.addLinks(links)
    }

    protected void addEmbedded(HalEmbedded embedded) {
        _embedded.putAll(embedded)

        //curies from embedded HAL representations must be defined on the
        //root representation
        _links.addCuries(embedded._links.curies)
    }
}
