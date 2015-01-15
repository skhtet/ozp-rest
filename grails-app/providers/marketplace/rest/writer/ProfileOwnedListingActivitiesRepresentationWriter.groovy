package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.ListingActivityRepresentation
import marketplace.rest.representation.out.EmbeddedChildCollectionRepresentation
import marketplace.rest.resource.uribuilder.ProfileUriBuilder
import marketplace.rest.resource.uribuilder.ProfileOwnedListingActivityUriBuilder
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder

import marketplace.rest.ProfileOwnedListingActivities

import marketplace.hal.AbstractRepresentationWriter

import marketplace.Profile
import marketplace.ListingActivity

@Provider
@Produces([
    ListingActivityRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ProfileOwnedListingActivitiesRepresentationWriter extends
        AbstractRepresentationWriter<ProfileOwnedListingActivities> {

    @Autowired
    ProfileOwnedListingActivitiesRepresentationWriter(GrailsApplication grailsApplication,

            ListingActivityRepresentation.Factory factory,
            ProfileOwnedListingActivityUriBuilder.Factory collectionUriBuilderFactory,
            ProfileUriBuilder.Factory parentUriBuilderFactory) {
        super(grailsApplication, EmbeddedChildCollectionRepresentation.createFactory(factory,
                collectionUriBuilderFactory, parentUriBuilderFactory))
    }
}
