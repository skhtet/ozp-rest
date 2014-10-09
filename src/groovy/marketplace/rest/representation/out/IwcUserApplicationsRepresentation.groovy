package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserApplications
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder

class IwcUserApplicationsRepresentation extends SelfRefRepresentation<IwcUserApplications> {
    IwcUserApplicationsRepresentation(IwcUserApplications userApplications,
            ProfileUriBuilder profileUriBuilder,
            ResourceUriBuilder<Listing> listingUriBuilder) {
        super(profileUriBuilder.getApplicationsUri(userApplications.user),
            linkApplications(userApplications.listings, listingUriBuilder), null)
    }

    private static HalLinks linkApplications(Collection<Listing> items,
            ResourceUriBuilder<Listing> listingUriBuilder) {
        new HalLinks(items.collect { item ->
            URI href = listingUriBuilder.getUri(item)
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    @Component
    static class Factory implements RepresentationFactory<IwcUserApplications> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired ListingUriBuilder.Factory listingUriBuilerFactory

        public IwcUserApplicationsRepresentation toRepresentation(
                IwcUserApplications userApplications,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserApplicationsRepresentation(userApplications,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                listingUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
