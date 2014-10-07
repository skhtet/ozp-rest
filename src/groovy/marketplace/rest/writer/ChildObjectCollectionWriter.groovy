package marketplace.rest.writer

import marketplace.hal.RepresentationFactory
import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.ChildObjectCollection
import marketplace.rest.representation.out.ChildObjectCollectionRepresentation

import marketplace.rest.resource.uribuilder.ResourceUriBuilder
import marketplace.rest.resource.uribuilder.ChildObjectCollectionUriBuilder

abstract class ChildObjectCollectionWriter<P,T> extends AbstractRepresentationWriter<ChildObjectCollection<P,T>> {
    /**
     * @param itemFactory The RepresentationFactory for the individual items in
     * the collection
     */
    protected ChildObjectCollectionWriter(RepresentationFactory<T> itemFactory,
            ChildObjectCollectionUriBuilder.Factory<P,T> collectionUriBuilderFactory,
            ResourceUriBuilder.Factory<P> parentUriBuilderFactory) {
        super(ChildObjectCollectionRepresentation.createFactory(itemFactory, collectionUriBuilderFactory, parentUriBuilderFactory))
    }
}
