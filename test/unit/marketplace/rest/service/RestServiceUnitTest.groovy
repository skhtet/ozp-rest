package marketplace.rest.service

import grails.test.mixin.Mock
import marketplace.ContactType
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import grails.validation.ValidationException
import org.springframework.security.access.AccessDeniedException
import marketplace.rest.DomainObjectNotFoundException
import marketplace.Listing
import marketplace.Type
import marketplace.DocUrl
import marketplace.Contact
import marketplace.Screenshot
import marketplace.Category
import marketplace.Profile
import marketplace.Intent
import marketplace.Agency
import marketplace.ApprovalStatus
import marketplace.validator.DomainValidator

import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.representation.in.AbstractInputRepresentation
import marketplace.rest.representation.in.ListingIdRef
import marketplace.rest.representation.in.TypeIdRef
import marketplace.rest.representation.in.ProfileIdRef
import marketplace.rest.representation.in.AgencyInputRepresentation
import marketplace.rest.representation.in.CategoryInputRepresentation

import marketplace.testutil.FakeAuditTrailHelper
import marketplace.testutil.ProfileMappedByFix

@TestMixin(DomainClassUnitTestMixin)
@Mock([ContactType])
class RestServiceUnitTest {
    GrailsApplication grailsApplication

    RestService<Listing> restService
    DomainValidator<Listing> validator


    private static class ServiceItemInputRepresentation
            extends AbstractInputRepresentation {
        ServiceItemInputRepresentation() {
            super(Listing.class)
        }

        String title
        Long id
        TypeIdRef type
        Set<InputRepresentation<Listing>> required
        Set<ProfileIdRef> owners
        String description
        String launchUrl
        String versionName
        ApprovalStatus approvalStatus
    }

    private static final exampleServiceItemProps = [
        id: 1,
        title: "test service item",
        type: [ id: 1 ],
        required: [],
        description: "a test service item",
        launchUrl: "https://localhost/asf",
        owners: [ id: 1 ],
        versionName: '1',
        approvalStatus: ApprovalStatus.IN_PROGRESS
    ]

    //a simple sublass of RestService that specializes in ServiceItems
    private static class TestService extends RestService<Listing> {
        TestService(GrailsApplication grailsApplication) {
            super(grailsApplication, Listing.class, null, null)
        }

        @Override
        void authorizeUpdate(Listing si) {}
    }

    void setUp() {
        //mock createCriteria.  It needs to return an object with a functioning list() method
        Listing.metaClass.static.createCriteria = {
            [ list: { params, closure -> Listing.list(params) } ]
        }

        def owner = new Profile(username: 'testUser')
        owner.id = 1

        def newOwner = new Profile(username: 'testUser2')
        newOwner.id = 2

        def type = new Type(title: 'Test Type')
        type.id = 1

        def exampleServiceItem = new Listing(exampleServiceItemProps + [
            owners: [owner],
            type: type
        ])

        exampleServiceItem.id = 1

        assertNotNull exampleServiceItem

        FakeAuditTrailHelper.install()
        ProfileMappedByFix.fixProfileMappedBy()

        mockDomain(Screenshot.class)
        mockDomain(Category.class)
        mockDomain(Listing.class, [exampleServiceItem])
        mockDomain(Profile.class, [owner, newOwner])
        mockDomain(Type.class, [type])
        mockDomain(Agency.class, [type])


        grailsApplication = new DefaultGrailsApplication()
        grailsApplication.refresh()

        //necessary to get reflection-based marshalling to work
        grailsApplication.addArtefact(DocUrl.class)
        grailsApplication.addArtefact(Screenshot.class)
        grailsApplication.addArtefact(Category.class)
        grailsApplication.addArtefact(Intent.class)
        grailsApplication.addArtefact(Listing.class)
        grailsApplication.addArtefact(Contact.class)
        grailsApplication.addArtefact(Agency.class)
        restService = new TestService(grailsApplication)
    }

    void testGetAll() {
        Collection<Listing> retval = restService.getAll(null, null)

        assert retval instanceof Collection
        assert retval.size() == 1

        Listing si = retval.iterator().next()
        assert si instanceof Listing
        assert si.title == exampleServiceItemProps.title
        assert si.id == exampleServiceItemProps.id
    }

    void testGetById() {
        def id = restService.getAll(0, 1).iterator().next().id

        Listing retval = restService.getById(id)
        assert retval instanceof Listing
        assert retval.title == exampleServiceItemProps.title
        assert retval.id == id
    }

    void testGetByIdInvalidId() {
        def goodId = restService.getAll(0, 1).iterator().next().id
        def badId = ~goodId //bitwise NOT

        shouldFail(DomainObjectNotFoundException) {
            restService.getById(badId)
        }
    }

    void testDeleteById() {
        def id = restService.getAll(0, 1).iterator().next().id

        restService.deleteById(id)

        shouldFail(DomainObjectNotFoundException) {
            def retval = restService.getById(id)
        }
    }

    void testDeleteByIdInvalidId() {
        def goodId = restService.getAll(0, 1).iterator().next().id
        def badId = ~goodId //bitwise NOT

        shouldFail(DomainObjectNotFoundException) {
            restService.deleteById(badId)
        }
    }

    void testAuthorizeUpdate() {
        def authorizedUser = Profile.get(1), unauthorizedUser = Profile.get(2)

        def currentUser

        def restService = new RestService<Agency>(grailsApplication, Agency.class, null,
                null) {
            @Override
            void authorizeUpdate(Agency agency) {
                if (currentUser != authorizedUser) {
                    throw new AccessDeniedException('Denied')
                }
            }
        }

        def makeRep = {
            new AgencyInputRepresentation(
                title: "test agency",
                shortName: 'ta'
            )
        }

        //test createFromDto.
        //default impl of authorizeCreate defers to authorizeUpdate
        shouldFail(AccessDeniedException) {
            currentUser = unauthorizedUser
            restService.createFromRepresentation(makeRep())
        }
        currentUser = authorizedUser
        def agencyId = restService.createFromRepresentation(makeRep()).id

        //test updateById
        def agency = makeRep()
        shouldFail(AccessDeniedException) {
            currentUser = unauthorizedUser

            restService.updateById(agencyId, agency)
        }
        currentUser = authorizedUser
        restService.updateById(agencyId, agency)

        //test deleteById
        shouldFail(AccessDeniedException) {
            currentUser = unauthorizedUser
            restService.deleteById(agencyId)
        }
        currentUser = authorizedUser
        restService.deleteById(agencyId)
    }

    void testAuthorizeCreate() {
        def authorizedUser = Profile.get(1), unauthorizedUser = Profile.get(2)

        def currentUser

        def restService = new RestService<Screenshot>(grailsApplication, Screenshot.class, null,
                null) {
            @Override
            void authorizeCreate(Screenshot screenshot) {
                if (currentUser != authorizedUser) {
                    throw new AccessDeniedException('Denied')
                }
            }

            @Override
            void authorizeUpdate(Screenshot screenshot) {}
        }

        def makeScreenshot = {
            def serviceItem = new Listing()
            serviceItem.id = 1

            new Screenshot(
                smallImageUrl: 'https://localhost/small',
                largeImageUrl: 'https://localhost/large',
                serviceItem: serviceItem
            )
        }

        //test createFromDto.
        //default impl of authorizeCreate defers to authorizeUpdate
        shouldFail(AccessDeniedException) {
            currentUser = unauthorizedUser
            restService.authorizeCreate(makeScreenshot())
        }
        currentUser = authorizedUser

        //should not fail
        restService.authorizeCreate(makeScreenshot())
    }

    void testValidator() {
        //make a category with only one field populated with a value
        def makeCategory = { fieldToPopulate, value ->
            def category = new CategoryInputRepresentation()
            category[fieldToPopulate] = value

            return category
        };

        //a stubbed-out validator with contrived rules
        def validator = [
            //only allow new categories that have a title, and only allow modifications
            //that have a different title and description
            validateNew: { dto ->
                if (dto.title == null) {
                    throw new IllegalArgumentException('invalid')
                }
            },

            validateChanges: { toUpdate, dto ->
                if (dto.title == dto.description) {
                    throw new IllegalArgumentException('invalid')
                }
            }
        ] as DomainValidator

        def restService = new RestService<Category>(grailsApplication, Category.class,
                validator, null) {
            @Override
            void authorizeUpdate(Category category) {}
        }

        shouldFail(IllegalArgumentException) {
            restService.createFromRepresentation(makeCategory('description', 'asdf'))
        }

        def successfulCategory = makeCategory('title', 'asdf')
        def categoryId = restService.createFromRepresentation(successfulCategory).id

        def failureUpdate
        shouldFail(IllegalArgumentException) {
            failureUpdate = makeCategory('description', 'asdf')
            failureUpdate.title = failureUpdate.description

            restService.updateById(categoryId, failureUpdate)
        }

        def successfulUpdate = makeCategory('description', 'qwerty')
        successfulUpdate.title = failureUpdate.title
        assert restService.updateById(categoryId, successfulUpdate).id == categoryId
    }

    void testUpdateByIdAndRepresentation() {
        final newTitle = 'Updated Name', newUniversalName = 'test.service.item.2'

        def ownerRep = new ProfileIdRef(id: 2)
        def typeRep = new TypeIdRef(id: 1)
        def relationships = new ListingIdRef(id: 1)

        def id = restService.getAll(0, 1).iterator().next().id
        InputRepresentation<Listing> updates = new ServiceItemInputRepresentation(exampleServiceItemProps + [
            title: newTitle,
            owners: [ownerRep],
            type: typeRep,
            required: [relationships],
            id: id
        ])

        Listing retval = restService.updateById(id, updates)
        assert retval instanceof Listing
        assert retval.title == newTitle

        //ensure that properties we didn't change do not change
        assert retval.description == exampleServiceItemProps.description
        assert retval.owners == [Profile.get(2)] as Set
        assert retval.type == Type.get(1)

        assert retval.id == id

        //ensure that the changes were actually saved
        Listing fromGet = restService.getById(id)
        assert fromGet.title == newTitle
        assert fromGet.owners == [Profile.get(2)] as Set
    }

    void testUpdateByIdInvalidDto() {
        def id = restService.getAll(0, 1).iterator().next().id
        InputRepresentation<Listing> updates = new ServiceItemInputRepresentation()

        shouldFail(ValidationException) {
            def retval = restService.updateById(id, updates)

            //shouldn't get here
            throw new RuntimeException("Retval: ${retval.dump()}")
        }
    }

    void testCreateFromRepresentation() {

        def ownerId = 1
        ProfileIdRef ownerRep = new ProfileIdRef(id: ownerId)

        def typeId = 1
        TypeIdRef typeRep = new TypeIdRef(id: typeId)

        ServiceItemInputRepresentation newServiceItem = new ServiceItemInputRepresentation(exampleServiceItemProps + [
            owners: [ownerRep],
            type: typeRep,
            required: []
        ] - [id: 1])

        Listing retval = restService.createFromRepresentation(newServiceItem)
        assert retval instanceof Listing
        assert retval.title == exampleServiceItemProps.title
        assert retval.owners == [Profile.get(ownerId)] as Set
        assert retval.type == Type.get(typeId)

        assertNotNull retval.id
    }
}
