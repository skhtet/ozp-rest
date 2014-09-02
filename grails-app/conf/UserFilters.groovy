import grails.util.Environment
import marketplace.*

/**
 * UserFilters - setup the session for the current user.
 * Determine if the user is an Admin using the AccountService.
 */
class UserFilters {

    def accountService
    def profileService

    def filters = {
        loginCheck(controller: '*', action: '*') {
            before = {
                UserAccount.withTransaction {
                    String cName = "${controllerName}"
                    String aName = "${actionName}"
                    def user = accountService.getLoggedInUser()
                    if (user) {
                        Date currDate = new Date()

                        if (!session.username) {
                            session.username = user.username
                        }
                        if (!session.loggedIn) {
                            UserAccount userAccount = accountService.loginAccount(user.username)

                            session.userAccountID = userAccount.id

                            // ADDING USER PROFILE....
                            def profile = Profile.findByUsername(user.username, [cache: true])
                            if (!profile) {
                                profile = profileService.createProfile(user, currDate)
                            }
                            else if (Environment.current == Environment.PRODUCTION) {
                                profileService.updateProfile(profile, user, currDate)
                            }
                        }
                    }
                }
            }
        }
    }
}
