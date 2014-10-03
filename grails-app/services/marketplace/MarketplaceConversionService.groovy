package marketplace

class MarketplaceConversionService {

    boolean transactional = true
    def sessionFactory

    //Is outside is a required field in order to enforce business logic introduced in 2012 December IOC
    //If it is null, we will set it to false (inside) for existing approved serviceItems. (AML-1128)
    def updateIsOutsideFlag() {
        log.info 'updateIsOutsideFlag:'

        def serviceItemsWithNullInsideFlag = Listing.findAllByIsOutsideAndApprovalStatus(null, ApprovalStatus.APPROVED)

        serviceItemsWithNullInsideFlag*.isOutside = false
        serviceItemsWithNullInsideFlag*.save()

    }

}
