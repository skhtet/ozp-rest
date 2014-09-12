package marketplace.rest

import marketplace.ServiceItem

class ListingInputRepresentation extends AbstractInputRepresentation<ServiceItem> {
    ListingInputRepresentation() {
        super(ServiceItem.class)
    }

    TypeIdRef types
    String title
    String launchUrl
    String requirements
    String descriptionShort
    String description
    String imageLargeUrl
    String imageMediumUrl
    String imageSmallUrl
    String imageXlargeUrl
    String versionName
    String whatIsNew
    Set<String> tags
}
