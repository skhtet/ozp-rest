package marketplace.rest.resource

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Types
import org.springframework.beans.factory.annotation.Autowired

import marketplace.rest.service.TypeRestService

@Path('api/type')
class TypeResource extends DomainResource<Types> {

    @Autowired
    public TypeResource(TypeRestService typeRestService) {
        super(Types.class, typeRestService)
    }

    TypeResource() {}
}
