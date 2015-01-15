package marketplace.rest.representation.out

import marketplace.Contact
import marketplace.DocUrl
import marketplace.Listing
import marketplace.RejectionListing
import marketplace.Screenshot
import marketplace.ApprovalStatus
import marketplace.ImageReference

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

class ListingRepresentation extends SelfRefRepresentation<Listing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-listings-v1+json'

    private Listing listing
    private ImageReferenceUriBuilder imageUriBuilder

    public ListingRepresentation(
            Listing listing,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ListingUriBuilder listingUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
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
    Float getAvgRate() { listing.avgRate }
    Integer getTotalVotes() { listing.totalVotes }
    Integer getTotalRate5() { listing.totalRate5 }
    Integer getTotalRate4() { listing.totalRate4 }
    Integer getTotalRate3() { listing.totalRate3 }
    Integer getTotalRate2() { listing.totalRate2 }
    Integer getTotalRate1() { listing.totalRate1 }
    String getLaunchUrl() { listing.launchUrl }

    UUID getSmallIconId() { listing.smallIconId }
    UUID getLargeIconId() { listing.largeIconId }
    UUID getBannerIconId() { listing.bannerIconId }
    UUID getFeaturedBannerIconId() { listing.featuredBannerIconId }

    @Deprecated
    String getImageSmallUrl() {
        listing.smallIconId ? imageUriBuilder.getImageUri(listing.smallIconId).toString() : null
    }

    @Deprecated
    String getImageMediumUrl() {
        listing.largeIconId ? imageUriBuilder.getImageUri(listing.largeIconId).toString() : null
    }

    @Deprecated
    String getImageLargeUrl() {
        listing.bannerIconId ? imageUriBuilder.getImageUri(listing.bannerIconId).toString() : null
    }

    @Deprecated
    String getImageXlargeUrl() {
        listing.featuredBannerIconId ?
            imageUriBuilder.getImageUri(listing.featuredBannerIconId).toString() : null
    }

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
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

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
    private ImageReferenceUriBuilder imageUriBuilder

    ScreenshotRepresentation(Screenshot screenshot, ImageReferenceUriBuilder imageUriBuilder) {
        this.screenshot = screenshot
        this.imageUriBuilder = imageUriBuilder
    }

    UUID getSmallImageId() { screenshot.smallImageId }

    UUID getLargeImageId() { screenshot.largeImageId }

    @Deprecated
    String getSmallImageUrl() {
        screenshot.smallImageId ? imageUriBuilder.getImageUri(screenshot.smallImageId).toString() : null
    }

    @Deprecated
    String getLargeImageUrl() {
        screenshot.largeImageId ? imageUriBuilder.getImageUri(screenshot.largeImageId).toString() : null
    }
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
