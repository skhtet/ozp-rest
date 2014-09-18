package marketplace.hal

import javax.ws.rs.core.UriBuilder

import com.fasterxml.jackson.annotation.JsonIgnore
import marketplace.rest.DomainResource
import marketplace.rest.RepresentationResource
import marketplace.rest.RepresentationCollectionResource

/**
 * Representation of a collection where all of the elements are embedded representations
 *
 * TODO: This representation could probably support optional paging (next/prev links) as well
 */
class EmbeddedCollectionRepresentation<T> extends SelfRefRepresentation<PagedCollection<T>> {
    @JsonIgnore
    final Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType
    @JsonIgnore
    final Class<?> domainResourceType
    @JsonIgnore
    final Class<?> collectionResourceType

    /**
     * The total unpaged number of items
     */
    final int total

    EmbeddedCollectionRepresentation(
            Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType,
            Class<? extends RepresentationResource<T>> domainResourceType,
            Class<? extends RepresentationCollectionResource<T>> collectionResourceType,
            PagedCollection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        super(
            uriBuilderHolder.builder
                .path(collectionResourceType)
                .path(collectionResourceType, 'readAll') //sanity check that resource has readAll
                .build(),
            null,
            null
        )

        this.embeddedRepresentationType = embeddedRepresentationType
        this.domainResourceType = domainResourceType
        this.collectionResourceType = collectionResourceType

        this.addEmbedded(embedEntities(entities, uriBuilderHolder))
        this.addLinks(linkEntities(entities, uriBuilderHolder))

        this.total = total
    }

    EmbeddedCollectionRepresentation(
            Class<? extends AbstractHalRepresentation<T>> embeddedRepresentationType,
            Class<? extends DomainResource<T>> domainResourceType,
            PagedCollection<T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {

        this(embeddedRepresentationType, domainResourceType, entities, uriBuilderHolder)
    }

    private HalEmbedded embedEntities(Collection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(entities.collect { Object entity ->

            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    embeddedRepresentationType.newInstance(entity, uriBuilderHolder))
        })
    }

    private HalLinks linkEntities(PagedCollection entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        Collection<Map.Entry> navLinks = []
        Map prevPageParams = getNextPageParams(entities)
        Map nextPageParams = getNextPageParams(entities)
        UriBuilder pagingUriBuilder = uriBuilderHolder.builder
            .path(collectionResourceType)
            .path(collectionResourceType, 'readAll')


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
        int offset = entities.offset,
            max = entities.max == null ? entities.total : entities.max
            prevOffset

        if (offset == null || offset == 0) {
            return null
        }
        else {
            prevOffset = offset - max
            if (prevOffset < 0) {
                prevOffset = 0
            }

            return [offset: prevOffset, max: max]
        }
    }

    private Map getNextPageParams(PagedCollection entities) {
        int offset = entities.offset == null ? 0 : entities.offset
            max = entities.max == null ? entities.total : entities.max
            nextOffset = offset + max

        if (entities.items.size() < max) {
            //assume this is the last page
            return null
        }
        else {
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
            Class<? extends DomainResource> domainResourceType) {

        { Collection entities, ApplicationRootUriBuilderHolder uriBuilderHolder ->
            new EmbeddedCollectionRepresentation(embeddedRepresentationType,
                    domainResourceType, entities, uriBuilderHolder)
        } as RepresentationFactory
    }
}
