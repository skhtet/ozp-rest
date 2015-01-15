package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.Listing

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.ChildObjectCollection

@TestMixin(GrailsUnitTestMixin)
class ApplicationLibraryEntryRepresentationUnitTest {
    RepresentationFactory<ApplicationLibraryEntry> factory
    ApplicationRootUriBuilderHolder uriBuilderHolder

    void setUp() {
        factory = new ApplicationLibraryEntryRepresentation.Factory()

        uriBuilderHolder = new ApplicationRootUriBuilderHolder(
            new DefaultGrailsApplication(),
            [
                getBaseUriBuilder: {
                    UriBuilder.fromPath('https://localhost/asdf/')
                }
            ] as UriInfo
        )

        factory.entryUriBuilderFactory = new ApplicationLibraryEntryUriBuilder.Factory() {
            ApplicationLibraryEntryUriBuilder getBuilder(
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ApplicationLibraryEntryUriBuilder(null) {
                    URI getUri(ApplicationLibraryEntry entry) {
                        new URI('https://localhost/asdf/api/entry/1')
                    }

                    URI getCollectionUri(ChildObjectCollection collection) {
                        new URI('https://localhost/asdf/api/profile/entry')
                    }
                    URI getCollectionUri(Profile parent) {
                        new URI('https://localhost/asdf/api/profile/entry')
                    }
                }
            }
        }
        factory.listingUriBuilderFactory = new ListingUriBuilder.Factory() {
            ListingUriBuilder getBuilder(
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ListingUriBuilder(null) {
                    URI getUri(Listing entry) {
                        new URI('https://localhost/asdf/api/listing/1')
                    }
                }
            }
        }
        factory.imageReferenceUriBuilderFactory = new ImageReferenceUriBuilder.Factory() {
            ImageReferenceUriBuilder getBuilder(
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new ImageReferenceUriBuilder(null, null, null) {
                    URI getImageUri(UUID id) {
                        new URI("https://localhost/asdf/api/image/$id")
                    }
                }
            }
        }
    }

    void testLinks() {
        Profile owner = new Profile()
        owner.id = 16
        Listing serviceItem = new Listing(
            launchUrl: 'https://localhost/'
        )
        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            listing: serviceItem
        )

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/entry/1'
        assert rep.links.toMap().get(RegisteredRelationType.COLLECTION).href ==
            'https://localhost/asdf/api/profile/entry'
    }

    void testEmbedded() {
        Profile owner = new Profile()
        owner.id = 16
        Listing serviceItem = new Listing(
            title: 'test app',
            launchUrl: 'https://localhost/'
        )

        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            listing: serviceItem
        )

        ApplicationLibraryEntry libraryApplicationEntry
        LibraryApplicationRepresentation.metaClass.constructor = { ApplicationLibraryEntry e,
                ObjectUriBuilder entryUriBuilder, ObjectUriBuilder listingUriBuilder,
                ImageReferenceUriBuilder imageUriBuilder ->
            libraryApplicationEntry = e

            return new AbstractHalRepresentation() {}
        }

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert libraryApplicationEntry.is(entry)
    }

    void testGetServiceItem() {
        Profile owner = new Profile()
        owner.id = 16
        Listing serviceItem = new Listing(
            title: 'test app',
            launchUrl: 'https://localhost/'
        )

        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            listing: serviceItem
        )

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert rep.listing.id == serviceItem.id
    }
}
