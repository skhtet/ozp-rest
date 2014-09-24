package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class AbstractHalRepresentationUnitTest {

    AbstractHalRepresentation representation

    private HalLinks makeLinks() {
        new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    new Link(new URI('https://localhost:8443/'))),
            new AbstractMap.SimpleEntry(OzpRelationType.APPLICATION,
                    new Link(new URI('https://localhost:8443/app'))),
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM,
                    new Link(new URI('http://localhost:8080/')))
        ])
    }

    private HalEmbedded makeEmbedded() {
        AbstractHalRepresentation via = new AbstractHalRepresentation(makeLinks(), null) {}
        AbstractHalRepresentation org = new AbstractHalRepresentation(null, null) {}

        new HalEmbedded([
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, via),
            new AbstractMap.SimpleEntry(OzpRelationType.ORGANIZATION, org)
        ])
    }

    void setUp() {
        //anonymous subclass since it is abstract
        representation = new AbstractHalRepresentation() {}
    }

    void testConstructor() {
        //test that empty constructor does not add any links or embedded
        assert representation.links == null
        assert representation.embedded == null

        HalLinks links = makeLinks()
        HalEmbedded embedded = makeEmbedded()

        representation = new AbstractHalRepresentation(links, embedded) {}

        assert representation.links.toMap().get(RegisteredRelationType.ITEM).collect {
            it.href
        } == ['https://localhost:8443/', 'http://localhost:8080/']
        assert representation.links.toMap().get(OzpRelationType.APPLICATION).collect {
            it.href
        } == ['https://localhost:8443/app']
        assert representation.links.toMap().get(CurieRelationType.CURIE) ==
            HalRelationCurie.OZP.toLink()

        assert representation.embedded.get(RegisteredRelationType.VIA).size() == 1
        assert representation.embedded.get(RegisteredRelationType.VIA)[0].is(
            embedded.get(RegisteredRelationType.VIA)[0])
        assert representation.embedded.get(OzpRelationType.ORGANIZATION)[0].is(
            embedded.get(OzpRelationType.ORGANIZATION)[0])
    }

    //test that getLinks and getEmbedded return null of they are empty
    void testGetters() {
        representation = new AbstractHalRepresentation(new HalLinks(), new HalEmbedded()) {}

        assert representation.links == null
        assert representation.embedded == null
    }

    void testGetCuries() {
        representation = new AbstractHalRepresentation(makeLinks(), null) {}
        assert representation.curies == [HalRelationCurie.OZP] as Set

        representation = new AbstractHalRepresentation(null, makeEmbedded()) {}
        assert representation.curies == [HalRelationCurie.OZP] as Set

        representation = new AbstractHalRepresentation(makeLinks(), makeEmbedded()) {}
        assert representation.curies == [HalRelationCurie.OZP] as Set

        representation = new AbstractHalRepresentation(null, null) {}
        assert representation.curies == [] as Set
    }

    void testAddLinks() {
        representation.addLinks(makeLinks())

        assert representation.links.toMap().get(RegisteredRelationType.ITEM).collect {
            it.href
        } == ['https://localhost:8443/', 'http://localhost:8080/']
        assert representation.links.toMap().get(OzpRelationType.APPLICATION).collect {
            it.href
        } == ['https://localhost:8443/app']
        assert representation.links.toMap().get(CurieRelationType.CURIE) ==
            HalRelationCurie.OZP.toLink()
        assert representation.curies == [HalRelationCurie.OZP] as Set
    }

    void testAddLink() {
        representation.addLink(RegisteredRelationType.ITEM,
            new Link(new URI('http://test-domain/')))

        assert representation.links.toMap().get(RegisteredRelationType.ITEM).href ==
            'http://test-domain/'
        assert representation.links.toMap().size() == 1
    }

    void testAddEmbedded() {
        HalEmbedded embedded = makeEmbedded()

        representation.addEmbedded(embedded)

        assert representation.embedded.get(RegisteredRelationType.VIA).size() == 1
        assert representation.embedded.get(RegisteredRelationType.VIA)[0].is(
            embedded.get(RegisteredRelationType.VIA)[0])
        assert representation.embedded.get(OzpRelationType.ORGANIZATION)[0].is(
            embedded.get(OzpRelationType.ORGANIZATION)[0])
        assert representation.curies == [HalRelationCurie.OZP] as Set
    }

    //The curies on embedded representations should be added to this representation
    void testCuriesAddedFromEmbeddedRepresentations() {
        AbstractHalRepresentation embeddedRepresentation = new AbstractHalRepresentation() {
            Set<HalRelationCurie> getCuries() {
                [HalRelationCurie.OZP] as Set
            }
        }

        representation.addEmbedded(
            new HalEmbedded(RegisteredRelationType.ITEM, embeddedRepresentation))

        assert representation.curies == [HalRelationCurie.OZP] as Set
    }

    void testSetIncludeCuries() {
        boolean curiesIncluded

        representation.addLink(RegisteredRelationType.ITEM,
            new Link(new URI('https://localhost')))

        representation.links.metaClass.setIncludeCuries = {
            curiesIncluded = it
        }

        representation.includeCuries = true
        assert curiesIncluded == true

        representation.includeCuries = false
        assert curiesIncluded == false
    }
}
