package marketplace.rest

import marketplace.ServiceItem

class IdRefRepresentation<T> extends AbstractInputRepresentation<T> {
    long id

    IdRefRepresentation(Class<T> cls) { super(cls) }

    T createNewObject() {
        throw new
            UnsupportedOperationException("Objects cannot be created from IdRefRepresentations")
    }
}

class ServiceItemIdRef extends IdRefRepresentation<ServiceItem> {
    ServiceItemIdRef() { super(ServiceItem.class) }
}
