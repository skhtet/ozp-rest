package marketplace.rest.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import marketplace.Constants
import marketplace.ApprovalStatus
import ozone.utils.ApplicationContextHolder
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly=true)
@Service
class SearchRestService {

    @Autowired ProfileRestService profileRestService

    public buildSearchParams(final Map params, Boolean isAdmin = profileRestService.isAdmin()) {
        if (!params.offset) params.offset = 0
        if (!params.max) params.max = ApplicationContextHolder.config.marketplace.defaultSearchPageSize
        if (!params.sort) params.sort = "score"
        if (!params.order) params.order = "asc"

        if(!isAdmin) {
            params.enabled_only = true
            params.state_isPublished = true
            params.statuses = [ApprovalStatus.APPROVED]
        }

        params.accessType = isAdmin ? Constants.VIEW_ADMIN : Constants.VIEW_USER
        params.username = profileRestService.currentUserProfile.username

        params
    }

    public buildAffiliatedSearchParams(Map params) {
        buildSearchParams(params, false)
    }

}
