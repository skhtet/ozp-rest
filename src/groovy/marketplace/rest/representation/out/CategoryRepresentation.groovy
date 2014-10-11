package marketplace.rest.representation.out

import marketplace.Category

import marketplace.hal.SelfRefRepresentation

import marketplace.rest.resource.uribuilder.ResourceUriBuilder

class CategoryRepresentation extends SelfRefRepresentation<Category> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-category-v1+json'

    private Category category

    private CategoryRepresentation(Category category,
            ResourceUriBuilder<Category> categoryUriBuilder) {
        super(categoryUriBuilder.getUri(category), null, null)

        this.category = category
    }

    public String getTitle() { category.title }
    public String getDescription() { category.description }
}
