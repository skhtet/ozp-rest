package marketplace.rest

import marketplace.Listing

/**
* This subclass symbolizes a listing activities from listings owned by the parent Profile
*/
class RequiringListingCollection extends ChildObjectCollection<Listing, Listing> {
    RequiringListingCollection(Collection<Listing> listings, Listing parent) {
        super(listings, parent)
    }
}
