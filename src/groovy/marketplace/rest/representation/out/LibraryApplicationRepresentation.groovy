package marketplace.rest.representation.out

import marketplace.Listing
import marketplace.ApplicationLibraryEntry

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.ProfileResource
import marketplace.rest.resource.ListingResource

/**
 * A representation of a Service Item within the Application Library, with all information needed
 * by the library UI to render it
 */
class LibraryApplicationRepresentation extends SelfRefRepresentation<Listing> {

    private Listing listing

    public LibraryApplicationRepresentation(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(ListingResource.class)
                .path(ListingResource.class, 'read')
                .buildFromMap(id: entry.listing.id),
            createLinks(entry, uriBuilderHolder),
            null
        )

        this.listing = entry.listing
    }

    private static HalLinks createLinks(ApplicationLibraryEntry entry,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        Listing listing = entry.listing
        URI launchUri = new URI(listing.launchUrl),
            libraryEntryUri = uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'removeFromApplicationLibrary')
                .buildFromMap(profileId: entry.owner.id, listingId: listing.id)

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
