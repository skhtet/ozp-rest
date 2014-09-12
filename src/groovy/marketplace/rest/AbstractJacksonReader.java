package marketplace.rest;

import java.util.List;

import java.io.InputStream;
import java.io.IOException;

import java.lang.reflect.Type;
import java.lang.annotation.Annotation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import com.google.common.reflect.TypeToken;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractJacksonReader<T> implements MessageBodyReader<T> {

    @Autowired ObjectMapper objectMapper;

    private TypeToken<T> type;
    private JavaType jacksonType;

    public AbstractJacksonReader() {
        this.type = new TypeToken<T>(getClass()) {};
        this.jacksonType = TypeFactory.defaultInstance().constructType(this.type.getType());
    }

    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        return this.type.isAssignableFrom(genericType);
    }

    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations,
            MediaType mediaType, MultivaluedMap<String,String> httpHeaders,
            InputStream entityStream) throws IOException {
        try {
            return objectMapper.readValue(entityStream, jacksonType);
        }
        catch (JsonMappingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

abstract class AbstractRepresentationReader<T extends InputRepresentation<?>>
        extends AbstractJacksonReader<T> {}

abstract class
        AbstractRepresentationCollectionReader<T extends InputRepresentation<?>>
        extends AbstractJacksonReader<List<T>> {}
