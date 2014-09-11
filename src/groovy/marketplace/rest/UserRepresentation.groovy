package marketplace.rest

import marketplace.Profile
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

class UserRepresentation extends SelfRefRepresentation<Profile> {
    final String userName
    final String name

    UserRepresentation(Profile user, ApplicationRootUriBuilderHolder uriBuilderHolder, URI requestUri) {
        super(requestUri, null, null)
        this.name = user.displayName
        this.userName = user.username
    }

    static class Factory implements RepresentationFactory<Profile> {
        public UserRepresentation toRepresentation(
                    Profile user,
                    ApplicationRootUriBuilderHolder uriBuilderHolder,
                    URI requestUri) {
            new UserRepresentation(user, uriBuilderHolder, requestUri)
        }
    }
}
