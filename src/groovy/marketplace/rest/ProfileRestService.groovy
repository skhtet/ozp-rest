package marketplace.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.AccessDeniedException
import marketplace.rest.DomainObjectNotFoundException

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
        throw new AccessDeniedException("Profiles cannot be created via the REST interface")
    }

    @Transactional(readOnly=true)
    public String getCurrentUserDataItem(String key) {
        Profile currentUser = getCurrentUserProfile()

        currentUser.userDataMap.get(key)
    }

    @Transactional
    public String updateCurrentUserDataByKey(String key, String value) {
        Profile currentUser = getCurrentUserProfile()
        String putValue = currentUser.userDataMap.put(key, value)

        putValue
    }

    @Transactional
    public String deleteCurrentUserDataByKey(String key) {
        Profile currentUser = getCurrentUserProfile()
        String value = currentUser.userDataMap.remove(key)

        value
    }

    @Transactional(readOnly=true)
    public Profile getCurrentUserProfile() {
        Profile.findByUsername(accountService.loggedInUsername)
    }
}
