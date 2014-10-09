package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.ChildObjectCollection

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

interface ChildObjectCollectionUriBuilder<P,T> {
    URI getCollectionUri(ChildObjectCollection<P,T> collection)
    URI getCollectionUri(T childObj)

    interface Factory<P,T> {
        ChildObjectCollectionUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

interface ChildObjectUriBuilder<P,T> extends
        DomainResourceUriBuilder<T>, ChildObjectCollectionUriBuilder<P,T> {
    interface Factory<P,T> extends
            DomainResourceUriBuilder.Factory<T>, ChildObjectCollectionUriBuilder.Factory<P,T> {
        ChildObjectUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}
