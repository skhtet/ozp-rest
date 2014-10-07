package marketplace.rest

/**
 * A wrapper around a collection of child objects that also includes a reference
 * to the parent object.  This facilitates the construction of HAL representations
 * that contain a link to the parent of a potentially empty collection
 */
class ChildObjectCollection<P,T> {
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
}
