package marketplace.rest

abstract class AbstractInputRepresentation<T> implements InputRepresentation<T> {
    private Class<T> representedClass;

    AbstractInputRepresentation(Class<T> representedClass) {
        this.representedClass = representedClass
    }

    public Class<T> representedClass() { representedClass }

    Map<String, Object> getInputProperties() {
        //filter out inputProperties from properties
        this.properties.findAll { k, v -> !(k in ['inputProperties', 'class']) }
    }
}
