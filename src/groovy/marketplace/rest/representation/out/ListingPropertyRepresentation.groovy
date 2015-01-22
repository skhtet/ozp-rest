package marketplace.rest.representation.out

import marketplace.Listing

/**
* Convenience class for the common use case where a profile appears as a property of some resource (e.g.
* the author of a listing rejection or the owner of a listing). Note that this differs in purpose from
* an embedded resource.
*
*/
class ListingPropertyRepresentation {
    private Listing listing

    ListingPropertyRepresentation(Listing listing) {
        this.listing = listing
    }

    Long getId() { listing.id }
    String getTitle() { listing.title }
    String getAgency() { listing.agency }
}
