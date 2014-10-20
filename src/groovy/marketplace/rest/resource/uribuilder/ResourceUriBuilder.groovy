package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.ChildObjectCollection
import marketplace.search.SearchResult

/**
 * Interface for objects which define the
 * URIs by which objects of type T can be accessed
 */
interface DomainResourceUriBuilder<T> {
    URI getUri(T obj)

    interface Factory<T> {
        DomainResourceUriBuilder<T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * A builder for "top-level" resources - those with a global
 * GET endpoint that can return the whole collection.  Profile and Listing
 * are examples of this, while ItemComment isn't (since it is a child of Listing)
 */
interface RootResourceUriBuilder {
    URI getRootUri()

    interface Factory {
        RootResourceUriBuilder getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Convenience sub-interface to unify DomainResourceUriBuilder and RootResourceUriBuilder
 */
interface ResourceUriBuilder<T> extends DomainResourceUriBuilder<T>, RootResourceUriBuilder {
    interface Factory<T> extends DomainResourceUriBuilder.Factory<T>, RootResourceUriBuilder.Factory {
        ResourceUriBuilder<T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Interface for builders of URIs to sub-collections within a resource.  For example, listings
 * owned by a given profile.
 */
interface SubCollectionUriBuilder<P,T> {
    URI getCollectionUri(ChildObjectCollection<P,T> collection)

    interface Factory<P,T> {
        SubCollectionUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Interface for builders of URIs of resources that are searchable
 *
 * @param < T >
 */
interface SearchableResourceUriBuilder<T> extends ResourceUriBuilder<T> {
    URI getSearchUri(SearchResult<T> entities)

    interface Factory<T> extends ResourceUriBuilder.Factory<T> {
        SearchableResourceUriBuilder<T> getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Convenience interface to unify DomainResourceUriBuilder and SubCollectionUriBuilder
 */
interface SubObjectUriBuilder<P,T> extends
        DomainResourceUriBuilder<T>, SubCollectionUriBuilder<P,T> {
    interface Factory<P,T> extends
            DomainResourceUriBuilder.Factory<T>, SubCollectionUriBuilder.Factory<P,T> {
        SubObjectUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Specialization of SubCollectionUriBuilder for objects that are truly children of
 * the parent, and whose URIs can be generated from a single child object
 */
interface ChildObjectCollectionUriBuilder<P,T> extends SubCollectionUriBuilder<P,T> {
    URI getCollectionUri(T childObj)

    interface Factory<P,T> extends SubCollectionUriBuilder.Factory<P,T> {
        ChildObjectCollectionUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

/**
 * Convenience interface to unify DomainResourceUriBuilder and ChildObjectCollectionUriBuilder
 */
interface ChildObjectUriBuilder<P,T> extends
        DomainResourceUriBuilder<T>, ChildObjectCollectionUriBuilder<P,T> {
    interface Factory<P,T> extends
            DomainResourceUriBuilder.Factory<T>, ChildObjectCollectionUriBuilder.Factory<P,T> {
        ChildObjectUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}
