package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

import marketplace.Listing
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.ApplicationLibraryEntry

class SimpleApplicationLibraryEntryRepresentation extends AbstractHalRepresentation {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-entry-simple-v1+json'

    private ApplicationLibraryEntry entry
    private ImageReferenceUriBuilder imageUriBuilder

    private SimpleApplicationLibraryEntryRepresentation(
            ApplicationLibraryEntry entry,
            ImageReferenceUriBuilder imageUriBuilder) {
        this.entry = entry
        this.imageUriBuilder = imageUriBuilder
    }

    public String getFolder() { entry.folder }
    public SimpleLibraryApplicationRepresentation getListing() {
        new SimpleLibraryApplicationRepresentation(entry.listing, imageUriBuilder)
    }

    private static class SimpleLibraryApplicationRepresentation {
        private Listing listing
        private ImageReferenceUriBuilder imageUriBuilder

        SimpleLibraryApplicationRepresentation(Listing listing,
                ImageReferenceUriBuilder imageUriBuilder) {
            this.listing = listing
            this.imageUriBuilder = imageUriBuilder
        }

        public long getId() { listing.id }
        public String getUuid() { listing.uuid }
        public String getTitle() { listing.title }
        public URI getImageSmallUrl() {
            UUID id = listing.smallIconId
            id ? imageUriBuilder.getImageUri(id) : null
        }
        public URI getImageMediumUrl() {
            UUID id = listing.largeIconId
            id ? imageUriBuilder.getImageUri(id) : null
        }
        public URI getImageLargeUrl() {
            UUID id = listing.bannerIconId
            id ? imageUriBuilder.getImageUri(id) : null
        }
        public URI getImageXlargeUrl() {
            UUID id = listing.featuredBannerIconId
            id ? imageUriBuilder.getImageUri(id) : null
        }
        public URI getLaunchUrl() { new URI(listing.launchUrl) }
    }

    @Component
    public static class Factory implements
            RepresentationFactory<ApplicationLibraryEntry> {
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

        SimpleApplicationLibraryEntryRepresentation toRepresentation(
                ApplicationLibraryEntry entry,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new SimpleApplicationLibraryEntryRepresentation(entry,
                    imageUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
