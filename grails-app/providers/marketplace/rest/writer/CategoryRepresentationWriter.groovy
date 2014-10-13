package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Category

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.CategoryRepresentation

@Provider
@Produces([CategoryRepresentation.MEDIA_TYPE])
class CategoryRepresentationWriter extends AbstractRepresentationWriter<Category> {

    @Autowired
    CategoryRepresentationWriter(CategoryRepresentation.Factory factory) {
        super(factory)
    }
}

