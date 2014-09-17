package marketplace.rest

/**
 * Filter that creates/updates Profile object on login
 */
class LoginFilter {
    ProfileRestService profileRestService

    def filters = {
        login(controller: '*', action: '*') {
            profileRestService.login()
        }
    }
}
