package marketplace.rest

import marketplace.Contact
import marketplace.Screenshot
import marketplace.ServiceItem
import marketplace.ServiceItemDocumentationUrl

class ListingInputRepresentation extends AbstractInputRepresentation<ServiceItem> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp.listing+json'
    ListingInputRepresentation() {
        super(ServiceItem.class)
    }

    String title
    String launchUrl
    String requirements
    String descriptionShort
    String description
    String imageLargeUrl
    String imageMediumUrl
    String imageSmallUrl
    String imageXlargeUrl
    String versionName
    String whatIsNew
    Set<String> tags

    TypeIdRef types
    Set<IntentIdRef> intents
    Set<ContactInputRepresentation> contacts
    Set<OwnerIdRef> owners
    Set<CategoryIdRef> categories
    AgencyIdRef agency
    Set<ResourceInputRepresentation> docUrls
    List<ScreenshotInputRepresentation> screenshots

    public void setIntents(Collection<String> intents) {
        this.intents = intents.collect { new IntentIdRef(it) }
    }
}

class ResourceInputRepresentation extends AbstractInputRepresentation<ServiceItemDocumentationUrl> {
    ResourceInputRepresentation() {
        super(ServiceItemDocumentationUrl.class)
    }

    String name
    String url
}

class ScreenshotInputRepresentation extends AbstractInputRepresentation<Screenshot> {
    ScreenshotInputRepresentation() {
        super(Screenshot.class)
    }

    String smallImageUrl
    String largeImageUrl
}

class ContactInputRepresentation extends AbstractInputRepresentation<Contact> {
    ContactInputRepresentation() {
        super(Contact.class)
    }

    String email
    String securePhone
    String unsecurePhone
    String organization
    String name
    ContactTypeIdRef type
}