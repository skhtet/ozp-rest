package marketplace.rest.representation.in

import marketplace.Intent

/**
 * Similar to the IdRefInputRepresentation, but uses identifying properties rather than database id to look up the object
 *
 * @param < T > The entity that is being represented
 */
abstract class PropertyRefInputRepresentation<T> extends AbstractInputRepresentation<T> {
    PropertyRefInputRepresentation(Class<T> cls) {
        super(cls)
    }

    /**
     *
     * @return A map of property names and properties to use in the lookup. The properties should uniquely identify
     * the entity.
     */
    abstract Map<String, ?> getIdentifyingProperties()
}

class IntentPropertyRefInputRepresentation extends PropertyRefInputRepresentation<Intent> {

    String action
    String type

    IntentPropertyRefInputRepresentation() {
        super(Intent.class)
    }

    IntentPropertyRefInputRepresentation(String id) {
        this()
        def props = id.split('/')
        action = props[2]
        type = "${props[0]}/${props[1]}"
    }

    public Map<String, String> getIdentifyingProperties() {
        [action: action, type: type]
    }
}