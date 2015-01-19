package marketplace.rest.representation.out

import marketplace.Profile

/**
 * Convenience class for the common use case where a profile appears as a property of some resource (e.g.
 * the author of a listing rejection or the owner of a listing). Note that this differs in purpose from
 * an embedded resource.
 *
 */
class ProfilePropertyRepresentation {
    private Profile owner

    ProfilePropertyRepresentation(Profile owner) {
        this.owner = owner
    }

    Long getId() { owner.id }
    String getUsername() { owner.username }
    String getDisplayName() { owner.displayName }
}
