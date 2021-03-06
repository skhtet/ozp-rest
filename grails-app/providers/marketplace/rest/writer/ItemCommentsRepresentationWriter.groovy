package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.representation.out.ItemCommentRepresentation
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ItemCommentUriBuilder

import marketplace.Listing
import marketplace.ItemComment

@Provider
@Produces([
    ItemCommentRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class ItemCommentsRepresentationWriter extends ChildObjectCollectionWriter<Listing, ItemComment> {

    @Autowired
    ItemCommentsRepresentationWriter(GrailsApplication grailsApplication,
            ItemCommentRepresentation.Factory factory,
            ItemCommentUriBuilder.Factory collectionUriBuilderFactory,
            ListingUriBuilder.Factory parentUriBuilderFactory) {
        super(grailsApplication, factory, collectionUriBuilderFactory, parentUriBuilderFactory)
    }
}
