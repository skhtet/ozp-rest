package marketplace.rest.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.hibernate.Criteria

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.Agency
import marketplace.Listing

@Service
class AgencyRestService extends AdminRestService<Agency> {

    @Autowired
    public AgencyRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, Agency.class, null, null)
    }

    //Keep CGLIB happy
    AgencyRestService() {}

	public Collection<Agency> getAll() {
		def crit = Agency.createCriteria()
		List<Agency> agencyList = crit.list{
			order("title", "asc")
		}
		agencyList
	}

    @Override
    public void deleteById(id) {
        Agency agency = getById(id)
        if (Listing.countByAgency(agency) > 0) {
            throw new IllegalArgumentException(
                "Cannot delete organization with associated listings")
        }
        else {
            super.deleteById(id)
        }
    }
}
