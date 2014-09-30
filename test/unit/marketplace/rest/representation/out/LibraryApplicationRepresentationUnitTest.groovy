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
class LibraryApplicationRepresentationUnitTest {
    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    ServiceItem serviceItem = new ServiceItem(
        title: 'Listing 1',
        imageSmallUrl: "https://localhost/small",
        imageMediumUrl: "https://localhost/med",
        imageLargeUrl: "https://localhost/large",
        imageXlargeUrl: "https://localhost/xlarge",
        launchUrl: 'https://localhost/launch',
        uuid: '124q2034985-4952-39'
    )

    Profile profile = new Profile()

    ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
        serviceItem: serviceItem,
        owner: profile
    )

    void setUp() {
        serviceItem.id = 12
        profile.id = 98
    }

    void testLinks() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.DESCRIBES).href ==
            serviceItem.launchUrl

        assert rep.links.toMap().get(RegisteredRelationType.VIA).href ==
            'https://localhost/asdf/api/profile/98/library/12'

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/serviceItem/12'
    }

    void testGetLaunchUrls() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, uriBuilderHolder)

        assert rep.launchUrls.default == new URI(serviceItem.launchUrl)
    }

    void testGetIcons() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, uriBuilderHolder)

        assert rep.icons.small == new URI(serviceItem.imageSmallUrl)
        assert rep.icons.large == new URI(serviceItem.imageMediumUrl)
        assert rep.icons.banner == new URI(serviceItem.imageLargeUrl)
        assert rep.icons.featuredBanner == new URI(serviceItem.imageXlargeUrl)
    }
}
