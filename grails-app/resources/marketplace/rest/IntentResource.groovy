package marketplace.rest

import marketplace.Intent
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Path

@Path('api/intent')
class IntentResource extends DomainResource<Intent> {
    @Autowired
    IntentResource(IntentRestService intentRestService) {
        super(Intent.class, intentRestService)
    }

    IntentResource() {}
}
