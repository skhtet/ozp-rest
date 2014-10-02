package marketplace.rest.representation.in

import marketplace.Agency
import marketplace.ContactType
import marketplace.Profile
import marketplace.Listing
import marketplace.Types
import marketplace.Category

class IdRefInputRepresentation<T, S> extends AbstractInputRepresentation<T> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-id-ref-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-id-refs-v1+json'

    S id

    IdRefInputRepresentation(Class<T> cls) { super(cls) }
}

class ServiceItemIdRef extends IdRefInputRepresentation<Listing, Long> {
    ServiceItemIdRef() { super(Listing.class) }
}

class ProfileIdRef extends IdRefInputRepresentation<Profile, Long> {
    ProfileIdRef() { super(Profile.class) }
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
