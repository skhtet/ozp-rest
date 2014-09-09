package marketplace.hal

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

abstract class AbstractHalRepresentation<T> {
    private HalLinks links = new HalLinks()
    private HalEmbedded embedded = new HalEmbedded()

    AbstractHalRepresentation() {}

    AbstractHalRepresentation(HalLinks links, HalEmbedded embedded) {
        if (links) addLinks(links)
        if (embedded) addEmbedded(embedded)
    }

    @JsonProperty('_links')
    @JsonInclude(Include.NON_NULL)
    HalLinks getLinks() { links.isEmpty() ? null : links }

    @JsonProperty('_embedded')
    @JsonInclude(Include.NON_NULL)
    HalEmbedded getEmbedded() { embedded.isEmpty() ? null : embedded }

    protected void addLinks(HalLinks links) {
        this.links.addLinks(links)
    }

    protected void addLink(RelationType relationType, Link link) {
        this.links.put(relationType, link)
    }

    protected void addEmbedded(HalEmbedded embedded) {
        this.embedded.putAll((Map)embedded)

        //curies from embedded HAL representations must be defined on the
        //root representation
        this.links.addCuries(embedded.collect { k, rep -> rep.links.curies }.flatten())
        this.links.addCuries(embedded.keySet().grep {
            it instanceof HalCuriedRelationType
        }.collect { it.halRelationCurie })
    }
}
