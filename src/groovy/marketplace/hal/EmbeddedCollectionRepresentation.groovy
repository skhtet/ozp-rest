package marketplace.hal

import javax.ws.rs.core.UriBuilder

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

/**
 * Representation of a collection where all of the elements are embedded representations
 */
class EmbeddedCollectionRepresentation<T> extends SelfRefRepresentation<Collection<T>> {
    /**
     * The total unpaged number of items
     */
    @JsonInclude(Include.NON_NULL)
    final Integer total

    EmbeddedCollectionRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            Class<?> domainResourceType,
            Collection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(
            uriBuilderHolder.builder
                .path(domainResourceType)
                .build(),
            createLinks(domainResourceType, entities, uriBuilderHolder),
            createEmbedded(embeddedRepFactory, entities, uriBuilderHolder)
        )

        if (entities instanceof PagedCollection) {
            this.total = entities.total
        }
    }

    private static HalEmbedded createEmbedded(RepresentationFactory<T> embeddedRepFactory,
            Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepFactory.toRepresentation(entity, uriBuilderHolder))
        })
    }

    private static HalLinks createLinks(Class<?> domainResourceType, Collection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        Collection<Map.Entry> navLinks = []

        //set up next and prev links if we have paging info
        if (entities instanceof PagedCollection) {
            Map prevPageParams = getPrevPageParams(entities)
            Map nextPageParams = getNextPageParams(entities)
            UriBuilder pagingUriBuilder = uriBuilderHolder.builder
                .path(domainResourceType)


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


        Collection<Map.Entry> itemLinks = entities.collect { entity ->
            Map props = entity.properties as HashMap
            props.id = entity.id

            URI href = uriBuilderHolder.builder
                    .path(domainResourceType)
                    .path(domainResourceType, 'read')
                    .buildFromMap(props)

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, new Link(href))
        }


        new HalLinks(itemLinks + navLinks)
    }

    private static Map getPrevPageParams(PagedCollection entities) {
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

    private static Map getNextPageParams(PagedCollection entities) {
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

    /**
     *
     * @param the Class of the representation for the items in the collection
     * @param the Class of the Resource for the items in the collection
     * @return
     */
    public static <T> RepresentationFactory<Collection<T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            Class<?> domainResourceType) {

        { Collection<T> entities, ApplicationRootUriBuilderHolder uriBuilderHolder ->
            new EmbeddedCollectionRepresentation(embeddedRepFactory,
                    domainResourceType, entities, uriBuilderHolder)
        } as RepresentationFactory
    }
}
