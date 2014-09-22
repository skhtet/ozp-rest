package marketplace.rest

import marketplace.IwcDataObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Profile
import marketplace.Agency
import marketplace.Role

import marketplace.AccountService

import javax.ws.rs.core.MediaType

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

    @Transactional
    public Collection<IwcDataObject> getCurrentUserData() {
        Profile profile = currentUserProfile
        authorizeView(profile)

        IwcDataObject.findAllByProfile(profile)
    }

    @Transactional(readOnly=true)
    public IwcDataObject getCurrentUserDataItem(String key) {
        Profile profile = currentUserProfile
        authorizeView(profile)

        def object = IwcDataObject.findByProfileAndKey(profile, key)

        if(!object) {
            throw new DomainObjectNotFoundException(IwcDataObject.class, key)
        }

        object
    }

    @Transactional
    public IwcDataObject updateCurrentUserDataByKey(String key, String entity, String contentType) {
        Profile profile = currentUserProfile
        authorizeUpdate(profile)

        IwcDataObject putValue = IwcDataObject.findByProfileAndKey(profile, key)

        if(!putValue) {
            profile.addToIwcData(key: key, entity: entity, contentType: contentType)
            profile.save(failOnError: true)
        } else {
            putValue.entity = entity
            putValue.contentType = contentType
            putValue.save(failOnError: true)
        }

        putValue
    }

    @Transactional
    public void deleteCurrentUserDataByKey(String key) {
        Profile profile = currentUserProfile
        authorizeUpdate(profile)

        getCurrentUserDataItem(key).delete()
    }

    @Transactional(readOnly=true)
    public Profile getCurrentUserProfile() {
        Profile.findByUsername(accountService.loggedInUsername)
    }

    /**
     * Ensure that a Profile object exists for the current user and update it from the security
     * plugin information
     */
    @Transactional
    public void login() {
        Profile profile = currentUserProfile ?: new Profile(
            username: accountService.loggedInUsername,
        )

        //TODO This might need to be more robust
        Agency organization = Agency.findByTitle(accountService.loggedInOrganization)
        if (organization) {
            profile.addToOrganizations(organization)
        }

        profile.with {
            displayName = accountService.loggedInDisplayName
            email = accountService.loggedInEmail
            lastLogin = new Date()
            highestRole = accountService.loggedInUserRoles.collect {
                Role.fromGrantedAuthority(it)
            }.max()
        }

        profile.save(failOnError:true)
    }

    @Transactional(readOnly = false)
    public void createRequired() {
        def profilesInConfig = grailsApplication.config.marketplace.metadata.profiles

        if (profilesInConfig) {
            profilesInConfig.each { Map profileInfo ->
                String username = profileInfo.username
                if (!Profile.findByUsername(username)) {
                    log.debug("#### Creating profile: $username")
                    Profile profile =
                        new Profile(username: username, displayName: profileInfo.displayName)
                    profile.save(failOnError:true)
                } else {
                    log.info("#### Found user: $username")
                }
            }
        } else {
            log.error "Profiles metadata info was not found in the loaded config files."
        }
    }

    @Override
    protected void postprocess(Profile updated, Map original = null) {
        super.postprocess(updated, original)

        if (updated.organizations != original.organizations) {
            accountService.checkAdmin("Organization affiliation can only be updated by admins")
        }
    }
}
