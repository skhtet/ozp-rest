package marketplace.rest.resource

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Agency

import marketplace.rest.service.AgencyRestService

@Path('/api/agency')
class AgencyResource extends DomainResource<Agency> {
    @Autowired
    AgencyResource(AgencyRestService agencyRestService) {
        super(Agency.class, agencyRestService)
    }

    AgencyResource() {}
}
