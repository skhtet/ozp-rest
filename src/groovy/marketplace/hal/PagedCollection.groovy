package marketplace.hal

/**
 * A wrapper object that represents a collection of elements from a paged source, along with
 * paging information
 */
class PagedCollection<T> {
    /**
     * The offset parameter that resulted in this collection
     */
    final Integer offset

    /**
     * the max param that resulted in this collection
     */
    final Integer max

    /**
     * The total number of items in this resource that this collection is a part of
     * (not nullable)
     */
    final int total

    final Collection<T> items

    PagedCollection(Integer offset, Integer max, int total, Collection<T> items) {
        if (items == null) {
            throw new NullPointerException()
        }

        this.offset = offset
        this.max = max
        this.total = total
        this.items = items
    }
}
