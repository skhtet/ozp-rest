package marketplace.rest

import marketplace.Intent

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created

@Path('api/intent')
class IntentResource {
    @Autowired IntentRestService intentRestService

    IntentResource() {}

    @GET
    @Path('/{mainType}/{subType}')
    Collection<Intent> readBySubType(@PathParam('mainType') String mainType,
                                     @PathParam('subType') String subType) {

        intentRestService.getByDataType(mainType, subType)
    }

    @GET
    @Path('/{mainType}')
    Collection<Intent> read(@PathParam('mainType') String mainType) {
        intentRestService.getByMainType(mainType)
    }

    @GET
    @Path('/{mainType}/{subType}/{action}')
    Intent read(@PathParam('mainType') String mainType,
                @PathParam('subType') String subType,
                @PathParam('action') String action) {

        intentRestService.getById("$mainType/$subType/$action")
    }

    @PUT
    @Path('/{mainType}/{subType}/{action}')
    Intent update(@PathParam('mainType') String mainType,
                  @PathParam('subType') String subType,
                  @PathParam('action') String action,
                  Intent dto) {

        intentRestService.updateById("$mainType/$subType/$action", dto)
    }

    @DELETE
    @Path('/{mainType}/{subType}/{action}')
    void delete(@PathParam('mainType') String mainType,
                @PathParam('subType') String subType,
                @PathParam('action') String action) {

        intentRestService.deleteById("$mainType/$subType/$action")
    }

    @POST
    Response create(Intent dto) {
        created intentRestService.createFromDto(dto)
    }

    @GET
    Collection<Intent> readAll(@QueryParam('offset') Integer offset,
                               @QueryParam('max') Integer max) {

        intentRestService.getAll(offset, max)
    }
}
