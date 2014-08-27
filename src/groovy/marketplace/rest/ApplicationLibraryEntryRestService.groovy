package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Profile
import marketplace.ApplicationLibraryEntry

import marketplace.Sorter

class ApplicationLibraryEntryRestService
        extends ChildObjectRestService<Profile, ApplicationLibraryEntry> {

    @Autowired
    public ApplicationLibraryEntryRestService(GrailsApplication grailsApplication,
            ProfileRestService profileRestService) {
        super(Profile.class, 'owner', 'applicationLibrary', grailsApplication,
            ApplicationLibraryEntry.class, profileRestService,
            new Sorter(Constants.SortDirection.ASC, 'folder'), null)
    }

    protected void authorizeUpdate(ApplicationLibraryEntry entry) {
        parentClassRestService.authorizeUpdate(getParent(entry))
    }
}
