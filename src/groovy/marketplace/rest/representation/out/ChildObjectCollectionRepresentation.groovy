package marketplace.rest.representation.out

import marketplace.hal.SelfRefRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.RepresentationFactory
import marketplace.hal.RegisteredRelationType
import marketplace.hal.RelationType
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link

import marketplace.rest.ChildObjectCollection
import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ChildObjectCollectionUriBuilder

class ChildObjectCollectionRepresentation<P,T> extends SelfRefRepresentation<Collection<T>> {

    protected ChildObjectCollectionRepresentation(ChildObjectCollection<P,T> collection,
            ApplicationRootUriBuilderHolder uriBuilderHolder, RepresentationFactory<T> itemFactory,
            ChildObjectCollectionUriBuilder<P,T> collectionUriBuilder,
            ResourceUriBuilder<P> parentUriBuilder) {
        super(
            collectionUriBuilder.getCollectionUri(collection),
            createLinks(collection, parentUriBuilder),
            createEmbedded(collection, uriBuilderHolder, itemFactory)
        )
    }

    private static HalLinks createLinks(ChildObjectCollection<P,T> collection,
            ResourceUriBuilder<P> parentUriBuilder) {
        new HalLinks(RegisteredRelationType.VIA, new Link(parentUriBuilder.getUri(collection.parent)))
    }

    private static HalEmbedded createEmbedded(ChildObjectCollection<P,T> collection,
            ApplicationRootUriBuilderHolder uriBuilderHolder, RepresentationFactory<T> itemFactory) {
        Collection<AbstractHalRepresentation<T>> embeddedReps = collection.collection.collect {
            itemFactory.toRepresentation(it, uriBuilderHolder)
        }

        new HalEmbedded(embeddedReps.collect {
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, it)
        })
    }

    public static <P,T> RepresentationFactory<ChildObjectCollection<P,T>> createFactory(RepresentationFactory<T> itemFactory,
            ChildObjectCollectionUriBuilder.Factory<P,T> collectionUriBuilderFactory,
            ResourceUriBuilder.Factory<P> parentUriBuilderFactory) {
        //due to GROOVY-6556, cannot use anonymous class here
        [
            toRepresentation: { ChildObjectCollection collection,
                    ApplicationRootUriBuilderHolder uriBuilderHolder ->
                new ChildObjectCollectionRepresentation(collection, uriBuilderHolder, itemFactory,
                    collectionUriBuilderFactory.getBuilder(uriBuilderHolder),
                    parentUriBuilderFactory.getBuilder(uriBuilderHolder))
            }
        ] as RepresentationFactory
    }
}
