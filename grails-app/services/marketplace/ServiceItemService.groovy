package marketplace

class ServiceItemService extends OzoneService {

    def getAllowableItem(def id, def sessionParams, def rules) throws AccessControlException {
        def item = Listing.get(id)
        def isUser = false
        def isAvailable = false
        def isApproved = false
        def matchesRule = false

        if (item) {
            isUser = item?.isAuthor((String) sessionParams?.username)
            isAvailable = item.isEnabled
            isApproved = item.statApproved()

            if (rules?.allNoRestrictions && isAvailable) {
                matchesRule = true
            }
            if (sessionParams?.isAdmin) {
                matchesRule = true
            }
            if (rules?.allIfApproved && isAvailable && isApproved) {
                matchesRule = true
            }
            if (rules?.userNoRestrictions && isUser) {
                matchesRule = true
            }
            if (rules?.userIfApproved && isUser && isApproved) {
                matchesRule = true
            }

            if (matchesRule) {
                return item
            } else {
                throw new AccessControlException('User is not authorized to access this item');
            }
        }
        return null;
    }
}
