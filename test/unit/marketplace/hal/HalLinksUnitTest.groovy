package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class HalLinksUnitTest {
    Link link1 = new Link(new URI('https://localhost/')),
        link2 = new Link(new URI('https://localhost/')),
        link3 = new Link(new URI('https://localhost/'))

    void testConstructors() {
        HalLinks links = new HalLinks()
        assert links.toMap().size() == 0

        links = new HalLinks(RegisteredRelationType.ITEM, link1)
        assert links.toMap().size() == 1
        assert links.toMap().get(RegisteredRelationType.ITEM).is(link1)

        links = new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, link1),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, link2),
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, link3)
        ])
        assert links.toMap().size() == 2
        assert links.toMap().get(RegisteredRelationType.VIA).is(link2)
        assert links.toMap().get(RegisteredRelationType.ITEM).size() == 2
        assert links.toMap().get(RegisteredRelationType.ITEM)[0].is(link1)
        assert links.toMap().get(RegisteredRelationType.ITEM)[1].is(link3)
    }

    void testAddCurie() {
        HalLinks links = new HalLinks()
        assert links.curies == [] as Set

        links.addCurie(HalRelationCurie.OZP)
        assert links.curies == [HalRelationCurie.OZP] as Set
    }

    void testAddCuries() {
        HalLinks links = new HalLinks()

        links.addCuries([HalRelationCurie.OZP])
        assert links.curies == [HalRelationCurie.OZP] as Set

        //if we ever have more than one defined curie, add more tests
    }

    void testAddLinks() {
        HalLinks links = new HalLinks()
        HalLinks links2 = new HalLinks(RegisteredRelationType.ITEM, link1)
        HalLinks links3 = new HalLinks([
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, link2),
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, link3)
        ])

        links.addLinks(links2)
        assert links.toMap().size() == 1
        assert links.toMap().get(RegisteredRelationType.ITEM).is(link1)
        assert links.curies == [] as Set

        links.addLinks(links3)
        assert links.toMap().size() == 2
        assert links.toMap().get(RegisteredRelationType.ITEM)[0].is(link1)
        assert links.toMap().get(RegisteredRelationType.ITEM)[1].is(link3)
        assert links.toMap().get(RegisteredRelationType.VIA).is(link2)
        assert links.curies == [] as Set
    }

    void testIsEmpty() {
        HalLinks links = new HalLinks()
        assert links.isEmpty()

        links.addCurie(HalRelationCurie.OZP)
        assert !links.isEmpty()

        //curies only count if includeCuries is true
        links.includeCuries = false
        assert links.isEmpty()

        //if there are actual links, isEmpty is false regardless of curies
        links = new HalLinks(RegisteredRelationType.ITEM, link1)
        assert !links.isEmpty()
        links.addCurie(HalRelationCurie.OZP)
        assert !links.isEmpty()
        links.includeCuries = false
        assert !links.isEmpty()
    }

    void testPut() {
        HalLinks links = new HalLinks()

        links.put(RegisteredRelationType.ITEM, link1)
        assert links.toMap().size() == 1
        assert links.toMap().get(RegisteredRelationType.ITEM).is(link1)
        assert links.curies == [] as Set

        links.put(RegisteredRelationType.ITEM, link2)
        assert links.toMap().size() == 1
        assert links.toMap().get(RegisteredRelationType.ITEM)[0].is(link1)
        assert links.toMap().get(RegisteredRelationType.ITEM)[1].is(link2)
        assert links.curies == [] as Set

        links.put(OzpRelationType.APPLICATION, link3)
        links.includeCuries = false
        assert links.toMap().size() == 2
        assert links.toMap().get(RegisteredRelationType.ITEM)[0].is(link1)
        assert links.toMap().get(RegisteredRelationType.ITEM)[1].is(link2)
        assert links.toMap().get(OzpRelationType.APPLICATION).is(link3)
        assert links.curies == [HalRelationCurie.OZP] as Set

        links.includeCuries = true
        assert links.toMap().size() == 3
        assert links.toMap().get(CurieRelationType.CURIE) == HalRelationCurie.OZP.toLink()
    }
}
