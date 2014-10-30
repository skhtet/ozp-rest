package marketplace.rest.representation.out

import marketplace.Listing
import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ObjectUriBuilder

/**
 * A representation of a Service Item within the Application Library, with all information needed
 * by the library UI to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<Listing> {

    private Listing listing

    public LibraryApplicationRepresentation(ApplicationLibraryEntry entry,
            ObjectUriBuilder<ApplicationLibraryEntry> entryUriBuilder,
            ObjectUriBuilder<Listing> listingUriBuilder) {
        super(
            listingUriBuilder.getUri(entry.listing),
            createLinks(entry, entryUriBuilder),
            null
        )

        this.listing = entry.listing
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
            small: new URI(listing.imageSmallUrl),
            large: new URI(listing.imageMediumUrl),
            banner: new URI(listing.imageLargeUrl),
            featuredBanner: new URI(listing.imageXlargeUrl)
        ]
    }
    public long getId() { listing.id }
}
