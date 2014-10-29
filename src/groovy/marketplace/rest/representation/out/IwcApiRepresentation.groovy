package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcApi
import marketplace.rest.resource.uribuilder.IwcUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder


class IwcApiRepresentation extends SelfRefRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-iwc-v1+json'

    IwcApiRepresentation(IwcApi api,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            IwcUriBuilder iwcUriBuilder,
            ProfileUriBuilder profileUriBuilder,
            RepresentationFactory<Profile> userRepresentationFactory) {
        super(
            iwcUriBuilder.getCollectionUri(),
            linkResources(api.user, iwcUriBuilder, profileUriBuilder),
            embedResources(api.user, uriBuilderHolder, userRepresentationFactory)
        )
    }

    private static HalEmbedded embedResources(Profile user,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            RepresentationFactory<Profile> userRepresentationFactory) {
        new HalEmbedded([
            new AbstractMap.SimpleEntry(OzpRelationType.USER,
                userRepresentationFactory.toRepresentation(user, uriBuilderHolder)),
            new AbstractMap.SimpleEntry(OzpRelationType.SYSTEM,
                new IwcSystemRepresentation(uriBuilderHolder))
        ])
    }

    private static HalLinks linkResources(Profile user, IwcUriBuilder iwcUriBuilder,
            ProfileUriBuilder profileUriBuilder) {
        URI appUri = profileUriBuilder.getApplicationsUri(user),
            intentsUri = profileUriBuilder.getIntentsUri(user),
            userDataUri = profileUriBuilder.getUserDataUri(user),
            userUri = profileUriBuilder.getUri(user),
            systemUri = iwcUriBuilder.getSystemUri()

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION, new Link(appUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.INTENT, new Link(intentsUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.USER_DATA, new Link(userDataUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.USER, new Link(userUri)),
            new AbstractMap.SimpleEntry(OzpRelationType.SYSTEM, new Link(systemUri))
        ])
    }

    @Component
    static class Factory implements RepresentationFactory<IwcApi> {
        @Autowired IwcUriBuilder.Factory iwcUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired UserRepresentation.Factory userRepresentationFactory

        public IwcApiRepresentation toRepresentation(
                    IwcApi api,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcApiRepresentation(api, uriBuilderHolder,
                iwcUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                userRepresentationFactory)
        }
    }
}
