package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Listing

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

/**
* Convenience class for the common use case where a profile appears as a property of some resource (e.g.
* the author of a listing rejection or the owner of a listing). Note that this differs in purpose from
* an embedded resource.
*
*/
class ListingActivityListingRepresentation extends AbstractHalRepresentation<Listing> {

    private Listing listing
    private ImageReferenceUriBuilder imageReferenceUriBuilder

    ListingActivityListingRepresentation(Listing listing,
        ApplicationRootUriBuilderHolder uriBuilderHolder,
        ImageReferenceUriBuilder imageReferenceUriBuilder) {
            this.imageReferenceUriBuilder = imageReferenceUriBuilder
            this.listing = listing
    }

    Long getId() { listing.id }
    String getTitle() { listing.title }
    String getAgency() { listing.agency }
    String getIconUrl() {
        if(listing.largeIconId){
            imageReferenceUriBuilder.getImageUri(listing.largeIconId)
        }        
    }

    @Component
    public static class Factory implements RepresentationFactory<Listing> {
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

        @Override
        public ListingActivityListingRepresentation toRepresentation(Listing listing,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new ListingActivityListingRepresentation(listing, uriBuilderHolder,
                    imageUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
