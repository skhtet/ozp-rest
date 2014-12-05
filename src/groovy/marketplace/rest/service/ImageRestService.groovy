package marketplace.rest.service

import javax.ws.rs.core.MediaType

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import org.springframework.security.access.AccessDeniedException

import org.apache.log4j.Logger

import org.codehaus.groovy.grails.commons.GrailsApplication

import marketplace.ImageReference

import marketplace.rest.DomainObjectNotFoundException

import marketplace.rest.representation.in.InputRepresentation
import marketplace.rest.representation.in.ImageReferenceInputRepresentation

@Service
class ImageRestService extends RestService<ImageReference> {

    private static final Logger log = Logger.getLogger(ImageRestService.class)

    @Autowired
    public ImageRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, ImageReference.class, null, null)
    }

    ImageRestService() {}

    @Override
    public void deleteById(Object id) {
        ImageReference img = getById(id)

        img.delete(flush: true)
        img.file.delete()
    }

    @Override
    public ImageReference createFromRepresentation(InputRepresentation<ImageReference> rep) {
        throw new UnsupportedOperationException(
            "Attempt to create ImageReference from unknown kind of representation")
    }

    public ImageReference createFromRepresentation(ImageReferenceInputRepresentation rep) {
        ImageReference imageRef = super.createFromRepresentation(rep)

        File imageFile = getFile(imageRef)

        //ensure directory exists
        imageFile.parentFile.mkdirs()

        if (imageFile.exists()) {
            throw new IllegalStateException("Trying to create file with path that already exists")
        }

        OutputStream stream = new FileOutputStream(imageFile)

        try {
            stream.write(rep.image)
        }
        catch (IOException e) {
            try {
                if (imageFile.exists()) {
                    imageFile.delete()
                }
            }
            catch (IOException e2) {
                log.warn("Could not clean up image folder after image creation failure", e2)
            }

            throw e
        }
        finally {
            try {
                stream.close()
            }
            catch (IOException e2) {
                log.warn("Could not close image output stream")
            }
        }

        return imageRef
    }

    @Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
    public File getFile(ImageReference imageRef) {
        String pathPrefix = grailsApplication.config.marketplace.imageStoragePath

        new File(pathPrefix + '/' + imageRef.path)
    }

    @Override
    protected void authorizeUpdate(ImageReference existing) {
        throw new AccessDeniedException("Images cannot be updated")
    }

    @Override
    protected void authorizeCreate(ImageReference newImg) {
        //anyone can create new images
    }

    @Override
    protected boolean canView(ImageReference img) {
        //anyone can view images
        true
    }
}
