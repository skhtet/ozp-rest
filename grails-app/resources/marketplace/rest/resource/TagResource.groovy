package marketplace.rest.resource

import javax.ws.rs.Path

import org.springframework.beans.factory.annotation.Autowired

import marketplace.Tag

import javax.ws.rs.GET
import javax.ws.rs.QueryParam

import marketplace.rest.service.TagRestService

@Path('/api/tag')
class TagResource extends DomainResource<Tag>{

    TagResource(){}

    @Autowired
    TagRestService tagRestService

    @Autowired
    public TagResource(TagRestService tagRestService) {
        super(Tag.class, tagRestService)
    }

    @GET
    @Path('/search')
    Collection<Tag> findByTitle(@QueryParam("title") String title){
        tagRestService.findAllLikeTitle(title)
    }
}
