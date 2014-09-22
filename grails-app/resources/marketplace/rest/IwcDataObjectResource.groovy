package marketplace.rest

import marketplace.IwcDataObject
import org.springframework.beans.factory.annotation.Autowired

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.HeaderParam
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder
import javax.ws.rs.core.HttpHeaders

@Path('api/profile/self/userData')
class IwcDataObjectResource {
    @Autowired ProfileRestService profileRestService

    @GET
    @Produces([
        IwcDataObjectRepresentation.COLLECTION_MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    Collection<IwcDataObject> readAll() {
        profileRestService.getCurrentUserData()
    }

    @Path('/{key:.+}')
    @GET
    @Produces([
        IwcDataObjectRepresentation.MEDIA_TYPE,
        MediaType.APPLICATION_JSON
    ])
    IwcDataObject read(@PathParam('key') String key) {
        profileRestService.getCurrentUserDataItem(keyFromPath(key))
    }

    @Path('/{key:.+}')
    @PUT
    @Consumes(MediaType.WILDCARD)
    Response update(@PathParam('key') String  key, String value,
                    @HeaderParam(HttpHeaders.CONTENT_TYPE) String contentType) {

        IwcDataObject putValue = profileRestService.updateCurrentUserDataByKey(
                keyFromPath(key), value, typeFromHeader(contentType))

        putValue ? Response.noContent().build() :
                Response.created(UriBuilder.fromPath(keyFromPath(key)).build()).build()
    }

    @Path('/{key:.+}')
    @DELETE
    Response delete(@PathParam('key') String key) {
        profileRestService.deleteCurrentUserDataByKey(keyFromPath(key))
        Response.noContent().build()
    }

    private static String keyFromPath(String key) {
        key.endsWith('/') ? key[0..-2] : key
    }

    private static String typeFromHeader(String contentType) {
        MediaType mt = MediaType.valueOf(contentType)
        mt.type + '/' + mt.subtype
    }
}
