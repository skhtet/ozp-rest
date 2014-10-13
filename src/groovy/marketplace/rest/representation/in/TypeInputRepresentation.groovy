package marketplace.rest.representation.in

import marketplace.Type

class TypeInputRepresentation extends AbstractInputRepresentation<Type> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-type-v1+json'

    TypeInputRepresentation() {
        super(Type.class)
    }

    String title
    String description
}
