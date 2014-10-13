package marketplace.rest.representation.in

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import marketplace.Agency
import marketplace.ContactType
import marketplace.Intent
import marketplace.Profile
import marketplace.Type
import marketplace.Category

@TestMixin(GrailsUnitTestMixin)
class PropertyRefInputRepresentationUnitTest {

    PropertyRefInputRepresentation rep

    void testIntentsPropertyInputRep() {
        rep = new IntentPropertyRefInputRepresentation('application/json/view')

        assert rep.representedClass() == Intent.class
        assert rep.identifyingProperties == [action: 'view', type: 'application/json']
    }

    void testProfilePropertyInputRep() {
        rep = new ProfilePropertyInputRepresentation()
        rep.username = 'user'

        assert rep.representedClass() == Profile.class
        assert rep.identifyingProperties == [username: 'user']
    }

    void testTitleRefInputRepresentation() {
        rep = new TitleRefInputRepresentation(PropertyRefInputRepresentationUnitTest.class, 'A title')

        assert rep.identifyingProperties == [title: 'A title']
        assert rep.representedClass() == PropertyRefInputRepresentationUnitTest.class
    }

    void testTypeTitleInputRef() {
        rep = new TypeTitleInputRepresentation('')

        assert rep.representedClass() == Type.class
    }

    void testCategoryTitleInputRef() {
        rep = new CategoryTitleInputRepresentation('')

        assert rep.representedClass() == Category.class
    }

    void testAgencyTitleInputRef() {
        rep = new AgencyTitleInputRepresentation('')

        assert rep.representedClass() == Agency.class
    }

    void testContactTypeInputRepresentation() {
        rep = new ContactTypeTitleInputRepresentation('')

        assert rep.representedClass() == ContactType.class
    }
}
