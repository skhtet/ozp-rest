package marketplace.rest

import java.lang.reflect.Type

import javax.ws.rs.core.MediaType

interface RepresentationFactory<T> {
    /**
     * @param sourceObj The object to be transformed into a representation
     * @param uriBuilder a UriBuilder that should be initialized to the application base URI.
     * @return A representation of the sourceObj, appropriate for this factory's MediaType
     */
    AbstractHalRepresentation<T> toRepresentation(T sourceObj,
            ApplicationRootUriBuilderHolder uriBuilderHolder)
}
