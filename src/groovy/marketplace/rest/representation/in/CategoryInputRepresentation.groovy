package marketplace.rest.representation.in

import marketplace.Profile

class CategoryInputRepresentation extends AbstractInputRepresentation<Category> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-category-v1+json'

    CategoryInputRepresentation() {
        super(Category.class)
    }

    String title
    String description
    String uuid
}
