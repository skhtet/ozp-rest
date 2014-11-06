package marketplace.rest.representation.in

import marketplace.Profile

class ProfileInputRepresentation extends AbstractInputRepresentation<Profile> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-profile-v1+json'

    ProfileInputRepresentation() {
        super(Profile.class)
    }

    String bio
    Set<AgencyTitleInputRepresentation> organizations
    Set<AgencyTitleInputRepresentation> stewardedOrganizations
}
