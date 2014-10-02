package marketplace.rest

import marketplace.Intent
import marketplace.IwcDataObject
import marketplace.Profile
import marketplace.Listing

class IwcApi {
    Profile user

    IwcApi(Profile user) {
        this.user = user
    }
}

class IwcUserApplications {
    Collection<Listing> listings
    Profile user

    IwcUserApplications(Collection<Listing> listings, Profile user) {
        this.listings = listings
        this.user = user
    }
}

class IwcUserIntents {
    Collection<Intent> intents
    Profile user

    IwcUserIntents(Collection<Intent> intents, Profile user) {
        this.intents = intents
        this.user = user
    }

}

class IwcUserData {
    Collection<IwcDataObject> dataObjects
    Profile user

    IwcUserData(Collection<IwcDataObject> dataObjects, Profile user) {
        this.dataObjects = dataObjects
        this.user = user
    }
}