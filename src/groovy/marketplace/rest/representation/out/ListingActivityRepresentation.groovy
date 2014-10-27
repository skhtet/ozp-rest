package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.DomainResourceUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.ListingActivity
import marketplace.ChangeDetail
import marketplace.Listing
import marketplace.Profile

import static marketplace.Constants.Action

class ListingActivityRepresentation extends AbstractHalRepresentation<ListingActivity> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-activity-v1+json'
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-listing-activities-v1+json'

    private ListingActivity activity

    ListingActivityRepresentation(ListingActivity activity,
            DomainResourceUriBuilder<Listing> listingUriBuilder,
            DomainResourceUriBuilder<Profile> profileUriBuilder) {
        super(
            createLinks(activity, listingUriBuilder, profileUriBuilder),
            null
        )

        this.activity = activity
    }

    private static HalLinks createLinks(ListingActivity activity,
            DomainResourceUriBuilder<Listing> listingUriBuilder,
            DomainResourceUriBuilder<Profile> profileUriBuilder) {

        URI appUri = listingUriBuilder.getUri(activity.listing),
            authorUri = profileUriBuilder.getUri(activity.author)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION, new Link(appUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.AUTHOR, new Link(authorUri))
        ])
    }

    public Long getId() { activity.id }
    public Action getAction() { activity.action }
    public Date getActivityDate() { activity.activityDate }
    public Collection<ChangeDetailJson> getChangeDetails() {
        activity.changeDetails?.collect { new ChangeDetailJson(it) } ?: []
    }

    public static class ChangeDetailJson {
        private ChangeDetail changeDetail

        ChangeDetailJson(ChangeDetail changeDetail) {
            this.changeDetail = changeDetail
        }

        public String getFieldName() { changeDetail.fieldName }
        public String getOldValue() { changeDetail.oldValue }
        public String getNewValue() { changeDetail.newValue }
    }

    @Component
    public static class Factory implements RepresentationFactory<ListingActivity> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory

        @Override
        ListingActivityRepresentation toRepresentation(ListingActivity activity,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            new ListingActivityRepresentation(activity,
                listingUriBuilderFactory.getBuilder(uriBuilderHolder),
                profileUriBuilderFactory.getBuilder(uriBuilderHolder)
            )
        }
    }
}
