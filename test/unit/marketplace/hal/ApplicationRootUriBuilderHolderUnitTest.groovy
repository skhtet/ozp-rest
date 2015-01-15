package marketplace.hal

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

@TestMixin(GrailsUnitTestMixin)
class ApplicationRootUriBuilderHolderUnitTest {
    URI baseUri
    UriInfo uriInfo
    ApplicationRootUriBuilderHolder builderHolder

    GrailsApplication grailsApplication

    void setUp() {
        baseUri = new URI('https://localhost/marketplace')
        UriBuilder baseUriBuilder = UriBuilder.fromUri(baseUri)
        uriInfo = [
            getBaseUriBuilder: { baseUriBuilder }
        ] as UriInfo

        grailsApplication = new DefaultGrailsApplication()

        builderHolder = new ApplicationRootUriBuilderHolder(
            grailsApplication, uriInfo)
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

    //test that if the marketplace.publicURI configuration is present,
    //it uses that instead of the UriInfo
    void testUsesConfiguration() {
        String confValue = 'https://widgethome:8443/store'

        grailsApplication.config.marketplace.publicURI = confValue

        //the conf is used at construction time so we have to make a new one
        builderHolder = new ApplicationRootUriBuilderHolder(
            grailsApplication, uriInfo)

        assert builderHolder.builder.build() == new URI(confValue)
    }
}
