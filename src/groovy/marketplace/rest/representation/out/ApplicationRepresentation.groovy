package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.Screenshot
import marketplace.Listing
import marketplace.ApprovalStatus
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.RepresentationFactory
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder

class ApplicationRepresentation extends SelfRefRepresentation<Listing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-application-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-applications-v1+json'

    private Listing listing

    String getName() { listing.title }
    String getType() { listing.type.title }
    String getDescription() { listing.description }
    String getId() { listing.uuid }
    ApprovalStatus getApprovalStatus() { listing.approvalStatus }
    Map<String, String> getLaunchUrls() { [default: listing.launchUrl] }
    Set<String> getTags() { listing.tags }

    List<Map<String, String>> getScreenshots() { listing.screenshots.collect { Screenshot sc ->
        [href: sc.smallImageUrl]
    }}

    Set<Map<String, String>> getIntents() { listing.intents.collect { Intent intent ->
        [type: intent.type, action: intent.action, icon: intent.icon, label: intent.label]
    }}

    UiHintsRepresentation getUiHints() { new UiHintsRepresentation(listing) }

    //TODO: What is state?
    final String state = 'Active'

    ApplicationRepresentation(Listing listing,
            ObjectUriBuilder<Listing> listingUriBuilder) {
        super(listingUriBuilder.getUri(listing), null, null)

        this.listing = listing

        this.addLink(RegisteredRelationType.DESCRIBES, new Link(new URI(listing.launchUrl)))
    }

    @Component
    public static class Factory implements RepresentationFactory<Listing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory

        public ApplicationRepresentation toRepresentation(
                    Listing listing,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ApplicationRepresentation(listing,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}

class UiHintsRepresentation {
    private Listing listing

    UiHintsRepresentation(Listing listing) {
        this.listing = listing
    }

    Integer getHeight() { listing.height }
    Integer getWidth() { listing.width }
    Boolean getSingleton() { listing.singleton }
}
