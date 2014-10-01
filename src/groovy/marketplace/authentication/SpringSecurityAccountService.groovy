package marketplace.authentication

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

import ozone.security.authentication.OWFUserDetails

class SpringSecurityAccountService implements AccountService {
    private UserDetails getUserDetails() {
        SecurityContextHolder.context.authentication.principal
    }

    private OWFUserDetails getOwfUserDetailsOrNull() {
        UserDetails userDetails = this.userDetails
        userDetails instanceof OWFUserDetails ?
            userDetails : null
    }

    String getLoggedInUsername() {
        userDetails.username
    }

    String getLoggedInDisplayName() {
        owfUserDetailsOrNull?.displayName
    }

    String getLoggedInEmail() {
        owfUserDetailsOrNull?.email
    }

    String getLoggedInOrganization() {
        owfUserDetailsOrNull?.organization
    }

    Collection<? extends GrantedAuthority> getLoggedInUserRoles() {
        userDetails.authorities
    }
}
