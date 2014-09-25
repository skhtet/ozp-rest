package marketplace.hal

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class RelationTypeUnitTest {
    void testExtensionRelationType() {
        String relationHref = 'http://localhost/rel'

        ExtensionRelationType relationType = new ExtensionRelationType(new URI(relationHref))
        assert relationType.relationName == relationHref
        assert relationType.toString() == relationHref
    }

    void testOzpRelationType() {
        OzpRelationType.values().each {
            assert it.halRelationCurie == HalRelationCurie.OZP
            assert it.relationName =~ /ozp:\w+/
            assert it.toString() == it.relationName
        }
    }

    //test that all types of RelationTypes correctly compare to each other
    void testCompareTo() {
        RelationType registered1 = RegisteredRelationType.ITEM,
            registered2 = RegisteredRelationType.PREV,
            curie = CurieRelationType.CURIE,
            extension1 = new ExtensionRelationType(new URI('http://localhost/rel')),
            extension1Copy = new ExtensionRelationType(new URI('http://localhost/rel')),
            extension2 = new ExtensionRelationType(new URI('http://localhost/rel2')),
            ozp1 = OzpRelationType.APPLICATION,
            ozp2 = OzpRelationType.INTENT

        List<RelationType> relations =
            [registered1, registered2, curie, extension1, extension1Copy, extension2, ozp1, ozp2]

        List<List<RelationType>> allComparisons = relations.collect { r1 ->
            relations.collect { r2 ->
                [r1, r2]
            }
        }.inject([]) { acc, curr ->
            //remove extra layer of lists
            acc + curr
        }

        allComparisons.each {
            //check that comparison is by relationName
            assert (it[0] <=> it[1]) == (it[0].relationName <=> it[1].relationName)

            //check that compareTo and equals agree
            assert (it[0] <=> it[1] == 0) == (it[0] == it[1])

            //check that hashCode and equals agree
            assert (it[0].hashCode() == it[1].hashCode()) == (it[0] == it[1])
        }
    }
}
