package marketplace.rest.representation.out

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.PagedCollection
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.rest.resource.uribuilder.CollectionUriBuilder
import marketplace.rest.resource.uribuilder.SearchUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.search.SearchResult

import marketplace.Paging

import javax.ws.rs.core.UriBuilder

class HalCollectionRepresentationSupport {
    static HalEmbedded createEmbedded(RepresentationFactory embeddedRepFactory,
              Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepFactory.toRepresentation(entity, uriBuilderHolder))
        })
    }

    static <T> HalLinks createLinks(
            SearchUriBuilder<T> searchUriBuilder,
            ObjectUriBuilder<T> objectUriBuilder,
            SearchResult<T> entities) {
        createLinks(
            searchUriBuilder.getCollectionUriBuilder(entities),
            objectUriBuilder,
            (Paging<T>)entities
        )
    }

    static <T> HalLinks createLinks(
            CollectionUriBuilder<T> collectionUriBuilder,
            ObjectUriBuilder<T> objectUriBuilder,
            Paging<T> entities) {
        Collection<Map.Entry> navLinks = []

        Map prevPageParams = getPrevPageParams(entities)
        Map nextPageParams = getNextPageParams(entities)
        UriBuilder pagingUriBuilder =
            UriBuilder.fromUri(collectionUriBuilder.getCollectionUri())

        //add link to previous page in collection
        if (prevPageParams) {
            UriBuilder prevPageUriBuilder = pagingUriBuilder.clone()

            prevPageParams.each { k, v ->
                prevPageUriBuilder = prevPageUriBuilder.replaceQueryParam(k, v)
            }

            navLinks << new AbstractMap.SimpleEntry(RegisteredRelationType.PREV,
                    new Link(prevPageUriBuilder.build()))
        }

        //add link to next page in collection
        if (nextPageParams) {
            UriBuilder nextPageUriBuilder = pagingUriBuilder.clone()

            nextPageParams.each { k, v ->
                nextPageUriBuilder = nextPageUriBuilder.replaceQueryParam(k, v)
            }

            navLinks << new AbstractMap.SimpleEntry(RegisteredRelationType.NEXT,
                    new Link(nextPageUriBuilder.build()))
        }

        HalLinks links = new HalLinks(navLinks)
        links.addLinks(createLinks(collectionUriBuilder, objectUriBuilder, (Collection)entities))

        return links
    }

    /**
     * This signature is intentionally parallel to that of the previous method, in order
     * to allow polymorphism to select the correct implementation
     */
    static <T> HalLinks createLinks(
            CollectionUriBuilder<T> collectionUriBuilder,
            ObjectUriBuilder<T> objectUriBuilder,
            Collection<T> entities) {
        if (objectUriBuilder) {
            Collection<Map.Entry> itemLinks =
                entities.collect { entity ->
                    URI href = objectUriBuilder.getUri(entity)
                    new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
                }

            new HalLinks(itemLinks)
        }
        else {
            new HalLinks()
        }
    }

    private static Map getPrevPageParams(Paging entities) {
        Integer offset = entities.offset,
                max = entities.max == null ? entities.total : entities.max,
                prevOffset

        if (offset == null || offset == 0) {
            return null
        }
        else {
            prevOffset = Math.max(offset - max, 0)
            return [offset: prevOffset, max: max]
        }
    }

    private static Map getNextPageParams(Paging entities) {
        Integer offset = entities.offset == null ? 0 : entities.offset,
                max = entities.max,
                nextOffset

        if (entities.max == null || offset + max >= entities.total) {
            //assume this is the last page
            return null
        }
        else {
            nextOffset = offset + max
            return [offset: nextOffset, max: max]
        }
    }
}
