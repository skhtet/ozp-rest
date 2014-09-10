package marketplace.rest

import marketplace.ApplicationLibraryEntry
import marketplace.ServiceItem

class ApplicationLibraryEntryInputRepresentation
        extends AbstractInputRepresentation<ApplicationLibraryEntry> {
    ApplicationLibraryEntryInputRepresentation() {
        super(ApplicationLibraryEntry.class)
    }

    String folder
    ServiceItemIdRef serviceItem
}
