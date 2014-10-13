package marketplace.rest.resource

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Consumes
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.hal.PagedCollection

import marketplace.rest.service.CategoryRestService

import marketplace.rest.representation.out.CategoryRepresentation
import marketplace.rest.representation.in.CategoryInputRepresentation

@Path('api/category')
@Produces([
    CategoryRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
@Consumes([
    CategoryInputRepresentation.MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class CategoryResource extends RepresentationResource<Category, CategoryInputRepresentation> {

    @Autowired
    public CategoryResource(CategoryRestService categoryRestService) {
        super(categoryRestService)
    }

    CategoryResource() {}

    @Produces([
        CategoryRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @GET
    PagedCollection<Category> readAll(@QueryParam('offset') Integer offset,
            @QueryParam('max') Integer max) {
        new PagedCollection(offset, max, service.getAll(offset, max))
    }
}
