package marketplace

import marketplace.converter.JsonDateConverter

import static marketplace.ValidationUtil.validateUrl

import ozone.utils.Utils

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder

import gorm.AuditStamp


@AuditStamp
class ServiceItem implements Serializable {

    //these two fields are used by the RestService to determine
    //how to handle marshalling of this domain
    //TODO: even though we've switched to input representations, these fields are still used for generating change logs
    final static bindableProperties = [
        'type', 'owners',
        'categories', 'intents',
        'approvalStatus', 'contacts',
        'agency', 'title', 'whatIsNew',
        'description', 'requirements',
        'versionName', 'imageLargeUrl',
        'imageSmallUrl', 'imageMediumUrl',
        'launchUrl', 'docUrls', 'descriptionShort',
        'screenshots', 'imageXlargeUrl',
        'isEnabled', 'tags', 'satisfiedScoreCardItems',
        'relationships', 'isFeatured'
    ]

    final static modifiableReferenceProperties = [
        'docUrls', 'screenshots', 'relationships', 'contacts'
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
        description boost: 1.9
        requirements boost: 1.8
        versionName index: 'not_analyzed', excludeFromAll: true
        totalComments index: 'not_analyzed', excludeFromAll: true
        imageSmallUrl index: 'not_analyzed', excludeFromAll: true
        imageMediumUrl index: 'not_analyzed', excludeFromAll: true
        imageLargeUrl index: 'not_analyzed', excludeFromAll: true
        imageXlargeUrl index: 'not_analyzed', excludeFromAll: true
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
            'title', 'agency', 'docUrls', 'uuid', 'launchUrl',
            'imageXlargeUrl', 'imageLargeUrl', 'imageMediumUrl', 'imageSmallUrl', 'approvalStatus',
            'createdDate', 'editedDate', 'isEnabled', 'tags', 'descriptionShort', 'whatIsNew'
        ]
    }

    // Specifies that changes to serviceItems will be written to the database as ChangeDetail
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
        'serviceItemActivities',

        //these fields are technically auditable, but are associated with a separate activity
        'relationships',
        'isEnabled',
        'approvalStatus',
        'isOutside',
        'isFeatured'
    ]]

    Date approvedDate

    String title
    String description
    String launchUrl
    String versionName
    String uuid = Utils.generateUUID()
    String imageSmallUrl
    String imageMediumUrl
    String imageLargeUrl
    String imageXlargeUrl
    String whatIsNew
    String descriptionShort
    String requirements
    String approvalStatus = Constants.APPROVAL_STATUSES['APPROVED']

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

    SortedSet rejectionListings
    List screenshots
    List serviceItemActivities

    ServiceItemActivity lastActivity
    Agency agency
    Types type

    static transients = ['sortTitle', 'lastActivityDate']

    static hasMany = [
        categories: Category,
        owners: Profile,
        itemComments: ItemComment,
        rejectionListings: RejectionListing,
        serviceItemActivities: ServiceItemActivity,
        docUrls: ServiceItemDocumentationUrl,
        screenshots: Screenshot,
        relationships: Relationship,
        contacts: Contact,
        satisfiedScoreCardItems: ScoreCardItem,
        tags: String,
        intents: Intent,
        applicationLibraryEntries: ApplicationLibraryEntry //necessary to get GORM to
                                                           //cascade the delete
    ]

    //so that GORM knows which property of the relationship is the backref
    static mappedBy = [relationships: 'owningEntity']

    static mapping = {
        cache true
        tablePerHierarchy false
        categories batchSize: 50
        serviceItemActivities batchSize: 50
        itemComments cascade: 'all-delete-orphan', batchSize: 50
        rejectionListings batchSize: 50
        screenshots indexColumn: [name: "ordinal", type: Integer], cascade: 'all-delete-orphan'
        contacts cascade: 'all-delete-orphan'
        relationships cascade: 'all-delete-orphan'
        docUrls cascade: 'all-delete-orphan'
        satisfiedScoreCardItems joinTable: [name: 'service_item_score_card_item',
                                            column: 'score_card_item_id',
                                            key: 'service_item_id']
    }

    static constraints = {
        whatIsNew nullable: true, maxSize: 250
        descriptionShort nullable: true, maxSize: 150
        isFeatured(nullable: true)
        title(blank: false, maxSize: 256)
        description(maxSize: 4000, nullable: true)
        versionName(maxSize: 256, nullable: true)
        type(blank: false)
        requirements(nullable: true, maxSize: 1000)
        agency(nullable: true)
        totalRate5(nullable: true)
        totalRate4(nullable: true)
        totalRate3(nullable: true)
        totalRate2(nullable: true)
        totalRate1(nullable: true)
        launchUrl(nullable: true, maxSize: Constants.MAX_URL_SIZE, validator: { val, obj ->
            if (obj.type?.hasLaunchUrl && (!val || 0 == val.trim().size())) {
                return [
                    'serviceItem.launchUrl.required'
                ]
            }
            if (obj.type?.hasLaunchUrl && !val && !validateUrl(val)) {
                return [
                    'serviceItem.launchUrl.url.invalid'
                ]
            }
            if (val != null && val.trim().size() > 0 && !validateUrl(val)) {
                return [
                    'serviceItem.launchUrl.url.invalid'
                ]
            }
        })
        categories(nullable: true)
        uuid(nullable:false, matches: /^[A-Fa-f\d]{8}-[A-Fa-f\d]{4}-[A-Fa-f\d]{4}-[A-Fa-f\d]{4}-[A-Fa-f\d]{12}$/)
        imageSmallUrl(nullable:true, maxSize:Constants.MAX_URL_SIZE, validator:{ val, obj ->
            if(val?.trim()?.size() > 0 && !validateUrl(val)) {
                return [
                    'serviceItem.imageSmallUrl.url.invalid'
                ]
            }
        })
        imageMediumUrl(nullable:true, maxSize:Constants.MAX_URL_SIZE, validator:{ val, obj ->
            if(val?.trim()?.size() > 0 && !validateUrl(val)) {
                return [
                    'serviceItem.imageLargeUrl.url.invalid'
                ]
            }
        })
        imageLargeUrl(nullable:true, maxSize:Constants.MAX_URL_SIZE, validator:{ val, obj ->
            if(val?.trim()?.size() > 0 && !validateUrl(val)) {
                return [
                    'serviceItem.imageLargeUrl.url.invalid'
                ]
            }
        })
        imageXlargeUrl(nullable:true, maxSize:Constants.MAX_URL_SIZE, validator:{ val, obj ->
            if(val?.trim()?.size() > 0 && !validateUrl(val)) {
                return [
                    'serviceItem.imageXlargeUrl.url.invalid'
                ]
            }
        })
        approvalStatus(inList:Constants.APPROVAL_STATUSES.values().toList())
        lastActivity(nullable:true)
        approvedDate(nullable:true)
        owners( validator: { val ->
            if (val == null || val.isEmpty()) {
                return 'empty'
            }
        })
    }

    String toString() {
        return "${id}:${title}:${uuid}:${approvalStatus}"
    }

    String prettyPrint() {
        return "${id}:${title}:${uuid}:${approvalStatus}:${type}:${categories}"
    }

    // The parameter requires allows the caller to pass in a list of required listings which will be
    // add to the JSON structure being returned.
    def asJSON(requires = null) {
        def currJSON = new JSONObject(
            id: id,
            title: title,
            versionName: versionName,
            approvedDate: approvedDate,
            lastActivity: new JSONObject(activityDate: lastActivity?.activityDate),
            approvalStatus: approvalStatus,
            isFeatured: isFeatured,
            avgRate: avgRate,
            agency: agency?.asJSON(),
            totalVotes: totalVotes,
            totalRate5: totalRate5,
            totalRate4: totalRate4,
            totalRate3: totalRate3,
            totalRate2: totalRate2,
            totalRate1: totalRate1,
            totalComments: totalComments,
            categories: (categories?.collect { it.asJSONRef()} ?: []) as JSONArray,
            owners: (owners?.collect { it.username } ?: []) as JSONArray,
            description: description,
            docUrls: (docUrls?.collect {it.asJSON()} ?: []) as JSONArray,
            imageSmallUrl: imageSmallUrl,
            imageMediumUrl: imageMediumUrl,
            imageLargeUrl: imageLargeUrl,
            imageXlargeUrl: imageXlargeUrl,
            isPublished: true,
            launchUrl: launchUrl,
            validLaunchUrl: validateUrl(launchUrl),
            satisfiedScoreCardItems: satisfiedScoreCardItems?.collect { it.asJSON() } as JSONArray,
            requirements: requirements,
            screenshots: (this.screenshots.collect { it?.asJSON() }.findAll { it != null }) as JSONArray,
            type: type?.asJSON(),
            class: getClass(),
            uuid: uuid,
            isEnabled: isEnabled,
            intents: intents as JSONArray,
            contacts: contacts.collect { it.asJSON() } as JSONArray,
            relationships: relationships.collect{ it.asJSON() } as JSONArray,
            tags: tags as JSONArray,
            descriptionShort: descriptionShort,
            whatIsNew: whatIsNew
        )

        JSONUtil.addCreatedAndEditedInfo(currJSON, this)
        if (owners != null) {
            currJSON.put('owners', new JSONArray(owners?.collect {
                new JSONObject(id: it.id, name: it.displayName, username: it.username)
            }))
        }

        if (requires != null) {
            currJSON.put("requires", new JSONArray(requires?.collect {
                new JSONObject(id: it.id, title: it.title, uuid: it.uuid)
            }))
        }

        return currJSON
    }

    def asJSONMinimum () {
        return new JSONObject(
            id: id,
            title: title,
            imageSmallUrl: imageSmallUrl
        )
    }

    boolean statApproved() {
        return this.approvalStatus == Constants.APPROVAL_STATUSES["APPROVED"]
    }

    boolean statPending() {
        return this.approvalStatus == Constants.APPROVAL_STATUSES["PENDING"]
    }

    boolean statInProgress() {
        return this.approvalStatus == Constants.APPROVAL_STATUSES["IN_PROGRESS"]
    }

    boolean statRejected() {
        return this.approvalStatus == Constants.APPROVAL_STATUSES["REJECTED"]
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
        if (other instanceof ServiceItem) {
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

    static List<ServiceItem> findAllByAuthor(Profile user) {
        ServiceItem.findAll("from ServiceItem as serviceItem where :user member of serviceItem.owners", [user: user])
    }

    def beforeValidate() {
        //make audit trail plugin work on child items
        (modifiableReferenceProperties + ['serviceItemActivities', 'lastActivity']).each { prop ->
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
        Collection<Float> ratings = this.itemComments.grep { it.rate != null }.collect { it.rate }

        //the rating values grouped
        Map<Integer, Collection<Float>> groupedRatings = ratings.groupBy { Math.round(it) }

        //update each of the totalRating1 ... totalRating5 counts
        (1..5).each { rating ->
            this."totalRate$rating" = groupedRatings[rating]?.size() ?: 0
        }

        this.totalVotes = ratings.size()
        this.avgRate = this.totalVotes ? (ratings.sum() ?: 0) / this.totalVotes : 0F
    }
}
