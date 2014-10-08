package marketplace

import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.commons.ApplicationHolder
import ozone.utils.Utils
import marketplace.JSONUtil as JS
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.EqualsBuilder

@gorm.AuditStamp
class Types implements Serializable {
    final static bindableProperties = ['title', 'description']
    final static modifiableReferenceProperties = []

    static searchable = {
        root false
        title index: 'analyzed', excludeFromAll: false
        ozoneAware index: 'not_analyzed', excludeFromAll: true
        only = ['id', 'title', 'ozoneAware']
    }

    String title
    String description
    boolean ozoneAware = true
    boolean hasLaunchUrl = true
    boolean hasIcons = true
    String uuid
    Boolean isPermanent = false

    def beforeInsert() {
        if (!uuid) {
            uuid = Utils.generateUUID();
        }
    }

    static constraints = {
        title(blank: false, nullable: false, maxSize: 50)
        description(nullable: true, maxSize: 250)
        typeId(nullable: true)
        uuid(nullable: true, unique: true)
        isPermanent(nullable: true)
    }

    static mapping = {
        cache true
    }

    static transients = ['sortTypeTitle', 'typeId']

    String toString() { title }

    String prettyPrint() {
        toString()
    }

    def asJSON() {
        return new JSONObject(
            id: id,
            title: title,
            description: description,
        )
    }

    Long getTypeId() {
        id
    }

    String getSortTypeTitle() {
        title?.toLowerCase()
    }

    @Override
    int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder()
        builder.append(id)
            .append(title)
            .append(description)
            .append(version)
            .append(uuid)
        def code = builder.toHashCode()
        return code;
    }

    @Override
    boolean equals(Object obj) {
        if (obj instanceof Types) {
            Types other = (Types) obj
            EqualsBuilder builder = new EqualsBuilder()
            builder.append(id, other.id)
                .append(uuid, other.uuid)
                .append(version, other.version)
                .append(description, other.description)
                .append(title, other.title)
            return builder.isEquals();
        }
        return false;
    }

    static boolean findDuplicates(def obj) {
        if (obj?.has('uuid')) {
            def allUuids = findAllByUuid(obj.uuid);
            if (allUuids.size() == 0) {
                if (obj.has('title')) {
                    def allTitles = findAllByTitle(obj.title);
                    return (allTitles.size() > 0) ?: false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
