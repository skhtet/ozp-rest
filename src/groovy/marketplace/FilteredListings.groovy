package marketplace

import grails.orm.PagedResultList

/**
 * A class to store the results of a parameter-filtered query of Listings.  This
 * includes the listings themselves (paged) as well as counts of total number of listings
 * matching the query in each org, approvalStatus, and enabled/disabled
 */
class FilteredListings {
    final PagedResultList listings
    final Counts counts

    FilteredListings(PagedResultList listings, Counts counts) {
        if (listings == null || counts == null) {
            throw new NullPointerException()
        }

        this.listings = listings
        this.counts = counts
    }

    public static class Counts {
        final int enabled

        final int inProgress
        final int pending
        final int rejected
        final int approvedOrg
        final int approved

        /**
         * map from agency id to count
         */
        final Map<Object, Integer> agencyCounts

        Counts(int enabled, int inProgress, int pending, int rejected,
                int approvedOrg, int approved, Map<Object, Integer> agencyCounts) {
            this.enabled = enabled
            this.inProgress = inProgress
            this.pending = pending
            this.rejected = rejected
            this.approvedOrg = approvedOrg
            this.approved = approved

            this.agencyCounts = Collections.unmodifiableMap(agencyCounts)
        }
    }
}
