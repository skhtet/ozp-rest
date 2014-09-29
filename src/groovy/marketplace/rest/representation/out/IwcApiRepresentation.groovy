package marketplace.rest.representation.out

import marketplace.Profile
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.OzpRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcApi
import marketplace.rest.resource.IwcResource
import marketplace.rest.resource.IwcSystemResource
import marketplace.rest.resource.ProfileResource

class IwcApiRepresentation extends SelfRefRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-iwc-v1+json'

    IwcApiRepresentation(IwcApi api,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(IwcResource.class)
                .build(),
            linkResources(api.user, uriBuilderHolder),
            embedResources(api.user, uriBuilderHolder)
        )
    }

    private static HalEmbedded embedResources(Profile user, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded([
                new AbstractMap.SimpleEntry(OzpRelationType.USER, new UserRepresentation(user, uriBuilderHolder)),
                new AbstractMap.SimpleEntry(OzpRelationType.SYSTEM, new IwcSystemRepresentation(uriBuilderHolder))
        ])
    }

    private static HalLinks linkResources(Profile user, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        def createLink = { OzpRelationType rel, String method = null ->
            def userMap = [profileId: user.id, id: user.id]
            def resource = ProfileResource.class

            URI href = method ? uriBuilderHolder.builder.path(resource).path(resource, method).buildFromMap(userMap) :
                    uriBuilderHolder.builder.path(resource).buildFromMap(userMap)

            new AbstractMap.SimpleEntry(rel, new Link(href))
        }

        new HalLinks([
                createLink(OzpRelationType.APPLICATION, 'readApplicationsForCurrentUser'),
                createLink(OzpRelationType.INTENT, 'readIntentsForApplicationsOfCurrentUser'),
                createLink(OzpRelationType.USER_DATA, 'readAllData'),
                createLink(OzpRelationType.USER, 'read'),
                new AbstractMap.SimpleEntry(OzpRelationType.SYSTEM,
                        new Link(uriBuilderHolder.builder.path(IwcSystemResource.class).build()))
        ])
    }

    static class Factory implements RepresentationFactory<IwcApi> {
        public IwcApiRepresentation toRepresentation(
                    IwcApi api,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcApiRepresentation(api, uriBuilderHolder)
        }
    }
}
