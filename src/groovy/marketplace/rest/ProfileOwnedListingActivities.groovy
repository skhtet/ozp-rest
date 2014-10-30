package marketplace.rest

import marketplace.Profile
import marketplace.ListingActivity

/**
 * This subclass symbolizes a listing activities from listings owned by the parent Profile
 */
class ProfileOwnedListingActivities extends
        PagingChildObjectCollection<Profile, ListingActivity> {
    ProfileOwnedListingActivities(Collection<ListingActivity> activities, Profile parent,
            Long offset, Long max) {
        super(activities, parent, offset, max)
    }
}
