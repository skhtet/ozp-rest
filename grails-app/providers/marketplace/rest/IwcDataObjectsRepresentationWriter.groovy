package marketplace.rest

import marketplace.IwcDataObject
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

@Provider
@Produces([
    IwcDataObjectRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcDataObjectsRepresentationWriter extends AbstractRepresentationWriter<Collection<IwcDataObject>> {
    IwcDataObjectsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(IwcDataObjectRepresentation.class,
                IwcDataObjectResource.class))
    }
}
