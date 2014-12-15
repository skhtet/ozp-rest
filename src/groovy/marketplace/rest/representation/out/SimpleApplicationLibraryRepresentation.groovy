package marketplace.rest.representation.out

import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

import com.fasterxml.jackson.annotation.JsonValue

import marketplace.ApplicationLibraryEntry
import marketplace.Profile

import marketplace.hal.ApplicationRootUriBuilderHolder
import marketplace.hal.AbstractHalRepresentation
import marketplace.hal.RepresentationFactory

import marketplace.rest.ChildObjectCollection


class SimpleApplicationLibraryRepresentation extends
        AbstractHalRepresentation<Collection<ApplicationLibraryEntry>> {

    public static final String MEDIA_TYPE = 'application/vnd.ozp-library-simple-v1+json'

    private List<ApplicationLibraryEntry> library
    private RepresentationFactory<ApplicationLibraryEntry> entryFactory
    private ApplicationRootUriBuilderHolder uriBuilderHolder

    private SimpleApplicationLibraryRepresentation(
            Collection<ApplicationLibraryEntry> library,
            RepresentationFactory<ApplicationLibraryEntry> entryFactory,
            ApplicationRootUriBuilderHolder uriBuilderHolder) {
        this.library = library as List
        this.entryFactory = entryFactory
        this.uriBuilderHolder = uriBuilderHolder
    }

    @JsonValue
    public List<SimpleApplicationLibraryEntryRepresentation> asJsonList() {
        library.collect {
            entryFactory.toRepresentation(it, uriBuilderHolder)
        }
    }


    @Component
    public static class Factory implements
            RepresentationFactory<ChildObjectCollection<Profile, ApplicationLibraryEntry>> {
        @Autowired SimpleApplicationLibraryEntryRepresentation.Factory entryFactory

        @Override
        SimpleApplicationLibraryRepresentation toRepresentation(
                ChildObjectCollection<Profile, ApplicationLibraryEntry>  entries,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {

            new SimpleApplicationLibraryRepresentation(entries, entryFactory, uriBuilderHolder)
        }
    }
}

