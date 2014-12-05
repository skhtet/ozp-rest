package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import com.fasterxml.jackson.annotation.JsonValue

import marketplace.ApplicationLibraryEntry
import marketplace.Profile
import marketplace.Listing

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.SelfRefRepresentation
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

import marketplace.rest.ChildObjectCollection


class SimpleApplicationLibraryRepresentation extends
        AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-simple-v1+json'

    private List<ApplicationLibraryEntry> library
    private ImageReferenceUriBuilder imageUriBuilder

    private SimpleApplicationLibraryRepresentation(
            Collection<ApplicationLibraryEntry> library,
            ImageReferenceUriBuilder imageUriBuilder) {
        this.library = library as List
        this.imageUriBuilder = imageUriBuilder
    }

    @JsonValue
    public List<SimpleApplicationLibraryEntryRepresentation> asJsonList() {
        library.collect {
            new SimpleApplicationLibraryEntryRepresentation(it, imageUriBuilder)
        }
    }

    private static class SimpleApplicationLibraryEntryRepresentation {

        private ApplicationLibraryEntry entry
        private ImageReferenceUriBuilder imageUriBuilder

        SimpleApplicationLibraryEntryRepresentation(
                ApplicationLibraryEntry entry,
                ImageReferenceUriBuilder imageUriBuilder) {
            this.entry = entry
            this.imageUriBuilder = imageUriBuilder
        }

        public String getFolder() { entry.folder }
        public SimpleLibraryApplicationRepresentation getListing() {
            new SimpleLibraryApplicationRepresentation(entry.listing, imageUriBuilder)
        }
    }

    private static class SimpleLibraryApplicationRepresentation {
        private Listing listing
        private ImageReferenceUriBuilder imageUriBuilder

        SimpleLibraryApplicationRepresentation(Listing listing, ImageReferenceUriBuilder imageUriBuilder) {
            this.listing = listing
            this.imageUriBuilder = imageUriBuilder
        }

        public long getId() { listing.id }
        public String getUuid() { listing.uuid }
        public String getTitle() { listing.title }
        public URI getImageSmallUrl() { imageUriBuilder.getUri(listing.smallIcon) }
        public URI getImageMediumUrl() { imageUriBuilder.getUri(listing.largeIcon) }
        public URI getImageLargeUrl() { imageUriBuilder.getUri(listing.bannerIcon) }
        public URI getImageXlargeUrl() { imageUriBuilder.getUri(listing.featuredBannerIcon) }
        public URI getLaunchUrl() { new URI(listing.launchUrl) }
    }

    @Component
    public static class Factory implements
            RepresentationFactory<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {
        @Autowired ImageReferenceUriBuilder.Factory imageUriBuilderFactory

        @Override
        SimpleApplicationLibraryRepresentation toRepresentation(
                ChildObjectCollection<Profile, ApplicationLibraryEntry>  entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            new SimpleApplicationLibraryRepresentation(entries,
                imageUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}

