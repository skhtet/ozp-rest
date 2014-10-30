package marketplace.rest.representation.out

import marketplace.rest.ChildObjectCollection

import marketplace.hal.RepresentationFactory
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.CollectionUriBuilder
import marketplace.rest.resource.uribuilder.ChildCollectionUriBuilder
import marketplace.rest.resource.uribuilder.ObjectUriBuilder

import marketplace.rest.ChildObjectCollection

/**
 * Subclass of EmbeddedCollectionRepresentation for ChildObjectCollections, which adds the 'via'
 * link to the parent object
 */
class EmbeddedChildCollectionRepresentation<P, T> extends EmbeddedCollectionRepresentation<T> {
    EmbeddedChildCollectionRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            ChildCollectionUriBuilder<P,T> collectionUriBuilder,
            ObjectUriBuilder<P> parentUriBuilder,
            ChildObjectCollection<P,T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(embeddedRepFactory,
            collectionUriBuilder.getCollectionUriBuilder(entities),
            entities, uriBuilderHolder)

        this.addLink(RegisteredRelationType.VIA,
            new Link(parentUriBuilder.getUri(entities.parent)))
    }

    public static <P,T> RepresentationFactory<ChildObjectCollection<P,T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            ChildCollectionUriBuilder.Factory uriBuilderFactory,
            ObjectUriBuilder.Factory<P> parentUriBuilderFactory) {

        new RepresentationFactory() {
            EmbeddedChildCollectionRepresentation toRepresentation(
                    entities,
                    ApplicationRootUriBuilderHolder uriBuilderHolder) {
                new EmbeddedChildCollectionRepresentation<P,T>(embeddedRepFactory,
                        uriBuilderFactory.getBuilder(uriBuilderHolder),
                        parentUriBuilderFactory.getBuilder(uriBuilderHolder),
                        entities, uriBuilderHolder)
            }
        }
    }
}
