// Uncomment to enable SQL logging
//logSql=true

dataSource {
    driverClassName = 'org.h2.Driver'
    username = 'sa'
    password = ''
    dbCreate = 'update'
}

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    cache.provider_class=''
}

environments {
    development {
        dataSource {
            url = 'jdbc:h2:file:mktplDevDb;DB_CLOSE_ON_EXIT=FALSE'
        }
    }
    test {
        dataSource {
            url = 'jdbc:h2:file:mktplTestDb;DB_CLOSE_ON_EXIT=FALSE'
        }
    }
    production {
        hibernate {
            cache.use_second_level_cache = true
            cache.use_query_cache = true
            cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
        }
    }
}
