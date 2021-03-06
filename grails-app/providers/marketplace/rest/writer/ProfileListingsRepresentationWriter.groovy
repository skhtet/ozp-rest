package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Profile
import marketplace.Listing

import marketplace.rest.representation.out.ListingRepresentation
import marketplace.rest.resource.uribuilder.ProfileListingUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

@Provider
@Produces([
    ListingRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfileListingsRepresentationWriter extends ChildObjectCollectionWriter<Profile, Listing> {
    @Autowired
    ProfileListingsRepresentationWriter(
            GrailsApplication grailsApplication,
            ListingRepresentation.Factory listingRepresentationFactory,
            ProfileListingUriBuilder.Factory profileListingUriBuilderFactory,
            ProfileUriBuilder.Factory profileUriBuilderFactory) {
        super(grailsApplication, listingRepresentationFactory, profileListingUriBuilderFactory,
            profileUriBuilderFactory)
    }
}
