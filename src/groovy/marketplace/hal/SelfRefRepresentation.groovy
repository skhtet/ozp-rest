package marketplace.hal

/**
 * Abstract class providing a 'self' link in the _links object
 */
abstract class SelfRefRepresentation<T> extends AbstractHalRepresentation<T> {

    /**
     * @param resourceClass The resourceClass that the self reference URI should refer to
     * @param methodName The method on the resourceClass that the self reference URI should
     * refer to, or null to just refer to the URI of the class itself
     * @param uriParams Parameters to be passed into the URI builder method to resolve within the
     * URI
     */
    SelfRefRepresentation(URI selfRefUri,
            HalLinks links, HalEmbedded embedded) {
        super(links, embedded)

        this.addLink(RegisteredRelationType.SELF, new Link(selfRefUri))
    }
}
