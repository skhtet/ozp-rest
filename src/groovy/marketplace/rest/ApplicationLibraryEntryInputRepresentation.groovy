package marketplace.rest

import marketplace.ApplicationLibraryEntry
import marketplace.ServiceItem

class ApplicationLibraryEntryInputRepresentation
        extends AbstractInputRepresentation<ApplicationLibraryEntry> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp.library.entry+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp.library+json'

    ApplicationLibraryEntryInputRepresentation() {
        super(ApplicationLibraryEntry.class)
    }

    String folder
    ServiceItemIdRef serviceItem
}
