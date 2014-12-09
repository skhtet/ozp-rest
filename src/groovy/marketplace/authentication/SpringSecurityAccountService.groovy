package marketplace.authentication

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

import ozone.security.authentication.OWFUserDetails

class SpringSecurityAccountService implements AccountService {
    private static final UserDetails SYSTEM_USER_DETAILS = [
        getAuthorities: { [new SimpleGrantedAuthority('ROLE_ADMIN')] },
        getPassword: { null },
        getUsername: { 'System' },
        isAccountNonExpired: { true },
        isAccountNonLocked: { true },
        isCredentialsNonExpired: { true },
        isEnabled: { true }
    ] as UserDetails

    private UserDetails getUserDetails() {
        SecurityContextHolder.context?.authentication?.principal
    }

    private OWFUserDetails getOwfUserDetailsOrNull() {
        UserDetails userDetails = this.userDetails
        userDetails instanceof OWFUserDetails ?
            userDetails : null
    }

    String getLoggedInUsername() {
        userDetails?.username
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
        userDetails?.authorities
    }

    public void asSystemUser(Closure closure) {
        if (userDetails) {
            throw new IllegalStateException(
                "Cannot become System user when a user is already logged in")
        }
        else {
            SecurityContextHolder.context = new SecurityContextImpl(
                authentication: new PreAuthenticatedAuthenticationToken(SYSTEM_USER_DETAILS, null)
            )

            closure()

            SecurityContextHolder.clearContext()
        }
    }

}
