import marketplace.Constants

/**
 * Contains values for reference metadata domain objects such as Types, States, and Categories.
 */
marketplace {
    metadata {
        profiles = [
                [username: Constants.SYSTEM_USER_USERNAME, displayName: Constants.SYSTEM_USER_DISPLAYNAME],
                [username: 'slackbot', displayName: 'Slackbot']
        ]
    }
}

println("Loaded Franchise Store metadata config info.")
