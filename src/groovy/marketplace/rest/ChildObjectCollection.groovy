package marketplace.rest

/**
 * A wrapper around a collection of child objects that also includes a reference
 * to the parent object.  This facilitates the construction of HAL representations
 * that contain a link to the parent of a potentially empty collection
 */
class ChildObjectCollection<P,T> implements Collection<T> {
    final Collection<T> collection
    final P parent

    ChildObjectCollection(Collection<T> collection, P parent) {
        if (collection == null || parent == null) {
            throw new NullPointerException(
                "ChildObjectCollection must have both a collection and a parent")
        }

        this.collection = collection
        this.parent = parent
    }

    /** Pass-through methods for the collection */
    boolean add(T e) { this.collection.add(e) }
    boolean addAll(Collection<? extends T> c) { this.collection.addAll(c) }
    void clear() { this.collection.clear() }
    boolean contains(Object o) { this.collection.contains(o) }
    boolean containsAll(Collection<?> c) { this.collection.containsAll(c) }
    boolean isEmpty() { this.collection.isEmpty() }
    Iterator<T> iterator() { this.collection.iterator() }
    boolean remove(Object o) { this.collection.remove(o) }
    boolean removeAll(Collection<?> c) { this.collection.removeAll(c) }
    boolean retainAll(Collection<?> c) { this.collection.retainAll(c) }
    int size() { this.collection.size() }
    Object[] toArray() { this.collection.toArray() }
    public <S> S[] toArray(S[] a) { this.collection.toArray(a) }

    boolean equals(Object other) {
        other instanceof ChildObjectCollection &&
            this.collection == other.collection &&
            this.parent == other.parent
    }

    int hashCode() {
        this.collection.hashCode() ^ this.parent.hashCode()
    }
}
