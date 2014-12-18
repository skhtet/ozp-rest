package marketplace.rest.service

import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import java.nio.file.FileSystems
import java.nio.file.FileSystem
import java.nio.file.DirectoryStream
import java.nio.file.FileVisitor
import java.nio.file.FileVisitResult
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime

import javax.ws.rs.core.MediaType

import org.springframework.security.access.AccessDeniedException

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

import net.sf.ehcache.CacheManager
import net.sf.ehcache.Cache
import net.sf.ehcache.Element
import net.sf.ehcache.config.Configuration
import net.sf.ehcache.config.CacheConfiguration

import marketplace.ImageReference
import marketplace.Role
import marketplace.Profile
import marketplace.Listing
import marketplace.Screenshot
import marketplace.Agency

import marketplace.rest.DomainObjectNotFoundException

@TestMixin(GrailsUnitTestMixin)
class ImageRestServiceUnitTest {
    ImageRestService service
    GrailsApplication grailsApplication
    CacheManager cacheManager

    Profile currentUser, admin, user

    private typeConfig = [
        'image/png': 'png',
        'image/bmp': 'bmp'
    ]

    //on Windows systems, all of the paths come back with backslash dir separators.  To
    //keep things consistent, switch them to forward slashes
    private toUnixPath(String path) {
        path.replaceAll('\\\\', '/')
    }

    void setUp() {
        grailsApplication = new DefaultGrailsApplication()
        grailsApplication.config.marketplace.acceptableImageTypes = typeConfig

        //use the test configuration to avoid starting up jgroups, which takes forever
        cacheManager = CacheManager.create('grails-app/conf/ehcache-test.xml')
        cacheManager.addCache(new Cache('imageReference', 10, false, false, 10000, 10000))

        admin = new Profile(username: 'admin', highestRole: Role.ADMIN)
        user = new Profile(username: 'user', highestRole: Role.USER)

        currentUser = admin

        service = new ImageRestService(grailsApplication, cacheManager)
        service.profileRestService = [
            getCurrentUserProfile: { currentUser }
        ] as ProfileRestService
    }

    void tearDown() {
        cacheManager.shutdown()
    }

    void testGetFileExtension() {
        MediaType mediaType = MediaType.valueOf('image/png')
        ImageReference imageRef = new ImageReference(mediaType)

        assert service.getFileExtension(imageRef) == 'png'

        mediaType = MediaType.valueOf('image/gif')
        imageRef = new ImageReference(mediaType)

        shouldFail(IllegalArgumentException) {
            service.getFileExtension(imageRef)
        }
    }

    void testGetImageDir() {
        String pathStr = '/var/lib/ozp/images'

        grailsApplication.config.marketplace.imageStoragePath = pathStr
        Path imageDir = service.getImageDir()

        assert toUnixPath(imageDir.toString()) == pathStr
    }

    void testGetMediaType() {
        assert service.getMediaType('bmp') == MediaType.valueOf('image/bmp')

        shouldFail(IllegalArgumentException) {
            service.getMediaType('svg')
        }
    }

    void testCreateFromRepresentation() {
        grailsApplication.config.marketplace.imageStoragePath = '/var/lib/ozp/images'

        UUID id = UUID.fromString('7619674d-76c9-435a-afe8-f2ef07803907')
        MediaType mediaType = MediaType.valueOf('image/png')
        ImageReference imageRef = new ImageReference(id, mediaType)
        boolean exists = false
        byte[] data = [1,2,3,4]


        Files.metaClass.static.createDirectories = { Path dir ->
            assert toUnixPath(dir.toString()) == '/var/lib/ozp/images/76'
        }
        Files.metaClass.static.exists = { Path p -> exists }
        Files.metaClass.static.write = { Path p, byte[] bytes ->
            assert toUnixPath(p.toString()) ==
                '/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.png'
            assert bytes == data
        }

        Path returned = service.createFromRepresentation(imageRef, data, null)

        assert toUnixPath(returned.toString()) ==
            '/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.png'

        ImageReference cachedRef =  cacheManager.getCache('imageReference').get(id).objectValue
        assert cachedRef.id == id
        assert cachedRef.mediaType == mediaType

        shouldFail(IllegalArgumentException) {
            service.createFromRepresentation(imageRef, new byte[0], null)
        }
        shouldFail(IllegalArgumentException) {
            service.createFromRepresentation(imageRef, new byte[(1 << 20) + 1], null)
        }

        //should not fail
        data = new byte[1 << 20]
        service.createFromRepresentation(imageRef, data, null)

        exists = true
        shouldFail(IllegalStateException) {
            service.createFromRepresentation(imageRef, data, null)
        }
    }

    void testGet() {
        grailsApplication.config.marketplace.imageStoragePath = '/var/lib/ozp/images'

        UUID id = UUID.fromString('7619674d-76c9-435a-afe8-f2ef07803907')
        MediaType mediaType = MediaType.valueOf('image/png')
        ImageReference imageRef = new ImageReference(id, mediaType)
        boolean exists = true

        Files.metaClass.static.notExists = { Path p -> !exists }

        Path result = service.get(imageRef, null)

        assert toUnixPath(result.toString()) ==
            '/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.png'

        exists = false
        shouldFail(DomainObjectNotFoundException) {
            service.get(imageRef, null)
        }
    }

    void testGetImageReference() {
        grailsApplication.config.marketplace.imageStoragePath = '/var/lib/ozp/images'

        UUID id = UUID.fromString('7619674d-76c9-435a-afe8-f2ef07803907')

        //start out with no matched file
        Path pathToFile = null

        Files.metaClass.static.newDirectoryStream = { Path p ->
            assert toUnixPath(p.toString()) == '/var/lib/ozp/images/76'

            DirectoryStream dStream = [
                close: {}
            ] as DirectoryStream

            //have to mock find method separately since its a metaClass method to begin with
            dStream.metaClass.find = { Closure closure ->
                return pathToFile
            }

            return dStream
        }
        FileSystems.metaClass.static.getDefault = { ->
            [
                getPathMatcher: { String matcherSpec ->
                    assert toUnixPath(matcherSpec) ==
                        'glob:/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.*'

                    return null
                }
            ] as FileSystem
        }

        shouldFail(DomainObjectNotFoundException) {
            service.getImageReference(id)
        }

        pathToFile =
            Paths.get('/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.bmp')

        ImageReference returnedRef = service.getImageReference(id)
        assert returnedRef.id == id
        assert returnedRef.mediaType == MediaType.valueOf('image/bmp')

        ImageReference cachedRef = cacheManager.getCache('imageReference').get(id).objectValue
        assert cachedRef.id == id
        assert cachedRef.mediaType == MediaType.valueOf('image/bmp')
    }

    void testGarbageCollectImages() {
        grailsApplication.config.marketplace.imageStoragePath = '/var/lib/ozp/images'

        //stub logImageDelete
        service.metaClass.logImageDelete = { UUID id -> }

        Date currentDate = new Date()
        Date old = new Date(currentDate.time - (1000 * 60 * 60 * 30)) //30 hours ago
        Date recent = new Date(currentDate.time - (1000 * 60 * 60 * 23)) //23 hours ago
        boolean currentDirectoryIsEmpty

        List<UUID> listingImageUUIDs = [
            'cbb4e9c7-18c0-4a07-89fa-dbb3fa6686e3',
            '7ca24d64-5c6d-4fa2-bb09-eb3f2263baa4',
            '8ddf4d27-a970-4188-a194-7a21e7e26e5b'
        ].collect { UUID.fromString(it) }
        List<UUID> screenshotImageUUIDs = [
            '8ddf4d27-a970-4188-a194-7a21e7e26e5b',
            'fb13835c-6f1f-4503-b996-c6299c30af3c',
            '57aceb2f-2b3a-4b4f-8f99-1786ca3f288f'
        ].collect { UUID.fromString(it) }
        List<UUID> agencyImageUUIDs = [
            '6d671fbb-5837-4cdf-90a3-ec228a79be81',
            '21371e89-1004-4e4f-a45c-c1c07c79f05c'
        ].collect { UUID.fromString(it) }

        Cache cache = cacheManager.getCache('imageReference')

        //put elements in the cache for some of the UUIDs
        [
            listingImageUUIDs,
            screenshotImageUUIDs,
            //an existing image that should be deleted
            [UUID.fromString('7619674d-76c9-435a-afe8-f2ef07803907')]
        ].flatten().each {
            cache.put(new Element(it, 1))
        }

        Listing.metaClass.static.createCriteria = { ->
            [ list: { closure -> listingImageUUIDs } ]
        }
        Screenshot.metaClass.static.createCriteria = { ->
            [ list: { closure -> screenshotImageUUIDs } ]
        }
        Agency.metaClass.static.createCriteria = { ->
            [ list: { closure -> agencyImageUUIDs } ]
        }

        //keep track of what was "deleted"
        Set<Path> deletedPaths = new HashSet()

        Files.metaClass.static.createDirectories = { Path p -> }
        Files.metaClass.static.newDirectoryStream = { Path dir ->
            [
                iterator: { ->
                    [
                        hasNext: { -> !currentDirectoryIsEmpty }
                    ] as Iterator
                },
                close: { -> }
            ] as DirectoryStream
        }
        Files.metaClass.static.delete = { Path p -> deletedPaths << p }
        Files.metaClass.static.walkFileTree = { Path p, FileVisitor visitor ->

            //a file that should be deleted
            FileVisitResult result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.bmp'),
                [
                    lastModifiedTime: { FileTime.fromMillis(old.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a file that is too recent to be deleted
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803908.bmp'),
                [
                    lastModifiedTime: { FileTime.fromMillis(recent.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a file that is still referenced
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/21/21371e89-1004-4e4f-a45c-c1c07c79f05c.bmp'),
                [
                    lastModifiedTime: { FileTime.fromMillis(recent.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a file that is still referenced but is old
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/fb/fb13835c-6f1f-4503-b996-c6299c30af3c.bmp'),
                [
                    lastModifiedTime: { FileTime.fromMillis(recent.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a filename in an unexpected format
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/fb/fb13835c-6f1f-4503-b996-c6299c30af3c'),
                [
                    lastModifiedTime: { FileTime.fromMillis(old.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a filename with an invalid UUID
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/fb/what.png'),
                [
                    lastModifiedTime: { FileTime.fromMillis(old.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a filename with an unexpected extension
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/cb/cbb4e9c7-18c0-4a07-89fa-dbb3fa6686e3.gif'),
                [
                    lastModifiedTime: { FileTime.fromMillis(old.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a filename with an unexpected extension that is old and unreferenced
            result = visitor.visitFile(
                Paths.get('/var/lib/ozp/images/be/be18d00f-f57e-4408-8705-87cd31d77b91.gif'),
                [
                    lastModifiedTime: { FileTime.fromMillis(old.time) }
                ] as BasicFileAttributes
            )
            assert result == FileVisitResult.CONTINUE

            //a directory that is not empty
            currentDirectoryIsEmpty = false
            result = visitor.postVisitDirectory(
                Paths.get('/var/lib/ozp/images/cb'),
                null
            )
            assert result == FileVisitResult.CONTINUE

            //a directory that is empty
            currentDirectoryIsEmpty = true
            result = visitor.postVisitDirectory(
                Paths.get('/var/lib/ozp/images/db'),
                null
            )
            assert result == FileVisitResult.CONTINUE

            //should never try to delete the imageDir itself
            currentDirectoryIsEmpty = true
            result = visitor.postVisitDirectory(
                Paths.get('/var/lib/ozp/images'),
                null
            )
            assert result == FileVisitResult.CONTINUE

            //exception pass-through
            currentDirectoryIsEmpty = true
            shouldFail(IOException) {
                visitor.postVisitDirectory(
                    Paths.get('/var/lib/ozp/images/eb'),
                    new IOException()
                )
            }
        }

        int deletedCount = service.garbageCollectImages()

        assert deletedPaths.contains(
                Paths.get('/var/lib/ozp/images/76/7619674d-76c9-435a-afe8-f2ef07803907.bmp'))
        assert deletedPaths.contains(
                Paths.get('/var/lib/ozp/images/be/be18d00f-f57e-4408-8705-87cd31d77b91.gif'))
        assert deletedPaths.contains(
                Paths.get('/var/lib/ozp/images/db'))
        assert deletedPaths.size() == 3

        //make sure the cache entry for the deleted image was also removed
        assert cache.get(UUID.fromString('7619674d-76c9-435a-afe8-f2ef07803907')) == null

        //number of FILES (not directories) that were deleted
        assert deletedCount == 2
    }

    void testGarbageCollectImagesNonAdmin() {
        currentUser = user

        shouldFail(AccessDeniedException) {
            service.garbageCollectImages()
        }
    }
}
