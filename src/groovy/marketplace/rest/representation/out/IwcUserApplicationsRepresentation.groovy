package marketplace.rest.representation.out

import marketplace.ServiceItem
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserApplications
import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ServiceItemResource

class IwcUserApplicationsRepresentation extends SelfRefRepresentation<IwcUserApplications> {
    IwcUserApplicationsRepresentation(IwcUserApplications userApplications, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'readApplicationsForCurrentUser')
                .buildFromMap([profileId: userApplications.user.id]),
            linkApplications(userApplications.listings, uriBuilderHolder), null)
    }

    private static HalLinks linkApplications(Collection<ServiceItem> items, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalLinks(items.collect { item ->
            URI href = uriBuilderHolder.builder
                    .path(ServiceItemResource)
                    .path(ServiceItemResource, 'read')
                    .buildFromMap([id: item.id])

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    static class Factory implements RepresentationFactory<IwcUserApplications> {
        public IwcUserApplicationsRepresentation toRepresentation(
                IwcUserApplications userApplications,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserApplicationsRepresentation(userApplications, uriBuilderHolder)
        }
    }
}
