package marketplace.rest

import marketplace.Profile
import marketplace.Agency

class StewardedOrganizations {
    final Collection<Agency> organizations
    final Profile profile

    StewardedOrganizations(Profile profile) {
        this.organizations = profile.stewardedOrganizations
        this.profile = profile
    }
}
