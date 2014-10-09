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

import marketplace.rest.ChildObjectCollection
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder

import marketplace.hal.HalLinks
import marketplace.hal.Link

class StewardedOrganizationsRepresentation extends
        SelfRefRepresentation<ChildObjectCollection<Profile, Agency>> {
    StewardedOrganizationsRepresentation(ChildObjectCollection<Profile, Agency> orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            ProfileUriBuilder profileUriBuilder) {
        super(
            profileUriBuilder.getStewardedOrganizationsUri(orgs.profile),
            createLinks(orgs, profileUriBuilder),
            createEmbedded(orgs, uriBuilderHolder)
        )
    }

    private static HalLinks createLinks(ChildObjectCollection<Profile, Agency> orgs,
            ResourceUriBuilder<Profile> profileUriBuilder) {
        URI profileUri = profileUriBuilder.getUri(orgs.profile)
        new HalLinks(RegisteredRelationType.VIA, new Link(profileUri))
    }

    private static HalEmbedded createEmbedded(ChildObjectCollection<Profile, Agency> orgs,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        RepresentationFactory<Agency> factory = new AgencyRepresentation.Factory()

        new HalEmbedded(orgs.organizations.collect {
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    factory.toRepresentation(it, uriBuilderHolder))
        })
    }

    @Component
    public static class Factory implements
            RepresentationFactory<ChildObjectCollection<Profile, Agency>> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        StewardedOrganizationsRepresentation toRepresentation(
                ChildObjectCollection<Profile, Agency> orgs,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new StewardedOrganizationsRepresentation(orgs, uriBuilderHolder,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
