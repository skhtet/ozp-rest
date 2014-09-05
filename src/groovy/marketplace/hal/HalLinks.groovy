package marketplace.hal

/**
 * The _links object within a HAL representation
 */
class HalLinks {
    private Set<HalRelationCurie> curies = new TreeSet()
    private Map<RelationType, List<Link>> linkMap = new TreeMap()

    private void addCurieForRelation(RelationType relationType) {
        if (relationType instanceof HalCuriedRelationType) {
            addCurie(relationType.halRelationCurie)
        }
    }

    /**
     * Add the curie to the set of curies to be included in this HalLinks
     */
    void addCurie(HalRelationCurie curie) {
        curies.add(curie)
    }

    void addCuries(Collection<? extends HalRelationCurie> curies) {
        curies.addAll(curies)
    }

    void addLinks(HalLinks otherLinks) {
        curies.addAll(otherLinks.@curies)
        linkMap.putAll(otherLinks.@linkMap)
    }

    HalLinks(Map<RelationType, List<Link>> linkMap) {
        this.linkMap.putAll(linkMap)
        linkMap.keySet().each { addCurieForRelation(it) }
    }

    HalLinks() {}

    boolean isEmpty() {
        curies.isEmpty() && linkMap.isEmpty()
    }

    /**
     * Add the specified link to the specified relation
     */
    Link put(RelationType relationType, Link link) {
        List<Link> links = linkMap.get(relationType)
        if (links) {
            links << link
        }
        else {
            links = new LinkedList()
            links << link
            linkMap.put(relationType, links)
        }

        addCurieForRelation(relationType)
    }

    /**
     * Output the links as a Map, including the "curies" section
     */
    Map<RelationType, List<Link>> toMap() {
        toMap(true)
    }

    /**
     * Output the links as a Map, but optionally do not include the "curies" section.  Not
     * including the curies is useful when this HalLinks is on a representation that is
     * embedded within another, in which case the curies should be added to the root
     * representation
     */
    protected Map<RelationType, List<Link>> toMap(boolean includeCuries) {
        Map<RelationType, List<Link>> retval = new TreeMap(linkMap)

        if (includeCuries) {
            retval.put(CurieRelationType.CURIE, curies.collect { it.toLink() })
        }

        return retval
    }

    /**
     * @return an unmodifiableSet containing all of the curies in this Links object
     */
    Set<HalRelationCurie> getCuries() {
        Collections.unmodifiableSet(curies)
    }
}
