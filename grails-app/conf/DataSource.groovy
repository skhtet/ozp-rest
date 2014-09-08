// Uncomment to enable SQL logging
//logSql=true

dataSource {
    driverClassName = 'org.h2.Driver'
    url = 'jdbc:h2:mem:mktplDb;DB_CLOSE_ON_EXIT=FALSE'
    username = 'sa'
    password = ''
    dbCreate = 'create-drop'
}

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    cache.provider_class=''
}
