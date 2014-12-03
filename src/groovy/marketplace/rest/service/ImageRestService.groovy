package marketplace.rest.service

import javax.ws.rs.core.MediaType

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

import marketplace.Image

import marketplace.rest.DomainObjectNotFoundException

@Service
@Transactional
class ImageRestService {
    @Autowired ProfileRestService profileRestService

    public Image create(byte[] data, MediaType mediaType) {
        new Image(data: data, mediaType: mediaType.toString()).save(failOnError:true)
    }

    @Transactional(readOnly=true)
    public Image getById(long id) {
        Image image = Image.get(id)

        if (!image) {
            throw new DomainObjectNotFoundException(Image, id)
        }

        return image
    }

    public void deleteById(long id) {
        profileRestService.checkAdmin()

        getById(id).delete(flush: true)
    }
}
