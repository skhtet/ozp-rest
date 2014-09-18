package marketplace.rest

/**
 * Filter that creates/updates Profile object on login
 */
class LoginFilters {
    ProfileRestService profileRestService

    def filters = {
        login(controller: '*', action: '*') {
            before = {
                profileRestService.login()
            }
        }
    }
}
