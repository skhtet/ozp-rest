package marketplace.rest.writer

import marketplace.IwcDataObject
import marketplace.hal.AbstractRepresentationWriter
import marketplace.hal.EmbeddedCollectionRepresentation

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider

import marketplace.rest.representation.out.IwcDataObjectRepresentation
import marketplace.rest.resource.IwcDataObjectResource

@Provider
@Produces([
    IwcDataObjectRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IwcDataObjectsRepresentationWriter extends AbstractRepresentationWriter<Collection<IwcDataObject>> {
    IwcDataObjectsRepresentationWriter() {
        super(EmbeddedCollectionRepresentation.createFactory(
            new IwcDataObjectRepresentation.Factory(), IwcDataObjectResource.class))
    }
}
