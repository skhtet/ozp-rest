package marketplace.rest

class InvalidContentTypeException extends IllegalArgumentException {
    InvalidContentTypeException(String message) {
        super(message)
    }

    InvalidContentTypeException(String message, Throwable cause) {
        super(message, cause)
    }
}
