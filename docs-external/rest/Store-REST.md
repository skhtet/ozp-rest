FORMAT: 1A

# OZP Marketplace NextGen REST Documentation

# Group API

## API [/api]

### Retrieve application metadata such as name, version, build date and build number [GET]

+ Response 200 (application/json)
    + Content-Type:application/json;charset=utf-8

    + Body

            {"name":"Marketplace","version":"7.5.0","buildNumber":"1","buildDate":"2013-11-20T05:00:00Z"}


# Group Tag

## Tags [/api/tag{?max,offset}]

### Returns all of the Tag objects in the system [GET]
+ Parameters
    + max (optional, number) ... The maximum number of Tags to return
    + offset (optional, number) ... The offset into the full list of Tags to start at

+ Response 200
    + Content-Type:application/json;charset=utf-8

    + Body

            [
                {
                    "id": 1,
                    "title": "MAP",
                    "itemCount": 2
                },
                {
                    "id": 2,
                    "title": "BOOK",
                    "itemCount": 5
                }
            ]

## Tag [/api/tag/{tagId}]

### Removes the Tag from all service items and deletes the tag if executed by admin or owner [DELETE]
+ Response 204


# Group Agency

## Agencies [/api/agency]

### Retrieves all Agencies in the system [GET]


+ Response 200
    + Headers

            Content-Type:application/json;charset=utf-8

    + Body

            [{ "id": 0, "createdBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "editedBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "iconUrl": "https:///", "title": "test company 14", "editedDate": "2013-11-14T17:32:15Z", "createdDate": "2013-11-14T17:32:15Z" }]

### Creates a new Agency. Only administrators may access this URL. [POST]


+ Request
    + Body

            {"title": "Agency Name", "https://localhost/icon.png"}

+ Response 201
    + Headers

            Content-Type:application/json;charset=utf-8
            Location: https://localhost:8443/marketplace/api/agency/0

    + Body

            { "id": 0, "createdBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "editedBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "iconUrl": "https:///", "title": "test agency 14", "editedDate": "2013-11-14T17:32:15Z", "createdDate": "2013-11-14T17:32:15Z" }


## Agency [/api/agency/{id}]

### Retrieves a specific Agency by id [GET]


+ Response 200
    + Headers

            Content-Type:application/json;charset=utf-8

    + Body

            { "id": 0, "createdBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "editedBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "iconUrl": "https:///", "title": "test agency 14", "editedDate": "2013-11-14T17:32:15Z", "createdDate": "2013-11-14T17:32:15Z" }

### The id in the request body and the id in the URL must match. Only administrators may access this URL. Updates an agency [PUT]


+ Request
    + Body

            {id: 1, "title": "Agency Name", "https://localhost/icon.png"}

+ Response 201
    + Headers

            Content-Type:application/json;charset=utf-8

    + Body

            { "id": 0, "createdBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "editedBy": { "id": 3, "username": "testAdmin1", "name": "Test Admin 1" }, "iconUrl": "https:///", "title": "test agency 14", "editedDate": "2013-11-14T17:32:15Z", "createdDate": "2013-11-14T17:32:15Z" }

### Delete an Agency from the system. Only administrators may access this URL. Delete an Agency from the system [DELETE]

+ Response 204

# Group ServiceItem

The JSON representation of a ServiceItem has many properties as shown in the GET Model.

The Following properties are read-only.  For PUT and POST requests these values do not need to be included
- totalRate5
- totalRate4
- totalRate3
- totalRate2
- totalRate1
- avgRate
- satifiedScoreCardItems
- uuid
- totalComments
- validLaunchUrl
- lastActivity
- totalVotes
- isPublished
- approvedDate
- ozoneAware

The following properties are references, meaning that for PUT and POST requests, only the
id property of the subobject is considered, and that id is used to reference an existing
object
- owners
- state
- types
- customFields[\*].customFieldDefinition
- agency
- categories
- intents[\*].intentDataType
- intents[\*].intentAction
- relationships[\*].relatedItems
- contacts[\*].type

The following properties are deprecated and only exist for backwards compatibility.
Most of them give information that is already available elsewhere in the JSON
- ozoneAware (available on the type)
- validLaunchUrl

Modifying the following properties will have additional effects as specified
- isEnabled - When changed, creates an extra ServiceItemActivity.
- isOutside - When changed, creates an extra ServiceItemActivity. May start as null, but once
    set to true or false, can never be null again.  Must be true or false for approval to succeed
- relationships - When relatedItems are added or removed, additional ServiceItemActivities are
    generated on both this ServiceItem and the related one

The following enum-based properties have the following valid values
- recommendedLayouts must be a list containing zero or more of the following strings: "DESKTOP", "ACCORDION", "TABBED", and "PORTAL"
- relationships.relationshipType must be "REQUIRE"

## ServiceItem [/api/serviceItem/{id}]

+ Parameters
    + id (number) ... The id of the ServiceItem to retrieve

+ Model (application/json)

    The JSON model of a ServiceItem

    + Body

            {
                "totalRate5": 0,
                "totalRate4": 0,
                "ozoneAware": true,
                "contacts": [{
                    "id": 0,
                    "organization": null,
                    "email": "test@example.org",
                    "name": "Test Contact",
                    "unsecurePhone": "555-555-5555",
                    "securePhone": "555-5555",
                    "type": {
                        "id": 0,
                        "title": "Sponsor",
                        "required": false
                    }
                }],
                "avgRate": 0,
                "totalRate2": 0,
                "totalRate3": 0,
                "description": "Test Description",
                "screenshots": [{
                    "id": 69,
                    "largeImageUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "ordinal": 0,
                    "smallImageUrl": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "approvalStatus": "Approved",
                "totalRate1": 0,
                "techPocs": ["tpou"],
                "class": "marketplace.ServiceItem",
                "satisfiedScoreCardItems": [],
                "versionName": "3",
                "isEnabled": true,
                "installUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "isOutside": false,
                "uuid": "e4fc6bf0-96f9-47b5-a913-f98120a9481e",
                "owners": [{
                    "id": 26,
                    "username": "testUser",
                    "name": "Test User"
                }],
                "imageLargeUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "opensInNewBrowserTab": false,
                "totalComments": 0,
                "launchUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "validLaunchUrl": true,
                "requirements": null,
                "id": 5,
                "title": "Book Lock",
                "lastActivity": {
                    "activityDate": "2014-02-19T17:09:05Z"
                },
                "organization": "Org 1",
                "releaseDate": "2012-06-09",
                "dependencies": null,
                "totalVotes": 0,
                "types": {
                    "id": 2,
                    "title": "App Component",
                    "description": "app component"
                },
                "relationships": [{
                    "relationshipType": "REQUIRE",
                    "relatedItems": [{
                        "id": 3,
                        "title": "Collaboration Buddy",
                        "imageSmallUrl": "https://www.owfgoss.org/demodata/chat-icon.png"
                    }]
                }],
                "docUrls": [{
                    "name": "https://www.owfgoss.org/demodata/Favorites.png",
                    "url": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "isPublished": true,
                "agency": {
                    "id": 1,
                    "title": "Some organization",
                    "iconUrl": "https://www.owfgoss.org/demodata/agency1.png"
                },
                "approvedDate": "2014-02-18T22:16:55Z",
                "intents": [{
                    "id": 13,
                    "dataType": {
                        "id": 1,
                        "title": "audio"
                    },
                    "send": true,
                    "action": {
                        "id": 2,
                        "title": "edit"
                    },
                    "receive": false
                }],
                "categories": [{
                    "id": 1,
                    "title": "Analytics and Analysis"
                }, {
                    "id": 14,
                    "title": "Geospatial Solutions"
                }, {
                    "id": 19,
                    "title": "Search"
                }],
                "imageSmallUrl": "https://www.owfgoss.org/demodata/Favorites.png"
            }

### Retrieves a single ServiceItem by ID [GET]
+ Response 200
    [ServiceItem][]

### Updates an existing ServiceItem by ID. The ID in the URL must match the ID in the JSON [PUT]
+ Request
    [ServiceItem][]
+ Response 200
    [ServiceItem][]

### Delete the ServiceItem [DELETE]
+ Response 204


## ServiceItems [/api/serviceItem{?max,offset}]

+ Model (application/json)
    + Body

            {
                "total": 1,
                "data": [{
                    "totalRate5": 0,
                    "totalRate4": 0,
                    "ozoneAware": true,
                    "contacts": [{
                        "id": 0,
                        "organization": null,
                        "email": "test@example.org",
                        "name": "Test Contact",
                        "unsecurePhone": "555-555-5555",
                        "securePhone": "555-5555",
                        "type": {
                            "id": 0,
                            "title": "Sponsor",
                            "required": false
                        }
                    }],
                    "avgRate": 0,
                    "totalRate2": 0,
                    "totalRate3": 0,
                    "description": "Test Description",
                    "screenshots": [{
                        "id": 69,
                        "largeImageUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                        "ordinal": 0,
                        "smallImageUrl": "https://www.owfgoss.org/demodata/Favorites.png"
                    }],
                    "approvalStatus": "Approved",
                    "totalRate1": 0,
                    "techPocs": ["tpou"],
                    "class": "marketplace.ServiceItem",
                    "satisfiedScoreCardItems": [],
                    "versionName": "3",
                    "isEnabled": true,
                    "installUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "isOutside": false,
                    "uuid": "e4fc6bf0-96f9-47b5-a913-f98120a9481e",
                    "owners": [{
                        "id": 26,
                        "username": "testUser",
                        "name": "Test User"
                    }],
                    "imageLargeUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "opensInNewBrowserTab": false,
                    "totalComments": 0,
                    "launchUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "validLaunchUrl": true,
                    "requirements": null,
                    "id": 5,
                    "title": "Book Lock",
                    "lastActivity": {
                        "activityDate": "2014-02-19T17:09:05Z"
                    },
                    "organization": "Org 1",
                    "releaseDate": "2012-06-09",
                    "dependencies": null,
                    "totalVotes": 0,
                    "types": {
                        "id": 2,
                        "title": "App Component",
                        "description": "app component"
                    },
                    "relationships": [{
                        "relationshipType": "REQUIRE",
                        "relatedItems": [{
                            "id": 3,
                            "title": "Collaboration Buddy",
                            "imageSmallUrl": "https://www.owfgoss.org/demodata/chat-icon.png"
                        }]
                    }],
                    "docUrls": [{
                        "name": "https://www.owfgoss.org/demodata/Favorites.png",
                        "url": "https://www.owfgoss.org/demodata/Favorites.png"
                    }],
                    "isPublished": true,
                    "agency": {
                        "id": 1,
                        "title": "Some organization",
                        "iconUrl": "https://www.owfgoss.org/demodata/agency1.png"
                    },
                    "approvedDate": "2014-02-18T22:16:55Z",
                    "intents": [{
                        "id": 13,
                        "dataType": {
                            "id": 1,
                            "title": "audio"
                        },
                        "send": true,
                        "action": {
                            "id": 2,
                            "title": "edit"
                        },
                        "receive": false
                    }],
                    "categories": [{
                        "id": 1,
                        "title": "Analytics and Analysis"
                    }, {
                        "id": 14,
                        "title": "Geospatial Solutions"
                    }, {
                        "id": 19,
                        "title": "Search"
                    }],
                    "imageSmallUrl": "https://www.owfgoss.org/demodata/Favorites.png"
                }]
            }

### Retrieve all ServiceItems, with optional paging [GET]
+ Parameters
    + max (optional, number) ... The maximum number of ServiceItems to return
    + offset (optional, number) ... The offset into the full list of ServiceItems to start at

+ Response 200
    [ServiceItems][]

### Create a new ServiceItem [POST]
+ Request
    [ServiceItem][]
+ Response 201
    [ServiceItem][]

## ServiceItemActivity [/api/serviceItem/{serviceItemId}/activity{?offset,max}]

+ Parameters
    + serviceItemId (number) ... The ID of the serviceItem whose activities are being retrieved
    + max (optional, number) ... The maximum number of ServiceItemsActivities to return
    + offset (optional, number) ... The offset into the full list of ServiceItemsActivities to start at

+ Model (application/json)
    + Body

            {
                "total": 10,
                "data": {
                    "author": {
                        "id": 2,
                        "username": "testAdmin1",
                        "name": "Test Administrator 1"
                    },
                    "activityDate": "2014-01-17T15:48:24Z",
                    "action": {
                        "description": "Outside",
                        "name": "OUTSIDE"
                    },
                    "changeDetails": [],
                    "serviceItem": {
                        "id": 2,
                        "title": "Agency Test User 2",
                        "imageSmallUrl": "http://localhost/icons/Comics.png"
                    }
            }

### Retrieve all ServiceItemActivities for a ServiceItem [GET]
+ Response 200
    [ServiceItemActivity][]

## ServiceItemActivityGlobal [/api/serviceItem/activity{?offset,max}]

+ Parameters
    + max (optional, number) ... The maximum number of ServiceItemsActivities to return
    + offset (optional, number) ... The offset into the full list of ServiceItemsActivities to start at

### Retrieve all ServiceItemActivities [GET]
+ Response 200
    [ServiceItemActivity][]

## RejectionListing [/api/serviceItem/{serviceItemId}/rejectionListing]

+ Parameters
    + serviceItemId (number) ... The ID of the serviceItem being rejected

+ Model
    + Body

            {
                "id": 2,
                "author": {
                    "id": 2,
                    "username": "testAdmin1",
                    "name": "Test Administrator 1"
                },
                "createdBy": {
                    "id": 2,
                    "username": "testAdmin1",
                    "name": "Test Administrator 1"
                },
                "editedBy": {
                    "id": 2,
                    "username": "testAdmin1",
                    "name": "Test Administrator 1"
                },
                "description": "This listing is terrible",
                "editedDate": "2014-03-09T04:33:05Z",
                "justification": {
                    "id": 3,
                    "title": "Data Content",
                    "description": "Data Content"
                },
                "createdDate": "2014-03-09T04:33:05Z"
            }

### Reject a ServiceItem. This create a RejectionListing and sets the ServiceItem's approvalStatus to Rejected. [POST]
+ Request
    [RejectionListing][]

+ Response 201
    [RejectionListing][]

### Get rejection justification for a ServiceItem. [GET]

+ Response 201
    [RejectionListing][]

## RequiredListings [/api/serviceItem/{serviceItemId}/requiredServiceItems]
+ Parameters
    + serviceItemId (number) ... The ID of the serviceItem whose requirements are being fetched

+ Model (application/json)
    A simple list of ServiceItems that are required by this ServiceItem
    + Body

            [{
                "totalRate5": 0,
                "totalRate4": 0,
                "ozoneAware": true,
                "contacts": [{
                    "id": 0,
                    "organization": null,
                    "email": "test@example.org",
                    "name": "Test Contact",
                    "unsecurePhone": "555-555-5555",
                    "securePhone": "555-5555",
                    "type": {
                        "id": 0,
                        "title": "Sponsor",
                        "required": false
                    }
                }],
                "avgRate": 0,
                "totalRate2": 0,
                "totalRate3": 0,
                "description": "Test Description",
                "screenshots": [{
                    "id": 69,
                    "largeImageUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "ordinal": 0,
                    "smallImageUrl": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "approvalStatus": "Approved",
                "totalRate1": 0,
                "techPocs": ["tpou"],
                "class": "marketplace.ServiceItem",
                "satisfiedScoreCardItems": [],
                "versionName": "3",
                "isEnabled": true,
                "installUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "isOutside": false,
                "uuid": "e4fc6bf0-96f9-47b5-a913-f98120a9481e",
                "owners": [{
                    "id": 26,
                    "username": "testUser",
                    "name": "Test User"
                }],
                "imageLargeUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "opensInNewBrowserTab": false,
                "totalComments": 0,
                "launchUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "validLaunchUrl": true,
                "requirements": null,
                "id": 5,
                "title": "Book Lock",
                "lastActivity": {
                    "activityDate": "2014-02-19T17:09:05Z"
                },
                "organization": "Org 1",
                "releaseDate": "2012-06-09",
                "dependencies": null,
                "totalVotes": 0,
                "types": {
                    "id": 2,
                    "title": "App Component",
                    "description": "app component"
                },
                "relationships": [{
                    "relationshipType": "REQUIRE",
                    "relatedItems": [{
                        "id": 3,
                        "title": "Collaboration Buddy",
                        "imageSmallUrl": "https://www.owfgoss.org/demodata/chat-icon.png"
                    }]
                }],
                "docUrls": [{
                    "name": "https://www.owfgoss.org/demodata/Favorites.png",
                    "url": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "isPublished": true,
                "agency": {
                    "id": 1,
                    "title": "Some organization",
                    "iconUrl": "https://www.owfgoss.org/demodata/agency1.png"
                },
                "approvedDate": "2014-02-18T22:16:55Z",
                "intents": [{
                    "id": 13,
                    "dataType": {
                        "id": 1,
                        "title": "audio"
                    },
                    "send": true,
                    "action": {
                        "id": 2,
                        "title": "edit"
                    },
                    "receive": false
                }],
                "categories": [{
                    "id": 1,
                    "title": "Analytics and Analysis",
                }, {
                    "id": 14,
                    "title": "Geospatial Solutions"
                }, {
                    "id": 19,
                    "title": "Search"
                }],
                "imageSmallUrl": "https://www.owfgoss.org/demodata/Favorites.png"
            }]

### Retrieve a list of all ServiceItems that are required by this ServiceItem. If the Referer header indicates that this call is from a foreign system, "Inside" ServiceItems will be filtered from the results.  This call supports JSONP [GET]
+ Response 200
    [RequiredListings][]


## RequiringListings [/api/serviceItem/{serviceItemId}/requiringServiceItems]
+ Parameters
    + serviceItemId (number) ... The ID of the serviceItem whose requiring listings are being fetched.

+ Model (application/json)
    A simple list of ServiceItems that directly require this ServiceItem
    + Body

            [{
                "totalRate5": 0,
                "totalRate4": 0,
                "ozoneAware": true,
                "contacts": [{
                    "id": 0,
                    "organization": null,
                    "email": "test@example.org",
                    "name": "Test Contact",
                    "unsecurePhone": "555-555-5555",
                    "securePhone": "555-5555",
                    "type": {
                        "id": 0,
                        "title": "Sponsor",
                        "required": false
                    }
                }],
                "avgRate": 0,
                "totalRate2": 0,
                "totalRate3": 0,
                "description": "Test Description",
                "screenshots": [{
                    "id": 69,
                    "largeImageUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                    "ordinal": 0,
                    "smallImageUrl": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "approvalStatus": "Approved",
                "totalRate1": 0,
                "techPocs": ["tpou"],
                "class": "marketplace.ServiceItem",
                "satisfiedScoreCardItems": [],
                "versionName": "3",
                "isEnabled": true,
                "installUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "isOutside": false,
                "uuid": "e4fc6bf0-96f9-47b5-a913-f98120a9481e",
                "owners": [{
                    "id": 26,
                    "username": "testUser",
                    "name": "Test User"
                }],
                "imageLargeUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "opensInNewBrowserTab": false,
                "totalComments": 0,
                "launchUrl": "https://www.owfgoss.org/demodata/Favorites.png",
                "validLaunchUrl": true,
                "requirements": null,
                "id": 5,
                "title": "Book Lock",
                "lastActivity": {
                    "activityDate": "2014-02-19T17:09:05Z"
                },
                "organization": "Org 1",
                "releaseDate": "2012-06-09",
                "dependencies": null,
                "totalVotes": 0,
                "types": {
                    "id": 2,
                    "title": "App Component",
                    "description": "app component",
                    "hasLaunchUrl": true,
                    "hasIcons": true,
                    "uuid": "9d541c50-60a7-4d5b-bf7f-7b63d330bfb1",
                    "ozoneAware": true,
                    "isPermanent": true
                },
                "relationships": [{
                    "relationshipType": "REQUIRE",
                    "relatedItems": [{
                        "id": 3,
                        "title": "Collaboration Buddy",
                        "imageSmallUrl": "https://www.owfgoss.org/demodata/chat-icon.png"
                    }]
                }],
                "docUrls": [{
                    "name": "https://www.owfgoss.org/demodata/Favorites.png",
                    "url": "https://www.owfgoss.org/demodata/Favorites.png"
                }],
                "isPublished": true,
                "agency": {
                    "id": 1,
                    "title": "Some organization",
                    "iconUrl": "https://www.owfgoss.org/demodata/agency1.png"
                },
                "approvedDate": "2014-02-18T22:16:55Z",
                "intents": [{
                    "id": 13,
                    "dataType": {
                        "id": 1,
                        "title": "audio",
                        "uuid": "ec31f696-7a20-423d-b36c-e85d6f0ae55c"
                    },
                    "send": true,
                    "action": {
                        "id": 2,
                        "title": "edit",
                        "uuid": "7620ad4c-3103-4c0c-9e50-c6772c015655"
                    },
                    "receive": false
                }],
                "categories": [{
                    "id": 1,
                    "title": "Analytics and Analysis",
                    "uuid": "a7a63e35-a811-46d2-8769-f9409841150f"
                }, {
                    "id": 14,
                    "title": "Geospatial Solutions",
                    "uuid": "2156a18a-b99c-4271-8f0b-2542de887ff8"
                }, {
                    "id": 19,
                    "title": "Search",
                    "uuid": "84ff9f28-28da-485f-b55e-875d52c194fd"
                }],
                "imageSmallUrl": "https://www.owfgoss.org/demodata/Favorites.png"
            }]

### Retrieve a list of ServiceItems which directly require this ServiceItem.  Note that this is unlike the requiredServiceItems called, which checks indirect relationships, aka. transitive dependencies, as well. If the Referer header indicates that this call is from a foreign system, "Inside" ServiceItems will be filtered from the results.  This call supports JSONP [GET]
+ Response 200
    [RequiredListings][]

## optional_title [/api/serviceItem/{serviceItemId}/tag/]

### Retrieve tags for this ServiceItem [GET]

+ Response 200
    + Content-Type:application/json;charset=utf-8

    + Body

            [
                {
                    "id": 1,
                    "createdBy": {
                        "id": 2,
                        "username": "testAdmin1"
                    },
                    "tag": {
                        "id": 1,
                        "title": "MAP"
                    }
                }
            ]


## optional_title [/api/serviceItem/{serviceItemId}/tag]

### Create a tag or tags for this ServiceItem [POST]

+ Request
    + Body

            [{"serviceItemId":5,"title":"tag1","createdBy":{"id":2}}]

+ Response 201
    + Content-Type:application/json;charset=utf-8

    + Body

            [
                {
                    "id": 3,
                    "createdBy": {
                        "id": 2,
                        "username": "testAdmin1"
                    },
                    "tag": {
                        "id": 3,
                        "title": "tag1"
                    }
                }
            ]

## optional_title [/api/serviceItem/{serviceItemId}/tag/{tagId}]

### Delete a tag for this ServiceItem [DELETE]

+ Response 204


# Group Contact Type

## ContactType [/api/contactType/{id}]

+ Parameters
    + id (number) ... The id of the contact type

+ Model
    + Body

            {
                "id": 1,
                "title": "A Required Contact Type",
                "required": false
            }

### Update an existing contactType [PUT]
+ Request
    [ContactType][]
+ Response 200
    [ContactType][]

### Delete a Contact Type [DELETE]
+ Response 204

## ContactTypes [/api/contactType{?max,offset}]
+ Model
    + Body

            {
                "total": 1,
                "data": [{
                    "id": 1,
                    "title": "A Required Contact Type",
                    "required": false
                }]
            }

### Create a ContactType - Admin only [POST]
+ Request
    [ContactType][]
+ Response 201
    [ContactType][]

### List ContactTypes [GET]
+ Parameters
    + max (optional, number) ... The maximum number of ContactTypes to return
    + offset (optional, number) ... The offset into the full list of ContactTypes to start at

+ Response 200
    [ContactTypes][]

# Group Type

## Type [/api/type/{id}]

+ Parameters
    + id (number) ... The id of the type

+ Model
    + Body

            {
                "id": 1,
                "title": "Web Application",
                "description": "This is a web application"
            }

### Update an existing Type [PUT]
+ Request
    [Type][]
+ Response 200
    [Type][]

### Type [DELETE]
+ Response 204

## Types [/api/type{?max,offset}]
+ Model
    + Body

            {
                "total": 1,
                "data": [{
                    "id": 1,
                    "title": "Web Application",
                    "description": "This is a web application"
                }]
            }

### Type - Admin only [POST]
+ Request
    [Type][]
+ Response 201
    [Type][]

### List Types [GET]
+ Parameters
    + max (optional, number) ... The maximum number of Types to return
    + offset (optional, number) ... The offset into the full list of Types to start at

+ Response 200
    [Types][]

# Group Category

## Category [/api/category/{id}]

+ Parameters
    + id (number) ... The id of the category

+ Model
    + Body

            {
                "id": 1,
                "title": "Category A",
                "description": "Category A Description"
            }

### Update an existing Category [PUT]
+ Request
    [Category][]
+ Response 200
    [Category][]

### Delete a Category [DELETE]
+ Response 204

## Categories [/api/category{?max,offset}]
+ Model
    + Body

            {
                "total": 1,
                "data": [{
                    "id": 1,
                    "title": "Category A",
                    "description": "Category A Description"
                }]
            }

### Create a Category - Admin only [POST]
+ Request
    [Category][]
+ Response 201
    [Category][]

### List Categories [GET]
+ Parameters
    + max (optional, number) ... The maximum number of Categories to return
    + offset (optional, number) ... The offset into the full list of Categories to start at

+ Response 200
    [Categories][]

# Group Profile REST

## Profiles [/api/profile{?offset,max}]

+ Model
    + Body

            {
                "total": 2,
                "data": [{
                    "id": 1,
                    "animationsEnabled": null,
                    "username": "System",
                    "bio": "",
                    "email": "",
                    "theme": null,
                    "editedDate": "2014-02-21T17:15:40Z",
                    "class": "marketplace.Profile",
                    "uuid": "457ae498-7068-4495-8a4c-d105d3f2415a",
                    "displayName": "System",
                    "createdDate": "2014-02-21T17:15:40Z"
                }, {
                    "theme": null,
                    "class": "marketplace.Profile",
                    "editedDate": "2014-02-21T17:16:12Z",
                    "id": 2,
                    "username": "testAdmin1",
                    "animationsEnabled": false,
                    "bio": "",
                    "createdBy": {
                        "id": 1,
                        "username": "System",
                        "name": "System"
                    },
                    "email": "testadmin1@nowhere.com",
                    "editedBy": {
                        "id": 1,
                        "username": "System",
                        "name": "System"
                    },
                    "uuid": "714b4169-8dc7-4eac-83d4-f54b559315a1",
                    "displayName": "Test Administrator 1",
                    "createdDate": "2014-02-21T17:16:12Z"
                }]
            }

### Retrieve a paged list of all profiles [GET]

+ Parameters
    + max (optional, number) ... The maximum number of ContactTypes to return
    + offset (optional, number) ... The offset into the full list of ContactTypes to start at

+ Response 200
    [Profiles][]

## Profile [/api/profile/{profileId}]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"

+ Model
    + Body

            {
                "theme": "gold",
                "class": "marketplace.Profile",
                "editedDate": "2014-02-21T17:16:12Z",
                "id": 2,
                "username": "testAdmin1",
                "animationsEnabled": false,
                "bio": "",
                "createdBy": {
                    "id": 1,
                    "username": "System",
                    "name": "System"
                },
                "email": "testadmin1@nowhere.com",
                "editedBy": {
                    "id": 1,
                    "username": "System",
                    "name": "System"
                },
                "uuid": "714b4169-8dc7-4eac-83d4-f54b559315a1",
                "displayName": "Test Administrator 1",
                "createdDate": "2014-02-21T17:16:12Z"
            }

### Retrieve a profile [GET]

+ Response 200
    [Profile][]

### Update a profile. Since most profile options are set via the security plugin, only "bio" is changeable via this call.  "animationsEnabled" and "theme" may be added in the future [PUT]

+ Request
    [Profile][]

+ Response 200
    [Profile][]

## ProfileServiceItems [/api/profile/{profileId}/serviceItem]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"

### Retrieve a list of ServiceItems for whom this Profile is an Owner [GET]

+ Response 200
    [ServiceItems][]

## ProfileComments [/api/profile/{profileId}/itemComment]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"

+ Model
    + Body

            [{
                "id": 1,
                "author": {
                    "id": 2,
                    "username": "testAdmin1",
                    "displayName": "Test Administrator 1"
                },
                "text": "Test Comment",
                "rate": 3,
                "createdBy": {
                    "id": 2,
                    "username": "testAdmin1",
                    "name": "Test Administrator 1"
                },
                "editedBy": {
                    "id": 2,
                    "username": "testAdmin1",
                    "name": "Test Administrator 1"
                },
                "editedDate": "2014-02-21T17:23:40Z",
                "serviceItem": {
                    "id": 1,
                    "title": "test listing",
                    "imageSmallUrl": "https://localhost/"
                },
                "createdDate": "2014-02-21T17:23:40Z"
            }]

### Retrieve all comments made by this user [GET]

+ Response 200
    [ProfileComments][]

## UserData [/api/profile/{profileId}/userData/{key}]
A key value store for storing/retrieving application specific data. Data can be submitted as any content type but will be returned as plain text.

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"
    + key (string) ... The key to lookup (note the key can include '/'s, for example - myApplication/dashboard/1234 is a valid key)


### Retrieve a value associated with a key for this user [GET]

+ Response 200(text/plain)

    + Body

            {"content": "Here's some Data"}

### Put a value associated with a key into the store [PUT]

+ Request(*/*)

    + Body

            {"content": "Here's some Data"}

+ Response 204

+ Response 201

### Remove the value for the associated key from store [DELETE]

+ Response 204


## ProfileServiceItemActivities [/api/profile/{profileId}/activity{?offset,max}]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"
    + max (optional, number) ... The maximum number of ServiceItemActivities to return
    + offset (optional, number) ... The offset into the full list of ServiceItemActivities to start at

+ Model
    + Body

            {
                "total": 4,
                "data": [{
                    "author": {
                        "id": 3,
                        "username": "testUser1",
                        "name": "Test User 1"
                    },
                    "relatedItems": [{
                        "id": 2,
                        "title": "invalid icon"
                    }],
                    "activityDate": "2014-03-05T20:00:32Z",
                    "action": {
                        "description": "Added as a requirement",
                        "name": "ADDRELATEDTOITEM"
                    },
                    "changeDetails": [],
                    "serviceItem": {
                        "id": 1,
                        "title": "no icon",
                        "imageSmallUrl": null
                    }
                }]
            }

### Retrieve all ServiceItemActivities made by this user [GET]

+ Response 200
    [ProfileServiceItemActivities][]

## OwnProfileServiceItemActivities [/api/profile/{profileId}/serviceItem/activity{?offset,max}]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"
    + max (optional, number) ... The maximum number of ServiceItemActivities to return
    + offset (optional, number) ... The offset into the full list of ServiceItemActivities to start at

+ Model
    + Body

            {
                "total": 4,
                "data": [{
                    "author": {
                        "id": 3,
                        "username": "testUser1",
                        "name": "Test User 1"
                    },
                    "relatedItems": [{
                        "id": 2,
                        "title": "invalid icon"
                    }],
                    "activityDate": "2014-03-05T20:00:32Z",
                    "action": {
                        "description": "Added as a requirement",
                        "name": "ADDRELATEDTOITEM"
                    },
                    "changeDetails": [],
                    "serviceItem": {
                        "id": 1,
                        "title": "no icon",
                        "imageSmallUrl": null
                    }
                }]
            }

### Retrieve all ServiceItemActivities on ServiceItems owned by this user [GET]

+ Response 200
    [ProfileServiceItemActivities][]

## ApplicationLibrary [/api/profile/{profileId}/library]
The user's Application Library - a personal list of "favorite" Applications (ServiceItems).  Each Application may be specified as being in a folder, indicated by the string value of the "folder" property fo the model.  A folder value of null indicates that the Application is not in a folder and should be displayed at the top level of the Application Library.

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"

+ Model
    + Body

        [{
            "folder": "folder 2",
            "serviceItem": {
                "imageLargeUrl": null,
                "id": 1,
                "title": "Listing 1",
                "launchUrl": "https:///",
                "imageMediumUrl": null
            }
        }]

### Retrieve this user's Application Library [GET]

+ Response 200
    [ApplicationLibrary][]

### Replace user's Application Library [PUT]

+ Request
    [ApplicationLibrary][]

+ Response 200
    [ApplicationLibrary][]

### Append to a user's Application Library [POST]

+ Request

        {
            "folder": "folder 2",
            "serviceItem": {
                "imageLargeUrl": null,
                "id": 1,
                "title": "Listing 1",
                "launchUrl": "https:///",
                "imageMediumUrl": null
            }
        }

+ Response 200

        {
            "folder": "folder 2",
            "serviceItem": {
                "imageLargeUrl": null,
                "id": 1,
                "title": "Listing 1",
                "launchUrl": "https:///",
                "imageMediumUrl": null
            }
        }

## ApplicationLibraryEntry [/api/profile/{profileId}/library/{serviceItemId}]

+ Parameters
    + profileId (string) ... The id of the profile being retrieved, or "self"
    + serviceItemId (string) ... The id of the ServiceItem associated with the Profile in it's Application Library

### Remove a ServiceItem from a user's Application Library [DELETE]
+ Response 204
