package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.HalLinks
import marketplace.hal.HalEmbedded
import marketplace.hal.Link
import marketplace.hal.RepresentationFactory
import marketplace.hal.OzpRelationType
import marketplace.hal.RegisteredRelationType

import marketplace.rest.resource.uribuilder.ObjectUriBuilder
import marketplace.rest.resource.uribuilder.ListingUriBuilder
import marketplace.rest.resource.uribuilder.ListingActivityUriBuilder
import marketplace.rest.resource.uribuilder.ProfileUriBuilder

import marketplace.ListingActivity
import marketplace.RejectionActivity
import marketplace.ModifyRelationshipActivity
import marketplace.ChangeDetail
import marketplace.Listing
import marketplace.Profile

import static marketplace.Constants.Action

class ListingActivityRepresentation extends AbstractHalRepresentation<ListingActivity> {
    public static final String MEDIA_TYPE = 'application/vnd.ozp-listing-activity-v1+json'
    public static final String COLLECTION_MEDIA_TYPE =
        'application/vnd.ozp-listing-activities-v1+json'

    protected ListingActivity activity

    ListingActivityRepresentation(ListingActivity activity,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ObjectUriBuilder<Profile> profileUriBuilder,
            RepresentationFactory<Profile> profileRepresentationFactory,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        super(
            createLinks(activity, listingUriBuilder, profileUriBuilder),
            createEmbedded(activity, profileRepresentationFactory, uriBuilderHolder)
        )

        this.activity = activity
    }

    private static HalLinks createLinks(ListingActivity activity,
            ObjectUriBuilder<Listing> listingUriBuilder,
            ObjectUriBuilder<Profile> profileUriBuilder) {

        URI appUri = listingUriBuilder.getUri(activity.listing),
            authorUri = profileUriBuilder.getUri(activity.author)

        new HalLinks([
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION, new Link(appUri)),
            new AbstractMap.SimpleEntry(RegisteredRelationType.AUTHOR, new Link(authorUri))
        ])
    }

    private static HalEmbedded createEmbedded(ListingActivity activity,
            RepresentationFactory<Profile> profileRepresentationFactory,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        new HalEmbedded(RegisteredRelationType.AUTHOR,
            profileRepresentationFactory.toRepresentation(activity.author, uriBuilderHolder))
    }

    public Long getId() { activity.id }
    public Action getAction() { activity.action }
    public ProfilePropertyRepresentation getAuthor() { new ProfilePropertyRepresentation(activity.author) }
    public ListingPropertyRepresentation getListing() { new ListingPropertyRepresentation(activity.listing) }
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

    public static class RejectionListingActivityRepresentation extends
            ListingActivityRepresentation {
        //stupid GORM proxy classes prevent decent static typing here
        RejectionListingActivityRepresentation(ListingActivity activity,
                ObjectUriBuilder<Listing> listingUriBuilder,
                ObjectUriBuilder<Profile> profileUriBuilder,
                RepresentationFactory<Profile> profileRepresentationFactory,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            super(activity, listingUriBuilder, profileUriBuilder,
                profileRepresentationFactory, uriBuilderHolder)
        }

        public String getRejectionDescription() { activity.rejectionListing.description }
    }

    public static class ModifyRelationshipActivityRepresentation extends
            ListingActivityRepresentation {
        //stupid GORM proxy classes prevent decent static typing here
        ModifyRelationshipActivityRepresentation(ListingActivity activity,
                ObjectUriBuilder<Listing> listingUriBuilder,
                ObjectUriBuilder<Profile> profileUriBuilder,
                RepresentationFactory<Profile> profileRepresentationFactory,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            super(activity, listingUriBuilder, profileUriBuilder,
                profileRepresentationFactory, uriBuilderHolder)

            Collection<Listing> relatedListings = activity.items*.listing - null

            this.addLinks(new HalLinks(relatedListings.collect {
                new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION,
                    new Link(listingUriBuilder.getUri(it)))
            }))
        }

        public Collection<String> getListings() { activity.items*.title }
    }

    @Component
    public static class Factory implements RepresentationFactory<ListingActivity> {
        @Autowired ListingUriBuilder.Factory listingUriBuilderFactory
        @Autowired ProfileUriBuilder.Factory profileUriBuilderFactory
        @Autowired ProfileShortRepresentation.Factory profileRepresentationFactory

        @Override
        ListingActivityRepresentation toRepresentation(ListingActivity activity,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            ObjectUriBuilder<Listing> listingUriBuilder =
                listingUriBuilderFactory.getBuilder(uriBuilderHolder)

            ObjectUriBuilder<Profile> profileUriBuilder =
                profileUriBuilderFactory.getBuilder(uriBuilderHolder)

            //GORM subclassses returned from db queries are proxy objects not real
            //subclasses, so the instanceof keyword doesn't work
            if (activity.instanceOf(RejectionActivity)) {
                return new RejectionListingActivityRepresentation(
                    activity,
                    listingUriBuilder,
                    profileUriBuilder,
                    profileRepresentationFactory,
                    uriBuilderHolder
                )
            }
            else if (activity.instanceOf(ModifyRelationshipActivity)) {
                return new ModifyRelationshipActivityRepresentation(
                    activity,
                    listingUriBuilder,
                    profileUriBuilder,
                    profileRepresentationFactory,
                    uriBuilderHolder
                )
            }
            else {
                return new ListingActivityRepresentation(
                    activity,
                    listingUriBuilder,
                    profileUriBuilder,
                    profileRepresentationFactory,
                    uriBuilderHolder
                )
            }
        }
    }
}
