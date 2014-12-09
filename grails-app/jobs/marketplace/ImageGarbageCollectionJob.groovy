package marketplace

import marketplace.rest.service.ImageRestService
import marketplace.authentication.AccountService

class ImageGarbageCollectionJob {
    static INTERVAL = (1000 * 60 * 60 * 24) //one day

    static triggers = {
        //the startDelay is to make sure bootstrap is finished before this runs
        simple name: 'imageGarbageCollectionTrigger', repeatInterval: INTERVAL, startDelay: 10000
    }

    def group = 'image'
    def description = 'Delete unused images from the database'

    ImageRestService imageRestService
    AccountService accountService

    def execute() {
        log.info "Image Garbage Collection starting"

        try {
            int deletedRefCount, deletedFileCount
            accountService.asSystemUser {
                List<Integer> counts = imageRestService.garbageCollectImages()
                deletedRefCount = counts[0]
                deletedFileCount = counts[1]
            }

            log.info "Image Garbage Collection complete. " +
                "Deleted $deletedRefCount ImageReferences and $deletedFileCount files"
        }
        catch (e) {
            log.error "Image Garbage Collection ERROR", e
        }
    }
}
