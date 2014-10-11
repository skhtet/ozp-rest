package marketplace.rest.representation.in

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AbstractInputRepresentation<T> implements InputRepresentation<T> {
    private Class<T> representedClass

    AbstractInputRepresentation(Class<T> representedClass) {
        this.representedClass = representedClass
    }

    public Class<T> representedClass() { representedClass }

    Map<String, Object> getInputProperties() {
        //filter out inputProperties from properties
        this.properties.findAll { String k, v -> !(k in ['inputProperties', 'class']) }
    }
}
