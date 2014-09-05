package marketplace.rest

import marketplace.ServiceItem
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.json.JSONArray

class ApplicationDto {
    private ServiceItem listing

    public ApplicationDto(ServiceItem listing) {
        this.listing = listing
    }

    public JSONObject asJSON() {
        listing == null ? null :
        new JSONObject([
            name: listing.title ?: '',
            description: listing.descriptionShort ?: '',
            type: listing.types?.title ?: '',
            state: 'active',
            uiHints: new JSONObject([
                width: 400,
                height: 400,
                singleton: false
            ]),
            icons: new JSONObject([
                small: listing.imageSmallUrl,
                large: listing.imageLargeUrl
            ]),
            tags: listing.tags as JSONArray,
            intents: listing.intents.collect {
                new JSONObject([
                    type: it.dataType.title,
                    action: it.action.title
                ])
            } as JSONArray,
            screenShots: listing.screenshots.collect {
                new JSONObject([
                    href: it.smallImageUrl
                ])
            } as JSONArray,
            launchUrls: new JSONObject([
                default: listing.launchUrl
            ])
        ])
    }

    boolean equals(other) {
        listing.equals(other)
    }

    int hashCode() {
        listing.hashCode()
    }
}
