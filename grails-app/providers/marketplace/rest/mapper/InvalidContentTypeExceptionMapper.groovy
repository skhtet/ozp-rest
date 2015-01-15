package marketplace.rest.mapper

import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

import marketplace.rest.InvalidContentTypeException

@Provider
class InvalidContentTypeExceptionMapper extends RestExceptionMapper<InvalidContentTypeException> {
    InvalidContentTypeExceptionMapper() {
        super(Response.Status.UNSUPPORTED_MEDIA_TYPE)
    }
}
