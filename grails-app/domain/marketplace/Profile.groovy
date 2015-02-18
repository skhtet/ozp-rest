package marketplace

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.codehaus.groovy.grails.web.json.JSONObject

@gorm.AuditStamp
class Profile implements Serializable {

    static searchable = {
        root false
        username index: 'not_analyzed', excludeFromAll: true
        displayName index: 'not_analyzed', excludeFromAll: true
        only = ['username', 'displayName']
    }

    static hasMany = [
        applicationLibrary: ApplicationLibraryEntry,
        organizations: Agency,
        stewardedOrganizations: Agency,
        iwcData: IwcDataObject,
        dismissedNotifications: Notification
    ]

    List<ApplicationLibraryEntry> applicationLibrary = new LinkedList()

    static mappedBy = [
        //keep grails from getting confused into thinking that these are opposite sides of the
        //same relationship
        createdBy: 'none',
        editedBy: 'none',

        applicationLibrary: 'owner',
        organizations: 'none',
        stewardedOrganizations: 'none'
    ]

    String username
    String displayName = ''
    String email = ''
    String bio = ''
    // not sure why createdDate is listed here since it will get added by the AuditStamp
    Date createdDate
    Date lastLogin = new Date()

    //the highest Role currently assigned to the user.  If we ever have Roles that aren't
    //strictly ordered we will need a more sophisticated mechanism to remember exactly what
    //roles a user has
    Role highestRole = Role.USER

    //user-settable preference for whether or not to launch applications into webtop
    //or a new tab by default
    boolean launchInWebtop = false


    Set<Agency> organizations = new HashSet()
    Set<Agency> stewardedOrganizations = new HashSet()
    Set<Notification> dismissedNotifications = new HashSet()

    static constraints = {
        username blank: false, nullable: false, unique: true, maxSize: 255
        displayName nullable: true, maxSize: 255
        email nullable: true, maxSize: 255
        bio nullable: true, maxSize: 1000
        createdDate nullable: false
        lastLogin nullable: false
        highestRole nullable: false
    }

    static mapping = {
        id natural: [properties: ['username']]
        cache true
        tablePerHierarchy false
        iwcData cascade: 'all-delete-orphan', batchSize: 25
    }

    static final String SYSTEM_USER_NAME = 'System'

    static Profile getSystemUser() { findByUsername SYSTEM_USER_NAME }

    @Override
    String toString() { username }

    @Override
    public int hashCode() {
        new HashCodeBuilder()
            .append(username)
            .toHashCode()
    }

    @Override
    public boolean equals(other) {
        // Since owners is a lazy loaded collection, the instances could be
        // hibernate proxies, so use the GORM 'instanceOf' method
        Boolean sameType
        try {
            sameType = other.instanceOf(Profile)
        } catch(MissingMethodException mme) {
            sameType = false
        }

        if(sameType) {
            return new EqualsBuilder()
                .append(username, other.username)
                .isEquals()
        }

        return false
    }

    def beforeValidate() {
        applicationLibrary.each { it.beforeValidate() }
    }

    boolean hasRole(Role role) {
        this.highestRole >= role
    }
}
