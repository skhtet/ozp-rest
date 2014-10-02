package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * An association between a Profile and a Listing, representing that the
 * Profile has the Listing in their Application Library, in the given folder
 */
@gorm.AuditStamp
class ApplicationLibraryEntry implements Serializable, Comparable<ApplicationLibraryEntry> {
    String folder

    static belongsTo = [owner: Profile, listing: Listing]

    static bindableProperties = ['folder', 'owner', 'listing']
    static modifiableReferenceProperties = []

    static mapping = {
        listing fetch: 'join' //we will pretty much always want the Listing
    }

    static constraints = {
        folder(nullable: true, blank: false, maxSize: 256)
        listing(nullable: false, unique: ['owner'])
    }

    public boolean equals(other) {
        other instanceof ApplicationLibraryEntry &&
            other.owner == this.owner &&
            other.folder == this.folder &&
            other.listing == this.listing
    }

    public int hashCode() {
        int ownerHash = owner?.hashCode() ?: 0
        int folderHash = folder?.hashCode() ?: 0
        int listing = this.listing?.hashCode() ?: 0

        ownerHash ^ folderHash ^ listing
    }

    /**
     * Sort first by owner, then by folder, then by Listing
     */
    public int compareTo(ApplicationLibraryEntry other) {
        int ownerCompare = owner <=> other.owner
        int folderCompare = folder <=> other.folder
        int listingCompare = owner <=> other.owner

        ownerCompare != 0 ? ownerCompare :
            (folderCompare != 0 ? folderCompare : listingCompare)
    }

    JSONObject asJSON() {
        new JSONObject(
            folder: folder,
            listing: new JSONObject(
                id: listing.id,
                title: listing.title,
                imageMediumUrl: listing.imageMediumUrl,
                imageLargeUrl: listing.imageLargeUrl,
                launchUrl: listing.launchUrl
            )
        )
    }
}
