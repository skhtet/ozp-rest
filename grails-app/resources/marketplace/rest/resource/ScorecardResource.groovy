package marketplace.rest.resource

import marketplace.Scorecard

import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created

import marketplace.rest.service.ScorecardRestService
import marketplace.rest.representation.in.ScorecardInputRepresentation
import marketplace.rest.representation.out.ScorecardRepresentation

@Path('api/scorecard')
class ScorecardResource {
    @Autowired ScorecardRestService scorecardRestService

    ScorecardResource() {}

    @GET
    @Path('/{id}')
    @Produces([
        ScorecardRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Scorecard read(@PathParam('id') long id) {

        scorecardRestService.getById(id)
    }

    @DELETE
    @Path('/{id}')
    void delete(@PathParam('id') long id) {

        scorecardRestService.deleteById(id)
    }

    @POST
    @Consumes([
        ScorecardInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        ScorecardRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Response create(ScorecardInputRepresentation rep) {
        created scorecardRestService.createFromRepresentation(rep)
    }

    @GET
    @Produces([
        ScorecardRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Collection<Scorecard> readAll(@QueryParam('offset') Integer offset,
                               @QueryParam('max') Integer max) {

        scorecardRestService.getAll(offset, max)
    }

    @PUT
    @Consumes([
        ScorecardInputRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Produces([
        ScorecardRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    @Path('/{id}')
    Scorecard update(@PathParam('id') long id,
                  ScorecardInputRepresentation rep) {
        scorecardRestService.updateById(id, rep)
    }
}
