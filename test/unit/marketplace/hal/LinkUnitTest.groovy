package marketplace.hal

import javax.ws.rs.core.MediaType;

import com.damnhandy.uri.template.UriTemplate

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class LinkUnitTest {
    String templateHref = 'http://localhost/{var}'
    String href = 'http://localhost/test'
    String name = 'test name'
    MediaType type = MediaType.APPLICATION_JSON_TYPE
    URI deprecation = new URI('http://localhost/deprecated')
    URI profile = new URI('http://localhost/profile')
    String title = 'human readable title'
    String hreflang = 'en-US'

    void testTemplateConstructors() {
        Link link = new Link(UriTemplate.buildFromTemplate(templateHref).build())
        assert link.href == templateHref
        assert link.templated == true
        assert link.type == null
        assert link.deprecation == null
        assert link.name == null
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        link = new Link(UriTemplate.buildFromTemplate(templateHref).build(), name)
        assert link.href == templateHref
        assert link.templated == true
        assert link.type == null
        assert link.deprecation == null
        assert link.name == name
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        link = new Link(UriTemplate.buildFromTemplate(templateHref).build(), type, deprecation,
            name, profile, title, hreflang)
        assert link.href == templateHref
        assert link.templated == true
        assert link.type == type
        assert link.deprecation == deprecation
        assert link.name == name
        assert link.profile == profile
        assert link.title == title
        assert link.hreflang == hreflang
    }

    void testURIConstructors() {
        Link link = new Link(new URI(href))
        assert link.href == href
        assert link.templated == null
        assert link.type == null
        assert link.deprecation == null
        assert link.name == null
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        link = new Link(new URI(href), name)
        assert link.href == href
        assert link.templated == null
        assert link.type == null
        assert link.deprecation == null
        assert link.name == name
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        link = new Link(new URI(href), type, deprecation, name, profile, title, hreflang)
        assert link.href == href
        assert link.templated == null
        assert link.type == type
        assert link.deprecation == deprecation
        assert link.name == name
        assert link.profile == profile
        assert link.title == title
        assert link.hreflang == hreflang
    }

    void testStringConstructor() {
        Link link = new Link(templateHref, true, type, deprecation, name, profile,
            title, hreflang)
        assert link.href == templateHref
        assert link.templated == true
        assert link.type == type
        assert link.deprecation == deprecation
        assert link.name == name
        assert link.profile == profile
        assert link.title == title
        assert link.hreflang == hreflang

        link = new Link(templateHref, true, null, null, null, null, null, null)
        assert link.href == templateHref
        assert link.templated == true
        assert link.type == null
        assert link.deprecation == null
        assert link.name == null
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        link = new Link(href, false, type, deprecation, name, profile, title, hreflang)
        assert link.href == href
        assert link.templated == null
        assert link.type == type
        assert link.deprecation == deprecation
        assert link.name == name
        assert link.profile == profile
        assert link.title == title
        assert link.hreflang == hreflang

        link = new Link(href, false, null, null, null, null, null, null)
        assert link.href == href
        assert link.templated == null
        assert link.type == null
        assert link.deprecation == null
        assert link.name == null
        assert link.profile == null
        assert link.title == null
        assert link.hreflang == null

        shouldFail(URISyntaxException) {
            new Link(templateHref, false, null, null, null, null, null, null)
        }

        shouldFail(URISyntaxException) {
            new Link(templateHref, false, type, deprecation, name, profile, title, hreflang)
        }
    }

    void testEquals() {
        assert new Link(new URI(href)) == new Link(new URI(href))
        assert new Link(new URI(href)) == new Link(new URI(href), name)
        assert new Link(new URI(href)) == new Link(new URI(href), type, deprecation, name,
            profile, title, hreflang)

        assert new Link(UriTemplate.buildFromTemplate(templateHref).build()) ==
            new Link(UriTemplate.buildFromTemplate(templateHref).build())
        assert new Link(UriTemplate.buildFromTemplate(templateHref).build()) ==
            new Link(UriTemplate.buildFromTemplate(templateHref).build(), name)
        assert new Link(UriTemplate.buildFromTemplate(templateHref).build()) ==
            new Link(UriTemplate.buildFromTemplate(templateHref).build(), type, deprecation, name,
                profile, title, hreflang)

        assert new Link(new URI(href)) != new Link(UriTemplate.buildFromTemplate(href).build())
        assert new Link(href, true, null, null, null, null, null, null) !=
            new Link(href, false, null, null, null, null, null, null)
    }

    void testHashCode() {
        assert new Link(new URI(href)).hashCode() == new Link(new URI(href), name).hashCode()
        assert new Link(new URI(href)).hashCode() == new Link(new URI(href), type, deprecation,
            name, profile, title, hreflang).hashCode()

        assert new Link(UriTemplate.buildFromTemplate(templateHref).build()).hashCode() ==
            new Link(UriTemplate.buildFromTemplate(templateHref).build(), name).hashCode()
        assert new Link(UriTemplate.buildFromTemplate(templateHref).build()).hashCode() ==
            new Link(UriTemplate.buildFromTemplate(templateHref).build(), type, deprecation, name,
                profile, title, hreflang).hashCode()

        assert new Link(new URI(href)).hashCode() !=
            new Link(UriTemplate.buildFromTemplate(href).build()).hashCode()
        assert new Link(href, true, null, null, null, null, null, null).hashCode() !=
            new Link(href, false, null, null, null, null, null, null).hashCode()
    }
}
