package marketplace.rest

class IdRefRepresentation<T> extends AbstractInputRepresentation<T> {
    long id

    T createNewObject() {
        throw new
            UnsupportedOperationException("Objects cannot be created from IdRefRepresentations")
    }
}
