// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts
def userConfig = System.properties.userConfig ?: "${userHome}/.ozone/MarketplaceConfig.groovy"
grails.config.locations = [
        'classpath:MarketplaceConfig.groovy',
        "classpath:OzoneConfig.properties",
        "file:${userConfig}",
        RequiredConfig
]

environments {
    production {
        log4j = {
            appenders {
                rollingFile name: 'stacktrace',
                    maxFileSize: "10000KB",
                    maxBackupIndex: 10,
                    file: "${System.properties['catalina.home']}/logs/stacktrace.log"
                layout: pattern(conversionPattern: '%d{dd MMM yyyy HH:mm:ss,SSS z} %m%n')
            }
            error stacktrace: "StackTrace"
        }
    }
}

println "grails.config.locations = ${grails.config.locations}"


marketplace.layout = "marketplace"

grails.databinding.useSpringBinder = true

grails.mime.file.extensions = false // enables the parsing of file extensions from URLs into the request format
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
    xml: ['text/xml', 'application/xml'],
    text: 'text-plain',
    js: 'text/javascript',
    rss: 'application/rss+xml',
    atom: 'application/atom+xml',
    css: 'text/css',
    csv: 'text/csv',
    all: '*/*',
    json: ['application/json', 'text/json'],
    form: 'application/x-www-form-urlencoded',
    multipartForm: 'multipart/form-data'
]
// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
grails.war.resources = { stagingDir ->
    delete(file: "${stagingDir}/WEB-INF/lib/jetty-6.1.21-sources.jar")
}
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true


discoveryMaxPerRow = 5;
discoveryWidgetMaxPerRow = 6;
grails {
    plugin {
        audittrail {
            //the created and edited fields should be present or they won't get added during AST
            createdBy.field = "createdBy" //id who created
            createdBy.mapping = "column: 'created_by_id'"
            createdBy.type = 'marketplace.Profile'
            createdBy.constraints = 'nullable: true'
            createdDate.field = "createdDate" // if you want a date stamp that is not the grails default dateCreated
            editedBy.field = "editedBy" //id who updated/edited
            editedBy.type = 'marketplace.Profile'
            editedBy.mapping = "column: 'edited_by_id'"
            editedBy.constraints = 'nullable: true'
            editedDate.field = "editedDate"//use this field instead of the grails default lastUpdated
            currentUserClosure = { ctx ->
                String username = ctx.accountService.loggedInUsername ?: marketplace.Constants.SYSTEM_USER_USERNAME
                marketplace.Profile.withNewSession {
                    marketplace.Profile.findByUsername(username)
                }
            }
        }
    }
}

/**
 * ElasticSearch Defaults - override these in an external config as needed
 */
elasticSearch {
    datastoreImpl = 'hibernateDatastore'
    client.mode = 'local'
    index.store.type = 'memory'
    path.data = "${System.properties['catalina.home']}/temp/data"

    //Note: We do our own custom indexing in Bootstrap.groovy. If this is overridden
    //search indexing will not behave as expected - specifically all listings will be
    //indexed on app startup, rather than just approved/enabled listings.
    bulkIndexOnStartup = false
}

environments {
    test {
        log4j = {
            appenders {
                rollingFile name: "marketplace", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/unittest/marketplace.log", layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS z} [%t] %-5p[%c]: %m%n')
                rollingFile name: "elasticsearch", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/elasticsearch.log", layout: pattern(conversionPattern: '%d{dd MMM yyyy HH:mm:ss,SSS z} %m%n')
            }
            debug marketplace: 'grails.app', additivity: false
            debug elasticsearch: 'org.grails.plugins.elasticsearch', additivity: false
            root {
                error 'marketplace'
                additivity = true
            }
        }

        uiperformance.enabled = false  // MS: Had to disable the plugin for the Selenium tests to work
    }

    stage {
    }

    schema_export_oracle {
    }
    development {
        uiperformance.enabled = false

        // ----------------------------------------------------------------------------
        // Import stub locations; if populated with a value, this will stub out the import interface!
        //    Any URL on any importTask will be overridden by this stub file content.
        //    Note that if multiple files are present, which file gets used is currently non-deterministic.
        //    May use classpath-relative path or URL.
        // ----------------------------------------------------------------------------
        //marketplace.importStub.locations = ["classpath:marketplaceImportStub.json"]
        //marketplace.importStub.locations = ["file:///c:/marketplace/test/marketplaceImportStub.json"]

        //log4j configuration
        log4j = {
            // Example of changing the log pattern for the default console
            // appender:
            //
            //appenders {
            //    console name:'stdout', layout:pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS z} [%t] %-5p[%c]: %m%n')
            //}

            appenders {
                console name: 'stdout', layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS z} [%t] %-5p[%c]: %m%n')
                rollingFile name: "stacktrace", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/stacktrace.log", layout: pattern(conversionPattern: '%d{dd MMM yyyy HH:mm:ss,SSS z} %m%n')
                rollingFile name: "marketplace", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/marketplace.log", layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS z} [%t] %-5p[%c]: %m%n')
                rollingFile name: "marketplaceCefAudit", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/marketplace-cef-audit.log", layout: pattern(conversionPattern: '%d{yyyy-MM-dd HH:mm:ss,SSS z} [%t] %-5p[%c]: %m%n')
                rollingFile name: "elasticsearch", maxFileSize: "10000KB", maxBackupIndex: 10, file: "logs/elasticsearch.log", layout: pattern(conversionPattern: '%d{dd MMM yyyy HH:mm:ss,SSS z} %m%n')
            }
            info marketplaceCefAudit: 'ozone.marketplace.util.AuditLogListener', 'org.ozoneplatform'
            info marketplace: 'grails.app.bootstrap'
            info marketplace: 'grails.app'
            info elasticsearch: 'org.grails.plugins.elasticsearch', additivity: false
            //debug marketplace: 'grails.app.bootstrap', additivity: false
            //debug marketplace: 'grails.app', additivity: false

            //debug 'ozone.utils'
            //debug 'util'
            error marketplace: ['org.springframework', 'org.hibernate']
            //debug  'org.springframework', 'org.hibernate.transaction'

            error stacktrace: 'StackTrace'

            root {
                error 'stdout'
                additivity = false
            }

            //debug marketplace: 'liquibase'
            //debug marketplace: 'grails.plugin.databasemigration'
            //trace 'org.hibernate.cache'
            //trace 'org.compass.core.lucene.engine.LuceneSearchEngine'
            //trace 'org.springframework.transaction'
            //trace 'org.codehaus.groovy.grails.orm.hibernate.GrailsHibernateTransactionManager'
            //trace 'org.hibernate.type'
            //debug 'org.hibernate.SQL'

            //uncomment the filter in src/templates/war/web.xml to use this
            debug 'org.apache.catalina.filters.RequestDumperFilter'
        }
    }
}
grails.cache.config = {
    defaults {
        // set default cache properties that will apply to all caches that do not override them
        eternal = false
        diskPersistent = false
        overflowToDisk = false
        // 40 minutes
        timeToLive = 2400
    }
//    caches {
//        pirateCache {
//            // set any properties unique to this cache
//            memoryStoreEvictionPolicy = "LRU"
//        }
//    }
}


system_user_id = 1

httpsession.timeout = 120

marketplace.defaultSearchPageSize = 24
marketplace.defaultLandingPageSize = 18

marketplace.defaultAffiliatedMarketplaceTimeout = 30000
// A value of null means export all
//marketplace.maxListingsToExport=25
//marketplace.maxProfilesToExport=20

marketplace.imageStoragePath = "${System.properties['catalina.home']}/images"

//set to a list of mediatypes that are allowed to be stored as images.  Note: types that
//do not start with image/ will not work regardless of this setting
marketplace.acceptableImageTypes = ['image/png']

environments {
    development {
        //images dir in dev tomcat gets deleted on restart, so use a dir in the source
        //tree instead
        marketplace.imageStoragePath = "images"
    }
}

//Custom quartz configuration goes here.
quartz {
    autoStartup = false
    props {
        scheduler.skipUpdateCheck = true
    }
}
environments {
    production {
        quartz {
            autoStartup = true
            props {
                scheduler.skipUpdateCheck = true
            }
        }
    }
}

cef {
    device {
        vendor = "OZONE"
        product = "Store"
        version = "500-27_L2::1.3"
    }
    version = 0
    enabled = true
    verbose = false
}



// Disabled SpringCache plugin since it does not support clustering by storing
// non-serializable objects in cache
grails.cache.enabled = false

org.grails.jaxrs.doreader.disable=true
org.grails.jaxrs.dowriter.disable=true

//disable grails multipart parsing so that jersey can do it.
//@see https://code.google.com/p/grails-jaxrs/issues/detail?id=52
grails.disableCommonsMultipart=true
grails.web.disable.multipart=true

notifications.enabled = false

//uncomment to get jaxrs trace logging in the HTTP response headers
//org.grails.jaxrs.provider.init.parameters=[
  //'com.sun.jersey.config.feature.Trace': 'true',
//]

println "Config loaded"
