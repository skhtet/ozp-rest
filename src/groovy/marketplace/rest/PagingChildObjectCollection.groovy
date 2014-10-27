package marketplace.rest

import marketplace.Paging

import grails.orm.PagedResultList

class PagingChildObjectCollection<P,T> extends ChildObjectCollection<P,T> implements Paging<T> {
    final Integer max
    final Integer offset

    final int total

    PagingChildObjectCollection(PagedResultList<T> collection, P parent, Integer offset,
            Integer max) {
        super(collection, parent)

        this.total = collection.totalCount
        this.max = max
        this.offset = offset
    }
}
