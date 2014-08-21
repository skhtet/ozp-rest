package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Profile
import marketplace.ServiceItem
import marketplace.ItemComment

import marketplace.AccountService

@Service
class ProfileRestService extends RestService<Profile> {
    @Autowired AccountService accountService

    @Autowired
    public ProfileRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Profile.class, null, null)
    }

    //Keep CGLIB happy
    ProfileRestService() {}

    protected void authorizeUpdate(Profile existing) {
        if (!(accountService.isAdmin() || accountService.loggedInUsername == existing.username)) {
            throw new AccessDeniedException("Unauthorized attempt to modify profile " +
                "${existing.username} by user ${accountService.loggedInUsername}")
        }
    }

    protected void authorizeCreate(Profile dto) {
        if (!accountService.isAdmin()) {
            throw new AccessDeniedException("Unauthorized attempt to create profile " +
                "${dto.username} by user ${accountService.loggedInUsername}")
        }
    }

    @Transactional
    public void updateCurrentUserDataByKey(String key, String value) {
        Profile profile = Profile.findByUsername(accountService.loggedInUsername)

        if (profile != null) {
            profile.userDataMap.put(key, value)
            profile.save()
        }
    }

    @Transactional
    public void deleteCurrentUserDataByKey(String key) {
        Profile profile = Profile.findByUsername(accountService.loggedInUsername)

        if (profile != null) {
            profile.userDataMap.remove(key)
            profile.save()
        }
    }

    @Transactional(readOnly=true)
    public Profile getCurrentUserProfile() {
        Profile.findByUsername(accountService.loggedInUsername)
    }
}
