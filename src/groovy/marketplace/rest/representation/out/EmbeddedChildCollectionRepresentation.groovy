package marketplace.rest.representation.out

import marketplace.rest.ChildObjectCollection

import marketplace.hal.RepresentationFactory
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.Link
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.RootResourceUriBuilder
import marketplace.rest.resource.uribuilder.DomainResourceUriBuilder

import marketplace.rest.ChildObjectCollection

/**
 * Subclass of EmbeddedCollectionRepresentation for ChildObjectCollections, which adds the 'via'
 * link to the parent object
 */
class EmbeddedChildCollectionRepresentation<P, T> extends EmbeddedCollectionRepresentation<T> {
    EmbeddedChildCollectionRepresentation(
            RepresentationFactory<T> embeddedRepFactory,
            RootResourceUriBuilder resourceUriBuilder,
            DomainResourceUriBuilder<P> parentUriBuilder,
            ChildObjectCollection<P,T> entities,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(embeddedRepFactory, resourceUriBuilder, entities, uriBuilderHolder)

        this.addLink(RegisteredRelationType.VIA,
            new Link(parentUriBuilder.getUri(entities.parent)))
    }

    public static <P,T> RepresentationFactory<ChildObjectCollection<P,T>> createFactory(
            RepresentationFactory<T> embeddedRepFactory,
            RootResourceUriBuilder.Factory uriBuilderFactory,
            DomainResourceUriBuilder.Factory<P> parentUriBuilderFactory) {

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
