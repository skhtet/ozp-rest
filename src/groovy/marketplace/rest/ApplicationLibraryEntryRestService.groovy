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
            profileRestService, null, null)
    }

    ApplicationLibraryEntryRestService() {}

    @Override
    protected void authorizeUpdate(ApplicationLibraryEntry entry) {
        parentClassRestService.authorizeUpdate(getParent(entry))
    }

    /**
     * Override the default implementation to keep the inherent List ordering instead of
     * using the Sorter
     */
    @Override
    public List<ApplicationLibraryEntry> getByParentId(Long parentId) {
        parentClassRestService.getById(parentId).applicationLibrary
    }

    @Override
    protected ApplicationLibraryEntry save(ApplicationLibraryEntry entry) {
        Profile owner = entry.owner

        //if its not already in the parent list, add it
        if (!owner.applicationLibrary.contains(entry)) {
            owner.addToApplicationLibrary(entry)
        }

        parentClassRestService.save(owner)

        return entry
    }
}
