package marketplace.rest.service

import marketplace.Constants
import marketplace.IwcDataObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Isolation
import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Profile
import marketplace.Agency
import marketplace.Role
import marketplace.Sorter

import marketplace.authentication.AccountService

import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.AgencyIdRef
import marketplace.rest.DomainObjectNotFoundException

@Service
class ProfileRestService extends RestService<Profile> {
    @Autowired AccountService accountService
    @Autowired AgencyRestService agencyRestService

    @Autowired
    public ProfileRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Profile.class, null,
            new Sorter<Profile>(Constants.SortDirection.ASC, 'displayName'))
    }

    //Keep CGLIB happy
    ProfileRestService() {}

    protected void authorizeUpdate(Profile existing) {
        Profile currentUserProfile = this.currentUserProfile
        if (!(isAdmin() || accountService.loggedInUsername == existing.username)) {
            throw new AccessDeniedException("Unauthorized attempt to modify profile " +
                "${existing.username} by user ${accountService.loggedInUsername}")
        }
    }

    protected void authorizeCreate(Profile dto) {
        throw new AccessDeniedException("Profiles cannot be created via the REST interface")
    }

    @Transactional(readOnly=true)
    public Collection<Profile> getAll(Integer offset, Integer max, Role role) {
        Profile.createCriteria().list(offset: offset, max: max) {
            switch (role) {
                case Role.USER:
                    or {
                        eq('highestRole', Role.USER)
                        eq('highestRole', Role.ORG_STEWARD)
                        eq('highestRole', Role.APPSMALL_STEWARD)
                        eq('highestRole', Role.ADMIN)
                    }
                    break;
                case Role.ORG_STEWARD:
                    or {
                        eq('highestRole', Role.ORG_STEWARD)
                        eq('highestRole', Role.APPSMALL_STEWARD)
                        eq('highestRole', Role.ADMIN)
                    }
                    break;
                case Role.APPSMALL_STEWARD:
                    or {
                        eq('highestRole', Role.APPSMALL_STEWARD)
                        eq('highestRole', Role.ADMIN)
                    }
            }

            if (this.sorter) {
                order(sorter.sortField, sorter.direction.name().toLowerCase())
            }
        }
    }

    @Transactional(readOnly = true)
    public Collection<IwcDataObject> getUserData(Long userId) {
        Profile profile = getById(userId)
        authorizeView(profile)

        IwcDataObject.findAllByProfile(profile)
    }

    @Transactional(readOnly=true)
    public IwcDataObject getDataItem(Long userId, String key) {
        Profile profile = getById(userId)
        authorizeView(profile)

        def object = IwcDataObject.findByProfileAndKey(profile, key)

        if(!object) {
            throw new DomainObjectNotFoundException(IwcDataObject.class, key)
        }

        object
    }

    @Transactional
    public IwcDataObject updateDataItem(Long userId, String key, String entity, String contentType) {
        Profile profile = getById(userId)
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
    public void deleteDataItem(Long userId, String key) {
        Profile profile = getById(userId)
        authorizeUpdate(profile)

        getDataItem(profile.id, key).delete()
    }

    /**
     * get the current user profile with an optional pessimistic lock
     * @param lock If true, the profile is locked for update at the database level
     */
    @Transactional(readOnly=true)
    public Profile getCurrentUserProfile(boolean lock=false) {
        Profile.findByUsername(accountService.loggedInUsername, [lock: lock])
    }

    /**
     * Ensure that a Profile object exists for the current user and update it from the security
     * plugin information
     */
    @Transactional(isolation=Isolation.READ_COMMITTED)
    public void login() {
        Profile profile = getCurrentUserProfile(true) ?: new Profile(
            username: accountService.loggedInUsername
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

    @Override
    protected void postprocess(Profile updated, Map original = null) {
        super.postprocess(updated, original)

        if (updated.organizations != original.organizations) {
            checkAdmin("Organization affiliation can only be updated by admins")
        }

        if (updated.stewardedOrganizations != original.stewardedOrganizations) {
            checkAdmin("Only admins can alter stewardship assignments")
        }
    }

    @Transactional(readOnly=true)
    public boolean isAdmin() {
        currentUserProfile.hasRole(Role.ADMIN)
    }

    @Transactional(readOnly=true)
    public boolean isUser() {
        currentUserProfile.hasRole(Role.USER)
    }

    /**
     * @return true if the current user is actually an org steward.  Note that this will
     * return false for users who are admins, even though being an admin implies org steward
     * capabilities.  The point of this method is to distinguish between org stewards and admins
     */
    @Transactional(readOnly=true)
    public boolean isOrgSteward() {
        currentUserProfile.hasRole(Role.ORG_STEWARD) && !isAdmin()
    }

    /**
     * @return whether or not the current user has org steward privileges over the specified
     * org.  This will be the case either if they are an admin, or if they are an org steward
     * whose stewardedOrganizations contains the specified org
     */
    @Transactional(readOnly=true)
    public boolean isOrgSteward(Agency org) {
        Profile profile = currentUserProfile

        isAdmin() ||
            (profile.hasRole(Role.ORG_STEWARD) && profile.stewardedOrganizations.contains(org))
    }

    /**
     * @throws AccessDeniedException if the current user in not an Admin
     * @param msg the Message for the exception
     */
    @Transactional(readOnly=true)
    public void checkAdmin(String msg = "Attempt to access Admin-only functionality") {
        if (!isAdmin()) {
            throw new AccessDeniedException(msg)
        }
    }

    @Transactional(readOnly=true)
    public void checkOrgSteward(Agency organization,
            String msg = "Attempt to access Organization-Steward " +
            "functionality for $organization") {
        if (!isOrgSteward(organization)) {
            throw new AccessDeniedException(msg)
        }
    }
}
