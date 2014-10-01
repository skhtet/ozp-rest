package marketplace.authentication

import org.springframework.security.core.GrantedAuthority

class MockAccountService implements AccountService {
    String loggedInUsername
    String loggedInDisplayName
    String loggedInEmail
    Collection<? extends GrantedAuthority> loggedInUserRoles
    String loggedInOrganization
}

