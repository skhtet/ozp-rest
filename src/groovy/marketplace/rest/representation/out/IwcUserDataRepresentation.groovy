package marketplace.rest.representation.out

import marketplace.IwcDataObject
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserData
import marketplace.rest.resource.ProfileResource

class IwcUserDataRepresentation extends SelfRefRepresentation<IwcUserData> {
    IwcUserDataRepresentation(IwcUserData iwcUserData, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(uriBuilderHolder.builder
                .path(ProfileResource.class)
                .path(ProfileResource.class, 'readAllData')
                .buildFromMap([profileId: iwcUserData.user.id]),
            linkDataObjects(iwcUserData, uriBuilderHolder), null)
    }

    private static HalLinks linkDataObjects(IwcUserData iwcUserData, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalLinks(iwcUserData.dataObjects.collect { IwcDataObject dataObject ->
            URI href = uriBuilderHolder.builder
                    .path(ProfileResource.class)
                    .path(ProfileResource.class, 'readDataItem')
                    .buildFromMap([profileId: iwcUserData.user.id, key: dataObject.key])

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    static class Factory implements RepresentationFactory<IwcUserData> {
        public IwcUserDataRepresentation toRepresentation(
                IwcUserData iwcUserData, ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserDataRepresentation(iwcUserData, uriBuilderHolder)
        }
    }
}
