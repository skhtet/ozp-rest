package marketplace.rest

import marketplace.Listing

/**
* This subclass symbolizes a listing activities from listings owned by the parent Profile
*/
class RequiredListingCollection extends ChildObjectCollection<Listing, Listing> {
      RequiredListingCollection(Collection<Listing> listings, Listing parent) {
              super(listings, parent)
          }
}
