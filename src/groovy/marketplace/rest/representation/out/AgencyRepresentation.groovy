package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Agency

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.AgencyResource
import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.AgencyUriBuilder

class AgencyRepresentation extends SelfRefRepresentation<Agency> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-organization-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-organizations-v1+json'

    private Agency agency

    AgencyRepresentation(Agency agency, ResourceUriBuilder<Agency> agencyUriBuilder) {
        super(agencyUriBuilder.getUri(agency), null, null)
        this.agency = agency
    }

    long getId() { agency.id }
    String getTitle() { agency.title }
    URI getIcon() { agency.iconUrl ? new URI(agency.iconUrl) : null }

    @Component
    public static class Factory extends RepresentationFactory<Agency> {
        @Autowired AgencyUriBuilder.Factory uriBuilderFactory

        @Override
        public AgencyRepresentation toRepresentation(Agency agency,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new AgencyRepresentation(agency,
                uriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
