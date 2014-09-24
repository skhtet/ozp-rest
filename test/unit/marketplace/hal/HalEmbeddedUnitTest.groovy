package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class HalEmbeddedUnitTest {
    void testConstructors() {
        AbstractHalRepresentation rep1 = new AbstractHalRepresentation() {}
        AbstractHalRepresentation rep2 = new AbstractHalRepresentation() {}
        AbstractHalRepresentation rep3 = new AbstractHalRepresentation() {}

        HalEmbedded embedded = new HalEmbedded(RegisteredRelationType.ITEM, rep1)

        assert embedded.size() == 1
        assert embedded.toMap().get(RegisteredRelationType.ITEM).is(rep1)

        embedded = new HalEmbedded([
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, rep1),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, rep2),
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, rep3)
        ])

        assert embedded.size() == 2
        assert embedded.toMap().get(RegisteredRelationType.VIA).is(rep2)
        assert embedded.toMap().get(RegisteredRelationType.ITEM).size() == 2
        assert embedded.toMap().get(RegisteredRelationType.ITEM)[0].is(rep1)
        assert embedded.toMap().get(RegisteredRelationType.ITEM)[1].is(rep3)

        embedded = new HalEmbedded()

        assert embedded.size() == 0
    }

    void testPut() {
        AbstractHalRepresentation rep1 = new AbstractHalRepresentation() {}
        AbstractHalRepresentation rep2 = new AbstractHalRepresentation() {}
        AbstractHalRepresentation rep3 = new AbstractHalRepresentation() {}

        HalEmbedded embedded = new HalEmbedded()
        embedded.put(RegisteredRelationType.ITEM, rep1)
        assert embedded.size() == 1
        assert embedded.toMap().get(RegisteredRelationType.ITEM).is(rep1)

        embedded.put(RegisteredRelationType.ITEM, rep2)
        assert embedded.size() == 1
        assert embedded.toMap().get(RegisteredRelationType.ITEM).size() == 2
        assert embedded.toMap().get(RegisteredRelationType.ITEM)[0].is(rep1)
        assert embedded.toMap().get(RegisteredRelationType.ITEM)[1].is(rep2)

        embedded.put(RegisteredRelationType.VIA, rep3)
        assert embedded.size() == 2
        assert embedded.toMap().get(RegisteredRelationType.VIA).is(rep3)
    }

    private static class CurieTrackingRepresentation extends AbstractHalRepresentation {
        Boolean includeCuries
    }

    void testSetIncludeCuries() {
        AbstractHalRepresentation rep1 = new CurieTrackingRepresentation()
        AbstractHalRepresentation rep2 = new CurieTrackingRepresentation()
        AbstractHalRepresentation rep3 = new CurieTrackingRepresentation()

        HalEmbedded embedded = new HalEmbedded([
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, rep1),
            new AbstractMap.SimpleEntry(RegisteredRelationType.VIA, rep2),
            new AbstractMap.SimpleEntry(RegisteredRelationType.ITEM, rep3)
        ])

        embedded.includeCuries = true
        assert rep1.includeCuries
        assert rep2.includeCuries
        assert rep3.includeCuries

        embedded.includeCuries = false
        assert !rep1.includeCuries
        assert !rep2.includeCuries
        assert !rep3.includeCuries
    }
}
