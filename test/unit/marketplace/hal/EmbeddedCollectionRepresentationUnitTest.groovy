package marketplace.hal

import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.UriInfo

import grails.orm.PagedResultList

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.testutil.MockPagedResultList

@TestMixin(GrailsUnitTestMixin)
class EmbeddedCollectionRepresentationUnitTest {
    private ApplicationRootUriBuilderHolder makeUriBuilderHolder() {
        ApplicationRootUriBuilderHolder uriBuilderHolder = new ApplicationRootUriBuilderHolder([
            getBaseUriBuilder: { UriBuilder.fromPath('https://localhost/asdf/') }
        ] as UriInfo)
    }

    void testSelfLink() {
        ApplicationRootUriBuilderHolder uriBuilderHolder = makeUriBuilderHolder()

        def representation = new EmbeddedCollectionRepresentation(null,
                new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
                null,
                [],
                uriBuilderHolder)

        assert representation.links.toMap().get(RegisteredRelationType.SELF).href ==
            'https://localhost/asdf/api/profile'
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
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
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

        ApplicationRootUriBuilderHolder uriBuilderHolder = makeUriBuilderHolder()

        def representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        //when the inner collection is not paged, the total should be its size
        assert representation.total == 4

        paged = new PagedCollection(null, null,
            new MockPagedResultList().createPagedResultList(entities, 100))

        uriBuilderHolder = makeUriBuilderHolder()
        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        assert representation.total == 100
    }

    void testPagingLinks() {
        Collection entities = [[id: 1],[id: 2],[id: 3],[id: 4]]
        PagedCollection paged = new PagedCollection(null, null, entities)

        def uriBuilderHolder = makeUriBuilderHolder()
        def representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        //with no offset and max the paging links should not be added
        assert representation.links.toMap().get(RegisteredRelationType.NEXT) == null
        assert representation.links.toMap().get(RegisteredRelationType.PREV) == null

        paged = new PagedCollection(null, 4,
            new MockPagedResultList().createPagedResultList(entities, 100))

        uriBuilderHolder = makeUriBuilderHolder()
        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        //on first page - no prev link
        assert representation.links.toMap().get(RegisteredRelationType.PREV) == null
        assert representation.links.toMap().get(RegisteredRelationType.NEXT).href ==
            'https://localhost/asdf/api/profile?max=4&offset=4'


        paged = new PagedCollection(8, 4,
            new MockPagedResultList().createPagedResultList(entities, 100))

        uriBuilderHolder = makeUriBuilderHolder()
        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        assert representation.links.toMap().get(RegisteredRelationType.PREV).href ==
            'https://localhost/asdf/api/profile?max=4&offset=4'
        assert representation.links.toMap().get(RegisteredRelationType.NEXT).href ==
            'https://localhost/asdf/api/profile?max=4&offset=12'

        paged = new PagedCollection(96, 4,
            new MockPagedResultList().createPagedResultList(entities, 100))

        uriBuilderHolder = makeUriBuilderHolder()
        representation = new EmbeddedCollectionRepresentation(
            new EmbeddedRepresentation.Factory(),
            new ProfileUriBuilder.Factory().getBuilder(uriBuilderHolder),
            null,
            paged,
            uriBuilderHolder
        )

        assert representation.links.toMap().get(RegisteredRelationType.PREV).href ==
            'https://localhost/asdf/api/profile?max=4&offset=92'

        //last page - no next link
        assert representation.links.toMap().get(RegisteredRelationType.NEXT) == null
    }
}
