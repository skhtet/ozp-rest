package marketplace.rest.reader

import javax.ws.rs.Consumes
import javax.ws.rs.ext.Provider
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.in.CategoryInputRepresentation

@Consumes([
    CategoryInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Provider
class CategoryInputRepresentationReader
        extends AbstractRepresentationReader<CategoryInputRepresentation> {}
