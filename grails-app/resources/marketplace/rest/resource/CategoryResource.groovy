package marketplace.rest.resource

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.rest.service.CategoryRestService

@Path('api/category')
class CategoryResource extends RepresentationResource<Category> {

    @Autowired
    public CategoryResource(CategoryRestService categoryRestService) {
        super(categoryRestService)
    }

    CategoryResource() {}
}
