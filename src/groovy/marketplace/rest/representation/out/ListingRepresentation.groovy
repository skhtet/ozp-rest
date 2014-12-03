package marketplace.rest.representation.out

import marketplace.Contact
import marketplace.DocUrl
import marketplace.Listing
import marketplace.RejectionListing
import marketplace.Screenshot
import marketplace.ApprovalStatus
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ImageUriBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

class ListingRepresentation extends SelfRefRepresentation<Listing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-listings-v1+json'

    private Listing listing
    private ImageUriBuilder imageUriBuilder

    public ListingRepresentation(
            Listing listing,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ListingUriBuilder listingUriBuilder,
            ImageUriBuilder imageUriBuilder) {
        super(listingUriBuilder.getUri(listing), createLinks(listing, listingUriBuilder), null)

        this.listing = listing
        this.imageUriBuilder = imageUriBuilder
    }

    Long getId() { listing.id }
    Boolean getIsEnabled() { listing.isEnabled }
    Boolean getIsFeatured() { listing.isFeatured }
    String getUuid() { listing.uuid }
    String getTitle() { listing.title }
    String getDescription() { listing.description }
    String getDescriptionShort() { listing.descriptionShort }
    Long getTotalComments() { listing.totalComments }
    String getLaunchUrl() { listing.launchUrl }
    String getImageSmallUrl() { imageUriBuilder.getUri(listing.smallIcon).toString() }
    String getImageMediumUrl() { imageUriBuilder.getUri(listing.largeIcon).toString() }
    String getImageLargeUrl() { imageUriBuilder.getUri(listing.bannerIcon).toString() }
    String getImageXlargeUrl() { imageUriBuilder.getUri(listing.featuredBannerIcon).toString() }
    String getVersionName() { listing.versionName }
    String getRequirements() { listing.requirements }
    String getWhatIsNew() { listing.whatIsNew }
    Date getApprovedDate() { listing.approvedDate }
    Date getEditedDate() { listing.editedDate }
    ApprovalStatus getApprovalStatus() { listing.approvalStatus }
    Collection<String> getTags() { listing.tags ?: [] }
    String getType() { listing.type?.title }
    String getAgency() { listing.agency?.title }
    String getAgencyShort() { listing.agency?.shortName }
    Integer getHeight() { listing.height }
    Integer getWidth() { listing.width }
    Boolean getSingleton() { listing.singleton }

    CurrentRejectionRepresentation getCurrentRejection() { listing.rejectionListings ?
        new CurrentRejectionRepresentation(listing.rejectionListings.first()) : null
    }

    Collection<String> getCategories() { listing.categories.collect { it.title }}

    Collection<String> getIntents() { listing.intents.collect {
        "${it.type}/${it.action}".toString()
    }}

    Collection<ScreenshotRepresentation> getScreenshots() { listing.screenshots.collect {
        new ScreenshotRepresentation(it, imageUriBuilder)
    }}

    Collection<ContactRepresentation> getContacts() { listing.contacts.collect {
        new ContactRepresentation(it)
    }}

    Collection<DocUrlRepresentation> getDocUrls() { listing.docUrls.collect {
        new DocUrlRepresentation(it)
    }}

    Collection<ProfilePropertyRepresentation> getOwners() { listing.owners.collect {
        new ProfilePropertyRepresentation(it)
    }}

    Set<IdRefRepresentation<Listing>> getRequired() {
        listing.required.collect { new IdRefRepresentation(it) }
    }

    private static HalLinks createLinks(Listing listing, ListingUriBuilder listingUriBuilder) {
        URI activitiesUri = listingUriBuilder.getListingActivitiesUri(listing),
            commentsUri = listingUriBuilder.getListingCommentsUri(listing),
            requiredUri = listingUriBuilder.getRequiredListingsUri(listing),
            requiringUri = listingUriBuilder.getRequiringListingsUri(listing)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.ACTIVITY, new Link(activitiesUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.REQUIRED, new Link(requiredUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.REQUIRED_BY, new Link(requiringUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.REVIEW, new Link(commentsUri))
        ])
    }

    @Component
    public static class Factory implements RepresentationFactory<Listing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ImageUriBuilder.Factory imageUriBuilderFactory

        @Override
        public ListingRepresentation toRepresentation(Listing listing,
                                                      ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingRepresentation(listing, uriBuilderHolder,
                    listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                    imageUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}

class ContactRepresentation {
    private Contact contact

    ContactRepresentation(Contact contact) {
        this.contact = contact
    }

    String getName() { contact.name }
    String getOrganization() { contact.organization }
    String getEmail() { contact.email }
    String getUnsecurePhone() { contact.unsecurePhone }
    String getSecurePhone() { contact.securePhone }
    String getType() { contact.type.title }
}

class DocUrlRepresentation {
    private DocUrl docUrl

    DocUrlRepresentation(DocUrl docUrl) {
        this.docUrl = docUrl
    }

    String getName() { docUrl.name }
    String getUrl() { docUrl.url }
}

class ScreenshotRepresentation {
    private Screenshot screenshot
    private ImageUriBuilder imageUriBuilder

    ScreenshotRepresentation(Screenshot screenshot, ImageUriBuilder imageUriBuilder) {
        this.screenshot = screenshot
        this.imageUriBuilder = imageUriBuilder
    }

    String getSmallImageUrl() { imageUriBuilder.getUri(screenshot.smallImage).toString() }
    String getLargeImageUrl() { imageUriBuilder.getUri(screenshot.largeImage).toString() }
}

class CurrentRejectionRepresentation {
    private RejectionListing rejection

    CurrentRejectionRepresentation(RejectionListing rejection) {
        this.rejection = rejection
    }

    ProfilePropertyRepresentation getAuthor() {
        new ProfilePropertyRepresentation(rejection.author)
    }

    String getDescription() {
        rejection.description
    }
}
