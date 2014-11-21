package marketplace.rest

import marketplace.Listing
import marketplace.FilteredListings

import marketplace.hal.PagedCollection

class FilteredListingsPagedCollection extends PagedCollection<Listing> {
    final FilteredListings.Counts counts

    FilteredListingsPagedCollection(Integer offset, Integer max,
            FilteredListings filteredListings) {
        super(offset, max, filteredListings.listings)

        this.counts = filteredListings.counts
    }
}
