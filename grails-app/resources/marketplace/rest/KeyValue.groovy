package marketplace.rest

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by richiep on 8/18/14.
 */

@ToString(includeNames=true)
@EqualsAndHashCode(includeFields=true)
class KeyValue {
    String key
    String value
}
