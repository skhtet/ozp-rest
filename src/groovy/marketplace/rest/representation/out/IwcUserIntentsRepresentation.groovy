package marketplace.rest.representation.out

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserIntents
import marketplace.rest.resource.IntentResource
import marketplace.rest.resource.ProfileResource

class IwcUserIntentsRepresentation extends SelfRefRepresentation<IwcUserIntents> {
    IwcUserIntentsRepresentation(IwcUserIntents userIntents, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'readIntentsForApplicationsOfCurrentUser')
                .buildFromMap([profileId: userIntents.user.id]),
            linkIntents(userIntents.intents, uriBuilderHolder), null
        )
    }

    private static HalLinks linkIntents(Collection<Intent> intents, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalLinks(intents.collect { intent ->
            URI href = uriBuilderHolder.builder
                    .path(IntentResource)
                    .path(IntentResource, 'read')
                    .buildFromMap([id: intent.id])

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    static class Factory implements RepresentationFactory<IwcUserIntents> {
        public IwcUserIntentsRepresentation toRepresentation(
                IwcUserIntents userIntents,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserIntentsRepresentation(userIntents, uriBuilderHolder)
        }
    }
}
