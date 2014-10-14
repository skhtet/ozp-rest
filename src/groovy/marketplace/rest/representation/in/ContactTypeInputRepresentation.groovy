package marketplace.rest.representation.in

import marketplace.ContactType

class ContactTypeInputRepresentation extends AbstractInputRepresentation<ContactType> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-contact-type-v1+json'

    ContactTypeInputRepresentation() {
        super(ContactType.class)
    }

    String title
    boolean required = false
}
