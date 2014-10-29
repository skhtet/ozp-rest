package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.ChildObjectCollection
import marketplace.search.SearchResult

/**
 * Interface to provide URIs to specific, individual objects
 */
interface ObjectUriBuilder<T> {
    URI getUri(T obj)

    interface Factory<T> {
        ObjectUriBuilder<T> getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Interface to provide the URI of a collection of objects
 */
interface CollectionUriBuilder<T> {
    URI getCollectionUri()

    interface Factory<T> {
        CollectionUriBuilder<T> getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Interface to provide the URI of a collection that is owned by another object
 */
interface ChildCollectionUriBuilder<P,T> {
    CollectionUriBuilder<T> getCollectionUriBuilder(P parent)
    URI getCollectionUri(P parent)

    CollectionUriBuilder<T> getCollectionUriBuilder(ChildObjectCollection<P,T> collection)
    URI getCollectionUri(ChildObjectCollection<P,T> collection)

    interface Factory<P,T> {
        ChildCollectionUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Interface to provide the URI used to search objects of a particular type
 */
interface SearchUriBuilder<T> {
    URI getSearchUri(SearchResult<T> searchResult)
    CollectionUriBuilder<T> getCollectionUriBuilder(SearchResult<T> searchResult)

    interface Factory<T> {
        SearchUriBuilder<T> getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}
