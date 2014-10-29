package marketplace.rest.writer

import marketplace.hal.RepresentationFactory
import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.ChildObjectCollection
import marketplace.rest.representation.out.ChildObjectCollectionRepresentation

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ChildCollectionUriBuilder

abstract class ChildObjectCollectionWriter<P,T> extends
        AbstractRepresentationWriter<ChildObjectCollection<P,T>> {
    /**
     * @param itemFactory The RepresentationFactory for the individual items in
     * the collection
     */
    protected ChildObjectCollectionWriter(RepresentationFactory<T> itemFactory,
            ChildCollectionUriBuilder.Factory<P,T> collectionUriBuilderFactory,
            ObjectUriBuilder.Factory<P> parentUriBuilderFactory) {
        super(ChildObjectCollectionRepresentation.createFactory(itemFactory,
                collectionUriBuilderFactory, parentUriBuilderFactory))
    }
}
