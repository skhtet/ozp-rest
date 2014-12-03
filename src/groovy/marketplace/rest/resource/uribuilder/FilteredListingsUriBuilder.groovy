package marketplace.rest.resource.uribuilder

import java.lang.reflect.Method

import javax.ws.rs.core.UriBuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.FilteredListingsPagedCollection
import marketplace.rest.resource.ListingResource
import marketplace.rest.representation.in.AgencyTitleInputRepresentation

import marketplace.Listing
import marketplace.ApprovalStatus

class FilteredListingsUriBuilder {
    protected ApplicationRootUriBuilderHolder uriBuilderHolder

    FilteredListingsUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.uriBuilderHolder = uriBuilderHolder
    }

    URI getCollectionUri(FilteredListingsPagedCollection collection) {
        AgencyTitleInputRepresentation org = collection.org
        ApprovalStatus approvalStatus = collection.approvalStatus
        Boolean enabled = collection.enabled
        Integer max = collection.max, offset = collection.offset

        UriBuilder uriBuilder = uriBuilderHolder.builder.path(ListingResource)

        if (org) uriBuilder.queryParam('org', org.title)
        if (approvalStatus) uriBuilder.queryParam('approvalStatus', approvalStatus)
        if (enabled) uriBuilder.queryParam('enabled', enabled)
        if (max) uriBuilder.queryParam('max', max)
        if (offset) uriBuilder.queryParam('offset', offset)

        uriBuilder.build()
    }

    CollectionUriBuilder<Listing> getCollectionUriBuilder(
            FilteredListingsPagedCollection collection) {
        { -> getCollectionUri(collection) } as CollectionUriBuilder
    }

    @Component
    public static class Factory {
        FilteredListingsUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new FilteredListingsUriBuilder(uriBuilderHolder)
        }
    }
}
