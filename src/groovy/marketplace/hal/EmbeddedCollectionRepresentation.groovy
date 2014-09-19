package marketplace.hal

import javax.ws.rs.core.UriBuilder

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

/**
 * Representation of a collection where all of the elements are embedded representations
 *
 * TODO: This representation could probably support optional paging (next/prev links) as well
 */
class EmbeddedCollectionRepresentation<T> extends SelfRefRepresentation<Collection<T>> {
    @JsonIgnore
    final Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType
    @JsonIgnore
    final Class<?> domainResourceType

    /**
     * The total unpaged number of items
     */
    @JsonInclude(Include.NON_NULL)
    final Integer total

    EmbeddedCollectionRepresentation(
            Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType,
            Class<?> domainResourceType,
            Collection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(
            uriBuilderHolder.builder
                .path(domainResourceType)
                .build(),
            null,
            null
        )

        this.embeddedRepresentationType = embeddedRepresentationType
        this.domainResourceType = domainResourceType
        this.domainResourceType = domainResourceType

        this.addEmbedded(embedEntities(entities, uriBuilderHolder))
        this.addLinks(linkEntities(entities, uriBuilderHolder))

        if (entities instanceof PagedCollection) {
            this.total = entities.total
        }
    }

    private HalEmbedded embedEntities(Collection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepresentationType.newInstance(entity, uriBuilderHolder))
        })
    }

    private HalLinks linkEntities(Collection entities,
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


        Collection<Map.Entry> itemLinks = entities.items.collect { entity ->
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

    private Map getPrevPageParams(PagedCollection entities) {
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

    private Map getNextPageParams(PagedCollection entities) {
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
    public static RepresentationFactory<Collection<?>> createFactory(
            Class<? extends AbstractHalRepresentation> embeddedRepresentationType,
            Class<?> domainResourceType) {

        { Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder ->
            new EmbeddedCollectionRepresentation(embeddedRepresentationType,
                    domainResourceType, entities, uriBuilderHolder)
        } as RepresentationFactory
    }
}
