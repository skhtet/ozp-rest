package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ResourceUriBuilder

class UserRepresentation extends SelfRefRepresentation<Profile> {
    final String userName
    final String name

    UserRepresentation(Profile user, ResourceUriBuilder<Profile> profileUriBuilder) {
        super(profileUriBuilder.getUri(user), null, null)

        this.name = user.displayName
        this.userName = user.username
    }

    @Component
    static class Factory implements RepresentationFactory<Profile> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        public UserRepresentation toRepresentation(
                    Profile user,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new UserRepresentation(user,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
