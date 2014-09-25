package marketplace.testutil

import marketplace.Profile

/**
 * Grails 2.3.7 has a bug in its test framework where
 * the 'none' keyword in the mappedBy block doesn't work.  Instead
 * null should be used.  At runtime however, null doesn't work.  To address
 * this we have 'none' in our source code, and this class patches Profile at
 * test time to use null instead
 *
 * @see https://jira.grails.org/browse/GRAILS-11285
 */
class ProfileMappedByFix {
    static void fixProfileMappedBy() {
        Profile.mappedBy['organizations'] = null
        Profile.mappedBy['stewardedOrganizations'] = null

        //for some reason the createdBy and editedBy mappings do work, so don't mess with them.
    }
}
