package marketplace

import ozone.utils.Utils

class MarketplaceConversionService {

    boolean transactional = true
    def sessionFactory
    def owfWidgetTypesService

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
