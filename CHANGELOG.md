## 0.4.0 (2014-12-09)


#### Bug Fixes

* **Agency:**
  * OZF-373 Fixing access control for agency DELETE ([6a5ae1be](https://github.com/ozone-development/ozp-rest/commit/6a5ae1be7562b335d32b48161ebfb28f8ed92aea))
  * OZF-313 Proper error when agency deletion fails due to existing listings ([c7bf0b2b](https://github.com/ozone-development/ozp-rest/commit/c7bf0b2b5deaa086f8431088fc10cb5dd82943d1))
  * Fixing null icon ([f4384d88](https://github.com/ozone-development/ozp-rest/commit/f4384d880b217b0280275bbae1ceb0eca75e9be1))
  * Adding missing unique constraint ([80a2afa1](https://github.com/ozone-development/ozp-rest/commit/80a2afa15920622336da00da9a7c7241142633d8))
* **Agency and Intents:** Agency and Intents are not throwing validation errors with regards to uniqueness ([ccac9ea4](https://github.com/ozone-development/ozp-rest/commit/ccac9ea4927ceffe245a15282d2fe47fa9cd1d38))
* **Application Library:** fixing Application Library HAL representation ([90ddfc31](https://github.com/ozone-development/ozp-rest/commit/90ddfc312fb882b49c66867fff786e8bb79d52ac))
* **Auditing:** Corrected the way the audit trail looks up the current user ([e739be75](https://github.com/ozone-development/ozp-rest/commit/e739be7518d242c1d6dbeb0e1dcc2a6de396bbad))
* **Category:**
  * text for category delete fail was ambigious. ([17710cbc](https://github.com/ozone-development/ozp-rest/commit/17710cbc093bf539804c5cf9c4d5ba21224fb2e6))
  * Fixing CategoryResource constructor ([289840e4](https://github.com/ozone-development/ozp-rest/commit/289840e441e304830b2f696dcdab6bd85d0ae0c7))
* **Category API:** categories are not deleted if any listings are present in the system ([9d2036b3](https://github.com/ozone-development/ozp-rest/commit/9d2036b3a708a1a03309ac745213dade28dbf24e))
* **Contacts:** OZF-492 Loosening rules for required Contact Types ([73339775](https://github.com/ozone-development/ozp-rest/commit/733397755de6f742d63427dcbc41ebeff72cf625))
* **Draft Listing:** Refining non-draft requirements ([bb7156af](https://github.com/ozone-development/ozp-rest/commit/bb7156af89ec4957b4e46f7a251c11115730deae))
* **Draft Listings:**
  * OZF-436 Correcting non-draft required fields ([fbc42227](https://github.com/ozone-development/ozp-rest/commit/fbc42227887163d60e623cb451869c0edb7504ba))
  * Making width and height nullable ([74a01b18](https://github.com/ozone-development/ozp-rest/commit/74a01b18a1b29ba5f1972219b6bfcea36a6e1fac))
  * Removing docUrls from non-draft required fields ([f0a06df4](https://github.com/ozone-development/ozp-rest/commit/f0a06df4516754e86c3d4c21eb2f8f1f939322a1))
* **Error Status Codes:** certain types are returning a 500 status code when a unique constraint is violat ([08480b84](https://github.com/ozone-development/ozp-rest/commit/08480b84ee5dc64a851bdcb6fb753e5f97f41b08))
* **IWC Application API:** Adding icons to the application representation ([fb6cb246](https://github.com/ozone-development/ozp-rest/commit/fb6cb2466c823fb334558eb740bb20b41b1f7480))
* **IWC Data API:** fixing entity size and resource status codes ([b240be02](https://github.com/ozone-development/ozp-rest/commit/b240be027d827368bd95874c2c1db7ca0e02ab71))
* **Intents:** Trying to modify immutable properties now returns the proper status code and a m ([8427cc8f](https://github.com/ozone-development/ozp-rest/commit/8427cc8f392a74461484ef347ee67fc0f23dd4eb))
* **ItemComment:**
  * OZF-375 Adding missing ItemComment ListingActivity logic ([3393f1f7](https://github.com/ozone-development/ozp-rest/commit/3393f1f75e36897dc287bd6f5015a7e96e120bf8))
  * OZF-283 optional comment ratings ([2e8134df](https://github.com/ozone-development/ozp-rest/commit/2e8134df6b89af5385dd12b1eec3c52b58778fcd))
  * Fixing rate parse error handling ([18bbf59d](https://github.com/ozone-development/ozp-rest/commit/18bbf59d7013c601540d9d2783e7ca62578a8628))
* **IwcApiRepresentation:** Fixing MissingMethodExceptions ([459052ca](https://github.com/ozone-development/ozp-rest/commit/459052ca64977bca5cf37e427b8a9d9d35de76a9))
* **IwcUserApplicationsRepresentation:** Fixing spelling ([2cd23d17](https://github.com/ozone-development/ozp-rest/commit/2cd23d1751aa0fcff16bb4ec68a4ccedc996ab24))
* **Listing:**
  * singleton is missing from the Listing Representation ([b5149b2e](https://github.com/ozone-development/ozp-rest/commit/b5149b2e218cc3d2f6f879ee94120008beca40fd))
  * changing approvalStatus representation ([79003902](https://github.com/ozone-development/ozp-rest/commit/7900390259de3d2fa868b14d08a40d76f27e0f70))
* **Listing API:**
  * OZF-534. Saving a listing fails when agency is null ([4f0d9e86](https://github.com/ozone-development/ozp-rest/commit/4f0d9e868a4afef8395e2664477765f60512722a))
  * listing collections are returning 404 rather than a default representation when  ([db725dcc](https://github.com/ozone-development/ozp-rest/commit/db725dcca0babf08e3f6d82633e68a7329506b5b))
  * editedData is missing from the listing representation ([234ab6ff](https://github.com/ozone-development/ozp-rest/commit/234ab6ff112dae8b71ea8786565728ae48394e55))
  * fixing a compilation error in the Listing RepresentationWriter ([1a00c208](https://github.com/ozone-development/ozp-rest/commit/1a00c2081d32e600d4f7ba532ab9c12371e7cbbf))
  * when a child item in a collection is not valid, a 500 error is returned rather t ([c1a3db30](https://github.com/ozone-development/ozp-rest/commit/c1a3db30b46de31f23fe65fdd56aac9cb6858228))
  * required contact type constraint is not being enforced ([ced80992](https://github.com/ozone-development/ozp-rest/commit/ced809924c5b55e33ea97598fd84f5a160786c6f))
* **Listing Activity:**
  * adding author as a property to Listing Activity Representation ([78f1effc](https://github.com/ozone-development/ozp-rest/commit/78f1effcd47ead8a73f1faf5b662a6f3f5b4802d))
  * OZF-379 Fixing Profile Listing Activity representations ([7b655b88](https://github.com/ozone-development/ozp-rest/commit/7b655b88c1683b7d91b487e5ea32830332726a9a))
  * OZF-374 Adding needed fields for Rejection Activities ([a85051d3](https://github.com/ozone-development/ozp-rest/commit/a85051d3100e89f4fa6d328c20bd6c311b469c2a))
* **Listing Activity Representation:** Adding missing HAL classes for ListingActivity ([678a2ed3](https://github.com/ozone-development/ozp-rest/commit/678a2ed336d0f5f18da5dc357b0f92a74602b3a7))
* **Profile:**
  * the user's highest role should be part of the Profile Representation ([2794b916](https://github.com/ozone-development/ozp-rest/commit/2794b9162a1e58d4e1cc1d0d2f1ef4ca0cf7a21f))
  * OZF-376 Adding id to ProfileRepresentation ([3cd9763b](https://github.com/ozone-development/ozp-rest/commit/3cd9763b707d8e0348d47b989c604b19f02c5a1b))
* **Profile Representation:** OZF-354 allowing ProfileRepresentation for application/json ([00395ac6](https://github.com/ozone-development/ozp-rest/commit/00395ac661ba0b6ae6854343ede0d5f46456016b))
* **REST:**
  * add uuid to /profile/self/library ([59dcc700](https://github.com/ozone-development/ozp-rest/commit/59dcc700d3d66ac5bb057ed7f90beb9353c2f54b))
  * fix runtime error in /profile/self/listing ([ca4acb01](https://github.com/ozone-development/ozp-rest/commit/ca4acb0133fd2a5c5ab83faec9262ed82b6b2951))
  * OZF-377 Removing Content-Type restrictions from DELETE methods ([0b34fddf](https://github.com/ozone-development/ozp-rest/commit/0b34fddf2b195d9978f1495e4133ca3aeffbd8ee))
* **Rejection:** OZF-300 Correcting auth error ([84e70c62](https://github.com/ozone-development/ozp-rest/commit/84e70c62b55ba6f9a30ec81fed772eeecedcbca5))
* **Required Listings:**
  * OZF-563 Removing self from requiringListings response ([7f699230](https://github.com/ozone-development/ozp-rest/commit/7f699230fa7d1e69773fe18d0727d1b37c5eea36))
  * OZF-562 Fix delete of listing with required listings ([56fb89ea](https://github.com/ozone-development/ozp-rest/commit/56fb89eab176068bc563b83ac6d95652fd0902a4))
* **RestService:** Properties of domain classes that are collections are not updating properly ([7d925596](https://github.com/ozone-development/ozp-rest/commit/7d92559607bd6454d16fb4129e669536aa151704))
* **Reviews:** OZF-661 Delete comment throwing an error ([81fe8766](https://github.com/ozone-development/ozp-rest/commit/81fe8766a34337d3a62f71845dc83d92b240205e))
* **Sample data:** adding the data directory ([7d51378e](https://github.com/ozone-development/ozp-rest/commit/7d51378e10d0ef25b7aeaeb4138cb54b62d3449a))
* **Search:**
  * Adding secondary and tertiary sort order ([08936eed](https://github.com/ozone-development/ozp-rest/commit/08936eeda054451ca808a0d2b889c76be950708a))
  * Approval status of search results is always being reported as IN_PROGRESS ([4c97a0de](https://github.com/ozone-development/ozp-rest/commit/4c97a0deab06e55df6155b099bdc126e765e1ad3))
  * Fixing search in reference to UriBuilder refactor ([d63f1f9e](https://github.com/ozone-development/ozp-rest/commit/d63f1f9ebf684d8a333e6607e7bf3a27d5429e4a))
  * the queryString param is not appearing in the self link for a search result ([389c4923](https://github.com/ozone-development/ozp-rest/commit/389c4923a22d2f22e1b05663bc2a107a1a2c03bf))
* **Search API:** filtering by category uses the wrong query param ([14466cc9](https://github.com/ozone-development/ozp-rest/commit/14466cc9fb0b521dcf9a83be23d5ab5ebbdf1063))
* **Search Ids:** OZF-551 Upgrading elasticsearch plugin ([0bc76175](https://github.com/ozone-development/ozp-rest/commit/0bc7617519d4dede4812a2e935db3b45ae9b7563))
* **Tags:** Fixing Tag length validation ([c0c6b095](https://github.com/ozone-development/ozp-rest/commit/c0c6b095d57a4a11c78e143d26009da781d44856))
* **sample data:** add loadSampleData script for convenience ([8ca4b879](https://github.com/ozone-development/ozp-rest/commit/8ca4b87949e8439ead4aa113730caaf8e7d718de))


#### Features

* **Agency API:** Adding shortname to agency ([5e60ab72](https://github.com/ozone-development/ozp-rest/commit/5e60ab72d5acfa290dc76c60c03f481390a52540))
* **ChildObjectCollection:** Removing now-redundant classes StewardedOrganizations and ApplicationLibrary ([267d4be7](https://github.com/ozone-development/ozp-rest/commit/267d4be7a94d0a50081c58038a80890c7f58ec86))
* **Draft Listing:** OZF-416 OZF-417 Validation of non-draft-required fields ([e9d21030](https://github.com/ozone-development/ozp-rest/commit/e9d210306860ab4e19a7f7caba954d6a71145c94))
* **Draft Listings:** OZF-170 ([ba735749](https://github.com/ozone-development/ozp-rest/commit/ba735749aaebaff8496d22dfa9311d680435830e))
* **Error messages:** Improve Error messages being returned to client from Rest services ([7b9b1c34](https://github.com/ozone-development/ozp-rest/commit/7b9b1c34db3d290d0ffea31e2b4c7ffd77898c02))
* **Featured:**
  * OZF-631 Add access controls for featured flag ([9d9d7765](https://github.com/ozone-development/ozp-rest/commit/9d9d77655ecef775ede2ce37a99b396215a8e567))
  * Add featured-flag changes the Modified changelog entries ([28268c20](https://github.com/ozone-development/ozp-rest/commit/28268c202dcb2181d371eadf06b159bfc009e1af))
  * OZF-631 OZF-628 isFeatured backend access controls ([4bfb75ba](https://github.com/ozone-development/ozp-rest/commit/4bfb75ba2f6e5fb847dfdedcd5138f9b8e788dab))
* **HAL:**
  * Listing representations from search queries should be in HAL format ([f1b6e8db](https://github.com/ozone-development/ozp-rest/commit/f1b6e8dbac5872f9ef827014c49ae95bab4753dd))
  * Contact Type HAL ([58b318f3](https://github.com/ozone-development/ozp-rest/commit/58b318f3d32a70672c8d58cce7b7fb83e70be073))
  * Agency HAL reps ([a8854293](https://github.com/ozone-development/ozp-rest/commit/a88542936719eceeb2f3cdef7c78fdbb109c90d4))
  * Intents Collection HAL ([8d5f9720](https://github.com/ozone-development/ozp-rest/commit/8d5f9720edcf5524ed758fccf600094e997cc095))
  * Converting Type to HAL ([16fcc1d1](https://github.com/ozone-development/ozp-rest/commit/16fcc1d10ddb61287d3b867a4dbfe31898db793b))
  * fixing Category content-type ([eaf0eed4](https://github.com/ozone-development/ozp-rest/commit/eaf0eed4307be12816369306c52c4805ba3f1254))
  * Completing Category HAL transition ([38cdf7c9](https://github.com/ozone-development/ozp-rest/commit/38cdf7c9690eb61c3c727b579e852426ac0b03c2))
  * Category reps for HAL ([3960376d](https://github.com/ozone-development/ozp-rest/commit/3960376d58ef84ba4359eb1ecdcb5e28aa36649e))
  * RejectionListing HAL ([9c23f37e](https://github.com/ozone-development/ozp-rest/commit/9c23f37ef197e6e2370c2c161eeed0e63d8b6362))
* **Listing:** Adding singleton, height && width properties to Listing ([6cfb32f6](https://github.com/ozone-development/ozp-rest/commit/6cfb32f666c538bd730b71f11515be59566d6601))
* **Listing Activity:** Paging support for listing activity representation ([09e0649d](https://github.com/ozone-development/ozp-rest/commit/09e0649d1ae0be5004ed86e805b283f1692232df))
* **Listing Admin:**
  * OZF-464 Parameterized Listing Admin REST call ([99fd3cab](https://github.com/ozone-development/ozp-rest/commit/99fd3cab8858aa4c1e6ad6d3e779b726045d1cb9))
  * Adding zero entries for empty agency counts ([47d3b45a](https://github.com/ozone-development/ozp-rest/commit/47d3b45a7eb6c7196aa5604b3b71918804a085c5))
  * Fixing counts for org stewards ([67a52e04](https://github.com/ozone-development/ozp-rest/commit/67a52e04db9dcf739828e461f21a843f36ce2e6f))
  * Fixing org steward detection ([7e8a0751](https://github.com/ozone-development/ozp-rest/commit/7e8a075129265d6336c12e3f3ce3d679ba498145))
  * Org Steward listing admin REST call ([73c5c8e6](https://github.com/ozone-development/ozp-rest/commit/73c5c8e679c54ca2059b09a2fc4efc13adcb7d79))
  * Fix count when using approvalStatus parameter ([d895ac2e](https://github.com/ozone-development/ozp-rest/commit/d895ac2e3fea28701522c02e6d6cae96d8cd7734))
  * Adding query params to HAL URIs ([e660af83](https://github.com/ozone-development/ozp-rest/commit/e660af83201fe263fc4878e6cd6ffd49b62aa340))
  * Listing counts ([c4b01d78](https://github.com/ozone-development/ozp-rest/commit/c4b01d7885331796b4d9efa66e572a928c9cc6cc))
  * Add basic REST call to get all by parameters ([b24561a1](https://github.com/ozone-development/ozp-rest/commit/b24561a1c7bb918a472ca7921bfa05b90400f8f5))
* **OZF-268 Approval:** Removing old RejectionJustification class ([ce8fce0b](https://github.com/ozone-development/ozp-rest/commit/ce8fce0b4807266c3e714a2abf00bb0d51ec084c))
* **Profile API:** sort by display name ([88e1b7a4](https://github.com/ozone-development/ozp-rest/commit/88e1b7a4b13df37308365632d53d9575614745dd))
* **Required Listings:**
  * OZF-564 Add required listing info to changelog ([486e8866](https://github.com/ozone-development/ozp-rest/commit/486e8866d8d957c7efd2d887196270490eca0484))
  * OZF-308 Add required listings to ListingRepresentation ([d9a628f7](https://github.com/ozone-development/ozp-rest/commit/d9a628f742650e70d8b4fa39614c5c57b5d96afd))
  * Simplifying and restoring required listings functionality ([c3ce99e0](https://github.com/ozone-development/ozp-rest/commit/c3ce99e09db626b50043dd2f9efa742c37990c82))
* **Steward Approval:**
  * Correct permissions and flow for rejection ([e8b1711a](https://github.com/ozone-development/ozp-rest/commit/e8b1711a22517eb4004b8637747a3c40ed241c81))
  * Add steward users in dev mode ([eff436d0](https://github.com/ozone-development/ozp-rest/commit/eff436d02795ea7b831030782c9d3a013f0d79f0))
  * Add APPROVED_ORG ApprovalStatus and Action ([bb164e3c](https://github.com/ozone-development/ozp-rest/commit/bb164e3cf7b9dd06d2f0eafe18d24be224ee9762))


#### Breaking Changes

* error response structure is changed

To migrate the code follow the example below:

Before:

{
    error: true,
    message: ‘’,
    resolvedMessages: []
}

After:

{
    message: ‘’,
    errors: {
        ‘fieldName’: ‘error message’,
        ‘fieldName2’: [‘error message’, ‘error message 2 ’] // if
errors are more than 1
    }
}

 ([7b9b1c34](https://github.com/ozone-development/ozp-rest/commit/7b9b1c34db3d290d0ffea31e2b4c7ffd77898c02))
* The following fields must have non-empty values for
    listings which are not IN_PROGRESS.  400 errors will otherwise
    result.

    width
    height
    whatIsNew
    descriptionShort
    isFeatured
    description
    versionName
    requirements
    agency
    launchUrl
    categories
    imageSmallUrl
    imageMediumUrl
    imageLargeUrl
    imageXlargeUrl
    contacts
    screenshots

    This is is addition to fields required for all Listings
    (title and type)

 ([ba735749](https://github.com/ozone-development/ozp-rest/commit/ba735749aaebaff8496d22dfa9311d680435830e))


## 0.3.0 (2014-11-26)


#### Bug Fixes

* **Contacts:** OZF-492 Loosening rules for required Contact Types ([73339775](https://github.com/ozone-development/ozp-rest/commit/733397755de6f742d63427dcbc41ebeff72cf625))
* **Listing API:** OZF-534. Saving a listing fails when agency is null ([4f0d9e86](https://github.com/ozone-development/ozp-rest/commit/4f0d9e868a4afef8395e2664477765f60512722a))
* **Required Listings:**
  * OZF-563 Removing self from requiringListings response ([7f699230](https://github.com/ozone-development/ozp-rest/commit/7f699230fa7d1e69773fe18d0727d1b37c5eea36))
  * OZF-562 Fix delete of listing with required listings ([56fb89ea](https://github.com/ozone-development/ozp-rest/commit/56fb89eab176068bc563b83ac6d95652fd0902a4))


#### Features

* **Required Listings:**
  * OZF-564 Add required listing info to changelog ([486e8866](https://github.com/ozone-development/ozp-rest/commit/486e8866d8d957c7efd2d887196270490eca0484))
  * OZF-308 Add required listings to ListingRepresentation ([d9a628f7](https://github.com/ozone-development/ozp-rest/commit/d9a628f742650e70d8b4fa39614c5c57b5d96afd))
  * Simplifying and restoring required listings functionality ([c3ce99e0](https://github.com/ozone-development/ozp-rest/commit/c3ce99e09db626b50043dd2f9efa742c37990c82))


## 0.2.0 (2014-11-12)


#### Bug Fixes

* **Agency:**
  * OZF-373 Fixing access control for agency DELETE ([6a5ae1be](https://github.com/ozone-development/ozp-rest/commit/6a5ae1be7562b335d32b48161ebfb28f8ed92aea))
  * OZF-313 Proper error when agency deletion fails due to existing listings ([c7bf0b2b](https://github.com/ozone-development/ozp-rest/commit/c7bf0b2b5deaa086f8431088fc10cb5dd82943d1))
  * Fixing null icon ([f4384d88](https://github.com/ozone-development/ozp-rest/commit/f4384d880b217b0280275bbae1ceb0eca75e9be1))
  * Adding missing unique constraint ([80a2afa1](https://github.com/ozone-development/ozp-rest/commit/80a2afa15920622336da00da9a7c7241142633d8))
* **Agency and Intents:** Agency and Intents are not throwing validation errors with regards to uniqueness ([ccac9ea4](https://github.com/ozone-development/ozp-rest/commit/ccac9ea4927ceffe245a15282d2fe47fa9cd1d38))
* **Application Library:** fixing Application Library HAL representation ([90ddfc31](https://github.com/ozone-development/ozp-rest/commit/90ddfc312fb882b49c66867fff786e8bb79d52ac))
* **Auditing:** Corrected the way the audit trail looks up the current user ([e739be75](https://github.com/ozone-development/ozp-rest/commit/e739be7518d242c1d6dbeb0e1dcc2a6de396bbad))
* **Category:**
  * text for category delete fail was ambigious. ([17710cbc](https://github.com/ozone-development/ozp-rest/commit/17710cbc093bf539804c5cf9c4d5ba21224fb2e6))
  * Fixing CategoryResource constructor ([289840e4](https://github.com/ozone-development/ozp-rest/commit/289840e441e304830b2f696dcdab6bd85d0ae0c7))
* **Category API:** categories are not deleted if any listings are present in the system ([9d2036b3](https://github.com/ozone-development/ozp-rest/commit/9d2036b3a708a1a03309ac745213dade28dbf24e))
* **Draft Listings:**
  * Refining non-draft requirements ([bb7156af](https://github.com/ozone-development/ozp-rest/commit/bb7156af89ec4957b4e46f7a251c11115730deae))
  * OZF-436 Correcting non-draft required fields ([fbc42227](https://github.com/ozone-development/ozp-rest/commit/fbc42227887163d60e623cb451869c0edb7504ba))
  * Making width and height nullable ([74a01b18](https://github.com/ozone-development/ozp-rest/commit/74a01b18a1b29ba5f1972219b6bfcea36a6e1fac))
  * Removing docUrls from non-draft required fields ([f0a06df4](https://github.com/ozone-development/ozp-rest/commit/f0a06df4516754e86c3d4c21eb2f8f1f939322a1))
* **Error Status Codes:** certain types are returning a 500 status code when a unique constraint is violat ([08480b84](https://github.com/ozone-development/ozp-rest/commit/08480b84ee5dc64a851bdcb6fb753e5f97f41b08))
* **IWC Application API:** Adding icons to the application representation ([fb6cb246](https://github.com/ozone-development/ozp-rest/commit/fb6cb2466c823fb334558eb740bb20b41b1f7480))
* **IWC Data API:** fixing entity size and resource status codes ([b240be02](https://github.com/ozone-development/ozp-rest/commit/b240be027d827368bd95874c2c1db7ca0e02ab71))
* **Intents:** Trying to modify immutable properties now returns the proper status code and a m ([8427cc8f](https://github.com/ozone-development/ozp-rest/commit/8427cc8f392a74461484ef347ee67fc0f23dd4eb))
* **ItemComment:**
  * OZF-375 Adding missing ItemComment ListingActivity logic ([3393f1f7](https://github.com/ozone-development/ozp-rest/commit/3393f1f75e36897dc287bd6f5015a7e96e120bf8))
  * OZF-283 optional comment ratings ([2e8134df](https://github.com/ozone-development/ozp-rest/commit/2e8134df6b89af5385dd12b1eec3c52b58778fcd))
  * Fixing rate parse error handling ([18bbf59d](https://github.com/ozone-development/ozp-rest/commit/18bbf59d7013c601540d9d2783e7ca62578a8628))
* **IwcApiRepresentation:** Fixing MissingMethodExceptions ([459052ca](https://github.com/ozone-development/ozp-rest/commit/459052ca64977bca5cf37e427b8a9d9d35de76a9))
* **IwcUserApplicationsRepresentation:** Fixing spelling ([2cd23d17](https://github.com/ozone-development/ozp-rest/commit/2cd23d1751aa0fcff16bb4ec68a4ccedc996ab24))
* **Listing:**
  * singleton is missing from the Listing Representation ([b5149b2e](https://github.com/ozone-development/ozp-rest/commit/b5149b2e218cc3d2f6f879ee94120008beca40fd))
  * changing approvalStatus representation ([79003902](https://github.com/ozone-development/ozp-rest/commit/7900390259de3d2fa868b14d08a40d76f27e0f70))
* **Listing API:**
  * listing collections are returning 404 rather than a default representation when  ([db725dcc](https://github.com/ozone-development/ozp-rest/commit/db725dcca0babf08e3f6d82633e68a7329506b5b))
  * editedData is missing from the listing representation ([234ab6ff](https://github.com/ozone-development/ozp-rest/commit/234ab6ff112dae8b71ea8786565728ae48394e55))
  * fixing a compilation error in the Listing RepresentationWriter ([1a00c208](https://github.com/ozone-development/ozp-rest/commit/1a00c2081d32e600d4f7ba532ab9c12371e7cbbf))
  * when a child item in a collection is not valid, a 500 error is returned rather t ([c1a3db30](https://github.com/ozone-development/ozp-rest/commit/c1a3db30b46de31f23fe65fdd56aac9cb6858228))
  * required contact type constraint is not being enforced ([ced80992](https://github.com/ozone-development/ozp-rest/commit/ced809924c5b55e33ea97598fd84f5a160786c6f))
* **Listing Activity:**
  * adding author as a property to Listing Activity Representation ([78f1effc](https://github.com/ozone-development/ozp-rest/commit/78f1effcd47ead8a73f1faf5b662a6f3f5b4802d))
  * OZF-379 Fixing Profile Listing Activity representations ([7b655b88](https://github.com/ozone-development/ozp-rest/commit/7b655b88c1683b7d91b487e5ea32830332726a9a))
  * OZF-374 Adding needed fields for Rejection Activities ([a85051d3](https://github.com/ozone-development/ozp-rest/commit/a85051d3100e89f4fa6d328c20bd6c311b469c2a))
* **Listing Activity Representation:** Adding missing HAL classes for ListingActivity ([678a2ed3](https://github.com/ozone-development/ozp-rest/commit/678a2ed336d0f5f18da5dc357b0f92a74602b3a7))
* **Profile:**
  * the user's highest role should be part of the Profile Representation ([2794b916](https://github.com/ozone-development/ozp-rest/commit/2794b9162a1e58d4e1cc1d0d2f1ef4ca0cf7a21f))
  * OZF-376 Adding id to ProfileRepresentation ([3cd9763b](https://github.com/ozone-development/ozp-rest/commit/3cd9763b707d8e0348d47b989c604b19f02c5a1b))
* **Profile Representation:** OZF-354 allowing ProfileRepresentation for application/json ([00395ac6](https://github.com/ozone-development/ozp-rest/commit/00395ac661ba0b6ae6854343ede0d5f46456016b))
* **REST:**
  * add uuid to /profile/self/library ([59dcc700](https://github.com/ozone-development/ozp-rest/commit/59dcc700d3d66ac5bb057ed7f90beb9353c2f54b))
  * fix runtime error in /profile/self/listing ([ca4acb01](https://github.com/ozone-development/ozp-rest/commit/ca4acb0133fd2a5c5ab83faec9262ed82b6b2951))
  * OZF-377 Removing Content-Type restrictions from DELETE methods ([0b34fddf](https://github.com/ozone-development/ozp-rest/commit/0b34fddf2b195d9978f1495e4133ca3aeffbd8ee))
* **Rejection:** OZF-300 Correcting auth error ([84e70c62](https://github.com/ozone-development/ozp-rest/commit/84e70c62b55ba6f9a30ec81fed772eeecedcbca5))
* **RestService:** Properties of domain classes that are collections are not updating properly ([7d925596](https://github.com/ozone-development/ozp-rest/commit/7d92559607bd6454d16fb4129e669536aa151704))
* **Sample data:** adding the data directory ([7d51378e](https://github.com/ozone-development/ozp-rest/commit/7d51378e10d0ef25b7aeaeb4138cb54b62d3449a))
* **Search:**
  * Adding secondary and tertiary sort order ([08936eed](https://github.com/ozone-development/ozp-rest/commit/08936eeda054451ca808a0d2b889c76be950708a))
  * Approval status of search results is always being reported as IN_PROGRESS ([4c97a0de](https://github.com/ozone-development/ozp-rest/commit/4c97a0deab06e55df6155b099bdc126e765e1ad3))
  * Fixing search in reference to UriBuilder refactor ([d63f1f9e](https://github.com/ozone-development/ozp-rest/commit/d63f1f9ebf684d8a333e6607e7bf3a27d5429e4a))
  * the queryString param is not appearing in the self link for a search result ([389c4923](https://github.com/ozone-development/ozp-rest/commit/389c4923a22d2f22e1b05663bc2a107a1a2c03bf))
* **Search API:** filtering by category uses the wrong query param ([14466cc9](https://github.com/ozone-development/ozp-rest/commit/14466cc9fb0b521dcf9a83be23d5ab5ebbdf1063))
* **Tags:** Fixing Tag length validation ([c0c6b095](https://github.com/ozone-development/ozp-rest/commit/c0c6b095d57a4a11c78e143d26009da781d44856))
* **Sample Data:** add loadSampleData script for convenience ([8ca4b879](https://github.com/ozone-development/ozp-rest/commit/8ca4b87949e8439ead4aa113730caaf8e7d718de))


#### Features

* **Agency API:** Adding shortname to agency ([5e60ab72](https://github.com/ozone-development/ozp-rest/commit/5e60ab72d5acfa290dc76c60c03f481390a52540))
* **ChildObjectCollection:** Removing now-redundant classes StewardedOrganizations and ApplicationLibrary ([267d4be7](https://github.com/ozone-development/ozp-rest/commit/267d4be7a94d0a50081c58038a80890c7f58ec86))
* **Draft Listing:** OZF-416 OZF-417 Validation of non-draft-required fields ([e9d21030](https://github.com/ozone-development/ozp-rest/commit/e9d210306860ab4e19a7f7caba954d6a71145c94))
* **Draft Listings:** OZF-170 ([ba735749](https://github.com/ozone-development/ozp-rest/commit/ba735749aaebaff8496d22dfa9311d680435830e))
* **Error messages:** Improve Error messages being returned to client from Rest services ([7b9b1c34](https://github.com/ozone-development/ozp-rest/commit/7b9b1c34db3d290d0ffea31e2b4c7ffd77898c02))
* **HAL:**
  * Listing representations from search queries should be in HAL format ([f1b6e8db](https://github.com/ozone-development/ozp-rest/commit/f1b6e8dbac5872f9ef827014c49ae95bab4753dd))
  * Contact Type HAL ([58b318f3](https://github.com/ozone-development/ozp-rest/commit/58b318f3d32a70672c8d58cce7b7fb83e70be073))
  * Agency HAL reps ([a8854293](https://github.com/ozone-development/ozp-rest/commit/a88542936719eceeb2f3cdef7c78fdbb109c90d4))
  * Intents Collection HAL ([8d5f9720](https://github.com/ozone-development/ozp-rest/commit/8d5f9720edcf5524ed758fccf600094e997cc095))
  * Converting Type to HAL ([16fcc1d1](https://github.com/ozone-development/ozp-rest/commit/16fcc1d10ddb61287d3b867a4dbfe31898db793b))
  * fixing Category content-type ([eaf0eed4](https://github.com/ozone-development/ozp-rest/commit/eaf0eed4307be12816369306c52c4805ba3f1254))
  * Completing Category HAL transition ([38cdf7c9](https://github.com/ozone-development/ozp-rest/commit/38cdf7c9690eb61c3c727b579e852426ac0b03c2))
  * Category reps for HAL ([3960376d](https://github.com/ozone-development/ozp-rest/commit/3960376d58ef84ba4359eb1ecdcb5e28aa36649e))
  * RejectionListing HAL ([9c23f37e](https://github.com/ozone-development/ozp-rest/commit/9c23f37ef197e6e2370c2c161eeed0e63d8b6362))
* **Listing:** Adding singleton, height && width properties to Listing ([6cfb32f6](https://github.com/ozone-development/ozp-rest/commit/6cfb32f666c538bd730b71f11515be59566d6601))
* **Listing Activity:** Paging support for listing activity representation ([09e0649d](https://github.com/ozone-development/ozp-rest/commit/09e0649d1ae0be5004ed86e805b283f1692232df))
* **OZF-268 Approval:** Removing old RejectionJustification class ([ce8fce0b](https://github.com/ozone-development/ozp-rest/commit/ce8fce0b4807266c3e714a2abf00bb0d51ec084c))
* **Profile API:** sort by display name ([88e1b7a4](https://github.com/ozone-development/ozp-rest/commit/88e1b7a4b13df37308365632d53d9575614745dd))


#### Breaking Changes

* error response structure is changed

    To migrate the code follow the example below:

    Before:

    ```js
    {
        error: true,
        message: ‘’,
        resolvedMessages: []
    }
    ```

    After:

    ```js
    {
        message: ‘’,
        errors: {
            ‘fieldName’: ‘error message’,
            ‘fieldName2’: [‘error message’, ‘error message 2 ’] // if errors are more than 1
        }
    }
    ```

 ([7b9b1c34](https://github.com/ozone-development/ozp-rest/commit/7b9b1c34db3d290d0ffea31e2b4c7ffd77898c02))
* The following fields must have non-empty values for
    listings which are not IN_PROGRESS.  400 errors will otherwise
    result.

    width
    height
    whatIsNew
    descriptionShort
    isFeatured
    description
    versionName
    requirements
    agency
    launchUrl
    categories
    imageSmallUrl
    imageMediumUrl
    imageLargeUrl
    imageXlargeUrl
    contacts
    screenshots

    This is is addition to fields required for all Listings
    (title and type)

 ([ba735749](https://github.com/ozone-development/ozp-rest/commit/ba735749aaebaff8496d22dfa9311d680435830e))


