package marketplace.rest.representation.out

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

import marketplace.Agency

import marketplace.rest.StewardedOrganizations
import marketplace.rest.resource.ProfileResource

import marketplace.hal.HalLinks
import marketplace.hal.Link

class StewardedOrganizationsRepresentation extends
        SelfRefRepresentation<StewardedOrganizations> {
    StewardedOrganizationsRepresentation(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(createSelfLink(orgs, uriBuilderHolder), createLinks(orgs, uriBuilderHolder),
            createEmbedded(orgs, uriBuilderHolder))
    }

    private static URI createSelfLink(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getStewardedOrganizations')
            .buildFromMap(profileId: orgs.profile.id)
    }

    private static HalLinks createLinks(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        URI profileUri = uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'read')
                .buildFromMap(id: orgs.profile.id)

        new HalLinks(RegisteredRelationType.VIA, new Link(profileUri))
    }

    private static HalEmbedded createEmbedded(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        RepresentationFactory<Agency> factory = new AgencyRepresentation.Factory()

        new HalEmbedded(orgs.organizations.collect {
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    factory.toRepresentation(it, uriBuilderHolder))
        })
    }

    public static class Factory implements RepresentationFactory<StewardedOrganizations> {
        StewardedOrganizationsRepresentation toRepresentation(StewardedOrganizations orgs,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new StewardedOrganizationsRepresentation(orgs, uriBuilderHolder)
        }
    }
}
