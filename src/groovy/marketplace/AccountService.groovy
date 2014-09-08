package marketplace

import grails.util.GrailsUtil
import ozone.utils.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.access.AccessDeniedException

/**
 *
 *  Provides a mock account service for demo purposes.
 *
 */
 @Service
public class AccountService {

    boolean transactional = false

    String loggedInUsername
    String loggedInDisplayName
    String loggedInEmail
    List<String> loggedInUserRoles
    String loggedInOrganization

    public User getLoggedInUser() {
        new User(
            username: loggedInUsername,
            name: loggedInDisplayName,
            email: loggedInEmail,
            org: loggedInOrganization
        )
    }

    public boolean isExtAdmin() {
        false
    }

    public boolean isAdmin() {
        hasRole(Constants.ADMIN)
    }

    public boolean isUser() {
        hasRole(Constants.USER)
    }

    /**
     * @throws AccessDeniedException if the current user in not an Admin
     * @param msg the Message for the exception
     */
    public void checkAdmin(String msg = "Attempt to access Admin-only functionality") {
        if (!isAdmin()) {
            throw new AccessDeniedException(msg)
        }
    }

    public String getloggedInUserAuthorities() {
        loggedInUserRoles.toString()
    }

    private boolean hasRole(String role) {
        loggedInUserRoles.contains(role)
    }

    @Transactional
    public UserAccount createUserAccount(String username, Date creationDate) {
        log.debug "Adding UserAccount and saving last login for ${username}"
        def userAccount = new UserAccount()
        userAccount.username = username
        userAccount.lastLogin = creationDate
        userAccount.save()
        def userDomainInstance = new UserDomainInstance(username: username)
        userDomainInstance.save()
        userAccount
    }

    @Transactional
    public UserAccount loginAccount(String username) {
        UserAccount userAccount = UserAccount.findByUsername(username)
        if (!userAccount) {
            userAccount = createUserAccount(username, new Date())
        }

        userAccount
    }
}
