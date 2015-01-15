package marketplace.rest.writer

import org.codehaus.groovy.grails.commons.GrailsApplication

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Intent
import marketplace.hal.AbstractRepresentationWriter
import marketplace.rest.representation.out.EmbeddedCollectionRepresentation

import javax.ws.rs.ext.Provider
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import marketplace.rest.representation.out.IntentRepresentation
import marketplace.rest.resource.uribuilder.IntentUriBuilder

@Provider
@Produces([
    IntentRepresentation.COLLECTION_MEDIA_TYPE,
    MediaType.APPLICATION_JSON
])
class IntentsRepresentationWriter extends AbstractRepresentationWriter<Collection<Intent>> {

    @Autowired
    IntentsRepresentationWriter(GrailsApplication grailsApplication,
            IntentRepresentation.Factory intentFactory,
            IntentUriBuilder.Factory intentUriBuilderFactory) {
        super(grailsApplication, EmbeddedCollectionRepresentation.createFactory(
                intentFactory, intentUriBuilderFactory))
    }
}
