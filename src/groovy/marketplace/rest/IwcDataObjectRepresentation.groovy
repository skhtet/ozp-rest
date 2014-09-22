package marketplace.rest

import marketplace.IwcDataObject
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation

class IwcDataObjectRepresentation extends SelfRefRepresentation<IwcDataObject> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-iwc-data-object-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-iwc-data-objects-v1+json'

    final String entity
    final String contentType

    IwcDataObjectRepresentation(IwcDataObject object, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder.builder
                .path(IwcDataObjectResource.class)
                .path(IwcDataObjectResource.class, 'read')
                .buildFromMap(key: object.key), null, null)

        this.entity = object.entity
        this.contentType = object.contentType
    }

    public static class Factory implements RepresentationFactory<IwcDataObject> {
        public IwcDataObjectRepresentation toRepresentation(
                IwcDataObject entity,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcDataObjectRepresentation(entity, uriBuilderHolder)
        }
    }
}
