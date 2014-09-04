package marketplace.hal

class HalLinks {
    private Set<HalRelationCurie> curies = new TreeSet()
    private Map<RelationType, List<Link>> linkMap = new TreeMap()

    private void addCurieForRelation(RelationType relationType) {
        if (relationType instanceof HalCuriedRelationType) {
            curies.add(relationType.halRelationCurie)
        }
    }

    HalLinks(Map<RelationType, List<Link>> linkMap) {
        this.linkMap.putAll(linkMap)
        linkMap.keySet().each { addCurieForRelation(it) }
    }

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

    Map<RelationType, List<Link>> toMap() {
        Map<RelationType, List<Link>> retval = new TreeMap(linkMap)
        retval.put(CurieRelationType.CURIE, curies.collect { it.toLink() })

        return retval
    }
}
