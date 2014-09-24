package marketplace.rest.representation.out

import marketplace.Profile
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.ProfileResource

class UserRepresentation extends SelfRefRepresentation<Profile> {
    final String userName
    final String name

    UserRepresentation(Profile user, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'read')
                .buildFromMap(id: user.id),
            null,
            null
        )

        this.name = user.displayName
        this.userName = user.username
    }

    static class Factory implements RepresentationFactory<Profile> {
        public UserRepresentation toRepresentation(
                    Profile user,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new UserRepresentation(user, uriBuilderHolder)
        }
    }
}
