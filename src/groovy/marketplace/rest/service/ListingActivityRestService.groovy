package marketplace.rest.service

import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.codehaus.groovy.grails.commons.GrailsApplication
import marketplace.Listing
import marketplace.ListingActivity
import marketplace.Constants
import marketplace.Sorter

@Service
class ListingActivityRestService
        extends ChildObjectRestService<Listing, ListingActivity> {

    @Autowired
    ListingActivityRestService(GrailsApplication grailsApplication,
            ListingRestService listingRestService) {

        super(Listing.class, 'listing', 'listingActivities', grailsApplication,
            ListingActivity.class, listingRestService, null,
            new Sorter<ListingActivity>(Constants.SortDirection.DESC, 'activityDate'))
    }

    public ListingActivityRestService() {}

    @Transactional(readOnly=true)
    public List<ListingActivity> getAllByProfileId(Long profileId, Integer offset,
            Integer max) {
        ListingActivity.createCriteria().list(max: max, offset: offset) {
            author {
                eq('id', profileId)
            }

            order(sorter.sortField, sorter.direction.name().toLowerCase())
        }
    }

    /**
     * Get ServiceItemActivities that belong to ServiceItems that have the given author
     */
    @Transactional(readOnly=true)
    public List<ListingActivity> getAllByListingOwnerId(Long profileId, Integer offset,
            Integer max) {
        ListingActivity.createCriteria().list(max: max, offset: offset) {
            listing {
                owners {
                    eq('id', profileId)
                }
            }

            order(sorter.sortField, sorter.direction.name().toLowerCase())
        }
    }
}
