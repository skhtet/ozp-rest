package marketplace

import grails.test.mixin.TestFor
import org.junit.Test

@TestFor(Screenshot)
class ScreenshotTests {

    private final UUID LARGE_ID = UUID.randomUUID()
    private final UUID SMALL_ID = UUID.randomUUID()

    @Test
    public void testGetLargeImageUrl() {
        Screenshot screenshot = new Screenshot(
            smallImageId: SMALL_ID,
            largeImageId: LARGE_ID
        )

        assert screenshot.largeImageId == LARGE_ID
    }

    @Test
    public void testGetLargeImageUrlMissing() {
        Screenshot screenshot = new Screenshot(
            smallImageId: SMALL_ID
        )

        //should use the small url when the large url is not set
        assert screenshot.largeImageId == SMALL_ID
    }

    @Test
    public void testSerializable() {
        assert (new Screenshot()) instanceof Serializable
    }
}
