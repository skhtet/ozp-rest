package marketplace.rest.resource

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import static javax.servlet.http.HttpServletResponse.*

//use Agency as an example domain object
import marketplace.Agency

import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin

import marketplace.rest.service.RestService

import marketplace.rest.representation.in.AgencyInputRepresentation
import marketplace.rest.representation.in.InputRepresentation

@TestMixin(DomainClassUnitTestMixin)
class RepresentationResourceUnitTest {
    DomainResource<Agency> domainResource
    GrailsApplication grailsApplication

    def restService

    private static final agencyProps = [
        title: "Agency Name",
        iconUrl: "https://localhost/icon.png"
    ]

    void setUp() {
        mockDomain(Agency)
    }

    //call this method after setting up mocking demands in
    //each test
    private void setUpResource() {
        domainResource = new RepresentationResource(restService)
    }

    void testCreate() {
        restService = [
            createFromRepresentation: { rep ->
                new Agency(rep.inputProperties + [id: 1])
            },
            authorizeUpdate: { a -> }
        ] as RestService

        setUpResource()

        def agencyRep = new AgencyInputRepresentation(agencyProps)
        def response = domainResource.create(agencyRep)

        assert response.status == SC_CREATED
        assert response.entity == agency
    }

    void testReadAll() {
        def newAgency = new Agency(agencyProps)
        restService = [
            getAll: { offset, max -> [newAgency] }
        ] as RestService

        setUpResource()

        Collection<Agency> retval = domainResource.readAll(null, null)

        assert retval instanceof Collection
        assert retval.size() == 1

        def agency = retval.iterator().next()
        assert agency instanceof Agency
        assert agency == newAgency
    }

    void testRead() {
        final id = 1
        def newAgency = new Agency(agencyProps + [id: id])
        restService = [
            getById: { serviceId ->
                assert serviceId == id
                newAgency
            }
        ] as RestService

        setUpResource()

        Agency agency = domainResource.read(id)
        assert agency instanceof Agency
        assert agency == newAgency
    }

    void testUpdate() {
        final id = 1, newName = 'New Name', newIcon = 'icon2.png'

        def existingAgency = new Agency(agencyProps)
        existingAgency.id = id
        def updates = new AgencyInputRepresentation(
            id: id,
            title: newName,
            iconUrl: newIcon
        )

        restService = [
            updateById: { Long serviceId, InputRepresentation<Agency> rep ->
                assert serviceId == id
                existingAgency.properties = rep.inputProperties
                existingAgency
            }
        ] as RestService

        setUpResource()

        Agency agency = domainResource.update(id, updates)
        assert agency instanceof Agency
        assert agency.title == newName
        assert agency.iconUrl == newIcon
        assert agency.id == id
    }

    void testDelete() {
        final id = 1

        restService = [
            deleteById: { serviceId ->
                assert serviceId == id
            }
        ] as RestService

        setUpResource()

        domainResource.delete(id)
    }
}
