package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.ServiceItem

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType
import marketplace.hal.OzpRelationType

@TestMixin(GrailsUnitTestMixin)
class ApplicationLibraryEntryRepresentationUnitTest {
    RepresentationFactory<ApplicationLibraryEntry> factory =
        new ApplicationLibraryEntryRepresentation.Factory()

    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    void testLinks() {
        Profile owner = new Profile()
        owner.id = 16
        ServiceItem serviceItem = new ServiceItem(
            launchUrl: 'https://localhost/'
        )
        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            serviceItem: serviceItem
        )

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/profile/16/library/13'
        assert rep.links.toMap().get(RegisteredRelationType.COLLECTION).href ==
            'https://localhost/asdf/api/profile/16/library'
    }

    void testEmbedded() {
        Profile owner = new Profile()
        owner.id = 16
        ServiceItem serviceItem = new ServiceItem(
            title: 'test app',
            launchUrl: 'https://localhost/'
        )

        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            serviceItem: serviceItem
        )

        ApplicationLibraryEntry libraryApplicationEntry
        ApplicationRootUriBuilderHolder libraryApplicationUriBuilderHolder
        LibraryApplicationRepresentation.metaClass.constructor = { ApplicationLibraryEntry e,
                ApplicationRootUriBuilderHolder ubh ->
            libraryApplicationEntry = e
            libraryApplicationUriBuilderHolder = ubh

            return new AbstractHalRepresentation() {}
        }

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert libraryApplicationEntry.is(entry)
        assert libraryApplicationUriBuilderHolder.is(uriBuilderHolder)
    }

    void testGetServiceItem() {
        Profile owner = new Profile()
        owner.id = 16
        ServiceItem serviceItem = new ServiceItem(
            title: 'test app',
            launchUrl: 'https://localhost/'
        )

        serviceItem.id = 13
        ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
            owner: owner,
            serviceItem: serviceItem
        )

        ApplicationLibraryEntryRepresentation rep =
            factory.toRepresentation(entry, uriBuilderHolder)

        assert rep.serviceItem.id == serviceItem.id
    }
}
