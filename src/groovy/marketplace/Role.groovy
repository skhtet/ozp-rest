package marketplace

import org.springframework.security.core.GrantedAuthority

/**
 * Enumeration of security Roles recognized by Marketplace.
 * The roles are defined in increasing order of power, where each
 * role has all of the abilities of the role before it, plus some
 */
enum Role {
    /**
     * Normal Users of the system
     */
    USER,

    /**
     * Organization Stewards - capable of approving Applications
     * within their organization
     */
    ORG_STEWARD,

    /**
     * Appsmall Stewards - capable of globally approving Applications
     * after the proper Organization Steward has approved them.  Also
     * has Organization Steward capabilities for all Organizations
     */
    APPSMALL_STEWARD,

    //TODO remove
    ADMIN

    static Role fromGrantedAuthority(GrantedAuthority authority) {
        switch (authority.authority) {
            case 'ROLE_USER': return USER
            case 'ROLE_ORG_STEWARD': return ORG_STEWARD
            case 'ROLE_APPSMALL_STEWARD': return APPSMALL_STEWARD
            case 'ROLE_ADMIN': return ADMIN //REMOVE
            default: return null
        }
    }
}
