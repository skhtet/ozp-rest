package marketplace.hal;

import java.io.OutputStream;
import java.io.IOException;

import java.lang.reflect.Type;
import java.lang.annotation.Annotation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import com.google.common.reflect.TypeToken;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractRepresentationWriter<T> implements MessageBodyWriter<T> {
    @Context UriInfo uriInfo;
    @Autowired ObjectMapper objectMapper;

    private TypeToken<T> type;
    private RepresentationFactory<T> factory;

    public AbstractRepresentationWriter(RepresentationFactory<T> factory) {
        if (factory == null)
            throw new NullPointerException("RepresentationFactory should not be null");

        this.type = new TypeToken<T>(getClass()) {};
        this.factory = factory;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return this.type.isAssignableFrom(genericType);
    }

    @Override
    public long getSize(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream)
            throws IOException {
        AbstractHalRepresentation<T> representation = factory.toRepresentation(
            t, new ApplicationRootUriBuilderHolder(uriInfo));

        objectMapper.writeValue(entityStream, representation);
    }
}
