package marketplace.rest

import marketplace.Agency
import marketplace.ContactType
import marketplace.Intent
import marketplace.Profile
import marketplace.ServiceItem
import marketplace.Types
import marketplace.Category

class IdRefInputRepresentation<T, S> extends AbstractInputRepresentation<T> {
    S id

    IdRefInputRepresentation(Class<T> cls) { super(cls) }

    T createNewObject() {
        throw new
            UnsupportedOperationException("Objects cannot be created from IdRefInputRepresentations")
    }
}

class ServiceItemIdRef extends IdRefInputRepresentation<ServiceItem, Long> {
    ServiceItemIdRef() { super(ServiceItem.class) }
}

class IntentIdRef extends IdRefInputRepresentation<Intent, String> {
    IntentIdRef() { super(Intent.class) }
    IntentIdRef(String id) {
        this()
        def props = id.split('/')
        this.id = Intent.generateId([
            type: props[0] + '/' + props[1],
            action: props[2]
        ])
    }
}

class TypeIdRef extends IdRefInputRepresentation<Types, Long> {
    TypeIdRef() { super(Types.class) }
}

class AgencyIdRef extends IdRefInputRepresentation<Agency, Long> {
    AgencyIdRef() { super(Agency.class) }
}

class ContactTypeIdRef extends IdRefInputRepresentation<ContactType, Long> {
    ContactTypeIdRef() { super(ContactType.class) }
}

class OwnerIdRef extends IdRefInputRepresentation<Profile, Long> {
    OwnerIdRef() { super(Profile.class) }
}

class CategoryIdRef extends IdRefInputRepresentation<Category, Long> {
    CategoryIdRef() { super(Category.class) }
}
