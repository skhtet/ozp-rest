package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.IwcDataObject
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

class IwcDataObjectRepresentation extends SelfRefRepresentation<IwcDataObject> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-iwc-data-object-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-iwc-data-objects-v1+json'

    final String entity
    final String contentType
    final String key

    IwcDataObjectRepresentation(IwcDataObject object, ProfileUriBuilder profileUriBuilder) {
        super(profileUriBuilder.getUserDataItemUri(object), null, null)

        this.entity = object.entity
        this.contentType = object.contentType
        this.key = object.key
    }

    @Component
    public static class Factory implements RepresentationFactory<IwcDataObject> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        public IwcDataObjectRepresentation toRepresentation(
                IwcDataObject entity,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcDataObjectRepresentation(entity,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
