package marketplace.hal

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class ApplicationRootUriBuilderHolderUnitTest {
    URI baseUri
    ApplicationRootUriBuilderHolder builderHolder

    void setUp() {
        baseUri = new URI('https://localhost/marketplace')
        UriBuilder baseUriBuilder = UriBuilder.fromUri(baseUri)
        UriInfo uriInfo = [
            getBaseUriBuilder: { baseUriBuilder }
        ] as UriInfo
        builderHolder = new ApplicationRootUriBuilderHolder(uriInfo)
    }

    void testGetsBaseUri() {
        assert builderHolder.builder.build() == baseUri
    }

    //test that each call to the getBuilder returns a fresh builder
    void testGetsFreshBuilder() {
        UriBuilder builder1 = builderHolder.builder
        UriBuilder builder2 = builderHolder.builder

        assert builder1.build() == baseUri
        assert builder2.build() == baseUri
        assert !builder1.is(builder2)

        UriBuilder builder3 = builderHolder.builder
        builder3.path('test-path')
        UriBuilder builder4 = builderHolder.builder

        assert builder3.build() != builder4.build()
        assert builder4.build() == baseUri
        assert !builder3.is(builder4)
    }
}
