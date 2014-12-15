package marketplace.rest.service

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import grails.converters.JSON
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import org.springframework.security.access.AccessDeniedException

import net.sf.ehcache.CacheManager

import marketplace.Profile
import marketplace.Agency
import marketplace.Role

import marketplace.authentication.AccountService

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

import marketplace.rest.representation.in.InputRepresentation

@TestMixin(DomainClassUnitTestMixin)
class ProfileRestServiceUnitTest {
    GrailsApplication grailsApplication

    ProfileRestService service

    def currentUser

    Profile admin1, admin2, user1, user2, orgSteward1, orgSteward2
    Agency agency1, agency2

    private createGrailsApplication() {
        grailsApplication = new DefaultGrailsApplication()
        grailsApplication.refresh()

        //necessary to get reflection-based marshalling to work
        grailsApplication.addArtefact(Profile.class)
    }

    private Profile makeProfile(username, id, Role role) {
        def profile = new Profile(
            username: username,
            highestRole: role
        )

        profile.id = id

        return profile
    }

    private InputRepresentation<Profile> makeInputRepresentation(username, id) {
        [
            getInputProperties: { [
                username: username,
                id: id
            ] },
            representedClass: { Profile.class }
        ] as InputRepresentation<Profile>
    }

    void setUp() {
        admin1 = makeProfile('testAdmin1', 1, Role.ADMIN)
        admin2 = makeProfile('testAdmin2', 2, Role.ADMIN)
        user1 = makeProfile('testUser1', 3, Role.USER)
        user2 = makeProfile('testUser2', 4, Role.USER)
        orgSteward1 = makeProfile('testOrgSteward1', 5, Role.ORG_STEWARD)
        orgSteward2 = makeProfile('testOrgSteward2', 6, Role.ORG_STEWARD)

        agency1 = new Agency(title: 'agency 1')
        agency2 = new Agency(title: 'agency 2')

        orgSteward1.stewardedOrganizations = [agency1]
        orgSteward2.stewardedOrganizations = [agency1, agency2]

        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()

        mockDomain(Profile.class, [admin1, admin2, user1, user2, orgSteward1, orgSteward2])

        createGrailsApplication()

        CacheManager cacheManager = [
            getCache: { String name -> null }
        ] as CacheManager

        service = new ProfileRestService(grailsApplication, cacheManager)

        service.accountService = [
            getLoggedInUsername: { currentUser.username }
        ] as AccountService
    }

    void testAuthorizeUpdate() {
        currentUser = admin1


        //edit self as admin - should succeed
        service.updateById(admin1.id, makeInputRepresentation('testAdmin11', admin1.id))

        //edit other as admin - should succeed
        service.updateById(admin2.id, makeInputRepresentation('testAdmin22', admin2.id))

        currentUser = user1

        //edit self as user, should succeed
        service.updateById(user1.id, makeInputRepresentation('testUser11', user1.id))

        //edit other as user, should fail
        shouldFail(AccessDeniedException) {
            service.updateById(user2.id, makeInputRepresentation('testUser22', user2.id))
        }
    }

    void testAuthorizeCreate() {
        currentUser = admin1

        //create not allowed at all
        shouldFail(AccessDeniedException) {
            service.createFromRepresentation(makeInputRepresentation('willFail', 10))
        }
    }

    void testGetCurrentUserProfile() {
        currentUser = admin1
        assert service.currentUserProfile == currentUser

        currentUser = user1
        assert service.currentUserProfile == currentUser
    }

    void testIsAdmin() {
        currentUser = admin1
        assert service.isAdmin()

        currentUser = orgSteward1
        assert !service.isAdmin()

        currentUser = user1
        assert !service.isAdmin()
    }

    void testIsUser() {
        currentUser = admin1
        assert service.isUser()

        currentUser = orgSteward1
        assert service.isUser()

        currentUser = user1
        assert service.isUser()
    }

    void testIsOrgSteward() {
        currentUser = admin1
        assert service.isOrgSteward(agency1)
        assert service.isOrgSteward(agency2)

        currentUser = orgSteward1
        assert service.isOrgSteward(agency1)
        assert !service.isOrgSteward(agency2)

        currentUser = orgSteward2
        assert service.isOrgSteward(agency1)
        assert service.isOrgSteward(agency2)

        currentUser = user1
        assert !service.isOrgSteward(agency1)
        assert !service.isOrgSteward(agency2)
    }

    void testCheckAdmin() {
        currentUser = admin1
        service.checkAdmin()

        currentUser = orgSteward1
        shouldFail(AccessDeniedException) {
            service.checkAdmin()
        }

        currentUser = user1
        shouldFail(AccessDeniedException) {
            service.checkAdmin()
        }
    }

    void testCheckOrgSteward() {
        currentUser = admin1
        service.checkOrgSteward(agency1)
        service.checkOrgSteward(agency2)

        currentUser = orgSteward1
        service.checkOrgSteward(agency1)
        shouldFail(AccessDeniedException) {
            service.checkOrgSteward(agency2)
        }

        currentUser = orgSteward2
        service.checkOrgSteward(agency1)
        service.checkOrgSteward(agency2)

        currentUser = user1
        shouldFail(AccessDeniedException) {
            service.checkOrgSteward(agency1)
        }
        shouldFail(AccessDeniedException) {
            service.checkOrgSteward(agency2)
        }
    }
}
