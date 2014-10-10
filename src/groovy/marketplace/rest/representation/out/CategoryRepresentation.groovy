package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.AbstractHalRepresentation

import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.CategoryUriBuilder

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
    public String getUuid() { category.uuid }
    public Long getId() { category.id }

    @Component
    public static class Factory implements RepresentationFactory<Category> {
        @Autowired CategoryUriBuilder.Factory categoryUriBuilderFactory

        CategoryRepresentation toRepresentation(Category category,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            new CategoryRepresentation(category,
                categoryUriBuilderFactory.getBuilder(uriBuilderHolder))
        }
    }
}
