package marketplace.rest

import marketplace.ApplicationLibraryEntry

class ApplicationLibrary {
    long profileId
    List<ApplicationLibraryEntry> entries

    ApplicationLibrary(long profileId, List<ApplicationLibraryEntry> entries) {
        this.profileId = profileId
        this.entries = entries
    }
}
