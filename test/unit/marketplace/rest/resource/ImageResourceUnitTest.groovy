package marketplace.rest.resource

import java.nio.file.Path
import java.nio.file.Paths

import javax.servlet.http.HttpServletRequest
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

import com.sun.jersey.multipart.FormDataBodyPart

import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.TestMixin

import marketplace.ClientAuditData
import marketplace.ImageReference

import marketplace.hal.ApplicationRootUriBuilderHolder

import marketplace.rest.service.ImageRestService
import marketplace.rest.resource.uribuilder.ImageReferenceUriBuilder

@TestMixin(DomainClassUnitTestMixin)
class ImageResourceUnitTest {
    private final ClientAuditData emptyAuditData = new ClientAuditData()

    ImageResource resource

    void setUp() {
        ClientAuditData.metaClass.static.fromHttpRequest = { HttpServletRequest req ->
            emptyAuditData
        }

        resource = new ImageResource()
    }

    void testGetImage() {
        UUID id = UUID.randomUUID()
        String fileExtension = 'png'
        MediaType mediaType = MediaType.valueOf('image/png')
        Path imagePath = Paths.get('test/file')

        def serviceMock = mockFor(ImageRestService)
        serviceMock.demand.getMediaType(1..1) { String ext ->
            assert ext == fileExtension

            return mediaType
        }
        serviceMock.demand.get(1..1) { ImageReference serviceImageRef,
                ClientAuditData serviceAuditData ->
            assert serviceImageRef.id == id
            assert serviceImageRef.mediaType == mediaType
            assert serviceAuditData.is(emptyAuditData)

            return imagePath
        }

        resource.service = serviceMock.createMock()

        Response response = resource.getImage(null, id, fileExtension)

        assert response.entity instanceof File
        assert response.entity.path == imagePath.toString()
        assert response.metadata['Content-Type'] == [mediaType]
    }

    void testCreate() {
        UriInfo uriInfo = [
            getBaseUriBuilder: { null }
        ] as UriInfo
        byte[] imageBytes = [1,2,3,4]
        MediaType requestType = MediaType.valueOf('image/png')

        def serviceMock = mockFor(ImageRestService)
        serviceMock.demand.createFromRepresentation(1..1) { ImageReference serviceImageRef,
                byte[] data, ClientAuditData serviceAuditData ->
            assert serviceImageRef.mediaType == requestType
            assert serviceAuditData.is(emptyAuditData)
            assert data == imageBytes
        }

        resource.service = serviceMock.createMock()

        def uriBuilderFactoryMock = mockFor(ImageReferenceUriBuilder.Factory)
        uriBuilderFactoryMock.demand.getBuilder(1..1) {
                ApplicationRootUriBuilderHolder uriBuilderHolder->
            new ImageReferenceUriBuilder(null, null, null) {
                URI getImageUri(ImageReference ref) {
                    new URI("https://localhost/test/image/$ref.id")
                }
            }
        }

        resource.uriBuilderFactory = uriBuilderFactoryMock.createMock()

        Response response = resource.create(uriInfo, null, imageBytes,
            requestType)

        assert response.entity instanceof ImageReference
        assert response.entity.id != null
        assert response.entity.mediaType == requestType
        assert response.metadata['Location'] ==
            [new URI("https://localhost/test/image/${response.entity.id}")]
    }

    void testCreateFromForm() {
        UriInfo uriInfo = [
            getBaseUriBuilder: { null }
        ] as UriInfo
        byte[] imageBytes = [1,2,3,4]
        MediaType requestType = MediaType.valueOf('image/png')
        FormDataBodyPart formData = [
            getValueAs: { Class cls -> imageBytes },
            getMediaType: { requestType }
        ] as FormDataBodyPart

        def serviceMock = mockFor(ImageRestService)
        serviceMock.demand.createFromRepresentation(1..1) { ImageReference serviceImageRef,
                byte[] data, ClientAuditData serviceAuditData ->
            assert serviceImageRef.mediaType == requestType
            assert serviceAuditData.is(emptyAuditData)
            assert data == imageBytes
        }

        resource.service = serviceMock.createMock()

        def uriBuilderFactoryMock = mockFor(ImageReferenceUriBuilder.Factory)
        uriBuilderFactoryMock.demand.getBuilder(1..1) {
                ApplicationRootUriBuilderHolder uriBuilderHolder->
            new ImageReferenceUriBuilder(null, null, null) {
                URI getImageUri(ImageReference ref) {
                    new URI("https://localhost/test/image/$ref.id")
                }
            }
        }

        resource.uriBuilderFactory = uriBuilderFactoryMock.createMock()

        Response response = resource.createFromForm(uriInfo, null, formData)

        assert response.entity instanceof ImageReference
        assert response.entity.id != null
        assert response.entity.mediaType == requestType
        assert response.metadata['Location'] ==
            [new URI("https://localhost/test/image/${response.entity.id}")]
    }
}
