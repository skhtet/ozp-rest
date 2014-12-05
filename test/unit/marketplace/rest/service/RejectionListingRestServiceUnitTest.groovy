package marketplace.rest.service

import grails.test.mixin.domain.DomainClassUnitTestMixin

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import org.springframework.security.access.AccessDeniedException

import marketplace.Listing
import marketplace.RejectionListing
import marketplace.Profile
import marketplace.Agency
import marketplace.ApprovalStatus

import marketplace.validator.ListingValidator

@TestMixin(DomainClassUnitTestMixin)
class RejectionListingRestServiceUnitTest {
    def grailsApplication = new DefaultGrailsApplication()
    def service

    void testPostprocess() {
        Listing listing = new Listing()
        RejectionListing rejection = new RejectionListing(serviceItem: listing)
        def passedListing, passedRejection

        service = new RejectionListingRestService(grailsApplication, [
            reject: { l, r ->
                passedListing = l
                passedRejection = r
            }
        ] as ListingRestService)

        service.postprocess(rejection)
        assert passedListing.is(listing)
        assert passedRejection.is(rejection)
    }

    void testPopulateDefaults() {
        Profile profile = new Profile()
        Listing listing = new Listing()
        RejectionListing rejection = new RejectionListing(serviceItem: listing)

        service = new RejectionListingRestService(grailsApplication, null)
        service.profileRestService = [
            getCurrentUserProfile: { profile }
        ] as ProfileRestService

        service.populateDefaults(rejection)

        assert rejection.author.is(profile)
    }

    void testAuthorizeCreate() {
        boolean canViewListing = false, isOrgSteward = false, isAdmin = false

        Agency agency = new Agency()
        Listing listing = new Listing(agency: agency)
        RejectionListing rejection = new RejectionListing(serviceItem: listing)

        service = new RejectionListingRestService(grailsApplication, [
            canView: { canViewListing }
        ] as ListingRestService)

        service.profileRestService = [
            checkOrgSteward: { if (!isOrgSteward) throw new AccessDeniedException('') },
            checkAdmin: { if (!isAdmin) throw new AccessDeniedException('') }
        ] as ProfileRestService

        shouldFail(AccessDeniedException) {
            service.authorizeCreate(rejection)
        }

        canViewListing = true
        shouldFail(AccessDeniedException) {
            service.authorizeCreate(rejection)
        }

        isOrgSteward = true
        listing.approvalStatus = ApprovalStatus.PENDING
        service.authorizeCreate(rejection)

        listing.approvalStatus = ApprovalStatus.APPROVED_ORG
        shouldFail(AccessDeniedException) {
            service.authorizeCreate(rejection)
        }

        isAdmin = true
        listing.approvalStatus = ApprovalStatus.PENDING
        service.authorizeCreate(rejection)

        listing.approvalStatus = ApprovalStatus.APPROVED_ORG
        service.authorizeCreate(rejection)
    }

    void testAuthorizeUpdate() {
        service = new RejectionListingRestService(grailsApplication, null)

        shouldFail(AccessDeniedException) {
            service.authorizeUpdate(new RejectionListing())
        }
    }
}
