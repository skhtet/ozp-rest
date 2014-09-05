package marketplace.hal

abstract class AbstractHalRepresentation<T> {
    private HalLinks _links = new HalLinks()
    private HalEmbedded _embedded = new HalEmbedded()

    AbstractHalRepresentation() {}

    AbstractHalRepresentation(HalLinks links, HalEmbedded embedded) {
        addLinks(links)
        addEmbedded(embedded)
    }

    HalLinks get_links() { _links.isEmpty() ? null : _links }
    HalEmbedded get_embedded() { _embedded.isEmpty() ? null : _embedded }

    Map<RelationType, List<Link>> getLinkMap() {
        getLinkMap(true)
    }

    Map<RelationType, List<Link>> getLinkMap(boolean includeCuries) {
        _links.toMap(includeCuries)
    }

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
