package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Sorter

import marketplace.Listing
import marketplace.ItemComment
import marketplace.Profile

import marketplace.Constants

@Service
class ItemCommentRestService extends ChildObjectRestService<Listing, ItemComment> {
    @Autowired ProfileRestService profileRestService

    @Autowired
    ItemCommentRestService(GrailsApplication grailsApplication,
            ListingRestService listingRestService) {
        super(Listing.class, 'listing', 'itemComments',
            grailsApplication, ItemComment.class,
            listingRestService, null,
            new Sorter<ItemComment>(Constants.SortDirection.DESC, 'editedDate'))
    }

    ItemCommentRestService() {}

    @Override
    public void deleteById(Long id) {
        ItemComment obj = getById(id)
        Listing listing = parentClassRestService.getById(obj.listing.id)

        //ensure that the Listings's statistics are updated
        listing.removeFromItemComments(obj)
        listing.updateRatingStats()

        super.deleteById(id)
    }

    /**
     * Get all ItemComments by the given author, ordered most-recent first.
     * Secondarily sorted by Listing title
     */
    public List<ItemComment> getAllByAuthorId(Long profileId) {
        Profile author = profileRestService.getById(profileId)

        //sort in the application because the primary sort will be all thats necessary almost
        //100% of the time.  If we sort in the database, it'll sort everything by the
        //listing title first and then sort it all by the editedDate
        ItemComment.findAllByAuthor(author).grep { canView(it) }.sort { a, b ->
            //negative for desc
            -(a.editedDate <=> b.editedDate) ?: a.listing.title <=> b.listing.title
        }
    }

    @Override
    protected void authorizeUpdate(ItemComment existing) {
        super.authorizeUpdate(existing)

        //comment authors and admins are allowed
        if (profileRestService.currentUserProfile != existing.author) {
            profileRestService.checkAdmin("Attempt by non-admin to update another user's comment")
        }
    }

    /**
     * Anyone who can view comments on this listing can create new ones
     */
    @Override
    protected void authorizeCreate(ItemComment dto) {
        authorizeView(dto)
    }

    protected void postprocess(ItemComment updated, Map original = null) {
        super.postprocess(updated, original)

        setAuthor(updated)

        if (original) {
            preventNonOwnerRatingChange(updated, original)
        }

        syncListingStats(updated)
        updated.listing.updateRatingStats()
    }

    private void setAuthor(ItemComment comment) {
        if (!comment.author) comment.author = profileRestService.currentUserProfile
    }

    private static void syncListingStats(ItemComment updated) {
        Listing listing = updated.listing
        listing.addToItemComments(updated)   //ensure that the collection is up to date
        listing.updateRatingStats()
    }

    private void preventNonOwnerRatingChange(ItemComment updated, Map original) {
        if (updated.rate != original.rate &&
                profileRestService.currentUserProfile != original.author) {
            throw new AccessDeniedException("Attempt by non-owner to change comment rating")
        }
    }
}
