package marketplace.rest

import marketplace.Notification
import marketplace.hal.PagedCollection

class ExpiredNotificationCollection extends PagedCollection<Notification> {
    ExpiredNotificationCollection(Integer offset, Integer max, Collection<Notification> items) {
        super(offset, max, items)
    }
}
