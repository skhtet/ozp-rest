package marketplace.rest.service

import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.codehaus.groovy.grails.commons.GrailsApplication
import javax.annotation.security.RolesAllowed
import marketplace.Listing
import marketplace.Agency
import marketplace.Profile
import marketplace.ListingActivity
import marketplace.Constants
import marketplace.Sorter
import marketplace.rest.representation.in.InputRepresentation


@Service
class ListingActivityRestService
        extends ChildObjectRestService<Listing, ListingActivity> {
    @Autowired ProfileRestService profileRestService


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


    /**
     * Get all Listings that match the passed-in parameters.
     * The different filters are combined using AND.
     * @param The organization to filter by.  For those with ROLE_ORG_STEWARD, this must be an
     * org that they are a steward of.  Can be null to match all orgs (or all orgs an Org Steward
     * is steward of).
     * @param approvalStatus The approvalStatus to filter by.  null to match all approvalStatuses
     * @param enabled True to match only enabled listings. false to match only disabled listings.
     * null to match all listings
     */
     @Transactional(readOnly=true)
     @RolesAllowed(['ROLE_ADMIN', 'ROLE_ORG_STEWARD'])
     public List<ListingActivity> getAllMatchingParams(
            Integer offset,
            Integer max,
            InputRepresentation<Agency> org) {
        Agency ag = org ? RestService.getFromDb(org) : null
        Collection<Agency> agencies = null

        if (ag) {
            profileRestService.checkOrgSteward(ag)
            agencies = [ag]
        }
        else if (profileRestService.isOrgSteward()) {
            agencies = profileRestService.currentUserProfile.stewardedOrganizations
        }

        //get the listing activity
        ListingActivity.createCriteria().list(max: max, offset: offset) {
            listing {
                if (agencies != null) {
                    agency {
                        inList('id', agencies*.id)
                    }
                }    
            }

            order(sorter.sortField, sorter.direction.name().toLowerCase())

        }
    }
}
