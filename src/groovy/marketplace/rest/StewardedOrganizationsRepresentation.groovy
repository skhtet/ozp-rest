package marketplace.rest

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

import marketplace.Agency


class StewardedOrganizationsRepresentation extends
        SelfRefRepresentation<StewardedOrganizations> {
    StewardedOrganizationsRepresentation(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(createSelfLink(orgs, uriBuilderHolder), null,
            createEmbedded(orgs, uriBuilderHolder))
    }

    private static URI createSelfLink(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        uriBuilderHolder.builder
            .path(ProfileResource.class)
            .path(ProfileResource.class, 'getStewardedOrganizations')
            .buildFromMap(profileId: orgs.profile.id)
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
