package marketplace.rest.writer

import java.lang.reflect.Type
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter
import java.lang.annotation.Annotation

import javax.ws.rs.Produces
import javax.ws.rs.ext.Provider

import grails.validation.ValidationException

@Provider
@Produces(['text/x-json', 'application/json'])
class ValidationExceptionWriter extends ThrowableWriterSupport<ValidationException> {
    boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
            MediaType mediaType) {
        ValidationException.class.isAssignableFrom(type)
    }

    @Override
    protected Map toBodyMap(ValidationException exception) {
        return [
            //Just get the first part of the error string
            message: exception.message.split('\\n')[0],
            errors: getResolvedMessages(exception.errors)
        ]
    }

    //This will resolve the messages based on local and pass them back
    Map getResolvedMessages(def errors){
        Map errMessages = [:]
        errors.getAllErrors().each {
            def fieldErrorCode =  it.objectName + "." + it.field + "." + it.code
            def message = grailsApplication.getMainContext().getMessage(
                fieldErrorCode,
                it.arguments,
                it.defaultMessage,
                Locale.getDefault()
            )
            errMessages[it.field] = errMessages[it.field] ? [errMessages[it.field], message] : message
        }
        errMessages
    }
}
