package marketplace.rest.service

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import org.springframework.security.access.AccessDeniedException

import marketplace.Listing
import marketplace.Profile
import marketplace.ItemComment
import marketplace.Type

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

import marketplace.rest.representation.in.ItemCommentInputRepresentation

@TestMixin(DomainClassUnitTestMixin)
class ChildObjectRestServiceUnitTest {
    GrailsApplication grailsApplication

    ChildObjectRestService<Listing, ItemComment> service

    Profile currentUser, adminUser, nonAdminUser

    private class TestService extends ChildObjectRestService<Listing, ItemComment> {
        TestService(GrailsApplication grailsApplication,
                ListingRestService listingRestService) {
            super(Listing.class, 'listing', 'itemComments', grailsApplication,
                ItemComment.class, listingRestService, null, null)
        }

        ItemComment save(ItemComment comment) {
            comment.author = currentUser

            super.save(comment)
        }
    }

    private ItemCommentInputRepresentation makeCommentDto(id=null) {
        ItemCommentInputRepresentation comment = new ItemCommentInputRepresentation(
            text: 'test comment text'
        )

        return comment
    }

    private void makeService(listingServiceMock) {
        service = new TestService(grailsApplication, listingServiceMock.createMock())
    }

    void setUp() {
        adminUser = new Profile(username: 'admin')
        nonAdminUser = new Profile(username: 'user')

        Type type = new Type(title: 'test type')

        Listing si1 = new Listing(
            title: 'Service Item 1',
            owners: [adminUser],
            type: type,
            launchUrl: 'https:///'
        )
        si1.id = 1

        Listing si2 = new Listing(
            title: 'Service Item 2',
            owners: [nonAdminUser],
            launchUrl: 'https:///',
            type: type
        )
        si2.id = 2

        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()

        mockDomain(ItemComment.class)
        mockDomain(Profile.class, [adminUser, nonAdminUser])
        mockDomain(Listing.class)
        [si1, si2].each { it.save(failOnError: true) }


        grailsApplication = new DefaultGrailsApplication()
        grailsApplication.refresh()

        grailsApplication.addArtefact(Listing.class)
        grailsApplication.addArtefact(ItemComment.class)
        grailsApplication.addArtefact(Profile.class)

    }

    void testCreateFromDto() {
        def serviceItemServiceMock = mockFor(ListingRestService)
        makeService(serviceItemServiceMock)

        //createFromDto is forbidden
        shouldFail(UnsupportedOperationException) {
            service.createFromRepresentation(makeCommentDto())
        }
    }
}
