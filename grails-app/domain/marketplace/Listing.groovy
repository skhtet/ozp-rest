package marketplace

import marketplace.converter.JsonDateConverter
import marketplace.converter.UUIDConverter

import marketplace.util.Utils

import org.codehaus.groovy.grails.web.json.JSONObject

import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder

import gorm.AuditStamp


@AuditStamp
class Listing implements Serializable {
    public static final CHANGE_LOG_PROPERTIES = [
        'type', 'owners',
        'categories', 'intents',
        'contacts', 'isFeatured',
        'agency', 'title', 'whatIsNew',
        'description', 'requirements',
        'versionName', 'bannerIconId',
        'smallIconId', 'largeIconId',
        'launchUrl', 'docUrls', 'descriptionShort',
        'screenshots', 'featuredBannerIconId',
        'tags', 'satisfiedScorecards'

    ]

    static searchable = {
        type component: true
        owners component: true
        categories component: true
        intents component: true
        itemComments component: true
        // Yes we need this much precision unless you want to see rounding errors between the short and detailed view
        avgRate index: 'not_analyzed', excludeFromAll: true
        totalRate5 index: 'not_analyzed', excludeFromAll: true
        totalRate4 index: 'not_analyzed', excludeFromAll: true
        totalRate3 index: 'not_analyzed', excludeFromAll: true
        totalRate2 index: 'not_analyzed', excludeFromAll: true
        totalRate1 index: 'not_analyzed', excludeFromAll: true
        totalVotes index: 'not_analyzed', excludeFromAll: true
        approvalStatus index: 'not_analyzed', excludeFromAll: false
        agency component: true
        title boost: 2.0
        sortTitle index: 'not_analyzed'
        description boost: 1.6
        descriptionShort boost: 1.4
        versionName index: 'not_analyzed', excludeFromAll: true
        totalComments index: 'not_analyzed', excludeFromAll: true
        smallIconId index: 'not_analyzed', excludeFromAll: true, converter: UUIDConverter
        largeIconId index: 'not_analyzed', excludeFromAll: true, converter: UUIDConverter
        bannerIconId index: 'not_analyzed', excludeFromAll: true, converter: UUIDConverter
        featuredBannerIconId index: 'not_analyzed', excludeFromAll: true, converter: UUIDConverter
        launchUrl index: 'not_analyzed', excludeFromAll: true
        docUrls component: true, excludeFromAll: true
        uuid index: 'not_analyzed', excludeFromAll: false
        screenshots component: true, excludeFromAll: true
        contacts component: true, excludeFromAll: true
        isEnabled index: 'not_analyzed', excludeFromAll: true
        isFeatured index: 'not_analyzed', excludeFromAll: true
        lastActivityDate index: 'not_analyzed', excludeFromAll: true, converter: JsonDateConverter
        approvedDate index: 'not_analyzed', excludeFromAll: true, converter: JsonDateConverter
        createdDate index: 'not_analyzed', excludeFromAll: true, converter: JsonDateConverter
        editedDate index: 'not_analyzed', excludeFromAll: true, converter: JsonDateConverter

        only = [
            'categories', 'owners', 'type', 'id', 'intents',
            'screenshots', 'approvedDate', 'lastActivityDate',
            'itemComments', 'contacts', 'totalRate1', 'totalRate2',
            'totalRate3', 'totalRate4', 'totalRate5', 'totalVotes', 'avgRate',
            'description', 'requirements', 'versionName', 'sortTitle', 'isFeatured',
            'title', 'agency', 'docUrls', 'uuid', 'launchUrl', 'singleton', 'width', 'height',
            'approvalStatus', 'createdDate', 'editedDate', 'isEnabled',
            'tags', 'descriptionShort', 'whatIsNew',
            'smallIconId', 'largeIconId', 'bannerIconId', 'featuredBannerIconId'
        ]
    }

    // Specifies that changes to listings will be written to the database as ChangeDetail
    // records and which fields to ignore.
    static auditable = [ignore:[
        'version',
        'lastUpdated',
        'editedBy',
        'editedDate',
        'totalVotes',
        'avgRate',
        'totalRate5',
        'totalRate4',
        'totalRate3',
        'totalRate2',
        'totalRate1',
        'itemComments',
        'totalComments',
        'lastActivity',
        'rejectionListings',
        'listingActivities',

        //these fields are technically auditable, but are associated with a separate activity
        'required',
        'isEnabled',
        'approvalStatus',
        'isFeatured'
    ]]

    Date approvedDate

    String title
    String description
    String launchUrl
    String versionName
    String uuid = UUID.randomUUID()
    UUID smallIconId
    UUID largeIconId
    UUID bannerIconId
    UUID featuredBannerIconId
    String whatIsNew
    String descriptionShort
    String requirements
    ApprovalStatus approvalStatus = ApprovalStatus.IN_PROGRESS

    Boolean isEnabled = true
    Boolean isFeatured = false

    Float avgRate = 0F
    Integer totalVotes = 0
    Integer totalRate5 = 0
    Integer totalRate4 = 0
    Integer totalRate3 = 0
    Integer totalRate2 = 0
    Integer totalRate1 = 0
    Integer totalComments = 0

    boolean singleton = false
    Integer width = 300
    Integer height = 300

    SortedSet<RejectionListing> rejectionListings
    List<Screenshot> screenshots
    List<ListingActivity> listingActivities
    Set<Listing> required = new HashSet()
    Set<Contact> contacts = new HashSet()

    ListingActivity lastActivity
    Agency agency
    Type type

    static transients = ['sortTitle', 'lastActivityDate']

    static hasMany = [
        categories: Category,
        owners: Profile,
        itemComments: ItemComment,
        rejectionListings: RejectionListing,
        listingActivities: ListingActivity,
        docUrls: DocUrl,
        screenshots: Screenshot,
        required: Listing,
        contacts: Contact,
        satisfiedScorecards: Scorecard,
        tags: String,
        intents: Intent,
        applicationLibraryEntries: ApplicationLibraryEntry //necessary to get GORM to
                                                           //cascade the delete
    ]

    static mapping = {
        cache true
        tablePerHierarchy false
        categories batchSize: 50
        listingActivities batchSize: 50
        itemComments cascade: 'all-delete-orphan', batchSize: 50
        rejectionListings batchSize: 50
        screenshots indexColumn: [name: "ordinal", type: Integer], cascade: 'all-delete-orphan'
        contacts cascade: 'all-delete-orphan'
        docUrls cascade: 'all-delete-orphan'
        satisfiedScorecards joinTable: [name: 'service_item_score_card_item',
                                            column: 'score_card_item_id',
                                            key: 'service_item_id']
        applicationLibraryEntries cascade: 'all-delete-orphan'
    }

    //A closure to use to validate that properties are present on a listing
    //that is in any approvalStatus other than IN_PROGRESS
    static requiredUnlessInProgress = { val, Listing listing ->
        (listing.approvalStatus != ApprovalStatus.IN_PROGRESS &&     //reject if not draft
            (val == null ||                                          //and val is null
                (val.respondsTo('size') && val.size() == 0)          //or empty/blank
            )
        ) ? "requiredUnlessInProgress" : true
    }

    static constraints = {
        width nullable: true
        height nullable: true
        whatIsNew nullable: true, maxSize: 250
        descriptionShort nullable: true, maxSize: 150, validator: requiredUnlessInProgress
        isFeatured nullable: true, validator: requiredUnlessInProgress
        title nullable: false, blank: false, maxSize: 255
        description maxSize: 4000, nullable: true, validator: requiredUnlessInProgress
        versionName maxSize: 255, nullable: true, validator: requiredUnlessInProgress
        requirements nullable: true, maxSize: 1000, validator: requiredUnlessInProgress
        agency nullable: true, validator: requiredUnlessInProgress
        type nullable: false
        totalRate5(nullable: true)
        totalRate4(nullable: true)
        totalRate3(nullable: true)
        totalRate2(nullable: true)
        totalRate1(nullable: true)
        launchUrl nullable: true, maxSize: Constants.MAX_URL_SIZE, matches: Constants.URL_REGEX,
            validator: requiredUnlessInProgress
        categories(nullable: true, validator: requiredUnlessInProgress)
        uuid nullable: false, blank: false, matches: /^[A-Fa-f\d]{8}-[A-Fa-f\d]{4}-[A-Fa-f\d]{4}-[A-Fa-f\d]{4}-[A-Fa-f\d]{12}$/
        smallIconId nullable: true, validator: requiredUnlessInProgress
        largeIconId nullable: true, validator: requiredUnlessInProgress
        bannerIconId nullable: true, validator: requiredUnlessInProgress
        featuredBannerIconId nullable:true, validator: requiredUnlessInProgress
        approvalStatus nullable: false
        lastActivity(nullable:true)
        approvedDate(nullable:true)
        owners( validator: { val ->
            if (val == null || val.isEmpty()) {
                return 'empty'
            }
        })
        tags(validator: { ts, obj ->
            if (ts.any { it.length() > 16 }) {
                return 'maxSize.exceeded'
            }
            else {
                return requiredUnlessInProgress(ts, obj)
            }
        })
        screenshots validator: requiredUnlessInProgress
    }

    String toString() {
        return "${id}:${title}:${uuid}:${approvalStatus}"
    }

    @Override
    int hashCode() {
        new HashCodeBuilder()
            .append(id)
            .append(version)
            .append(uuid)
            .toHashCode()
    }

    @Override
    boolean equals(other) {
        if (other instanceof Listing) {
            return new EqualsBuilder()
                .append(id, other.id)
                .append(version, other.version)
                .append(uuid, other.uuid)
                .isEquals()
        }

        false
    }

    String getSortTitle() {
        title?.toLowerCase()
    }

    Date getLastActivityDate() {
        lastActivity?.activityDate
    }

    boolean isOwner(Profile user) {
        owners?.find { it.username == user.username }
    }

    static List<Listing> findAllByAuthor(Profile user) {
        Listing.findAll("from Listing as listing where :user member of listing.owners", [user: user])
    }

    static List<Listing> findAllByRequired(Listing req) {
        Listing.createCriteria().list() {
            required {
                eq('id', req.id)
            }
        }
    }

    def beforeValidate() {
        List childProperties = [
            'listingActivities',
            'lastActivity',
            'itemComments',
            'rejectionListings',
            'listingActivities',
            'docUrls',
            'screenshots',
            'contacts'
        ]

        //make audit trail plugin work on child items
        childProperties.each { prop ->
            Utils.singleOrCollectionDo(this[prop]) {
                //call beforeValidate if it exists
                if (it?.metaClass?.respondsTo(it, 'beforeValidate')) {
                    it.beforeValidate()
                }
            }
        }
    }

    /**
     * Update the rating statistics fields to be up to date with the
     * current list of ItemComments.  The following fields are updated:
     * totalComments, totalRate*, totalVotes, and avgRate
     */
    public void updateRatingStats() {
        if (this.itemComments == null) this.itemComments = new HashSet()

        this.totalComments = this.itemComments.size()

        //all of the non-null rating values
        Collection<Integer> ratings = this.itemComments.grep { it.rate != null }
            .collect { it.rate }

        //the rating values grouped
        Map<Integer, Collection<Integer>> groupedRatings = ratings.groupBy { it }

        //update each of the totalRating1 ... totalRating5 counts
        (1..5).each { rating ->
            this."totalRate$rating" = groupedRatings[rating]?.size() ?: 0
        }

        this.totalVotes = ratings.size()
        this.avgRate = this.totalVotes ? (ratings.sum() ?: 0) / this.totalVotes : 0F
    }
}
