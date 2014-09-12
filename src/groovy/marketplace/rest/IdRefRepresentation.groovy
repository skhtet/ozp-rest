package marketplace.rest

import marketplace.Intent
import marketplace.ServiceItem
import marketplace.Types

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
}

class TypeIdRef extends IdRefRepresentation<Types, Long> {
    TypeIdRef() { super(Types.class) }
}