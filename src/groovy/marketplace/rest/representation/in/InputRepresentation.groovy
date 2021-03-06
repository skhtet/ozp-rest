package marketplace.rest.representation.in

interface InputRepresentation<T> {
    /**
     * Retrieve the map of properties that came in on this representation and which should be
     * put into a domain model
     */
    Map<String, Object> getInputProperties()

    Class<T> representedClass()
}
