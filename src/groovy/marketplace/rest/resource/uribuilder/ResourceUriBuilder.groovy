package marketplace.rest.resource.uribuilder

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.ChildObjectCollection

/**
 * Interface for objects which define the
 * URIs by which objects of type T can be accessed
 */
interface ResourceUriBuilder<T> {
    URI getUri(T obj)

    //TODO maybe add a method for collection URIs

    interface Factory<T> {
        ResourceUriBuilder<T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}

interface ChildObjectCollectionUriBuilder<P,T> {
    URI getCollectionUri(ChildObjectCollection<P,T> collection)

    interface Factory<P,T> {
        ChildObjectCollectionUriBuilder<P,T> getBuilder(
            ApplicationRootUriBuilderHolder uriBuilderHolder)
    }
}
