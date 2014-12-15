package marketplace.rest.representation.out

import marketplace.Listing
import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

/**
 * A representation of a Service Item within the Application Library, with all information needed
 * by the library UI to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<Listing> {

    private Listing listing
    private ImageReferenceUriBuilder imageUriBuilder

    public LibraryApplicationRepresentation(ApplicationLibraryEntry entry,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ImageReferenceUriBuilder imageUriBuilder) {
        super(
            listingUriBuilder.getUri(entry.listing),
            createLinks(entry, entryUriBuilder),
            null
        )

        this.listing = entry.listing
        this.imageUriBuilder = imageUriBuilder
    }

    private static HalLinks createLinks(ApplicationLibraryEntry entry,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder) {
        String launchUrl = entry.listing.launchUrl
        URI launchUri = launchUrl ? new URI(launchUrl): null,
            libraryEntryUri = entryUriBuilder.getUri(entry)

        Map.Entry launchLinkEntry = launchUri ?
            new AbstractMap.SimpleEntry(RegisteredRelationType.DESCRIBES, new Link(launchUri)) :
            null

        new HalLinks([
            launchLinkEntry,
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, new Link(libraryEntryUri))
        ] - null)
    }

    public String getTitle() { listing.title }
    public String getUuid() { listing.uuid }
    public Map<String, URI> getLaunchUrls() { [default: new URI(listing.launchUrl)] }
    public Map<String, URI> getIcons() {
        [
            small: imageUriBuilder.getImageUri((UUID)listing.smallIconId),
            large: imageUriBuilder.getImageUri((UUID)listing.largeIconId),
            banner: imageUriBuilder.getImageUri((UUID)listing.bannerIconId),
            featuredBanner: imageUriBuilder.getImageUri((UUID)listing.featuredBannerIconId)
        ]
    }
    public long getId() { listing.id }
}
