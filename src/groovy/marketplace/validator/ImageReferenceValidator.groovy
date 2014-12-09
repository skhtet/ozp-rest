package marketplace.validator

import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Component

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.ImageReference


@Component
class ImageReferenceValidator implements DomainValidator<ImageReference> {

    private final Collection<MediaType> acceptableImageTypes

    @Autowired
    ImageReferenceValidator(GrailsApplication grailsApplication) {
        Collection<String> typeStrings = grailsApplication.config.marketplace.acceptableImageTypes
        this.acceptableImageTypes = typeStrings.collect { MediaType.valueOf(it) }
    }

    @Override
    public void validateNew(ImageReference imageRef) {
        MediaType imageType = MediaType.valueOf(imageRef.mediaType)

        if (!this.acceptableImageTypes.any { imageType.isCompatible(it) }) {
            throw new IllegalArgumentException(
                "Content-Type $imageType disallowed by dynamic configuration")
        }
    }

    //this should never get called since the service layer doesn't support updates
    @Override
    public void validateChanges(Map existing, ImageReference updated) {
        throw new UnsupportedOperationException()
    }
}
