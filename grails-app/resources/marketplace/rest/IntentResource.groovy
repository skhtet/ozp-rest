package marketplace.rest

import marketplace.Intent
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path('api/intent')
class IntentResource extends DomainResource<Intent> {
    @Autowired
    IntentResource(IntentRestService intentRestService) {
        super(Intent.class, intentRestService)
    }

    IntentResource() {}

    @GET
    @Path('/{mainType}/{subType}/{action}')
    Intent read(@PathParam('mainType') String mainType,
                @PathParam('subType') String subType,
                @PathParam('action') String action) {

        service.getById("$mainType/$subType/$action")
    }

    @PUT
    @Path('/{mainType}/{subType}/{action}')
    Intent update(@PathParam('mainType') String mainType,
                  @PathParam('subType') String subType,
                  @PathParam('action') String action,
                  Intent dto) {

        service.updateById("$mainType/$subType/$action", dto)
    }

    @DELETE
    @Path('/{mainType}/{subType}/{action}')
    void delete(@PathParam('mainType') String mainType,
                @PathParam('subType') String subType,
                @PathParam('action') String action) {

        service.deleteById("$mainType/$subType/$action")
    }
}
