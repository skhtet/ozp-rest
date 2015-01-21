## [Licensing Info](./README.txt)

## Run

In order to run this project you need JDK 6 or 7 with $JAVA_HOME defined in your environment. Run the project from the base directory with the following invocation:

```
./grailsw run-app -https
```

(on a windows system, omit the leading "./")

## Use

The sample security configuration uses HTTP basic auth. You have the choice of logging in as one of two roles. To log in as a regular user, login with "testUser1" and "password" as the credentials. The credentials for the admin role are "testAdmin1" and "password".

## Build

Building the project has the same dependencies as running it. After satisfying the prerequisites above, build the project war file with the following invocation:

```
./grailsw war
```

(on a windows system, omit the leading "./")

The output (./target/marketplace.war) can generally be dropped in any servlet container and run without additional configuration. However, Marketplace defaults to using an in-memory Elasticsearch index and H2 database and may, in some cases, need additional Java heap allocated to the servlet container to avoid out of memory errors. The recommended minimum heap size is 512 Mb.

## Load Sample Data

In order to load sample data, you need NodeJS installed. Head over to [the Node.js website](http://nodejs.org/) if you need to do that. Once server is up and running, execute:
```
npm install
npm run loadSampleMetaData
npm run loadSampleListings
```

The first script will populate categories, intents, etc and the second script will populate listings.

## Configure

Note the following information, while generally applicable is geared towards a development environment.

Marketplace default configurations can be override with an external configuration file. That file can reside at the following locations:

- A path passed to the application as a Java System variable called userConfig (e.g -DuserConfig=/path/to/my/custom/config.groovy)
- $USER_HOME/.ozone/MarketplaceConfig.groovy
- A file called MarketplaceConfig.groovy on the classpath (e.g. $TOMCAT_HOME/lib)

An important characteristic of these external config locations is that if multiple configs exists the settings will be merged, with duplicate settings overriding those of less precedence. Configuration precedence follows the order above - that is the first overrides the second which overrides the third which overrides the internal defaults. The external configurations should be in Groovy config slurper format and can contain environment specific blocks. Here is an example:

```
environments {
    development {
        marketplace.some.config = 'this config value applies to the "dev" environment (the default when using run-app)'
    }

    production {
        marketplace.some.config = 'applies to the "prod" environment (the default when running from a war file)'
    }

    myCustomEnv {
        marketplace.some.config = 'applies to a custom environment which can be used by invoking grails -Dgrails.env=myCustomEnv run-app'
    }
}
```

It is best practice to define all external configs in environment specific blocks.

### Configuring the Data Source for Persistent Data

The most commonly needed custom configuration is the dataSource. The following example shows an example dataSource block to configure the internal H2 instance to save changes across application restart in dev mode.

```
environments {
    development {
        dataSource {
             dbCreate = 'update'
             url = 'jdbc:h2:file:mktplDevDb;DB_CLOSE_ON_EXIT=FALSE'
        }
    }
}
```

With the above url config, Grails will keep track of data changes and dump the contents to a file when shutting down. The dbCreate property governs the degree to which Grails keeps the schema in sync with domain classes, possible values are 'none', 'create', 'update', 'create-drop'. Consult the [Grails Docs](http://grails.org/doc/latest/guide/conf.html#dataSource) for more information, but the above config is usually sufficient for dev mode happiness.

### Configuring the ElasticSearch Index

By default Marketplace uses an in memory, embedded ElasticSearch index. In development mode, it can help with application start up time to run ElasticSearch separately and configure Marketplace to use it. The following example demonstrates this.

```
environments {
    development {
        elasticSearch {
            client.mode = 'transport'
            client.hosts = [
                [host:'192.168.59.103', port:9300]
            ]
        }
    }
}
```
