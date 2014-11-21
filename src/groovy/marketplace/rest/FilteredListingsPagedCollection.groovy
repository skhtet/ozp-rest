package marketplace.rest

import marketplace.Listing
import marketplace.FilteredListings
import marketplace.ApprovalStatus

import marketplace.hal.PagedCollection

import marketplace.rest.representation.in.AgencyTitleInputRepresentation

/**
 * A paged collection which carries additional information needed to represent a list of
 * listings created by some filtered query.  This extra information includes the filtering
 * parameters and the counts object created by the filter call
 */
class FilteredListingsPagedCollection extends PagedCollection<Listing> {
    final FilteredListings.Counts counts
    final AgencyTitleInputRepresentation org
    final ApprovalStatus approvalStatus
    final Boolean enabled

    FilteredListingsPagedCollection(
            FilteredListings filteredListings,
            AgencyTitleInputRepresentation org,
            ApprovalStatus approvalStatus,
            Boolean enabled,
            Integer offset,
            Integer max) {
        super(offset, max, filteredListings.listings)

        this.counts = filteredListings.counts
        this.org = org
        this.approvalStatus = approvalStatus
        this.enabled = enabled
    }
}
