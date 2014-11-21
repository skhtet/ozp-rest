package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import com.fasterxml.jackson.annotation.JsonProperty

import marketplace.Listing
import marketplace.FilteredListings

import marketplace.hal.RepresentationFactory
import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.FilteredListingsUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.FilteredListingsPagedCollection

class FilteredListingsRepresentation extends EmbeddedCollectionRepresentation<Listing> {
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-listings-filtered-v1+json'

    private FilteredListings.Counts counts

    FilteredListingsRepresentation(
            RepresentationFactory<Listing> listingRepFactory,
            FilteredListingsUriBuilder filteredListingsUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder,
            FilteredListingsPagedCollection collection,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            listingRepFactory,
            filteredListingsUriBuilder.getCollectionUriBuilder(collection),
            listingUriBuilder,
            collection,
            uriBuilderHolder
        )

        this.counts = collection.counts
    }

    public CountsRepresentation getCounts() { return new CountsRepresentation(this.counts) }

    private static class CountsRepresentation {
        private FilteredListings.Counts counts

        CountsRepresentation(FilteredListings.Counts counts) {
            this.counts = counts
        }

        public int getEnabled() { return counts.enabled }

        @JsonProperty('IN_PROGRESS')
        public int getInProgress() { return counts.inProgress }
        @JsonProperty('PENDING')
        public int getPending() { return counts.pending }
        @JsonProperty('REJECTED')
        public int getRejected() { return counts.rejected }
        @JsonProperty('APPROVED_ORG')
        public int getApprovedOrg() { return counts.approvedOrg }
        @JsonProperty('APPROVED')
        public int getApproved() { return counts.approved }

        public Map<String, Integer> getOrganizations() {
            return counts.agencyCounts.inject([:]) { acc, k, v ->
                k ? acc + [new AbstractMap.SimpleEntry(k.toString(), v)] : acc
            }
        }
    }

    @Component
    public static class Factory implements
            RepresentationFactory<FilteredListingsPagedCollection> {
        @Autowired ListingRepresentation.Factory listingRepFactory
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired FilteredListingsUriBuilder.Factory filteredListingsUriBuilderFactory

        FilteredListingsRepresentation toRepresentation(
                FilteredListingsPagedCollection collection,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new FilteredListingsRepresentation(
                    listingRepFactory,
                    filteredListingsUriBuilderFactory.getBuilder(uriBuilderHolder),
                    listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                    collection,
                    uriBuilderHolder)
        }
    }
}
