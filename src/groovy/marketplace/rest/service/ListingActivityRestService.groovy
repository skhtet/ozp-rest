package marketplace.rest.service

import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.criterion.CriteriaSpecification
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
     * Get all listing activities that match the passed-in parameters.
     * The different filters are combined using AND.
     * @param The organization to filter by.  For those with ROLE_ORG_STEWARD, this must be an
     * org that they are a steward of.  Can be null to match all orgs (or all orgs an Org Steward
     * is steward of).
     */
     @Transactional(readOnly=true)
     @RolesAllowed(['ROLE_ADMIN', 'ROLE_ORG_STEWARD'])
     public List<ListingActivity> getAllMatchingParams(
            Integer offset,
            Integer max) {
        Collection<Agency> agencies = null

        if (profileRestService.isOrgSteward()) {
            agencies = profileRestService.currentUserProfile.stewardedOrganizations
        }

        Long userId = profileRestService.currentUserProfile.id

        //get the listing activity
        ListingActivity.createCriteria().list(max: max, offset: offset) {
            if (profileRestService.isOrgSteward()) {
                listing {
                    or {
                        owners {
                            eq('id', userId)
                        }
                        agency(CriteriaSpecification.LEFT_JOIN) {
                            inList('id', agencies*.id)
                        }
                    }
                }
            }
            order(sorter.sortField, sorter.direction.name().toLowerCase())
        }
    }
}
