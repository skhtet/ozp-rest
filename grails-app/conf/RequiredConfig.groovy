import marketplace.Constants

environments {
    production {
        /**
         * Contains values for reference metadata domain objects such as Types, States, and Categories.
         */
        marketplace {
            metadata {
                profiles = [
                        [username: Constants.SYSTEM_USER_USERNAME, displayName: Constants.SYSTEM_USER_DISPLAYNAME]
                ]
            }
        }

        elasticSearch {
            //Note: We do our own custom indexing in Bootstrap.groovy. If this is overridden
            //search indexing will not behave as expected - specifically all listings will be
            //indexed on app startup, rather than just approved/enabled listings.
            bulkIndexOnStartup = false
        }
    }
}

println("Loaded Required Configurations.")
