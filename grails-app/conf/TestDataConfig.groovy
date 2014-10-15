import marketplace.*

testDataConfig {
    sampleData {
        Listing {
            uuid = { UUID.randomUUID() }
            isHidden = 0
            launchUrl = "http://launch.url.gov"
            imageSmallUrl = "http://launch.url.gov/image.gif"
            imageMediumUrl = "http://launch.url.gov/image.gif"
            imageLargeUrl = "http://launch.url.gov/image.gif"
            totalVotes = 0
            avgRate = 0
            categories = {-> [new Category(title:"Category A"),new Category(title:"Category B")]}
        }
        'marketplace.Profile' {
          	def i = 2
              username = {-> "testUser${i++}" }
        }
    }
}

environments {
    production {
        testDataConfig {
            enabled = false
        }
    }
}
