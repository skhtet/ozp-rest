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

    //do not delete images that are younger than a day
    private static final long GARBAGE_COLLECTION_MIN_AGE = (1000 * 60 * 60 * 24)

    @Autowired ProfileRestService profileRestService

    @Autowired
    public ImageRestService(GrailsApplication grailsApplication) {
        super(grailsApplication, ImageReference.class, null, null)
    }

    ImageRestService() {}

    @Override
    public void deleteById(Object id, boolean deleteFile = true) {
        profileRestService.checkAdmin()

        ImageReference img = getById(id, true)

        if (deleteFile) {
            deleteImageFile(getFile(img))
        }

        img.delete(flush: true)
    }

    /**
     * delete the specified file containing an image
     */
    private void deleteImageFile(File file) {
        log.debug "Deleting file for image: $file"

        File parent = file.parentFile
        assert parent.parentFile == imageDir

        if (file.exists()) file.delete()
        if (parent.exists() && parent.listFiles().length == 0) {
            //clean up empty directory
            parent.delete()
        }
    }

    /**
     * @param skipFileExistenceCheck Unless true, a check will be made to
     * ensure that the image file exists.  If it doesn't exist, a DomainObjectNotFoundException
     * will be thrown
     */
    @Override
    public ImageReference getById(Object id, boolean skipFileExistenceCheck=false) {
        ImageReference imageRef = super.getById(id)

        if (!skipFileExistenceCheck && !getFile(imageRef).exists()) {
            throw new DomainObjectNotFoundException(ImageReference, id)
        }

        return imageRef
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
        String fileName = imageRef.id, folderName = fileName[0..1]
        String path = "$folderName/$fileName"

        new File(imageDir, path)
    }

    @Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
    public File getImageDir() {
        new File(grailsApplication.config.marketplace.imageStoragePath)
    }

    /**
     * Delete 'orphan' images/ImageReferences.  An image is an orphan if it is at least a day
     * old and has no Listings, Screenshots, or Agencies referring to it.  Also deletes all image
     * files that are not referenced by any ImageReference
     * @return  the number of images deleted
     */
    public List<Integer> garbageCollectImages() {
        profileRestService.checkAdmin()

        Date maxDateToDelete = new Date(new Date().time - GARBAGE_COLLECTION_MIN_AGE)

        //query to find all images which aren't referenced by anything which are at least
        //a day old
        Collection<String> imageRefIdsToDelete = ImageReference.executeQuery("""
                SELECT DISTINCT
                    ir.id
                FROM
                    ImageReference AS ir
                WHERE
                    ir.createdDate < :maxDateToDelete AND
                    ir not in (
                        SELECT l.smallIcon FROM Listing AS l WHERE l.smallIcon IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT l.largeIcon FROM Listing AS l WHERE l.largeIcon IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT l.bannerIcon FROM Listing AS l WHERE l.bannerIcon IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT l.featuredBannerIcon FROM Listing AS l
                        WHERE l.featuredBannerIcon IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT s.smallImage FROM Screenshot AS s WHERE s.smallImage IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT s.largeImage FROM Screenshot AS s WHERE s.largeImage IS NOT NULL
                    ) AND
                    ir not in (
                        SELECT a.icon FROM Agency AS a WHERE a.icon IS NOT NULL
                    )
            """,
            [maxDateToDelete: maxDateToDelete],
            [readOnly: true]
        )

        imageRefIdsToDelete.each { deleteById(it, false) }

        int deletedOrphanFiles = deleteOrphanFiles()

        return [imageRefIdsToDelete.size(), deletedOrphanFiles]
    }

    private int deleteOrphanFiles() {
        Collection<String> existingIds = ImageReference.createCriteria().list() {
            projections {
                id()
            }
        }

        Collection<File> imageFiles = imageDir.listFiles().collect { dir ->
            dir.listFiles()
        }.flatten()

        Collection<File> toDelete = imageFiles.grep { !(it.name in existingIds) }
        toDelete.each { deleteImageFile(it) }

        return toDelete.size()
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
