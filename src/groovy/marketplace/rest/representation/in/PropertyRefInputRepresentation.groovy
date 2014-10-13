package marketplace.rest.representation.in

import marketplace.Agency
import marketplace.ContactType
import marketplace.Intent
import marketplace.Profile
import marketplace.Type
import marketplace.Category

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

    IntentPropertyRefInputRepresentation(String id) {
        super(Intent.class)
        def props = id.split('/')
        action = props[2]
        type = "${props[0]}/${props[1]}"
    }

    public Map<String, String> getIdentifyingProperties() {
        [action: action, type: type]
    }
}

class ProfilePropertyInputRepresentation extends PropertyRefInputRepresentation<Profile> {
    String username

    ProfilePropertyInputRepresentation() {
        super(Profile.class)
    }

    public Map<String, String> getIdentifyingProperties() {
        [username: username]
    }
}

class TitleRefInputRepresentation<T> extends PropertyRefInputRepresentation<T> {
    String title

    TitleRefInputRepresentation(Class<T> representedClass, String title) {
        super(representedClass)
        this.title = title
    }

    public Map<String, String> getIdentifyingProperties() {
        [title: title]
    }
}

class TypeTitleInputRepresentation extends TitleRefInputRepresentation<Type> {
    TypeTitleInputRepresentation(String title) { super(Type.class, title) }
}

class CategoryTitleInputRepresentation extends TitleRefInputRepresentation<Category> {
    CategoryTitleInputRepresentation(String title) { super(Category.class, title) }
}

class AgencyTitleInputRepresentation extends TitleRefInputRepresentation<Agency> {
    AgencyTitleInputRepresentation(String title) { super(Agency.class, title) }
}

class ContactTypeTitleInputRepresentation extends TitleRefInputRepresentation<ContactType> {
    ContactTypeTitleInputRepresentation(String title) { super(ContactType.class, title) }
}