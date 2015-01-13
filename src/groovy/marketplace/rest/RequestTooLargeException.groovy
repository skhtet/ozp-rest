package marketplace.rest

class RequestTooLargeException extends IllegalArgumentException {
    RequestTooLargeException(String message) {
        super(message)
    }

    RequestTooLargeException(String message, Throwable cause) {
        super(message, cause)
    }
}

