package marketplace.rest

import java.lang.reflect.Type

import javax.ws.rs.core.MediaType

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static ozone.utils.Utils.collectEntries

@Component
class RepresentationRegistry {
    private Map<Type, Map<MediaType, RepresentationFactory>> registry

    @Autowired
    RepresentationRegistry(Collection<RepresentationFactory> representationFactories) {
        Map<Type, Map<MediaType, RepresentationFactory>> modifiableRegistry = [:]

        representationFactories.each { factory ->
            Type type = factory.supportedType

            Map<MediaType, RepresentationFactory> mediaTypeMap =
                modifiableRegistry.get(type) ?: [:]

            factory.mediaTypes.each { mediaType ->
                mediaTypeMap.put(mediaType, factory)
            }

            modifiableRegistry.put(type, mediaTypeMap)
        }

        //freeze maps
        registry = Collections.unmodifiableMap(collectEntries(modifiableRegistry) { k,v ->
            [k, Collections.unmodifiableMap(v)]
        })
    }

    public RepresentationFactory get(Type type, MediaType mediaType) {
System.err.println "in registry get.  type = $type and mediaType = $mediaType"
        registry.get(type)?.get(mediaType)
    }
}
