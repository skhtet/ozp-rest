package marketplace.rest

import marketplace.Listing

import marketplace.search.SearchResult

/**
 * This class represents a grouping of all of the listing data needed by the initial page
 * of the UI
 */
class Storefront {
    final List<Listing> featured
    final List<Listing> recent
    final List<Listing> mostPopular

    public Storefront(
            SearchResult<Listing> featuredResults,
            SearchResult<Listing> recentResults,
            SearchResult<Listing> mostPopularResults) {
        featured = featuredResults.items
        recent = recentResults.items
        mostPopular = mostPopularResults.items
    }
}
