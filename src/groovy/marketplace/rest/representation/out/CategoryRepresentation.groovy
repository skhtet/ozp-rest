package marketplace.rest.representation.out

import marketplace.Category

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.AbstractHalRepresentation

import marketplace.rest.resource.ProfileResource

class CategoryRepresentation extends SelfRefRepresentation<Category> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-category-v1+json'

    private Category category

    private CategoryRepresentation(Category category,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(createSelfUri(category, uriBuilderHolder), null, null)

        this.category = category
    }

    private static URI createSelfUri(Category category,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        uriBuilderHolder.builder
            .path(CategoryResource.class)
            .path(CategoryResource.class, 'read')
            .buildFromMap(id: category.id)
    }

    public String getTitle() { category.title }
    public String getDescription() { category.description }
    public String getUuid() { category.uuid }
}
