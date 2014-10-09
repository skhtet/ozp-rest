package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.IwcDataObject
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.hal.SelfRefRepresentation
import marketplace.rest.IwcUserData
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

class IwcUserDataRepresentation extends SelfRefRepresentation<IwcUserData> {
    IwcUserDataRepresentation(IwcUserData iwcUserData, ProfileUriBuilder profileUriBuilder) {
        super(
            profileUriBuilder.getUserDataUri(iwcUserData.user),
            linkDataObjects(iwcUserData, profileUriBuilder), null)
    }

    private static HalLinks linkDataObjects(IwcUserData iwcUserData,
            ProfileUriBuilder profileUriBuilder) {
        new HalLinks(iwcUserData.dataObjects.collect { IwcDataObject dataObject ->
            URI href = profileUriBuilder.getUserDataItemUri(dataObject)
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        })
    }

    @Component
    static class Factory implements RepresentationFactory<IwcUserData> {
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        public IwcUserDataRepresentation toRepresentation(
                IwcUserData iwcUserData, ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new IwcUserDataRepresentation(iwcUserData,
                profileUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
