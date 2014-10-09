package marketplace.rest.representation.out

import marketplace.Listing
import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ResourceUriBuilder

/**
 * A representation of a Service Item within the Application Library, with all information needed
 * by the library UI to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<Listing> {

    private Listing listing

    public LibraryApplicationRepresentation(ApplicationLibraryEntry entry,
            ResourceUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ResourceUriBuilder<Listing> listingUriBuilder) {
        super(
            listingUriBuilder.getUri(entry.listing),
            createLinks(entry, entryUriBuilder),
            null
        )

        this.listing = entry.listing
    }

    private static HalLinks createLinks(ApplicationLibraryEntry entry,
            ResourceUriBuilder<ApplicationLibraryEntry> entryUriBuilder) {
        URI launchUri = new URI(entry.listing.launchUrl),
            libraryEntryUri = entryUriBuilder.getUri(entry)
        new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.DESCRIBES, new Link(launchUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, new Link(libraryEntryUri))
        ])
    }

    public String getTitle() { listing.title }
    public String getUuid() { listing.uuid }
    public Map<String, URI> getLaunchUrls() { [default: new URI(listing.launchUrl)] }
    public Map<String, URI> getIcons() {
        [
            small: new URI(listing.imageSmallUrl),
            large: new URI(listing.imageMediumUrl),
            banner: new URI(listing.imageLargeUrl),
            featuredBanner: new URI(listing.imageXlargeUrl)
        ]
    }
    public long getId() { listing.id }
}
