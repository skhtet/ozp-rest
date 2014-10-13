package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Type

import marketplace.hal.PagedCollection

import marketplace.rest.service.TypeRestService

import marketplace.rest.representation.out.TypeRepresentation
import marketplace.rest.representation.in.TypeInputRepresentation

@Path('api/type')
@Produces([
    TypeRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON
])
@Consumes([
    TypeInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class TypeResource extends RepresentationResource<Type, TypeInputRepresentation> {

    @Autowired
    public TypeResource(TypeRestService typeRestService) {
        super(typeRestService)
    }

    TypeResource() {}

    @Produces([
        TypeRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Type> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }
}
