package marketplace.rest.representation.out

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalEmbedded
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.PagedCollection
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RepresentationFactory
import marketplace.rest.resource.uribuilder.RootResourceUriBuilder
import marketplace.rest.resource.uribuilder.DomainResourceUriBuilder
import marketplace.search.SearchResult

import javax.ws.rs.core.UriBuilder

class HalCollectionRepresentationSupport {
    static HalEmbedded createEmbedded(RepresentationFactory embeddedRepFactory,
                                              Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepFactory.toRepresentation(entity, uriBuilderHolder))
        })
    }

    static HalLinks createLinks(RootResourceUriBuilder resourceUriBuilder,
                                        Collection entities) {
        Collection<Map.Entry> navLinks = []

        //TODO: Next/Prev links for SearchResult
        //set up next and prev links if we have paging info
        if (entities instanceof PagedCollection || entities instanceof SearchResult) {
            Map prevPageParams = getPrevPageParams(entities)
            Map nextPageParams = getNextPageParams(entities)
            UriBuilder pagingUriBuilder = entities instanceof SearchResult ?
                    UriBuilder.fromUri(resourceUriBuilder.getSearchUri(entities)) : UriBuilder.fromUri(resourceUriBuilder.getRootUri())

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
        }


        //generate links to items if possible
        Collection<Map.Entry> itemLinks =
            (resourceUriBuilder instanceof DomainResourceUriBuilder) ?
                entities.collect { entity ->
                    URI href = resourceUriBuilder.getUri(entity)
                    new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
                } : []

        new HalLinks(itemLinks + navLinks)
    }

    private static Map getPrevPageParams(Collection entities) {
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

    private static Map getNextPageParams(Collection entities) {
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
