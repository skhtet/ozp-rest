/**
 * Contains values for reference metadata domain objects such as Types, States, and Categories.
 */
marketplace {
    metadata {
        profiles = [
                [username: 'System', displayName: 'System'],
                [username: 'slackbot', displayName: 'Slackbot']
        ]
    }
}

println("Loaded Franchise Store metadata config info.")
