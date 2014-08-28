package marketplace.rest

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.IntentDataType
import org.springframework.beans.factory.annotation.Autowired

@Path('api/intentDataType')
class IntentDataTypeResource extends DomainResource<IntentDataType> {

    @Autowired
    public IntentDataTypeResource(IntentDataTypeRestService intentDataTypeRestService) {
        super(IntentDataType.class, intentDataTypeRestService)
    }

    IntentDataTypeResource() {}
}
