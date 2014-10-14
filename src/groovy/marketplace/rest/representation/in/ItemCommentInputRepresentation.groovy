package marketplace.rest.representation.in

import marketplace.ItemComment

class ItemCommentInputRepresentation extends AbstractInputRepresentation<ItemComment> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-comment-v1+json'

    ItemCommentInputRepresentation() {
        super(ItemComment.class)
    }

    Integer rate
    String text
}
