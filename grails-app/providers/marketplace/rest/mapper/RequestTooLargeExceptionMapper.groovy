package marketplace.rest.mapper

import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

import marketplace.rest.RequestTooLargeException

@Provider
class RequestTooLargeExceptionMapper extends RestExceptionMapper<RequestTooLargeException> {
    RequestTooLargeExceptionMapper() {
        //this response code is apparently too obscure to be predefined in JAX-RS 1
        super([
            getFamily: { -> Response.Status.Family.CLIENT_ERROR },
            getReasonPhrase: { -> 'Request Entity Too Large' },
            getStatusCode: { -> 413 }
        ] as Response.StatusType)
    }
}

