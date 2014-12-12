package marketplace.converter

import java.util.UUID
import java.beans.PropertyEditorSupport

class UUIDConverter extends PropertyEditorSupport {

    @Override
    def String getAsText() {
        value.toString()
    }

    @Override
    void setAsText (String text) {
        setValue(UUID.fromString(text))
    }
}

