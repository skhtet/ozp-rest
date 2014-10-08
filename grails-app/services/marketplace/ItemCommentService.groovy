package marketplace

import org.springframework.transaction.annotation.Transactional
import ozone.utils.Utils
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

public class ItemCommentService {

    @Transactional
    def deleteItemComment(itemCommentToDelete, si) {
        def si_id = itemCommentToDelete.listing.id

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            log.debug "Deleting itemComment: ServiceID: ${si_id} / CommentId: ${itemCommentToDelete.id}"

            def userRate = itemCommentToDelete.rate ?: null
            if (userRate) {
                userRate = Math.round(userRate)
                si.avgRate = Utils.removeRatingFromAverageRate(si.avgRate, si.totalVotes, userRate)
                if (si.totalVotes > 0) {
                    si.totalVotes -= 1
                }
                if (userRate && Utils.rangeCheck(userRate, itemCommentToDelete.author.username) == 1) {
                    if (si."totalRate${userRate}" && (si."totalRate${userRate}" > 0)) {
                        si."totalRate${userRate}"--
                    }
                }
            }
            si.totalComments -= 1
            si.removeFromItemComments(itemCommentToDelete)
            itemCommentToDelete.delete()
            si.save()
        } finally {
            lock.unlock();
        }
    }
}
