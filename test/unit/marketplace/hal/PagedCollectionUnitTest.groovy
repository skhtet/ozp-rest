package marketplace.hal

import grails.orm.PagedResultList

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.testutil.MockPagedResultList

@TestMixin(GrailsUnitTestMixin)
class PagedCollectionUnitTest {

    //test that Collection methods are passed through to the underlying collection
    void testPassThrough() {
        def collectionMock = mockFor(ArrayList)

        //size is called in the constructor too
        collectionMock.demand.size(1..1) { -> 1 }
        collectionMock.demand.add(1..1) { it -> false }
        collectionMock.demand.addAll(1..1) { Collection it -> false }
        collectionMock.demand.clear(1..1) { -> }
        collectionMock.demand.contains(1..1) { o -> false }
        collectionMock.demand.containsAll(1..1) { Collection c -> false }
        collectionMock.demand.isEmpty(1..1) { -> false }
        collectionMock.demand.iterator(1..1) { -> }
        collectionMock.demand.remove(1..1) { o -> false }
        collectionMock.demand.removeAll(1..1) { Collection c -> false }
        collectionMock.demand.retainAll(1..1) { Collection c -> false }
        collectionMock.demand.size(1..1) { -> 1 }
        collectionMock.demand.toArray(1..1) { -> }
        collectionMock.demand.toArray(1..1) { Object[] a -> }

        PagedCollection pagedCollection = new PagedCollection(null, null,
            collectionMock.createMock())

        pagedCollection.add(new Object())
        pagedCollection.addAll([])
        pagedCollection.clear()
        pagedCollection.contains(new Object())
        pagedCollection.containsAll([])
        pagedCollection.isEmpty()
        pagedCollection.iterator()
        pagedCollection.remove(new Object())
        pagedCollection.removeAll([])
        pagedCollection.retainAll([])
        pagedCollection.size()
        pagedCollection.toArray()
        pagedCollection.toArray(new Object[0])
    }

    void testRejectNullItems() {
        shouldFail(NullPointerException) {
            new PagedCollection(1, 2, null)
        }
    }

    void testTotal() {
        Collection items = [1,2,3,4]

        assert new PagedCollection(null, null, items).total == 4
        assert new PagedCollection(null, null,
            new MockPagedResultList().createPagedResultList(items, 100)).total == 100
    }

    void testConstructor() {
        Integer max = 1, offset = 5
        Collection items = [1,2,3,4]

        PagedCollection paged = new PagedCollection(offset, max, items)

        assert paged.items == items
        assert paged.max == max
        assert paged.offset == offset
    }

    void testEquals() {
        assert new PagedCollection(null, null, []) == new PagedCollection(null, null, [])
        assert new PagedCollection(null, null, [1,2,3,4]) ==
            new PagedCollection(null, null, [1,2,3,4])
        assert new PagedCollection(null, null, [1,2,3,4]) != [1,2,3,4]
        assert new PagedCollection(1,2,[3,4,5,6]) == new PagedCollection(1,2,[3,4,5,6])
        assert new PagedCollection(1,2,[3,4,5,6]) != new PagedCollection(5,2,[3,4,5,6])
        assert new PagedCollection(1,2,[3,4,5,6]) != new PagedCollection(1,4,[3,4,5,6])
        assert new PagedCollection(1,2,[3,4,5,6]) ==
            new PagedCollection(1,2, new MockPagedResultList().createPagedResultList([3,4,5,6], 4))
        assert new PagedCollection(1,2,[3,4,5,6]) !=
            new PagedCollection(1,2, new MockPagedResultList().createPagedResultList([3,4,5,6], 400))
    }

    void testHashCode() {
        assert new PagedCollection(null, null, []).hashCode() ==
            new PagedCollection(null, null, []).hashCode()
        assert new PagedCollection(null, null, [1,2,3,4]).hashCode() ==
            new PagedCollection(null, null, [1,2,3,4]).hashCode()
        assert new PagedCollection(null, null, [1,2,3,4]).hashCode() != [1,2,3,4]
        assert new PagedCollection(1,2,[3,4,5,6]).hashCode() ==
            new PagedCollection(1,2,[3,4,5,6]).hashCode()
        assert new PagedCollection(1,2,[3,4,5,6]).hashCode() !=
            new PagedCollection(5,2,[3,4,5,6]).hashCode()
        assert new PagedCollection(1,2,[3,4,5,6]).hashCode() !=
            new PagedCollection(1,4,[3,4,5,6]).hashCode()
        assert new PagedCollection(1,2,[3,4,5,6]).hashCode() == new PagedCollection(1,2,
                new MockPagedResultList().createPagedResultList([3,4,5,6], 4)).hashCode()
        assert new PagedCollection(1,2,[3,4,5,6]).hashCode() != new PagedCollection(1,2,
                new MockPagedResultList().createPagedResultList([3,4,5,6], 400)).hashCode()
    }
}
