package marketplace.rest.representation.out

import marketplace.Agency

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory

import marketplace.rest.resource.AgencyResource

class AgencyRepresentation extends SelfRefRepresentation<Agency> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-organization-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-organizations-v1+json'

    private Agency agency

    AgencyRepresentation(Agency agency, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            uriBuilderHolder.builder
                .path(AgencyResource.class)
                .path(AgencyResource.class, 'read')
                .buildFromMap(id: agency.id),
            null, null
        )

        this.agency = agency
    }

    long getId() { agency.id }
    String getTitle() { agency.title }
    URI getIcon() { agency.iconUrl ? new URI(agency.iconUrl) : null }

    public static class Factory extends RepresentationFactory<Agency> {
        @Override
        public AgencyRepresentation toRepresentation(Agency agency,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new AgencyRepresentation(agency, uriBuilderHolder)
        }
    }
}
