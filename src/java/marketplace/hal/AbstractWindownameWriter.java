package marketplace.hal;

import java.io.OutputStream;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import java.lang.reflect.Type;
import java.lang.annotation.Annotation;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.codehaus.groovy.grails.commons.GrailsApplication;

import com.google.common.reflect.TypeToken;

/**
 * class for writing out JSON string embedded in HTML suitable for the legacy windowname
 * transport mechanism
 */
public abstract class AbstractWindownameWriter<T> extends AbstractRepresentationWriter<T> {
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    //The beginning of a minimal HTML file which will embed the JSON representation
    //of the entity in a JavaScript string that gets assigned to the window.name field.
    //The JSON is wrapped in single-quotes to avoid escaping problems (all strings in JSON
    //are double quoted)
    private static final byte[] windownamePrelude = (
        "<!DOCTYPE html>" +
        "<title>Windowname transport</title>" +
        "<script>window.name='"
    ).getBytes(CHARSET);

    private static final byte[] windownamePostlude = ("';</script>").getBytes(CHARSET);

    public AbstractWindownameWriter(GrailsApplication grailsApplication,
            RepresentationFactory<T> factory) {
        super(grailsApplication, factory);
    }

    @Override
    public void writeTo(T t, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream)
            throws IOException {
        entityStream.write(windownamePrelude);
        super.writeTo(t, type, genericType, annotations, mediaType, httpHeaders, entityStream);
        entityStream.write(windownamePostlude);
    }
}
