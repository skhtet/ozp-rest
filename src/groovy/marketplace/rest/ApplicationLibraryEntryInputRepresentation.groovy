package marketplace.rest

import marketplace.ApplicationLibraryEntry
import marketplace.ServiceItem

class ApplicationLibraryEntryInputRepresentation
        extends AbstractInputRepresentation<ApplicationLibraryEntry> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-entry-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-library-v1+json'

    ApplicationLibraryEntryInputRepresentation() {
        super(ApplicationLibraryEntry.class)
    }

    String folder
    ServiceItemIdRef serviceItem
}
