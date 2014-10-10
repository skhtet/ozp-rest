package marketplace.rest.resource.uribuilder

import org.springframework.stereotype.Component

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.resource.CategoryResource
import marketplace.Category

class CategoryUriBuilder extends RepresentationResourceUriBuilder<Category> {
    protected CategoryUriBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(CategoryResource.class, uriBuilderHolder)
    }

    @Component
    public static class Factory implements ResourceUriBuilder.Factory<Category> {
        CategoryUriBuilder getBuilder(
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new CategoryUriBuilder(uriBuilderHolder)
        }
    }
}

