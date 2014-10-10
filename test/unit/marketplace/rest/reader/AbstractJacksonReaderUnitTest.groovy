package marketplace.rest.reader

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
class AbstractJacksonReaderUnitTest {
    AbstractJacksonReader reader

    private static class ClassToRead<T> {
        String name
        int age
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
                ClassToRead.class
            }
        ] as ParameterizedType
    }

    void setUp() {
        reader =
            new AbstractJacksonReader<ClassToRead<Integer>>() {}
    }

    void testIsReadable() {
        assert reader.isReadable(Object.class, Object.class, null, null)

        assert !reader.isReadable(ClassToRead.class, makeTypeToken(Number), null, null)
        assert !reader.isReadable(ClassToRead.class, makeTypeToken(Float), null, null)
        assert reader.isReadable(ClassToRead.class, makeTypeToken(Integer), null, null)
        assert !reader.isReadable(ClassToRead.class, makeTypeToken(Object), null, null)
        assert !reader.isReadable(ClassToRead.class, makeTypeToken(AbstractJacksonReaderUnitTest), null, null)
    }

    void testReadFrom() {
        String uriBase = 'https://localhost:8443/test'

        reader.objectMapper = new ObjectMapper()

        ByteArrayInputStream inputStream = new ByteArrayInputStream('{"name": "bob", "age": 10}'.getBytes('UTF-8'))
        ClassToRead obj = reader.readFrom(ClassToRead.class, makeTypeToken(Integer), null, MediaType.APPLICATION_JSON_TYPE,
            null, inputStream)

        assert obj.age == 10
        assert obj.name == 'bob'
    }
}
