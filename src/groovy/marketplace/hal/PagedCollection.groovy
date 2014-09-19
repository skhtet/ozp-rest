package marketplace.hal

import grails.orm.PagedResultList

/**
 * A wrapper object that represents a collection of elements from a paged source, along with
 * paging information
 */
class PagedCollection<E> implements Collection<E> {
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

    final Collection<E> items

    PagedCollection(Integer offset, Integer max, Collection<E> items) {
        if (items == null) {
            throw new NullPointerException()
        }

        this.offset = offset
        this.max = max
        this.total = items instanceof PagedResultList ? items.totalCount : items.size()
        this.items = items
    }

    /** Pass-through methods for the collection */
    boolean add(E e) { this.items.add(e) }
    boolean addAll(Collection<? extends E> c) { this.items.addAll(c) }
    void clear() { this.items.clear() }
    boolean contains(Object o) { this.items.contains(o) }
    boolean containsAll(Collection<?> c) { this.items.containsAll(c) }
    boolean equals(Object o) { this.items.equals(o) }
    int hashCode() { this.items.hashCode() }
    boolean isEmpty() { this.items.isEmpty() }
    Iterator<E> iterator() { this.items.iterator() }
    boolean remove(Object o) { this.items.remove(o) }
    boolean removeAll(Collection<?> c) { this.items.removeAll(c) }
    boolean retainAll(Collection<?> c) { this.items.retainAll(c) }
    int size() { this.items.size() }
    Object[] toArray() { this.items.toArray() }
    public <T> T[] toArray(T[] a) { this.items.toArray(a) }
}
