package marketplace.rest.representation.out

import marketplace.IwcDataObject
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.resource.ProfileResource

class IwcDataObjectRepresentation extends SelfRefRepresentation<IwcDataObject> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-iwc-data-object-v1+json'
    public static final String COLLECTION_MEDIA_TYPE = 'application/vnd.ozp-iwc-data-objects-v1+json'

    final String entity
    final String contentType
    final String key

    IwcDataObjectRepresentation(IwcDataObject object, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'readDataItem')
                .buildFromMap(key: object.key, profileId: object.profile.id), null, null)

        this.entity = object.entity
        this.contentType = object.contentType
        this.key = object.key
    }

    public static class Factory implements RepresentationFactory<IwcDataObject> {
        public IwcDataObjectRepresentation toRepresentation(
                IwcDataObject entity,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcDataObjectRepresentation(entity, uriBuilderHolder)
        }
    }
}
