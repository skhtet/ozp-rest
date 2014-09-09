package marketplace.rest

import marketplace.ApplicationLibraryEntry
import marketplace.ServiceItem

class ApplicationLibraryEntryInputRepresentation
        extends AbstractInputRepresentation<ApplicationLibraryEntry> {
    String folder
    IdRefRepresentation<ServiceItem> serviceItem
}
