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
import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ChildCollectionUriBuilder

class ChildObjectCollectionRepresentation<P,T>
        extends SelfRefRepresentation<ChildObjectCollection<P,T>> {

    protected ChildObjectCollectionRepresentation(ChildObjectCollection<P,T> collection,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            RepresentationFactory<T> itemFactory,
            ChildCollectionUriBuilder<P,T> collectionUriBuilder,
            ObjectUriBuilder<P> parentUriBuilder) {
        super(
            collectionUriBuilder.getCollectionUri(collection),
            createLinks(collection, parentUriBuilder),
            createEmbedded(collection, uriBuilderHolder, itemFactory)
        )
    }

    private static HalLinks createLinks(ChildObjectCollection<P,T> collection,
            ObjectUriBuilder<P> parentUriBuilder) {
        new HalLinks(RegisteredRelationType.VIA,
            new Link(parentUriBuilder.getUri(collection.parent)))
    }

    private static HalEmbedded createEmbedded(
            ChildObjectCollection<P,T> collection,
            ApplicationRootUriBuilderHolder uriBuilderHolder,
            RepresentationFactory<T> itemFactory) {
        Collection<AbstractHalRepresentation<T>> embeddedReps = collection.collection.collect {
            itemFactory.toRepresentation(it, uriBuilderHolder)
        }

        new HalEmbedded(embeddedReps.collect {
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, it)
        })
    }

    public static <P,T> RepresentationFactory<ChildObjectCollection<P,T>> createFactory(
            RepresentationFactory<T> itemFactory,
            ChildCollectionUriBuilder.Factory<P,T> collectionUriBuilderFactory,
            ObjectUriBuilder.Factory<P> parentUriBuilderFactory) {
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
