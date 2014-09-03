package marketplace.rest

import java.lang.reflect.Type

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.MediaType

interface RepresentationFactory<T> {
    /**
     * The MediaTypes that go along with the Representation produced by this factory.
     * Generally this will be one specific media type and optionally one more general one, like
     * application/json
     */
    Set<MediaType> getMediaTypes()

    /**
     * The Type supported as input to this factory.  Usually this will just be the Class<T>, but
     * it could be a generic ParameterizedType, especially for collections
     */
    Type getSupportedType()

    /**
     * @param sourceObj The object to be transformed into a representation
     * @param uriBuilder a UriBuilder that should be initialized to the application base URI.
     * @return A representation of the sourceObj, appropriate for this factory's MediaType
     */
    AbstractHalRepresentation<T> toRepresentation(T sourceObj, UriBuilder uriBuilder)
}
