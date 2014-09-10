package marketplace.rest

import java.lang.reflect.Type
import java.lang.annotation.Annotation

import javax.ws.rs.Produces
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

/**
 * Superclass for writers of throwables.
 */
@Provider
//any json-ish content type can be produced.  This is partially enforced by the implementation
//of isWriteable
@Produces(['text/x-json', 'application/*'])
class ThrowableWriterSupport<T extends Throwable> extends AbstractMessageBodyWriter<T> {
    ThrowableWriterSupport() {
        super(Throwable.class)
    }

    @Override
    protected Map toBodyMap(T exception) {
        [
            error: true,
            message: exception.message ?: exception.cause?.message ?: exception.getClass().name
        ]
    }

    @Override
    boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        (mediaType.subtype.endsWith('json') || mediaType.subtype.endsWith('hal')) &&
            super.isWriteable(type, genericType, annotations, mediaType)
    }
}
