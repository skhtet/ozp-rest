package marketplace.hal

import java.lang.reflect.Type
import java.lang.reflect.ParameterizedType

import javax.ws.rs.core.UriInfo
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.UriBuilder

import com.fasterxml.jackson.databind.ObjectMapper

import grails.converters.JSON

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class AbstractRepresentationWriterUnitTest {
    AbstractRepresentationWriter writer
    AbstractHalRepresentation<WrittenClass<?>> rep

    private static class WrittenClass<T> {}

    private class Factory<T> implements RepresentationFactory<WrittenClass<T>> {
        AbstractHalRepresentation<WrittenClass<T>> toRepresentation(WrittenClass obj,
                ApplicationRootUriBuilderHolder uriBuilderHolder) {
            rep = new AbstractHalRepresentation() {
                WrittenClass<T> obj() { obj }
                ApplicationRootUriBuilderHolder uriBuilderHolder() { uriBuilderHolder }

                String getName() { "bob" }
                int getAge() { 1 }
            }

            return rep
        }
    }


    ParameterizedType makeTypeToken(Type typeParam) {
        [
            getActualTypeArguments: {
                [typeParam] as Type[]
            },
            getOwnerType: {
                null
            },
            getRawType: {
                WrittenClass.class
            }
        ] as ParameterizedType
    }

    void setUp() {
        writer =
            new AbstractRepresentationWriter<WrittenClass<? extends Number>>(new Factory<Number>()) {}
    }

    void testIsWriteable() {
        assert !writer.isWriteable(Object.class, Object.class, null, null)

        assert writer.isWriteable(WrittenClass.class, makeTypeToken(Number), null, null)
        assert writer.isWriteable(WrittenClass.class, makeTypeToken(Float), null, null)
        assert writer.isWriteable(WrittenClass.class, makeTypeToken(Integer), null, null)
        assert !writer.isWriteable(WrittenClass.class, makeTypeToken(Object), null, null)
        assert !writer.isWriteable(WrittenClass.class, makeTypeToken(AbstractRepresentationWriterUnitTest), null, null)
    }

    void testWriteTo() {
        String uriBase = 'https://localhost:8443/test'

        writer.objectMapper = new ObjectMapper()
        writer.uriInfo = [
            getBaseUriBuilder: {
                UriBuilder.fromPath(uriBase)
            }
        ] as UriInfo

        WrittenClass obj = new WrittenClass()

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        writer.writeTo(obj, WrittenClass.class, makeTypeToken(Integer), null, MediaType.APPLICATION_JSON_TYPE,
            null, outputStream)

        def json = JSON.parse(new ByteArrayInputStream(outputStream.toByteArray()), 'UTF-8')

        assert json.age == 1
        assert json.name == 'bob'
        assert rep.uriBuilderHolder().builder.build() == new URI(uriBase)

        //.get() is necessary because rep.obj ends up as a groovy.lang.reference
        assert rep.obj.get().is(obj)
    }
}
