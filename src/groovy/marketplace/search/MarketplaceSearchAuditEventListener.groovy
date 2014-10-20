package marketplace.search

import marketplace.Listing
import marketplace.ApprovalStatus

import org.grails.plugins.elasticsearch.AuditEventListener
import org.grails.datastore.mapping.engine.event.*
import org.grails.datastore.mapping.core.Datastore


class MarketplaceSearchAuditEventListener extends AuditEventListener {

    MarketplaceSearchAuditEventListener(Datastore datastore) {
        super(datastore)
    }

    @Override
    void onPostInsert(PostInsertEvent event) {
        def entity = getEventEntity(event)
        if(entity && entity instanceof Listing){
            if(!shouldIndexListing(entity)) {
                return
            }
        }
        super.onPostInsert(event)
    }

    @Override
    void onPostUpdate(PostUpdateEvent event) {
        def entity = getEventEntity(event)
        if(entity && entity instanceof Listing){
            if(!shouldIndexListing(entity)) {
                pushToDelete(entity)
                return
            }
        }
        super.onPostUpdate(event)
    }

    private static boolean shouldIndexListing(listing) {
        listing.isEnabled && listing.approvalStatus == ApprovalStatus.APPROVED
    }
}
