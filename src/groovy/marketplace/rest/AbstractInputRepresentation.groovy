package marketplace.rest

import com.google.common.reflect.TypeToken;

abstract class AbstractInputRepresentation<T> implements InputRepresentation<T> {
    private Class<T> representedClass = new TypeToken<T>(getClass()) {}.getRawType()

    Class<T> representedClass() { representedClass }

    Map<String, Object> getProperties() { this.properties }
}
