package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.ItemComment

import marketplace.rest.representation.out.ItemCommentListingRepresentation
import marketplace.rest.resource.uribuilder.ProfileItemCommentUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

@Provider
@Produces([
    ItemCommentListingRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfileItemCommentsRepresentationWriter extends
        ChildObjectCollectionWriter<Profile, ItemComment> {
    @Autowired
    ProfileItemCommentsRepresentationWriter(
            ItemCommentListingRepresentation.Factory itemCommentRepresentationFactory,
            ProfileItemCommentUriBuilder.Factory profileItemCommentUriBuilderFactory,
            ProfileUriBuilder.Factory profileUriBuilderFactory) {
        super(itemCommentRepresentationFactory, profileItemCommentUriBuilderFactory,
            profileUriBuilderFactory)
    }
}
