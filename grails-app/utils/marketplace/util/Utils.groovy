package marketplace.util

class Utils {
    /**
     * If obj is a collection, invoke the closure on each element.
     * Otherwise, invoke the closure on obj itself
     */
    static void singleOrCollectionDo(obj, Closure closure) {
        if (obj instanceof Collection) {
            obj.each(closure)
        }
        else {
            closure(obj)
        }
    }
}
