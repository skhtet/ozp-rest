package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.RejectionListing
import marketplace.Listing
import marketplace.Profile

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType
import marketplace.hal.AbstractHalRepresentation

import marketplace.rest.resource.uribuilder.DomainResourceUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

class RejectionListingRepresentation extends AbstractHalRepresentation<RejectionListing> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-rejection-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-listing-rejections-v1+json'

    private RejectionListing rejection

    RejectionListingRepresentation(RejectionListing rejection,
            DomainResourceUriBuilder<Listing> listingUriBuilder,
            DomainResourceUriBuilder<Profile> profileUriBuilder) {
        super(
            createLinks(rejection, listingUriBuilder, profileUriBuilder),
            null
        )

        this.rejection = rejection
    }

    private static HalLinks createLinks(RejectionListing rejection,
            DomainResourceUriBuilder<Listing> listingUriBuilder,
            DomainResourceUriBuilder<Profile> profileUriBuilder) {
        URI listingUri = listingUriBuilder.getUri(rejection.serviceItem),
            authorUri = profileUriBuilder.getUri(rejection.author)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION, new Link(listingUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, new Link(authorUri))
        ])
    }

    String getDescription() { rejection.description }

    @Component
    public static class Factory extends RepresentationFactory<RejectionListing> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        public RejectionListingRepresentation toRepresentation(RejectionListing rejection,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new RejectionListingRepresentation(rejection,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
