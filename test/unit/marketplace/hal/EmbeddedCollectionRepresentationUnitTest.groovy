package marketplace.hal

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.orm.PagedResultList

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.rest.resource.ProfileResource

@TestMixin(GrailsUnitTestMixin)
class EmbeddedCollectionRepresentationUnitTest {
    private ApplicationRootUriBuilderHolder makeUriBuilderHolder() {
        ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
            getBaseUriBuilder: { UriBuilder.fromPath('https://localhost/asdf/') }
        ] as UriInfo)
    }

    private PagedResultList mockPagedResultList(items, total) {
        //taken from http://stackoverflow.com/a/19216929
        def mockC = mockFor(org.hibernate.Criteria)
        mockC.demand.list { return [] } //PagedResultList constructor calls this

        return new PagedResultList(null, mockC.createMock()){{
           list = items
           totalCount = total
        }}
    }

    void testSelfLink() {
        URI selfUri = new URI('https://localhost/asdf/')
        def selfLinkResource

        ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
            getBaseUriBuilder: {
                [
                    clone: {
                        [
                            path: {
                                selfLinkResource = it
                                return [
                                    build: {
                                        selfUri
                                    }
                                ] as UriBuilder
                            }
                        ] as UriBuilder
                    }
                ] as UriBuilder
            }
        ] as UriInfo)

        def representation = new EmbeddedCollectionRepresentation(null, this.getClass(), [],
                uriBuilderHolder)

        assert selfLinkResource == this.getClass()
        assert representation.links.toMap().get(RegisteredRelationType.SELF).href ==
            selfUri.toString()
    }

    private static class EmbeddedRepresentation extends AbstractHalRepresentation {
        def entity
        def uriBuilderHolder

        EmbeddedRepresentation(entity, ApplicationRootUriBuilderHolder uriBuilderHolder) {
            this.entity = entity
            this.uriBuilderHolder = uriBuilderHolder
        }

        public static class Factory implements RepresentationFactory {
            EmbeddedRepresentation toRepresentation(entity,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new EmbeddedRepresentation(entity, uriBuilderHolder)
            }
        }
    }

    void testEmbeddedEntities() {
        Collection entities = [[id: 1],[id: 2],[id: 3],[id: 4]]
        ApplicationRootUriBuilderHolder uriBuilderHolder = makeUriBuilderHolder()

        def representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            entities,
            uriBuilderHolder
        )

        Collection embedded = representation.embedded.get(RegisteredRelationType.ITEM)

        assert embedded.inject(true) { acc, embed ->
            acc && embed instanceof EmbeddedRepresentation
        }
        assert embedded.inject(true) { acc, embed ->
            acc && embed.uriBuilderHolder == uriBuilderHolder
        }
        assert [embedded, entities].transpose().collect { it[0].entity == it[1] }
    }

    void testPagedCollectionTotal() {
        Collection entities = [[id: 1],[id: 2],[id: 3],[id: 4]]
        PagedCollection paged = new PagedCollection(null, null, entities)

        def representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        //when the inner collection is not paged, the total should be its size
        assert representation.total == 4

        paged = new PagedCollection(null, null, mockPagedResultList(entities, 100))
        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        assert representation.total == 100
    }

    void testPagingLinks() {
        Collection entities = [[id: 1],[id: 2],[id: 3],[id: 4]]
        PagedCollection paged = new PagedCollection(null, null, entities)

        def representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        //with no offset and max the paging links should not be added
        assert representation.links.toMap().get(RegisteredRelationType.NEXT) == null
        assert representation.links.toMap().get(RegisteredRelationType.PREV) == null

        paged = new PagedCollection(null, 4, mockPagedResultList(entities, 100))

        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        //on first page - no prev link
        assert representation.links.toMap().get(RegisteredRelationType.PREV) == null
        assert representation.links.toMap().get(RegisteredRelationType.NEXT).href ==
            'https://localhost/asdf/api/profile?max=4&offset=4'


        paged = new PagedCollection(8, 4, mockPagedResultList(entities, 100))

        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        assert representation.links.toMap().get(RegisteredRelationType.PREV).href ==
            'https://localhost/asdf/api/profile?max=4&offset=4'
        assert representation.links.toMap().get(RegisteredRelationType.NEXT).href ==
            'https://localhost/asdf/api/profile?max=4&offset=12'

        paged = new PagedCollection(96, 4, mockPagedResultList(entities, 100))

        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            ProfileResource.class,
            paged,
            makeUriBuilderHolder()
        )

        assert representation.links.toMap().get(RegisteredRelationType.PREV).href ==
            'https://localhost/asdf/api/profile?max=4&offset=92'

        //last page - no next link
        assert representation.links.toMap().get(RegisteredRelationType.NEXT) == null
    }
}
