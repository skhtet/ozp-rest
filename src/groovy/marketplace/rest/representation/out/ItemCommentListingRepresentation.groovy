package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ItemCommentUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

import marketplace.ItemComment
import marketplace.Listing
import marketplace.Profile

class ItemCommentListingRepresentation extends ItemCommentRepresentation {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-comment-listing-v1+json'
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-listing-comment-listings-v1+json'

    ItemCommentListingRepresentation(
            ItemComment itemComment,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ObjectUriBuilder<ItemComment> itemCommentUriBuilder,
            ObjectUriBuilder<Profile> profileUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
        super(itemComment, listingUriBuilder, itemCommentUriBuilder, profileUriBuilder)

        this.addEmbedded(new HalEmbedded(OzpRelationType.APPLICATION,
            new ListingRepresentation(itemComment.listing, listingUriBuilder, imageUriBuilder)))
    }

    private static class ListingRepresentation extends SelfRefRepresentation<Listing> {
        private Listing listing
        private ImageReferenceUriBuilder imageUriBuilder

        ListingRepresentation(
                Listing listing,
                ObjectUriBuilder<Listing> listingUriBuilder,
                ImageReferenceUriBuilder imageUriBuilder) {
            super(listingUriBuilder.getUri(listing), null, null)

            this.listing = listing
            this.imageUriBuilder = imageUriBuilder
        }

        public long getId() { listing.id }
        public String getTitle() { listing.title }
        public URI getImageSmallUrl() { imageUriBuilder.getImageUri(listing.smallIcon) }
    }

    @Component
    public static class Factory implements RepresentationFactory<ItemComment> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ItemCommentUriBuilder.Factory itemCommentUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

        @Override
        ItemCommentListingRepresentation toRepresentation(ItemComment itemComment,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            new ItemCommentListingRepresentation(itemComment,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                itemCommentUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                imageUriBuilderFactory.getBuilder(uriBuilderHolder)
            )
        }
    }
}

