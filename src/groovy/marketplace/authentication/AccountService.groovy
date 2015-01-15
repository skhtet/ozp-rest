package marketplace.authentication

import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import org.springframework.security.core.GrantedAuthority

/**
 * Interface for getting information about the currently logged
 * in user.  Application-level code that needs info on
 * the current user should be retrieved from the Profile
 */
@Transactional(propagation=Propagation.SUPPORTS)
interface AccountService {
    String getLoggedInUsername()
    String getLoggedInDisplayName()
    String getLoggedInEmail()
    Collection<? extends GrantedAuthority> getLoggedInUserRoles()
    String getLoggedInOrganization()
    void asSystemUser(Closure closure)
}
