package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserIntents
import marketplace.rest.resource.uribuilder.IntentUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder

class IwcUserIntentsRepresentation extends SelfRefRepresentation<IwcUserIntents> {
    IwcUserIntentsRepresentation(IwcUserIntents userIntents,
            ProfileUriBuilder profileUriBuilder, ObjectUriBuilder<Intent> intentUriBuilder) {
        super(
            profileUriBuilder.getIntentsUri(userIntents.user),
            linkIntents(userIntents.intents, intentUriBuilder), null
        )
    }

    private static HalLinks linkIntents(Collection<Intent> intents,
            ObjectUriBuilder<Intent> intentUriBuilder) {
        new HalLinks(intents.collect { intent ->
            URI href = intentUriBuilder.getUri(intent)
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    @Component
    static class Factory implements RepresentationFactory<IwcUserIntents> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired IntentUriBuilder.Factory intentUriBuilderFactory

        public IwcUserIntentsRepresentation toRepresentation(
                IwcUserIntents userIntents,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserIntentsRepresentation(userIntents,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder),
                intentUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
