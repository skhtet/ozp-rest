package marketplace.rest

import marketplace.Intent

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
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
    Collection<Intent> readAllBySubType(@PathParam('mainType') String mainType,
                                     @PathParam('subType') String subType,
                                     @QueryParam('max') Integer max,
                                     @QueryParam('offset') Integer offset) {

        intentRestService.getAllByMediaType(mainType, subType, max, offset)
    }

    @GET
    @Path('/{mainType}')
    Collection<Intent> readAllByMainType(@PathParam('mainType') String mainType,
                                      @QueryParam('max') Integer max,
                                      @QueryParam('offset') Integer offset) {
        intentRestService.getAllByMainType(mainType, max, offset)
    }

    @GET
    @Path('/{mainType}/{subType}/{action}')
    Intent read(@PathParam('mainType') String mainType,
                @PathParam('subType') String subType,
                @PathParam('action') String action) {

        intentRestService.getById("$mainType/$subType/$action")
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
