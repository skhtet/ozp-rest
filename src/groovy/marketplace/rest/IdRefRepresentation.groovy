package marketplace.rest

import marketplace.Agency
import marketplace.ContactType
import marketplace.Intent
import marketplace.Profile
import marketplace.ServiceItem
import marketplace.Types
import marketplace.Category

class IdRefRepresentation<T, S> extends AbstractInputRepresentation<T> {
    S id

    IdRefRepresentation(Class<T> cls) { super(cls) }

    T createNewObject() {
        throw new
            UnsupportedOperationException("Objects cannot be created from IdRefRepresentations")
    }
}

class ServiceItemIdRef extends IdRefRepresentation<ServiceItem, Long> {
    ServiceItemIdRef() { super(ServiceItem.class) }
}

class IntentIdRef extends IdRefRepresentation<Intent, String> {
    IntentIdRef() { super(Intent.class) }
    IntentIdRef(String id) {
        this()
        this.id = id
    }
}

class TypeIdRef extends IdRefRepresentation<Types, Long> {
    TypeIdRef() { super(Types.class) }
}

class AgencyIdRef extends IdRefRepresentation<Agency, Long> {
    AgencyIdRef() { super(Agency.class) }
}

class ContactTypeIdRef extends IdRefRepresentation<ContactType, Long> {
    ContactTypeIdRef() { super(ContactType.class) }
}

class OwnerIdRef extends IdRefRepresentation<Profile, Long> {
    OwnerIdRef() { super(Profile.class) }
}

class CategoryIdRef extends IdRefRepresentation<Category, Long> {
    CategoryIdRef() { super(Category.class) }
}