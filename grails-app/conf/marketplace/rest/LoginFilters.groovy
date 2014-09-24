package marketplace.rest

import org.springframework.dao.DataIntegrityViolationException

import marketplace.rest.service.ProfileRestService

/**
 * Filter that creates/updates Profile object on login
 */
class LoginFilters {
    ProfileRestService profileRestService

    def filters = {
        login(controller: '*', action: '*') {
            before = {
                def tryLogin

                tryLogin = {
                    try {
                        profileRestService.login()
                    }
                    catch (DataIntegrityViolationException e) {
                        //happens in case of multiple concurrent requests from brand new
                        //user - only first one succeeds at creating user. Other requests
                        //fail and should be retried
                        tryLogin()
                    }
                }

                tryLogin()
            }
        }
    }
}
