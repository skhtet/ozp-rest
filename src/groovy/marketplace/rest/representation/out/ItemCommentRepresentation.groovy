package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ItemCommentUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.ItemComment
import marketplace.Listing
import marketplace.Profile

class ItemCommentRepresentation extends SelfRefRepresentation<ItemComment> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-comment-v1+json'
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-listing-comments-v1+json'

    private ItemComment itemComment

    ItemCommentRepresentation(ItemComment itemComment,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ObjectUriBuilder<ItemComment> itemCommentUriBuiler,
            ObjectUriBuilder<Profile> profileUriBuilder) {
        super(
            itemCommentUriBuiler.getUri(itemComment),
            createLinks(itemComment, listingUriBuilder, profileUriBuilder),
            null
        )

        this.itemComment = itemComment
    }

    private static HalLinks createLinks(ItemComment itemComment,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ObjectUriBuilder<Profile> profileUriBuilder) {

        URI appUri = listingUriBuilder.getUri(itemComment.listing),
            authorUri = profileUriBuilder.getUri(itemComment.author)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION, new Link(appUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, new Link(authorUri))
        ])
    }

    public Long getId() { itemComment.id }
    public Integer getRate() { itemComment.rate }
    public String getText() { itemComment.text }

    @Component
    public static class Factory implements RepresentationFactory<ItemComment> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ItemCommentUriBuilder.Factory itemCommentUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        ItemCommentRepresentation toRepresentation(ItemComment itemComment,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            new ItemCommentRepresentation(itemComment,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                itemCommentUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder)
            )
        }
    }
}
