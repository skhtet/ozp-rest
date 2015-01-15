package marketplace.rest.representation.out

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import marketplace.Category

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.CategoryUriBuilder

@TestMixin(GrailsUnitTestMixin)
class CategoryRepresentationUnitTest {
    RepresentationFactory<Category> factory
    ApplicationRootUriBuilderHolder uriBuilderHolder

    void setUp() {
        uriBuilderHolder = new ApplicationRootUriBuilderHolder(
            new DefaultGrailsApplication(),
            [
                getBaseUriBuilder: {
                    UriBuilder.fromPath('https://localhost/asdf/')
                }
            ] as UriInfo
        )

        factory = new CategoryRepresentation.Factory()

        factory.uriBuilderFactory = new CategoryUriBuilder.Factory() {
            CategoryUriBuilder getBuilder(ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new CategoryUriBuilder(uriBuilderHolder) {
                    URI getUri(Category category) {
                        new URI("https://localhost/asdf/category/${category.id}")
                    }
                }
            }
        }
    }

    void testSelfUri() {
        Category category = new Category()
        category.id = 14

        CategoryRepresentation rep = factory.toRepresentation(category, uriBuilderHolder)

        assert rep.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/category/14'
    }
}
