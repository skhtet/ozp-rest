package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

import marketplace.Agency
import marketplace.Profile

import marketplace.rest.StewardedOrganizations
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder

import marketplace.hal.HalLinks
import marketplace.hal.Link

class StewardedOrganizationsRepresentation extends
        SelfRefRepresentation<StewardedOrganizations> {
    StewardedOrganizationsRepresentation(StewardedOrganizations orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ProfileUriBuilder profileUriBuilder) {
        super(
            profileUriBuilder.getStewardedOrganizationsUri(orgs.profile),
            createLinks(orgs, profileUriBuilder),
            createEmbedded(orgs, uriBuilderHolder)
        )
    }

    private static HalLinks createLinks(StewardedOrganizations orgs,
            ResourceUriBuilder<Profile> profileUriBuilder) {
        URI profileUri = profileUriBuilder.getUri(orgs.profile)
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

    @Component
    public static class Factory implements RepresentationFactory<StewardedOrganizations> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        StewardedOrganizationsRepresentation toRepresentation(StewardedOrganizations orgs,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new StewardedOrganizationsRepresentation(orgs, uriBuilderHolder,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
