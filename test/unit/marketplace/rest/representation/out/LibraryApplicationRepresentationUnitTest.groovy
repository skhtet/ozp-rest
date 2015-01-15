package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.Listing
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ApplicationLibraryEntryUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

@TestMixin(GrailsUnitTestMixin)
class LibraryApplicationRepresentationUnitTest {
    ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
        getBaseUriBuilder: {
            UriBuilder.fromPath('https://localhost/asdf/')
        }
    ] as UriInfo)

    ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder =
        new ApplicationLibraryEntryUriBuilder(uriBuilderHolder)

    ObjectUriBuilder<Listing> listingUriBuilder =
        new ListingUriBuilder(uriBuilderHolder)

    ImageReferenceUriBuilder ImageReferenceUriBuilder =
        new ImageReferenceUriBuilder(null, null, uriBuilderHolder) {
            URI getImageUri(UUID id) {
                new URI("https://localhost/asdf/image/$id")
            }
        }

    Listing serviceItem = new Listing(
        title: 'Listing 1',
        smallIconId: UUID.randomUUID(),
        largeIconId: UUID.randomUUID(),
        bannerIconId: UUID.randomUUID(),
        featuredBannerIconId: UUID.randomUUID(),
        launchUrl: 'https://localhost/launch'
    )

    Profile profile = new Profile()

    ApplicationLibraryEntry entry = new ApplicationLibraryEntry(
        listing: serviceItem,
        owner: profile
    )

    void setUp() {
        serviceItem.id = 12
        profile.id = 98
    }

    void testLinks() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, entryUriBuilder,
                    listingUriBuilder, ImageReferenceUriBuilder)

        assert rep.links.toMap().get(RegisteredRelationType.DESCRIBES).href ==
            serviceItem.launchUrl

        assert rep.links.toMap().get(RegisteredRelationType.VIA).href ==
            'https://localhost/asdf/api/profile/98/library/12'

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/listing/12'
    }

    void testGetLaunchUrls() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, entryUriBuilder, listingUriBuilder,
                    imageReferenceUriBuilder)

        assert rep.launchUrls.default == new URI(serviceItem.launchUrl)
    }

    void testGetIcons() {
        LibraryApplicationRepresentation rep =
            new LibraryApplicationRepresentation(entry, entryUriBuilder, listingUriBuilder,
                    imageReferenceUriBuilder)

        assert rep.icons.small ==
            new URI("https://localhost/asdf/image/${serviceItem.smallIconId}")
        assert rep.icons.large ==
            new URI("https://localhost/asdf/image/${serviceItem.largeIconId}")
        assert rep.icons.banner ==
            new URI("https://localhost/asdf/image/${serviceItem.bannerIconId}")
        assert rep.icons.featuredBanner ==
            new URI("https://localhost/asdf/image/${serviceItem.featuredBannerIconId}")
    }
}
