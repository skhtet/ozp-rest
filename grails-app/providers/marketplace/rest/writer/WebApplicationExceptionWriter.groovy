package marketplace.rest.writer

import java.lang.reflect.Type
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter
import java.lang.annotation.Annotation

import javax.ws.rs.Produces
import javax.ws.rs.ext.Provider

import javax.ws.rs.WebApplicationException

@Provider
@Produces(['text/x-json', 'application/json', '*/*'])
class WebApplicationExceptionWriter extends ThrowableWriterSupport<WebApplicationException> {
    boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        WebApplicationException.class.isAssignableFrom(type)
    }

    //WebApplicationExceptions have no way to get a decent message out of them
    @Override
    protected Map toBodyMap(WebApplicationException exception) {
        [ error: true ]
    }
}
