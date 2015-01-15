package marketplace.rest.writer

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.ItemComment

import marketplace.hal.AbstractRepresentationWriter

import marketplace.rest.representation.out.ItemCommentRepresentation

@Provider
@Produces([ItemCommentRepresentation.MEDIA_TYPE, MediaType.APPLICATION_JSON])
class ItemCommentRepresentationWriter extends AbstractRepresentationWriter<ItemComment> {
    @Autowired
    ItemCommentRepresentationWriter(GrailsApplication grailsApplication,
            ItemCommentRepresentation.Factory factory) {
        super(grailsApplication, factory)
    }
}

