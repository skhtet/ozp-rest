package marketplace

import ozone.utils.Utils

class MarketplaceConversionService {

    boolean transactional = true
    def sessionFactory
    def owfWidgetTypesService

    boolean upgrade11To20() {

        if (Text.findByName("version")) {
            return true
        }
        log.info 'ConversionService: upgrade11To20 - upgrading'

        migrateCustomFields()

        def offset = 0
        def pageSize = 20
        def finished = false

        log.debug 'adding rejection activities'
        while (!finished) {
            def listings = ServiceItem.createCriteria().list([max: pageSize, offset: offset]) {
                isNotEmpty("rejectionListings")
            }
            finished = listings.size() < pageSize
            offset += pageSize
            for (item in listings) {
                def rejectionActivities = []
                item.serviceItemActivities.each { sia ->
                    if (sia.action == Constants.Action.REJECTED) {
                        rejectionActivities << sia
                    }
                }
                def rejectionListings = item.rejectionListings.sort { it.createdDate }
                if (rejectionListings.size != rejectionActivities.size) {
                    log.error "Different number of Service Item Activity Rejection record ${rejectionActivities.size} the Rejection Listing records ${rejectionListings.size}"
                    return false
                }
                def i = 0
                for (rl in rejectionListings) {
                    ServiceItemActivity sia = rejectionActivities[i]

                    def statement = "insert into rejection_activity values (${sia.id},${rl.id})"
                    def sql = new groovy.sql.Sql(sessionFactory.currentSession.connection())
                    sql.execute(statement)
                    i++
                }
            }
            sessionFactory.currentSession.clear()
        }

        finished = false
        offset = 0
        // Set the new member variable serviceItem.totalComments to the correct value
        while (!finished) {
            def listings = ServiceItem.createCriteria().list([max: pageSize, offset: offset]) {
                isNotEmpty("itemComments")
            }
            finished = listings.size() < pageSize
            offset += pageSize
            for (item in listings) {
                int totalComments = item.itemComments.size()
                log.debug "setting totalComments to ${totalComments} for serviceItem ${item.id}"
                item.totalComments = totalComments
                item.save(flush: true)
            }
            sessionFactory.currentSession.clear()
        }

        new Text(name: "version", value: "2.0", readOnly: true).save()
//    new Text(name:"Analyst", value:"Analyst", readOnly: false).save()
//    new Text(name:"Developer", value:"Developer", readOnly: false).save()
//    new Text(name:"Administrator", value:"Administrator", readOnly: false).save(flush:true)
    }

    // For any listing that is of a type with ozoneAware set to true, then if it does not already have
    // a corresponding owfProperty record, we will create one. The owfProperty record will have the
    // default values including visibleInLaunch set to true.
    def setOwfPropertiesDefault() {
        log.info 'setOwfPropertiesDefault:'
        def owfTypes = Types.findAllByOzoneAware(true)
        owfTypes.each { typeIn ->
            log.info "Setting owfProperties for Type: ${typeIn}"

            // Find all ozone aware service items
            def items = ServiceItem.findAllByTypes(typeIn)
            items?.each { sItem ->
                // If owfProperties doesn't exist, add it to service item
                if (!sItem.owfProperties) {

                    log.info("Setting owfProperties for serviceItem ${sItem.title}")
                    OwfProperties owfProperties = new OwfProperties()
                    owfProperties.save()
                    sItem.owfProperties = owfProperties
                    sItem.save()
                }

                // If owfProperties.owfWidgetType doesn't exit, add default value
                if (!sItem.owfProperties.owfWidgetType) {
                    log.info("Setting owfProperties.owfWidgetType for serviceItem ${sItem.title}")
                    sItem.owfProperties.owfWidgetType = owfWidgetTypesService.getDefaultOwfWidgetType()
                    sItem.owfProperties.save()
                    sItem.save()
                }

            }

        }
    }

    def setUUIDs() {
        log.info 'setUUIDs:'
        def states = State.findAllByUuid(null)
        states.each {
            log.info "setting uuid for ${it}"
            it.uuid = Utils.generateUUID()
            it.save()
        }
        def types = Types.findAllByUuid(null)
        types.each {
            log.info "setting uuid for ${it}"
            it.uuid = Utils.generateUUID()
            it.save()
        }
        def categories = Category.findAllByUuid(null)
        categories.each {
            log.info "setting uuid for ${it}"
            it.uuid = Utils.generateUUID()
            it.save()
        }
        def profiles = Profile.findAllByUuid(null)
        profiles.each {
            log.info "setting uuid for ${it}"
            it.uuid = Utils.generateUUID()
            it.save()
        }
    }

    //Is outside is a required field in order to enforce business logic introduced in 2012 December IOC
    //If it is null, we will set it to false (inside) for existing approved serviceItems. (AML-1128)
    def updateIsOutsideFlag() {
        log.info 'updateIsOutsideFlag:'

        def serviceItemsWithNullInsideFlag = ServiceItem.findAllByIsOutsideAndApprovalStatus(null, Constants.APPROVAL_STATUSES["APPROVED"])

        serviceItemsWithNullInsideFlag*.isOutside = false
        serviceItemsWithNullInsideFlag*.save()

    }

}
