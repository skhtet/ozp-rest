package marketplace.rest

import java.lang.reflect.Type
import java.lang.annotation.Annotation

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.UriInfo
import javax.ws.rs.core.Context
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter

import com.google.common.reflect.TypeToken

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractRepresentationWriter<T> implements MessageBodyWriter<T> {
    @Context UriInfo uriInfo
    //@Autowired RepresentationRegistry representationRegistry
    @Autowired ObjectMapper objectMapper

    private TypeToken<T> type
    private RepresentationFactory factory

    AbstractRepresentationWriter(TypeToken<T> type, RepresentationFactory factory) {
        this.type = type
        this.factory = factory
    }

    boolean isWriteable(Class type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {

System.err.println "in isWriteable"
        //!!representationRegistry.get(genericType, mediaType)
        this.type.isAssignableFrom(genericType)
    }

    long getSize(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        -1
    }

    void writeTo(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream) {

        AbstractHalRepresentation representation = factory.toRepresentation(
            t, uriInfo.baseUriBuilder)

        objectMapper.writeValue(entityStream, representation)
    }
}
