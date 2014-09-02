package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Profile
import marketplace.ApplicationLibraryEntry

import marketplace.Constants
import marketplace.Sorter

@Service
class ApplicationLibraryEntryRestService
        extends ChildObjectRestService<Profile, ApplicationLibraryEntry> {

    @Autowired
    ApplicationLibraryEntryRestService(GrailsApplication grailsApplication,
            ProfileRestService profileRestService) {
        super(Profile.class, 'owner', 'applicationLibrary',
            grailsApplication, ApplicationLibraryEntry.class,
            profileRestService, null,
            new Sorter<ApplicationLibraryEntry>(Constants.SortDirection.ASC, 'folder'))
    }

    ApplicationLibraryEntryRestService() {}

    @Override
    protected void authorizeUpdate(ApplicationLibraryEntry entry) {
        parentClassRestService.authorizeUpdate(getParent(entry))
    }
}
