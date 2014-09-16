package marketplace.converter

import java.beans.PropertyEditorSupport
import java.text.SimpleDateFormat

class JsonDateConverter extends PropertyEditorSupport {

    public static final String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"

    @Override
    def String getAsText() {
        new SimpleDateFormat(JSON_DATE_FORMAT).format(value)
    }

    @Override
    void setAsText (String text) {
        text == null ? null : setValue(new SimpleDateFormat(JSON_DATE_FORMAT).parse(text))
    }
}