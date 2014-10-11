package marketplace.rest.representation.in

import marketplace.Contact
import marketplace.Screenshot
import marketplace.Listing
import marketplace.DocUrl
import marketplace.ApprovalStatus

class ListingInputRepresentation extends AbstractInputRepresentation<Listing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-v1+json'

    ListingInputRepresentation() {
        super(Listing.class)
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
    Boolean isFeatured = false
    Boolean isEnabled = true
    Set<String> tags
    ApprovalStatus approvalStatus = ApprovalStatus.IN_PROGRESS
    TypeTitleInputRepresentation type
    Set<IntentPropertyRefInputRepresentation> intents
    Set<ContactInputRepresentation> contacts
    Set<ProfilePropertyInputRepresentation> owners
    Set<CategoryTitleInputRepresentation> categories
    AgencyTitleInputRepresentation agency
    Set<ResourceInputRepresentation> docUrls
    List<ScreenshotInputRepresentation> screenshots

    public void setType(String typeTitle) {
        this.type = new TypeTitleInputRepresentation(typeTitle)
    }

    public void setAgency(String agencyTitle) {
        this.agency = new AgencyTitleInputRepresentation(agencyTitle)
    }

    public void setCategories(Collection<String> categoryTitles) {
        this.categories = categoryTitles.collect { new CategoryTitleInputRepresentation(it) }
    }

    public void setIntents(Collection<String> intents) {
        this.intents = intents.collect { new IntentPropertyRefInputRepresentation(it) }
    }

    public void setApprovalStatus(String status) {
        this.approvalStatus = ApprovalStatus.findByStatus(status)
    }
}

class ResourceInputRepresentation extends AbstractInputRepresentation<DocUrl> {
    ResourceInputRepresentation() {
        super(DocUrl.class)
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
    ContactTypeTitleInputRepresentation type

    public void setType(String typeTitle) {
        this.type = new ContactTypeTitleInputRepresentation(typeTitle)
    }

}
