package marketplace.rest

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.IntentAction
import org.springframework.beans.factory.annotation.Autowired

@Path('api/intentAction')
class IntentActionResource extends DomainResource<IntentAction> {

    @Autowired
    public IntentActionResource(IntentActionRestService intentActionRestService) {
        super(IntentAction.class, intentActionRestService)
    }

    IntentActionResource() {}
}
