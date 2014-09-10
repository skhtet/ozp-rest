package marketplace.hal

/**
 * Represents the _embedded section of a HAL object
 */
class HalEmbedded extends TreeMap<RelationType, List<AbstractHalRepresentation<?>>> {
    /**
     * A potentially more convenient constructor allowing individual RelationType -> Rep
     * pairings to be passed in
     */
    HalEmbedded(Collection<Map.Entry<RelationType, AbstractHalRepresentation<?>>> links) {
        links.each { link ->
            put(link.key, link.value)
        }
    }

    HalEmbedded(RelationType relationType, AbstractHalRepresentation<?> rep) {
        put(relationType, rep)
    }

    HalEmbedded() {}

    /**
     * Add the specified representation to the specified relation
     */
    List<AbstractHalRepresentation<?>> put(RelationType relationType,
            AbstractHalRepresentation<?> rep) {
        List<AbstractHalRepresentation<?>> representations = get(relationType)
        if (representations) {
            representations << rep
        }
        else {
            representations = new LinkedList()
            representations << rep
            put(relationType, representations)
        }
    }

    public void setIncludeCuries(boolean includeCuries) {
        values().flatten().each { it.setIncludeCuries(includeCuries) }
    }
}
