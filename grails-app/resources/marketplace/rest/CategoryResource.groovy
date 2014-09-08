package marketplace.rest

import javax.ws.rs.Path
import marketplace.Category
import org.springframework.beans.factory.annotation.Autowired

@Path('api/category')
class CategoryResource extends DomainResource<Category> {

    @Autowired
    public CategoryResource(CategoryRestService categoryRestService) {
        super(Category.class, categoryRestService)
    }

    CategoryResource() {}
}
