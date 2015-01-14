package marketplace

import javax.ws.rs.core.MediaType

/**
 * Class for moving around an image id and its media type together
 */
class ImageReference implements Serializable {
    final UUID id
    //store as string to allow serialization (MediaType isn't serializable)
    private final String mediaType

    ImageReference(UUID id, MediaType mediaType) {
        this.id = id
        this.mediaType = mediaType.toString()
    }

    ImageReference(MediaType mediaType) {
        this(UUID.randomUUID(), mediaType)
    }

    public MediaType getMediaType() { MediaType.valueOf(mediaType) }

    public String toString() {
        "ImageReference:$id:$mediaType"
    }
}
