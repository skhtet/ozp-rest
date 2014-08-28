package marketplace.rest

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Types
import org.springframework.beans.factory.annotation.Autowired

@Path('api/type')
class TypeResource extends DomainResource<Types> {

    @Autowired
    public TypeResource(TypeRestService typeRestService) {
        super(Types.class, typeRestService)
    }

    TypeResource() {}
}
