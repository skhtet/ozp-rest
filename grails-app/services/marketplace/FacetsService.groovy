package marketplace

class FacetsService {

    public Map<String, Object> extractFacetInfo(result) {
        Map<String, Object> returnValue = [:]
        if (result.facets) {
            Map<String, Object> facets = result.facets
            def termCounts
            def rangeCounts

            // Use the comparator with a sorted map to assure the filters are sorted alphabetically by respective titles.
            def comparator = [compare:
                    { a, b ->
                        int val = a.title.compareTo(b.title)
                        if (val == 0)
                            return a.id.compareTo(b.id)
                        else
                            return val
                    }
            ] as Comparator

            // Currently have separate procedural logic for each type of facet returned
            if (facets.types) {
                termCounts = facets.types.termCounts
                returnValue['types'] = new TreeMap<Type, Integer>(comparator)
                termCounts.each { entry ->
                    Type type = Type.get(Integer.valueOf(entry.term))
                    returnValue['types'][(type)] = entry.count
                }
            }

            if (facets.categories) {
                termCounts = facets.categories.termCounts
                returnValue['categories'] = new TreeMap<Category, Integer>(comparator)
                termCounts.each { entry ->
                    Category category = Category.get(Integer.valueOf(entry.term))
                    returnValue['categories'][(category)] = entry.count
                }
            }

            // AML-680  agency attribute for a listing - Extract the agency facet data
            if (facets.agency) {
                termCounts = facets.agency.termCounts
                returnValue['agencies'] = new TreeMap<String, Integer>(comparator)
                termCounts.each { entry ->
                    Agency agency = Agency.get(Integer.valueOf(entry.term))
                    returnValue['agencies'][(agency)] = entry.count
                }
            }

            // Reverse the rating order
            comparator = [compare:
                    { a, b -> b.compareTo(a) }
            ] as Comparator

            if (facets.rating) {
                rangeCounts = facets.rating.rangeCounts
                returnValue['ratings'] = new TreeMap<Integer, Integer>(comparator)
                rangeCounts.each { entry ->
                    returnValue['ratings'][(entry.from as int)] = entry.count
                }
            }
        }
        returnValue
    }

}
